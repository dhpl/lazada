package com.philong.lazada.controller.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.philong.lazada.R;
import com.philong.lazada.model.SanPham;
import com.philong.lazada.util.ParseJson;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Long on 9/7/2017.
 */

public class AdapterSanPham extends RecyclerView.Adapter<AdapterSanPham.SanPhamViewHolder>{

    private Context mContext;
    private List<SanPham> mSanPhamList;

    public AdapterSanPham(Context context, List<SanPham> sanPhamList) {
        mContext = context;
        mSanPhamList = sanPhamList;
    }

    @Override
    public SanPhamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_san_pham_2, parent, false);
        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SanPhamViewHolder holder, int position) {
        SanPham sanPham = mSanPhamList.get(position);
        holder.bind(sanPham);
    }

    @Override
    public int getItemCount() {
        return mSanPhamList.size();
    }

    public class SanPhamViewHolder extends RecyclerView.ViewHolder{

        public ImageView mHinhSanPhamImageView;
        public TextView mTenSanPhamTextView;
        public TextView mGiaSanPhamTextView;
        public TextView mGiamGiaSanPhamTextView;

        public SanPhamViewHolder(View itemView) {
            super(itemView);
            mHinhSanPhamImageView = (ImageView) itemView.findViewById(R.id.item_san_pham_2_hinh_san_pham);
            mTenSanPhamTextView = (TextView) itemView.findViewById(R.id.item_san_pham_2_ten_text_view);
            mGiaSanPhamTextView = (TextView) itemView.findViewById(R.id.item_san_pham_2_gia_text_view);
            mGiamGiaSanPhamTextView = (TextView) itemView.findViewById(R.id.item_san_pham_2_giam_gia_text_view);
        }

        public void bind(SanPham sanPham){
            mTenSanPhamTextView.setText(sanPham.getTenSanPham());
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
            String gia = numberFormat.format(sanPham.getGia());
            mGiaSanPhamTextView.setText(gia);
            Picasso.with(mContext)
                    .load(ParseJson.BASE_URL + sanPham.getAnhLon())
                    .fit()
                    .error(R.drawable.ic_error)
                    .centerCrop()
                    .into(mHinhSanPhamImageView);
        }
    }

}
