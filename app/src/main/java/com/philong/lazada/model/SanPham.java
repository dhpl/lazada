package com.philong.lazada.model;

/**
 * Created by Long on 9/7/2017.
 */

public class SanPham {

    private int mMaSanPham;
    private long mGia;
    private String mAnhLon;
    private String mAnhNho;
    private String mThongTin;
    private String mTenSanPham;
    private int mSoLuong;
    private int mMaLoaiSanPham;
    private int mLuotMua;
    private int mMaThuongHieu;
    private int mMaNhanVien;



    public SanPham() {

    }

    public SanPham(int maSanPham, long gia, String anhLon, String anhNho, String thongTin, String tenSanPham, int soLuong, int maLoaiSanPham, int luotMua, int maThuongHieu, int maNhanVien) {
        mMaSanPham = maSanPham;
        mGia = gia;
        mAnhLon = anhLon;
        mAnhNho = anhNho;
        mThongTin = thongTin;
        mTenSanPham = tenSanPham;
        mSoLuong = soLuong;
        mMaLoaiSanPham = maLoaiSanPham;
        mLuotMua = luotMua;
        mMaThuongHieu = maThuongHieu;
        mMaNhanVien = maNhanVien;
    }

    public int getMaSanPham() {
        return mMaSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        mMaSanPham = maSanPham;
    }

    public long getGia() {
        return mGia;
    }

    public void setGia(long gia) {
        mGia = gia;
    }

    public String getAnhLon() {
        return mAnhLon;
    }

    public void setAnhLon(String anhLon) {
        mAnhLon = anhLon;
    }

    public String getAnhNho() {
        return mAnhNho;
    }

    public void setAnhNho(String anhNho) {
        mAnhNho = anhNho;
    }

    public String getThongTin() {
        return mThongTin;
    }

    public void setThongTin(String thongTin) {
        mThongTin = thongTin;
    }

    public int getSoLuong() {
        return mSoLuong;
    }

    public void setSoLuong(int soLuong) {
        mSoLuong = soLuong;
    }

    public int getMaLoaiSanPham() {
        return mMaLoaiSanPham;
    }

    public void setMaLoaiSanPham(int maLoaiSanPham) {
        mMaLoaiSanPham = maLoaiSanPham;
    }

    public int getLuotMua() {
        return mLuotMua;
    }

    public void setLuotMua(int luotMua) {
        mLuotMua = luotMua;
    }

    public int getMaThuongHieu() {
        return mMaThuongHieu;
    }

    public void setMaThuongHieu(int maThuongHieu) {
        mMaThuongHieu = maThuongHieu;
    }

    public int getMaNhanVien() {
        return mMaNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        mMaNhanVien = maNhanVien;
    }

    public String getTenSanPham() {
        return mTenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        mTenSanPham = tenSanPham;
    }
}
