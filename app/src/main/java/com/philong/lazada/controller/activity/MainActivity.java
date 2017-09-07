package com.philong.lazada.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import com.philong.lazada.R;
import com.philong.lazada.controller.adapter.AdapterDanhMucViewPager;
import com.philong.lazada.controller.adapter.AdapterExpandableListView;
import com.philong.lazada.model.LoaiSanPham;
import com.philong.lazada.util.DownLoadJsonGet;
import com.philong.lazada.util.ParseJson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mMainTabLayout;
    private ViewPager mMainViewPager;
    private Button mSearchButton;
    private ImageButton mCameraImageButton;

    private AdapterDanhMucViewPager mAdapterDanhMucViewPager;

    //DrawwerLayout
    private DrawerLayout mMainDrawerLayout;
    private ExpandableListView mMainExpandableListView;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private AdapterExpandableListView mAdapterExpandableListView;


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
        mMainDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mMainExpandableListView = (ExpandableListView) findViewById(R.id.main_expand_list_view);
        //Set toolbar
        if(getSupportActionBar() == null){
            setSupportActionBar(mToolbar);
            getSupportActionBar().setTitle("Lazada");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        //Set Tablayout, ViewPager
        mMainTabLayout.setupWithViewPager(mMainViewPager);
        mAdapterDanhMucViewPager = new AdapterDanhMucViewPager(getSupportFragmentManager());
        mMainViewPager.setAdapter(mAdapterDanhMucViewPager);
        //Set drawer layout
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mMainDrawerLayout, R.string.open, R.string.close);
        mMainDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        //Set Expandable Menu
        new DownLoadJsonGet(new DownLoadJsonGet.ProtocolDownLoadJsonGet() {
            @Override
            public void compleDownLoadJsonGet(String s) {
                List<LoaiSanPham> loaiSanPhamList = new ParseJson().parseJsonMenuLoaiSanPham(s);
                if(loaiSanPhamList != null){
                    mAdapterExpandableListView = new AdapterExpandableListView(loaiSanPhamList, MainActivity.this);
                    mMainExpandableListView.setAdapter(mAdapterExpandableListView);
                }
                System.out.println();
            }
        }).execute(ParseJson.BASE_URL + "loai-san-pham.php?maloaicha=0");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mActionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        int id = item.getItemId();
        switch(id){
            case R.id.main_menu_dang_nhap:
                startActivity(DangNhapActivity.newIntent(this));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
