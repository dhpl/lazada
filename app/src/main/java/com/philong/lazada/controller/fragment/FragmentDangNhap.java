package com.philong.lazada.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.philong.lazada.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Long on 9/6/2017.
 */

public class FragmentDangNhap extends Fragment {

    private TextInputLayout mTenTextInputLayout;
    private TextInputEditText mTenDangNhapTextInputEditText;
    private TextInputEditText mMatKhauTextInputEditText;
    private Button mDangNhapButton;

    public static FragmentDangNhap newInstance() {
        Bundle args = new Bundle();
        FragmentDangNhap fragment = new FragmentDangNhap();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dang_nhap, container, false);
        //Get View
        mTenTextInputLayout = (TextInputLayout) view.findViewById(R.id.dang_nhap_ten_text_input);
        mDangNhapButton = (Button) view.findViewById(R.id.dang_nhap_button);
        mTenDangNhapTextInputEditText = (TextInputEditText) view.findViewById(R.id.dang_nhap_ten_edit_text);
        mMatKhauTextInputEditText = (TextInputEditText) view.findViewById(R.id.dang_nhap_mat_khau_edit_text);
        //Set button dang nhap
        mDangNhapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mTenDangNhapTextInputEditText.getText().toString().trim();
                String password = mMatKhauTextInputEditText.getText().toString().trim().replaceAll("\\s+", "");
                System.out.println("Password: " + password);
                if(TextUtils.isEmpty(email)){
                    mTenDangNhapTextInputEditText.setError("Email không được để trống.");
                    return;
                }
                if(!checkEmail(email)){
                    mTenDangNhapTextInputEditText.setError("Định dạng Email không đúng.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mMatKhauTextInputEditText.setError("Mật khẩu không được để trống.");
                    return;
                }
                if(password.length() < 6){
                    mMatKhauTextInputEditText.setError("Mật khẩu phải lớn hơn hoặc bằng 6 ký tự.");
                    return;
                }

            }
        });
        return view;
    }

    private boolean checkEmail(String email){
        String regular = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()){
            return true;
        }
        return false;
    }
}
