package com.philong.lazada.controller.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.philong.lazada.R;
import com.philong.lazada.controller.activity.MainActivity;
import com.philong.lazada.util.DownLoadJsonPost;
import com.philong.lazada.util.ParseJson;

import org.json.JSONException;
import org.json.JSONObject;

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

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public static FragmentDangNhap newInstance() {
        Bundle args = new Bundle();
        FragmentDangNhap fragment = new FragmentDangNhap();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dang_nhap, container, false);
        //Set sharepreference
        mSharedPreferences = getActivity().getSharedPreferences("NhanVien", Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        //Get View
        mTenTextInputLayout = (TextInputLayout) view.findViewById(R.id.dang_nhap_ten_text_input);
        mDangNhapButton = (Button) view.findViewById(R.id.dang_nhap_button);
        mTenDangNhapTextInputEditText = (TextInputEditText) view.findViewById(R.id.dang_nhap_ten_edit_text);
        mMatKhauTextInputEditText = (TextInputEditText) view.findViewById(R.id.dang_nhap_mat_khau_edit_text);
        //Set button dang nhap
        mDangNhapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = mTenDangNhapTextInputEditText.getText().toString().trim();
                final String password = mMatKhauTextInputEditText.getText().toString().trim().replaceAll("\\s+", "");
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
                new DownLoadJsonPost(new DownLoadJsonPost.ProtocolDownLoadJsonPost() {
                    @Override
                    public void completeDownLoadJsonPost(String s) {
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            String result = jsonObject.getString("result");
                            if(Integer.parseInt(result) == 1){
                                mEditor.putString("Email", email);
                                mEditor.putString("Password", password);
                                mEditor.commit();
                                Toast.makeText(getActivity(), "Đăng nhập thành công.", Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        getActivity().startActivity(MainActivity.newIntent(getActivity()));
                                    }
                                }, 2000);
                            }else{
                                Toast.makeText(getActivity(), "Đăng nhập thất bại.", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }).execute(ParseJson.BASE_URL + "dang-nhap-thanh-vien.php", "email", email, "matkhau", password);

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
