package com.philong.lazada.controller.adapter;

/**
 * Created by Long on 9/7/2017.
 */

public class KhuyenMai {

    private int mMaKhuyenMai;
    private int mMaLoaiSanPham;
    private String mTenKhuyenMai;
    private String mNgayBatDau;
    private String mNgayKetThuc;
    private String mHinhKhuyenMai;

    public KhuyenMai(int maKhuyenMai, int maLoaiSanPham, String tenKhuyenMai, String ngayBatDau, String ngayKetThuc, String hinhKhuyenMai) {
        mMaKhuyenMai = maKhuyenMai;
        mMaLoaiSanPham = maLoaiSanPham;
        mTenKhuyenMai = tenKhuyenMai;
        mNgayBatDau = ngayBatDau;
        mNgayKetThuc = ngayKetThuc;
        mHinhKhuyenMai = hinhKhuyenMai;
    }

    public int getMaKhuyenMai() {
        return mMaKhuyenMai;
    }

    public void setMaKhuyenMai(int maKhuyenMai) {
        mMaKhuyenMai = maKhuyenMai;
    }

    public int getMaLoaiSanPham() {
        return mMaLoaiSanPham;
    }

    public void setMaLoaiSanPham(int maLoaiSanPham) {
        mMaLoaiSanPham = maLoaiSanPham;
    }

    public String getTenKhuyenMai() {
        return mTenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        mTenKhuyenMai = tenKhuyenMai;
    }

    public String getNgayBatDau() {
        return mNgayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        mNgayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return mNgayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        mNgayKetThuc = ngayKetThuc;
    }

    public String getHinhKhuyenMai() {
        return mHinhKhuyenMai;
    }

    public void setHinhKhuyenMai(String hinhKhuyenMai) {
        mHinhKhuyenMai = hinhKhuyenMai;
    }
}
