package com.philong.lazada.model;

import java.util.List;

/**
 * Created by Long on 9/6/2017.
 */

public class LoaiSanPham {

    private int mMaLoaiSanPham;
    private int mMaLoaiCha;
    private String mTenLoaiSanPham;
    private List<LoaiSanPham> mLoaiSanPhamConList;


    public int getMaLoaiSanPham() {
        return mMaLoaiSanPham;
    }

    public void setMaLoaiSanPham(int maLoaiSanPham) {
        mMaLoaiSanPham = maLoaiSanPham;
    }

    public int getMaLoaiCha() {
        return mMaLoaiCha;
    }

    public void setMaLoaiCha(int maLoaiCha) {
        mMaLoaiCha = maLoaiCha;
    }

    public List<LoaiSanPham> getLoaiSanPhamConList() {
        return mLoaiSanPhamConList;
    }

    public void setLoaiSanPhamConList(List<LoaiSanPham> loaiSanPhamConList) {
        mLoaiSanPhamConList = loaiSanPhamConList;
    }

    public String getTenLoaiSanPham() {
        return mTenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        mTenLoaiSanPham = tenLoaiSanPham;
    }
}
