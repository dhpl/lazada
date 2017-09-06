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

public class FragmentLamDep extends Fragment {

    public static FragmentLamDep newInstance() {
        Bundle args = new Bundle();
        FragmentLamDep fragment = new FragmentLamDep();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lam_dep, container, false);
        return view;
    }
}
