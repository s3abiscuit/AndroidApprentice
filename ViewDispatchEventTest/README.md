## view的坐标

view原始左上角相对于父容器左上角的位置, 这些一般都是不变的.

- mLeft = getLeft()
- mTop = getTop()
- mRight = getRight()
- mBottom = getBottom()

view左上角相对于父容器左上角的坐标,这些一般都是变化的

- x = getX() = mLeft + translationX
- y = getY() = mTop + translationY

view内容左上角相对与view左上角的坐标

- mScrollX为正表示, 手指往左滑, 内容左边界在view左边界的左边 
- mScrollY为正表示, 手指往上滑, 内容上边界在view上边界的上方

MotionEvent坐标, view中的点相对于父容器左上角的坐标

- getX, getY是相对于父容器的左上角

MotionEvent坐标, view中的点相对于屏幕左上角的坐标

- getRawX, getRawY是相对于屏幕的左上角

## view的滑动

三种方式

1. 使用scrollTo方法, 改变的只是view内容的位置
2. 使用动画, 新位置上只是view的影像, view位置并未改变
3. 改变布局参数

弹性滑动

1. 使用Scroller, 本质上是多次调用scrollTo方法
2. 使用延时策略, 本质上是多次调用scrollTo方法
3. 使用动画

## 外部拦截法

这种情况每个事件都要经过ViewGroup来判断是否拦截，ViewGroup一旦在某一个事件拦截后续全部都会拦截

`HorizontalScrollViewEx` + `ListView`

**假设事件的序列是 `DOWN->MOVE(水平距离大于竖直距离)->UP`** 左右滑动

- DOWN: HorizontalScrollViewEx的onInterceptTouchEvent判断不拦截(如果拦截则后面都会拦截)
- MOVE: HorizontalScrollViewEx的onInterceptTouchEvent继续判断并拦截, 这时候onTouchEvent消耗MOVE，后续事件默认继续消耗
- UP: HorizontalScrollViewEx会直接消耗up，即使onInterceptTouchEvent返回了false

**假设事件的序列是 `DOWN->MOVE(水平距离小于竖直距离)->UP`** 上下滑动

- DOWN: HorizontalScrollViewEx的onInterceptTouchEvent判断不拦截(如果拦截则后面都会拦截)
- MOVE: HorizontalScrollViewEx的onInterceptTouchEvent继续判断返回不拦截, 这时候ListView的dispatchTouchEvent消耗MOVE
- UP: HorizontalScrollViewEx的onInterceptTouchEvent判断并返回结果不拦截, 这时候ListView的dispatchTouchEvent消耗UP

## 内部拦截法

这种情况每个事件都要交给view来判断是否拦截，但是一旦交给了ViewGroup那么后续所有事件都由ViewGroup处理

`HorizontalScrollViewEx2` + `ListViewEx`


| 外部拦截 dx>dy | onInterceptTouchEvent | intercepted | OnTouchEvent   | dispatchTouchEvent | requestDisallowInterceptTouchEvent | OnTouchEvent |
| -------------- | --------------------- | ----------- | -------------- | ------------------ | ---------------------------------- | ------------ |
| DOWN           | 执行, 返回false       | false       | 不执行         | 执行               | 无                                 | 执行         |
| MOVE           | 执行, 返回true        | true        | 执行           | 不执行             | 无                                 | 不执行       |
| UP             | 不执行                | true        | 执行           | 不执行             | 无                                 | 不执行       |
| 外部拦截dx<dy  |                       |             |                |                    |                                    |              |
| DOWN           | 执行, 返回false       | false       | 不执行         | 执行               | 无                                 | 执行         |
| MOVE           | 执行, 返回false       | false       | 不执行         | 执行               | 无                                 | 执行         |
| UP             | 执行, 返回false       | false       | 不执行         | 执行               | 无                                 | 执行         |
| 内部拦截dx>dy  |                       |             |                |                    |                                    |              |
| DOWN           | 执行, 返回false       | false       | 不执行         | 执行               | 传入true                           | 执行         |
| MOVE           | 不执行,               | false       | 执行(子不处理) | 执行               | 传入false                          | 不执行       |
| UP             | 执行, 返回true        | true        | 执行           | 不执行             | 不执行                             | 不执行       |
| 内部拦截dx<dy  |                       |             |                |                    |                                    |              |
| DOWN           | 执行, 返回false       | false       | 不执行         | 执行               | 传入true                           | 执行         |
| MOVE           | 不执行                | false       | 不执行         | 执行               | 传入true                           | 执行         |
| UP             | 不执行                | false       | 不执行         | 执行               | 不执行                             | 执行         |


## measure过程



- ViewGroup.measure(MeasureSpec)

- ViewGroup.onMeasure(MeasureSpec)
    - measureChildren
        - measureChild(MeasureSpec, childLayoutParams) 确定View的MeasureSpec
            - View.measure(childMeasureSpec)
                - View.onMeasure(childMeasureSpec)
                    - View.setMeasureDimention(measureWidth, measureHeight)
    - ViewGroup.setMeasureDimention
        - wrap_content情况
        - match_parent情况
