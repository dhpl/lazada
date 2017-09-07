package com.philong.lazada.controller.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.philong.lazada.controller.fragment.FragmentDienTu;
import com.philong.lazada.controller.fragment.FragmentLamDep;
import com.philong.lazada.controller.fragment.FragmentMeVaBe;
import com.philong.lazada.controller.fragment.FragmentNhaCuaVaDoiSong;
import com.philong.lazada.controller.fragment.FragmentTheThaoVaDuLich;
import com.philong.lazada.controller.fragment.FragmentThoiTrang;
import com.philong.lazada.controller.fragment.FragmentThuongHieu;
import com.philong.lazada.controller.fragment.FragmetChuongTrinhKhuyenMai;
import com.philong.lazada.controller.fragment.FragmetNoiBat;

/**
 * Created by Long on 9/6/2017.
 */

public class AdapterDanhMucViewPager extends FragmentPagerAdapter {

    private Fragment[] mDanhMucFragment = {
            FragmetNoiBat.newInstance(),
            FragmetChuongTrinhKhuyenMai.newInstance(),
            FragmentDienTu.newInstance(),
            FragmentNhaCuaVaDoiSong.newInstance(),
            FragmentMeVaBe.newInstance(),
            FragmentLamDep.newInstance(),
            FragmentThoiTrang.newInstance(),
            FragmentTheThaoVaDuLich.newInstance(),
            FragmentThuongHieu.newInstance()
    };

    private String[] mTenDanhMuc = {
            "Nổi bật", "Chương trình khuyến mãi", "Điện tử", "Nhà cửa & đời sống", "Mẹ & bé", "Làm đẹp", "Thời trang",
            "Thể thao & du lịch", "Thương hiệu"
    };

    public AdapterDanhMucViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mDanhMucFragment[position];
    }

    @Override
    public int getCount() {
        return mDanhMucFragment.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTenDanhMuc[position];
    }
}
