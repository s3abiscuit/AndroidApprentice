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



**DrawerLayout使用**

1. 设置为activity_main的根控件
2. 设置ActionBarDrawerToggle控制Drawer的打开关闭
3. 覆盖onBackPressed()实现点击返回按钮关闭Drawer

```java
DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open,
        R.string.navigation_drawer_close);
if (drawer != null) {
    drawer.addDrawerListener(toggle);
}
toggle.syncState();
```

**NavigationView的使用**

1. xml中设置menu
2. activity中设置menu点击监听
3. 覆写监听的动作

```xml
<android.support.design.widget.NavigationView
android:id="@+id/nav_view"
android:layout_width="wrap_content"
android:layout_height="match_parent"
android:layout_gravity="start"
android:fitsSystemWindows="true"
app:headerLayout="@layout/nav_header_main"
app:menu="@menu/activity_main_drawer" />
```

```java
NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
if (navigationView != null) {
    navigationView.setNavigationItemSelectedListener(this);   
}

public boolean onNavigationItemSelected(MenuItem item) {
DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
// Handle navigation view item clicks here.
switch (item.getItemId()) {
    case R.id.nav_camera:
        // Handle the camera import action (for now display a toast).
        drawer.closeDrawer(GravityCompat.START);
        displayToast(getString(R.string.chose_camera));
        return true;
    case R.id.nav_gallery:
        // Handle the gallery action (for now display a toast).
        drawer.closeDrawer(GravityCompat.START);
        displayToast(getString(R.string.chose_gallery));
        return true;
    case R.id.nav_slideshow:
        // Handle the slideshow action (for now display a toast).
        drawer.closeDrawer(GravityCompat.START);
        displayToast(getString(R.string.chose_slideshow));
        return true;
    case R.id.nav_manage:
        // Handle the tools action (for now display a toast).
        drawer.closeDrawer(GravityCompat.START);
        displayToast(getString(R.string.chose_tools));
        return true;
    case R.id.nav_share:
        // Handle the share action (for now display a toast).
        drawer.closeDrawer(GravityCompat.START);
        displayToast(getString(R.string.chose_share));
        return true;
    case R.id.nav_send:
        // Handle the send action (for now display a toast).
        drawer.closeDrawer(GravityCompat.START);
        displayToast(getString(R.string.chose_send));
        return true;
    default:
        return false;
}
```
