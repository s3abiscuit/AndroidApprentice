# AndroidApprentice

## 09TabExperiment

使用 TabLayout 和 ViewPager 这两个控件

其中 TabLayout 继承自 HorizontalScrollView  `public class TabLayout extends HorizontalScrollView`

使用 

```java
// Create an instance of the tab layout from the view.
TabLayout tabLayout = findViewById(R.id.tab_layout);
// 添加 3个Tab
tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1));
tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2));
tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3));

// Set the tabs to fill the entire layout.
tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
```
