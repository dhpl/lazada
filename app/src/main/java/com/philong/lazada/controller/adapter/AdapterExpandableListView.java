package com.philong.lazada.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.philong.lazada.R;
import com.philong.lazada.model.LoaiSanPham;
import com.philong.lazada.util.DownLoadJsonGet;
import com.philong.lazada.util.ParseJson;

import java.util.List;

/**
 * Created by Long on 9/6/2017.
 */

public class AdapterExpandableListView extends BaseExpandableListAdapter {

    private List<LoaiSanPham> mLoaiSanPhamList;
    private Context mContext;

    public AdapterExpandableListView(List<LoaiSanPham> loaiSanPhamList, Context context) {
        mLoaiSanPhamList = loaiSanPhamList;
        mContext = context;
        int size = mLoaiSanPhamList.size();
        for (int i = 0; i < size; i++) {
            int maLoaiSanPham = mLoaiSanPhamList.get(i).getMaLoaiSanPham();
            final int finalI = i;
            new DownLoadJsonGet(new DownLoadJsonGet.ProtocolDownLoadJsonGet() {
                @Override
                public void compleDownLoadJsonGet(String s) {
                    mLoaiSanPhamList.get(finalI).setLoaiSanPhamConList(new ParseJson().parseJsonMenuLoaiSanPham(s));
                }
            }).execute(ParseJson.BASE_URL + "loai-san-pham.php?maloaicha=" + maLoaiSanPham);
        }
    }

    @Override
    public int getGroupCount() {
        return mLoaiSanPhamList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mLoaiSanPhamList.get(i).getLoaiSanPhamConList().size();
    }

    @Override
    public Object getGroup(int i) {
        return mLoaiSanPhamList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mLoaiSanPhamList.get(i).getLoaiSanPhamConList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return mLoaiSanPhamList.get(i).getMaLoaiSanPham();
    }

    @Override
    public long getChildId(int i, int i1) {
        return mLoaiSanPhamList.get(i).getLoaiSanPhamConList().get(i1).getMaLoaiSanPham();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        LoaiSanPham loaiSanPham = mLoaiSanPhamList.get(i);
        View v = view;
        LayoutInflater inflater;
        ViewHolderGroupParent viewHolderGroupParent;
        if(v == null){
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_group_parent, viewGroup, false);
            viewHolderGroupParent = new ViewHolderGroupParent();
            viewHolderGroupParent.mTenGroupChaTextView = (TextView)v.findViewById(R.id.item_group_parent_text_view);
            v.setTag(viewHolderGroupParent);
        }else{
            viewHolderGroupParent = (ViewHolderGroupParent) v.getTag();
        }
        viewHolderGroupParent.mTenGroupChaTextView.setText(loaiSanPham.getTenLoaiSanPham());
        return v;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        LoaiSanPham loaiSanPham = mLoaiSanPhamList.get(i);
        View v = view;
        LayoutInflater inflater;
        ViewHolderGroupChilder viewHolderGroupChild;
        if(v == null){
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_group_child, viewGroup, false);
            viewHolderGroupChild = new ViewHolderGroupChilder();
            viewHolderGroupChild.mTenGroupChilderTextView = (TextView)v.findViewById(R.id.item_group_child_text_view);
            v.setTag(viewHolderGroupChild);
        }else{
            viewHolderGroupChild = (ViewHolderGroupChilder) v.getTag();
        }
        viewHolderGroupChild.mTenGroupChilderTextView.setText(loaiSanPham.getLoaiSanPhamConList().get(i1).getTenLoaiSanPham());
        return v;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    public static class ViewHolderGroupParent {
        private TextView mTenGroupChaTextView;
    }

    public static class ViewHolderGroupChilder{
        private TextView mTenGroupChilderTextView;
    }

}
