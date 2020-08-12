package com.packagee.tugasuasakb;

/*
    Tanggal pengerjaan  : 8/11/2020
    NIM                 : 10117267
    Nama                : Ichsan Nugraha
    Kelas               : IF - 8
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private LinearLayout layoutTab;
    private TabLayout tabLayout;
    private PagerAdapter pagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.fragment_container);
        layoutTab = (LinearLayout) findViewById(R.id.layoutTab);
        tabLayout = (TabLayout) findViewById(R.id.tabBar);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        mViewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    mViewPager.setCurrentItem(tab.getPosition());
                } else if (tab.getPosition() == 1) {
                    mViewPager.setCurrentItem(tab.getPosition());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId(R.id.nav_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_profile:
                            layoutTab.setVisibility(View.GONE);
                            frameLayout.setVisibility(View.VISIBLE);
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.nav_home:
                            layoutTab.setVisibility(View.GONE);
                            frameLayout.setVisibility(View.VISIBLE);
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_settings:
                            layoutTab.setVisibility(View.VISIBLE);
                            frameLayout.setVisibility(View.GONE);
                            selectedFragment = new SettingsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}
