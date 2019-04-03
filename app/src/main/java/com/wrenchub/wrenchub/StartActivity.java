package com.wrenchub.wrenchub;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wrenchub.wrenchub.Adapter.ViewPagerAdapter;
import com.wrenchub.wrenchub.Fragments.LoginFragment;
import com.wrenchub.wrenchub.Fragments.RegistrationFragment;

public class StartActivity extends AppCompatActivity {

    private ViewPager mPager;

    private TabLayout mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();

        mPager = findViewById(R.id.viewpager);
        mTabs = findViewById(R.id.tabs);

        setupViewPager(mPager);

        mTabs.setupWithViewPager(mPager);
    }

    public void setupViewPager(ViewPager upViewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Fragment fragment = new LoginFragment();
        adapter.addFragment(fragment, "Login");

        fragment = new RegistrationFragment();
        adapter.addFragment(fragment, "Register");
        upViewPager.setAdapter(adapter);
    }
}
