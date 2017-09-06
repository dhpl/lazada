package com.philong.lazada.util;

import com.philong.lazada.model.LoaiSanPham;

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
        List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();
        try {
            System.out.println("JSON: " + json);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return loaiSanPhamList;
    }



}
