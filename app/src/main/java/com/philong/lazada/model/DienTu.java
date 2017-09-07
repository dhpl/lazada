package com.philong.lazada.model;

import java.util.List;

/**
 * Created by Long on 9/7/2017.
 */

public class DienTu {

    private String mHinhKhuyenMai;
    private List<ThuongHieu> mThuongHieuList;
    private List<SanPham> mSanPhamList;
    private String mTen1;
    private String mTen2;


    public DienTu() {
    }

    public DienTu(String hinhKhuyenMai, List<ThuongHieu> thuongHieuList, List<SanPham> sanPhamList, String ten1, String ten2) {
        mHinhKhuyenMai = hinhKhuyenMai;
        mThuongHieuList = thuongHieuList;
        mSanPhamList = sanPhamList;
        mTen1 = ten1;
        mTen2 = ten2;
    }

    public String getHinhKhuyenMai() {
        return mHinhKhuyenMai;
    }

    public void setHinhKhuyenMai(String hinhKhuyenMai) {
        mHinhKhuyenMai = hinhKhuyenMai;
    }

    public List<ThuongHieu> getThuongHieuList() {
        return mThuongHieuList;
    }

    public void setThuongHieuList(List<ThuongHieu> thuongHieuList) {
        mThuongHieuList = thuongHieuList;
    }

    public List<SanPham> getSanPhamList() {
        return mSanPhamList;
    }

    public void setSanPhamList(List<SanPham> sanPhamList) {
        mSanPhamList = sanPhamList;
    }

    public String getTen1() {
        return mTen1;
    }

    public void setTen1(String ten1) {
        mTen1 = ten1;
    }

    public String getTen2() {
        return mTen2;
    }

    public void setTen2(String ten2) {
        mTen2 = ten2;
    }
}
