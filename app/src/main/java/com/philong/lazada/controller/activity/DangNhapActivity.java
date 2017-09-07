package com.philong.lazada.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.philong.lazada.R;
import com.philong.lazada.controller.adapter.AdapterDangNhapDangKyViewPager;
import com.philong.lazada.controller.fragment.FragmentDangKy;
import com.philong.lazada.model.NhanVien;

public class DangNhapActivity extends AppCompatActivity implements FragmentDangKy.ProtocolDangKyThanhCong{

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mDangNhapViewPager;
    private AdapterDangNhapDangKyViewPager mAdapterDangNhapDangKyViewPager;


    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, DangNhapActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        //Get view
        mToolbar = (Toolbar) findViewById(R.id.dang_nhap_toolbar);
        mDangNhapViewPager = (ViewPager) findViewById(R.id.dang_nhap_view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.dang_nhap_tab_layout);
        //Set tablayout
        mTabLayout.setupWithViewPager(mDangNhapViewPager);
        mAdapterDangNhapDangKyViewPager = new AdapterDangNhapDangKyViewPager(getSupportFragmentManager());
        mDangNhapViewPager.setAdapter(mAdapterDangNhapDangKyViewPager);
        //Set toolbar
        if(getSupportActionBar() == null){
            setSupportActionBar(mToolbar);
            getSupportActionBar().setTitle("Đăng nhập - Đăng ký");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }


    @Override
    public void completeDangKyThanhCong(boolean isComplete, NhanVien nhanVien) {
        if(isComplete){
            mDangNhapViewPager.setCurrentItem(0);
        }
    }
}
