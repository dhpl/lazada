package com.philong.lazada.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.philong.lazada.R;

/**
 * Created by Long on 9/6/2017.
 */

public class FragmentThuongHieu extends Fragment {

    public static FragmentThuongHieu newInstance() {
        Bundle args = new Bundle();
        FragmentThuongHieu fragment = new FragmentThuongHieu();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thuong_hieu, container, false);
        return view;
    }
}

