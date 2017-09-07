package com.philong.lazada.controller.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.philong.lazada.R;
import com.philong.lazada.model.ThuongHieu;
import com.philong.lazada.util.ParseJson;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Long on 9/7/2017.
 */

public class AdapterThuongHieu extends RecyclerView.Adapter<AdapterThuongHieu.ThuongHieuViewHolder>{

    private Context mContext;
    private List<ThuongHieu> mThuongHieuList;

    public AdapterThuongHieu(Context context, List<ThuongHieu> thuongHieuList) {
        mContext = context;
        mThuongHieuList = thuongHieuList;
    }

    @Override
    public ThuongHieuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_san_pham_1, parent, false);
        return new ThuongHieuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ThuongHieuViewHolder holder, int position) {
        ThuongHieu thuongHieu = mThuongHieuList.get(position);
        holder.bind(thuongHieu);
    }

    @Override
    public int getItemCount() {
        return mThuongHieuList.size();
    }

    public  class ThuongHieuViewHolder extends RecyclerView.ViewHolder{

        public TextView mTenThuongHieuTextView;
        public ImageView mHinhThuongHieu;

        public ThuongHieuViewHolder(View itemView) {
            super(itemView);
            mTenThuongHieuTextView = (TextView) itemView.findViewById(R.id.item_san_pham_1_ten_text_view);
            mHinhThuongHieu = (ImageView) itemView.findViewById(R.id.item_san_pham_1_hinh_san_pham);

        }

        public void bind(ThuongHieu thuongHieu){
            mTenThuongHieuTextView.setText(thuongHieu.getTenThuongHieu());
            Picasso.with(mContext)
                    .load(ParseJson.BASE_URL + thuongHieu.getHinhThuongHieu())
                    .error(R.drawable.ic_error)
                    .fit()
                    .centerCrop()
                    .into(mHinhThuongHieu);
        }
    }

}
