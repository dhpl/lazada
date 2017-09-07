package com.philong.lazada.util;

import android.text.TextUtils;

import com.philong.lazada.model.LoaiSanPham;
import com.philong.lazada.model.SanPham;
import com.philong.lazada.model.ThuongHieu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 9/6/2017.
 */

public class ParseJson {

    public static final String  BASE_URL = "http://192.168.100.17/lazada/";

    public  List<LoaiSanPham> parseJsonMenuLoaiSanPham(String json){
        if(!TextUtils.isEmpty(json) && json != null){
            List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();
            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray("loaisanpham");
                int size = jsonArray.length();
                for(int i = 0; i < size; i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String maLoaiSanPham =  jsonObject1.getString("MALOAISP");
                    String maLoaiCha = jsonObject1.getString("MALOAI_CHA");
                    String tenLoaiSanPham = jsonObject1.getString("TENLOAISP");
                    LoaiSanPham loaiSanPham = new LoaiSanPham();
                    loaiSanPham.setMaLoaiCha(Integer.parseInt(maLoaiCha));
                    loaiSanPham.setTenLoaiSanPham(tenLoaiSanPham);
                    loaiSanPham.setMaLoaiSanPham(Integer.parseInt(maLoaiSanPham));
                    loaiSanPhamList.add(loaiSanPham);
                }
                return loaiSanPhamList;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<ThuongHieu> parseJsonThuongHieu(String json){
        try {
            List<ThuongHieu> thuongHieuList = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("thuonghieu");
            int size = jsonArray.length();
            for (int i = 0; i < size ; i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String maThuongHieu = jsonObject1.getString("mathuonghieu");
                String tenThuongHieu = jsonObject1.getString("tenthuonghieu");
                String hinhThuongHieu = jsonObject1.getString("hinhthuonghieu");
                String luotMua = jsonObject1.getString("luotmua");
                thuongHieuList.add(new ThuongHieu(Integer.parseInt(maThuongHieu), Integer.parseInt(luotMua), tenThuongHieu, hinhThuongHieu));
            }
            return thuongHieuList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPham> parseJsonSanPham(String json){
        try {
            List<SanPham> sanPhamList = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("sanpham");
            int size = jsonArray.length();
            for (int i = 0; i < size; i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String masp = jsonObject1.getString("masp");
                String tensp = jsonObject1.getString("tensp");
                String gia = jsonObject1.getString("gia");
                String anhlon = jsonObject1.getString("anhlon");
                String anhnho = jsonObject1.getString("anhnho");
                String thongtin = jsonObject1.getString("thongtin");
                String soluong = jsonObject1.getString("soluong");
                String maloaisp = jsonObject1.getString("maloaisp");
                String mathuonghieu = jsonObject1.getString("mathuonghieu");
                String manv = jsonObject1.getString("manv");
                String luotmua = jsonObject1.getString("luotmua");
                sanPhamList.add(new SanPham(Integer.parseInt(masp), Long.parseLong(gia), anhlon, anhnho, thongtin
                        , tensp, Integer.parseInt(soluong), Integer.parseInt(maloaisp)
                        , Integer.parseInt(luotmua), Integer.parseInt(mathuonghieu), Integer.parseInt(manv)));
            }
            return sanPhamList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  null;
    }


}
