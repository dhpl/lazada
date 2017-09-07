package com.philong.lazada.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.philong.lazada.R;
import com.philong.lazada.controller.adapter.AdapterDienTu;
import com.philong.lazada.model.DienTu;
import com.philong.lazada.model.SanPham;
import com.philong.lazada.model.ThuongHieu;
import com.philong.lazada.util.DownLoadJsonGet;
import com.philong.lazada.util.ParseJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 9/6/2017.
 */

public class FragmentDienTu extends Fragment{

    //Dien tu
    private List<DienTu> mDienTuList;
    private List<ThuongHieu> mThuongHieuList;
    private List<SanPham> mSanPhamList;
    private AdapterDienTu mAdapterDienTu;
    private RecyclerView mDienTuRecyclerView;
    private ProgressBar mProgressBar;

    public static FragmentDienTu newInstance() {
        Bundle args = new Bundle();
        FragmentDienTu fragment = new FragmentDienTu();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dien_tu, container, false);
        //Get view
        mProgressBar = (ProgressBar) view.findViewById(R.id.dien_tu_progress_bar);
        mDienTuRecyclerView = (RecyclerView) view.findViewById(R.id.dien_tu_recycler_view);
        //Set dien tu
        mDienTuList = new ArrayList<>();
        mThuongHieuList = new ArrayList<>();
        mDienTuRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mDienTuRecyclerView.setHasFixedSize(false);
        mDienTuRecyclerView.setNestedScrollingEnabled(false);
        mDienTuRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        new DownLoadJsonGet(new DownLoadJsonGet.ProtocolDownLoadJsonGet() {
            @Override
            public void compleDownLoadJsonGet(String s) {
                final DienTu dienTu = new DienTu();
                mThuongHieuList = new ParseJson().parseJsonThuongHieu(s);
                dienTu.setThuongHieuList(mThuongHieuList);
                new DownLoadJsonGet(new DownLoadJsonGet.ProtocolDownLoadJsonGet() {
                    @Override
                    public void compleDownLoadJsonGet(String s) {
                        mSanPhamList = new ParseJson().parseJsonSanPham(s);
                        dienTu.setSanPhamList(mSanPhamList);
                        dienTu.setTen1("Các thương hiệu lớn");
                        dienTu.setTen2("Sản phẩm");
                        mDienTuList.add(dienTu);
                        mAdapterDienTu = new AdapterDienTu(getActivity(), mDienTuList);
                        mDienTuRecyclerView.setAdapter(mAdapterDienTu);
                        mProgressBar.setVisibility(View.GONE);
                    }
                }).execute(ParseJson.BASE_URL + "san-pham.php");

            }
        }).execute(ParseJson.BASE_URL + "danh-sach-thuong-hieu.php");
        return view;
    }
}
