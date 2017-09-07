package com.philong.lazada.controller.adapter;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.philong.lazada.R;
import com.philong.lazada.model.DienTu;

import java.util.List;

/**
 * Created by Long on 9/7/2017.
 */

public class AdapterDienTu extends RecyclerView.Adapter<AdapterDienTu.DienTuViewHolder> {

    private Context mContext;
    private List<DienTu> mDienTuList;

    public AdapterDienTu(Context context, List<DienTu> dienTuList) {
        mContext = context;
        mDienTuList = dienTuList;
    }

    @Override
    public DienTuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_dien_tu, parent, false);
        return new DienTuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DienTuViewHolder holder, int position) {
        DienTu dienTu = mDienTuList.get(position);
        holder.bind(dienTu);
    }

    @Override
    public int getItemCount() {
        return mDienTuList.size();
    }

    public class DienTuViewHolder extends RecyclerView.ViewHolder{

        private ImageView mDienTuBannerImageView;
        private TextView mTen1TextView;
        private TextView mTen2TextView;

        //1
        private AdapterThuongHieu mAdapterThuongHieu;
        private RecyclerView mDientuRecylerView1;
        //2
        private AdapterSanPham mAdapterSanPham;
        private RecyclerView mDientuRecylerView2;


        public DienTuViewHolder(View itemView) {
            super(itemView);
            mDientuRecylerView1 = (RecyclerView) itemView.findViewById(R.id.dien_tu_recycler_view_1);
            mDientuRecylerView2 = (RecyclerView) itemView.findViewById(R.id.dien_tu_recycler_view_2);
            mDienTuBannerImageView = (ImageView) itemView.findViewById(R.id.dien_tu_banner);
            mTen1TextView = (TextView) itemView.findViewById(R.id.dien_tu_ten_1);
            mTen2TextView = (TextView) itemView.findViewById(R.id.dien_tu_ten_2);
            //Set Recycler view 1
            mDientuRecylerView1.setItemAnimator(new DefaultItemAnimator());
            mDientuRecylerView1.setNestedScrollingEnabled(false);
            mDientuRecylerView1.setLayoutManager(new GridLayoutManager(mContext, 2));
            mDientuRecylerView1.setHasFixedSize(false);
            //Set recycler view 2
            mDientuRecylerView2.setItemAnimator(new DefaultItemAnimator());
            mDientuRecylerView2.setNestedScrollingEnabled(false);
            mDientuRecylerView2.setLayoutManager(new GridLayoutManager(mContext, 2));
            mDientuRecylerView2.setHasFixedSize(false);
        }

        public void bind(DienTu dienTu){
            //Set ten
            mTen1TextView.setText(dienTu.getTen1());
            mTen2TextView.setText(dienTu.getTen2());
            //Thuong hieu
            mAdapterThuongHieu = new AdapterThuongHieu(mContext, dienTu.getThuongHieuList());
            mDientuRecylerView1.setAdapter(mAdapterThuongHieu);
            mAdapterThuongHieu.notifyDataSetChanged();
            //San pham
            mAdapterSanPham = new AdapterSanPham(mContext, dienTu.getSanPhamList());
            mDientuRecylerView2.setAdapter(mAdapterSanPham);
            mAdapterThuongHieu.notifyDataSetChanged();
        }

    }
}
