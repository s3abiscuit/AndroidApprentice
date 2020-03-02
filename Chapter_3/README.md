## 外部拦截法

`HorizontalScrollViewEx` + `ListView`

**假设事件的序列是 `DOWN->MOVE(水平距离大于竖直距离)->UP`**

- DOWN: HorizontalScrollViewEx的onInterceptTouchEvent判断不拦截(如果拦截则后面都会拦截)
- MOVE: HorizontalScrollViewEx的onInterceptTouchEvent继续判断并拦截, 这时候onTouchEvent消耗MOVE
- UP: HorizontalScrollViewEx的onInterceptTouchEvent不用判断直接拦截, 这时候o'nTouchEvent消耗UP

**假设事件的序列是 `DOWN->MOVE(水平距离小于竖直距离)->UP`**

- DOWN: HorizontalScrollViewEx的onInterceptTouchEvent判断不拦截(如果拦截则后面都会拦截)
- MOVE: HorizontalScrollViewEx的onInterceptTouchEvent继续判断返回不拦截, 这时候ListView的dispatchTouchEvent消耗MOVE
- UP: HorizontalScrollViewEx的onInterceptTouchEvent判断并返回结果不拦截, 这时候ListView的dispatchTouchEvent消耗UP

## 内部拦截法

`HorizontalScrollViewEx2` + `ListViewEx`

**假设事件的序列是 `DOWN->MOVE(水平距离大于竖直距离)->UP`**

- DOWN: HorizontalScrollViewEx的onInterceptTouchEvent判断不拦截(如果拦截则后面都会拦截), 
ListView的dispatchTouchEvent处理DOWN`(requestDisallowInterceptTouchEvent(true))`
- MOVE: HorizontalScrollViewEx的onInterceptTouchEvent走不到, 结果是不拦截, 
这时候ListView的dispatchTouchEvent继续处理MOVE`(requestDisallowInterceptTouchEvent(false))`
然后onTouchEvent消耗MOVE
- UP: HorizontalScrollViewEx的onInterceptTouchEvent判断并拦截, 这时候onTouchEvent消耗UP

**假设事件的序列是 `DOWN->MOVE(水平距离小于竖直距离)->UP`**

- DOWN: HorizontalScrollViewEx的onInterceptTouchEvent判断不拦截(如果拦截则后面都会拦截),
ListView的dispatchTouchEvent处理DOWN`(requestDisallowInterceptTouchEvent(true))`
- MOVE: HorizontalScrollViewEx的onInterceptTouchEvent走不到, 结果是不拦截, 这时候ListView的dispatchTouchEvent继续处理MOVE, 并且消耗MOVE
- UP: HorizontalScrollViewEx的onInterceptTouchEvent走不到, 结果是不拦截, 这时候ListView的dispatchTouchEvent消耗UP
