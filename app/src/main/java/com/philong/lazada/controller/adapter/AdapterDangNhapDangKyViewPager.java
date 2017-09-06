package com.philong.lazada.controller.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.philong.lazada.controller.fragment.FragmentDangKy;
import com.philong.lazada.controller.fragment.FragmentDangNhap;

/**
 * Created by Long on 9/6/2017.
 */

public class AdapterDangNhapDangKyViewPager extends FragmentPagerAdapter {

    private Context mContext;
    private Fragment[] mFragments = {
            FragmentDangNhap.newInstance(),
            FragmentDangKy.newInstance()
    };
    private String[] mTenFragments = {
            "Đăng nhập", "Đăng ký"
    };

    public AdapterDangNhapDangKyViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTenFragments[position];
    }
}
