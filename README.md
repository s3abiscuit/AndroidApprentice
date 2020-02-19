# AndroidApprentice

## 09TabExperiment

使用 TabLayout 和 ViewPager 这两个控件

**TabLayout使用**
TabLayout 继承自 HorizontalScrollView  `public class TabLayout extends HorizontalScrollView`

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

**ViewPager的使用**

1. 设置Adapter, 传入FragmentManager和 TabLayout的tab数量, 每个tab对应一个Fragment
2. 设置两个Listener监听tab的变化

```java
final ViewPager viewPager = findViewById(R.id.pager);
final PagerAdapter adapter = new PagerAdapter
        (getSupportFragmentManager(), tabLayout.getTabCount());
viewPager.setAdapter(adapter);

// Setting a listener for clicks.
viewPager.addOnPageChangeListener(new
        TabLayout.TabLayoutOnPageChangeListener(tabLayout));
tabLayout.addOnTabSelectedListener(
        new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }
});
```


## 10NavDrawerExperiment

使用到的控件: DrawerLayout, NavigationView, CoordinatorLayout

控件层级

- **DrawerLayout**
    - CoordinatorLayout
        - AppBarLayout(include, app_bar_main.xml)
            - **Toolbar**
        - RelativeLayout(include, activity_main.xml)
            - **TextView**
        - **FloatingActionButton**
    - **NavigationView**




