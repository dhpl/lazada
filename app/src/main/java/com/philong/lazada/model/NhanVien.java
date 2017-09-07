package com.philong.lazada.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Long on 9/7/2017.
 */

public class NhanVien implements Parcelable{

    private int mMa, mMaLoai, mGioiTinh;
    private String mTenDangNhap, mMatKhau, mTen, mDiaChi, mNgaySinh, mSDT, mEmailDocQuyen, mEmail;

    public NhanVien() {
    }

    public NhanVien(int ma, int maLoai, int gioiTinh, String tenDangNhap, String matKhau, String ten, String diaChi, String ngaySinh, String SDT, String emailDocQuyen) {
        mMa = ma;
        mMaLoai = maLoai;
        mGioiTinh = gioiTinh;
        mTenDangNhap = tenDangNhap;
        mMatKhau = matKhau;
        mTen = ten;
        mDiaChi = diaChi;
        mNgaySinh = ngaySinh;
        mSDT = SDT;
        mEmailDocQuyen = emailDocQuyen;
    }

    protected NhanVien(Parcel in) {
        mMa = in.readInt();
        mMaLoai = in.readInt();
        mGioiTinh = in.readInt();
        mTenDangNhap = in.readString();
        mMatKhau = in.readString();
        mTen = in.readString();
        mDiaChi = in.readString();
        mNgaySinh = in.readString();
        mSDT = in.readString();
        mEmailDocQuyen = in.readString();
        mEmail = in.readString();
    }

    public static final Creator<NhanVien> CREATOR = new Creator<NhanVien>() {
        @Override
        public NhanVien createFromParcel(Parcel in) {
            return new NhanVien(in);
        }

        @Override
        public NhanVien[] newArray(int size) {
            return new NhanVien[size];
        }
    };

    public int getMa() {
        return mMa;
    }

    public void setMa(int ma) {
        mMa = ma;
    }

    public int getMaLoai() {
        return mMaLoai;
    }

    public void setMaLoai(int maLoai) {
        mMaLoai = maLoai;
    }

    public int getGioiTinh() {
        return mGioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        mGioiTinh = gioiTinh;
    }

    public String getTenDangNhap() {
        return mTenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        mTenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return mMatKhau;
    }

    public void setMatKhau(String matKhau) {
        mMatKhau = matKhau;
    }

    public String getTen() {
        return mTen;
    }

    public void setTen(String ten) {
        mTen = ten;
    }

    public String getDiaChi() {
        return mDiaChi;
    }

    public void setDiaChi(String diaChi) {
        mDiaChi = diaChi;
    }

    public String getNgaySinh() {
        return mNgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        mNgaySinh = ngaySinh;
    }

    public String getSDT() {
        return mSDT;
    }

    public void setSDT(String SDT) {
        mSDT = SDT;
    }

    public String getEmailDocQuyen() {
        return mEmailDocQuyen;
    }

    public void setEmailDocQuyen(String emailDocQuyen) {
        mEmailDocQuyen = emailDocQuyen;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mMa);
        parcel.writeInt(mMaLoai);
        parcel.writeInt(mGioiTinh);
        parcel.writeString(mTenDangNhap);
        parcel.writeString(mMatKhau);
        parcel.writeString(mTen);
        parcel.writeString(mDiaChi);
        parcel.writeString(mNgaySinh);
        parcel.writeString(mSDT);
        parcel.writeString(mEmailDocQuyen);
        parcel.writeString(mEmail);
    }
}
