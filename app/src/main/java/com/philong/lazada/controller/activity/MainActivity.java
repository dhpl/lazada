package com.philong.lazada.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;

import com.philong.lazada.R;
import com.philong.lazada.controller.adapter.AdapterDanhMucViewPager;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mMainTabLayout;
    private ViewPager mMainViewPager;
    private Button mSearchButton;
    private ImageButton mCameraImageButton;

    private AdapterDanhMucViewPager mAdapterDanhMucViewPager;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get view
        mToolbar = (Toolbar) findViewById(R.id.main_tool_bar);
        mMainTabLayout = (TabLayout) findViewById(R.id.main_tab_layout);
        mMainViewPager = (ViewPager) findViewById(R.id.main_view_pager);
        mSearchButton = (Button) findViewById(R.id.main_search_button);
        mCameraImageButton = (ImageButton) findViewById(R.id.main_camera_image_button);
        //Set toolbar
        if(getSupportActionBar() == null){
            setSupportActionBar(mToolbar);
            getSupportActionBar().setTitle("Lazada");
        }
        //Set Tablayout, ViewPager
        mMainTabLayout.setupWithViewPager(mMainViewPager);
        mAdapterDanhMucViewPager = new AdapterDanhMucViewPager(getSupportFragmentManager());
        mMainViewPager.setAdapter(mAdapterDanhMucViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
