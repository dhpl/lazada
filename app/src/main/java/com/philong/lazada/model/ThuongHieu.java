package com.philong.lazada.model;

/**
 * Created by Long on 9/7/2017.
 */

public class ThuongHieu {

    private int mMaThuongHieu;
    private int mLuotMua;
    private String mTenThuongHieu;
    private String mHinhThuongHieu;

    public ThuongHieu() {
    }

    public ThuongHieu(int maThuongHieu, int luotMua, String tenThuongHieu, String hinhThuongHieu) {
        mMaThuongHieu = maThuongHieu;
        mLuotMua = luotMua;
        mTenThuongHieu = tenThuongHieu;
        mHinhThuongHieu = hinhThuongHieu;
    }

    public int getMaThuongHieu() {
        return mMaThuongHieu;
    }

    public void setMaThuongHieu(int maThuongHieu) {
        mMaThuongHieu = maThuongHieu;
    }

    public int getLuotMua() {
        return mLuotMua;
    }

    public void setLuotMua(int luotMua) {
        mLuotMua = luotMua;
    }

    public String getTenThuongHieu() {
        return mTenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        mTenThuongHieu = tenThuongHieu;
    }

    public String getHinhThuongHieu() {
        return mHinhThuongHieu;
    }

    public void setHinhThuongHieu(String hinhThuongHieu) {
        mHinhThuongHieu = hinhThuongHieu;
    }
}
