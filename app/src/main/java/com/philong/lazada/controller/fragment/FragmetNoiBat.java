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

public class FragmetNoiBat extends Fragment {

    public static FragmetNoiBat newInstance() {
        Bundle args = new Bundle();
        FragmetNoiBat fragment = new FragmetNoiBat();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noi_bat, container, false);
        return view;
    }
}

