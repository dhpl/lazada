package com.philong.lazada.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.philong.lazada.R;
import com.philong.lazada.model.NhanVien;
import com.philong.lazada.util.DownLoadJsonPost;
import com.philong.lazada.util.ParseJson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Long on 9/6/2017.
 */

public class FragmentDangKy extends Fragment {

    private TextInputLayout mDangKyTextInputLayout;
    private TextInputEditText mDangKyTenTextInputEditText;
    private TextInputLayout mDangKyEmailTextInputLayout;
    private TextInputEditText mDangKyEmailTextEditText;
    private TextInputEditText mDangKyMatKhauTextInputEditText;
    private TextInputEditText mDangKyNhapLaiMatKhauTextInputEditText;
    private SwitchCompat mDangKySwitch;
    private Button mDangKyButton;
    private TextInputLayout mNhapLaiMatKhauTextInputLayout;
    private ProtocolDangKyThanhCong mProtocolDangKyThanhCong;





    public static FragmentDangKy newInstance() {
        Bundle args = new Bundle();
        FragmentDangKy fragment = new FragmentDangKy();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mProtocolDangKyThanhCong = (ProtocolDangKyThanhCong) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dang_ky, container, false);
        //Get view
        mDangKyTextInputLayout = (TextInputLayout) view.findViewById(R.id.dang_ky_ten_text_input);
        mDangKyTenTextInputEditText = (TextInputEditText) view.findViewById(R.id.dang_ky_ten_edit_text);
        mDangKyEmailTextInputLayout = (TextInputLayout) view.findViewById(R.id.dang_ky_ten_email_text_input);
        mDangKyEmailTextEditText = (TextInputEditText) view.findViewById(R.id.dang_ky_ten_email_edit_text);
        mDangKyMatKhauTextInputEditText = (TextInputEditText) view.findViewById(R.id.dang_ky_mat_khau_edit_text);
        mDangKyNhapLaiMatKhauTextInputEditText = (TextInputEditText) view.findViewById(R.id.dang_ky_nhap_lai_mat_khau_edit_text);
        mDangKySwitch = (SwitchCompat) view.findViewById(R.id.dang_ky_switch);
        mDangKyButton = (Button) view.findViewById(R.id.dang_ky_button);
        mNhapLaiMatKhauTextInputLayout = (TextInputLayout) view.findViewById(R.id.dang_ky_nhap_lai_mat_khau_text_input);
        //Set Dang nhap
        mDangKyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = mDangKyTenTextInputEditText.getText().toString().trim();
                String email = mDangKyEmailTextEditText.getText().toString().trim();
                String matKhau  = mDangKyMatKhauTextInputEditText.getText().toString().trim();
                String nhapLaiMatKhau = mDangKyNhapLaiMatKhauTextInputEditText.getText().toString().trim();
                if(TextUtils.isEmpty(ten)){
                    mDangKyTenTextInputEditText.setError("Tên không được để trống.");
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    mDangKyEmailTextEditText.setError("Email không được để trống.");
                    return;
                }
                if(!checkEmail(email)){
                    mDangKyEmailTextEditText.setError("Email không đúng định dạng");
                    return;
                }
                if(TextUtils.isEmpty(matKhau)){
                    mDangKyMatKhauTextInputEditText.setError("Mật khẩu không được để trống.");
                    return;
                }
                if(TextUtils.isEmpty(nhapLaiMatKhau)){
                    mDangKyNhapLaiMatKhauTextInputEditText.setError("Nhập lại mật khẩu không được để trống.");
                    return;
                }
                if(!matKhau.equals(nhapLaiMatKhau)){
                   mDangKyMatKhauTextInputEditText.setError("Mật khẩu phải trùng nhau.");
                    return;
                }
                final NhanVien nhanVien = new NhanVien();
                nhanVien.setTen(ten);
                if(mDangKySwitch.isChecked()){
                    nhanVien.setEmailDocQuyen("true");
                }else{
                    nhanVien.setEmailDocQuyen("false");
                }
                nhanVien.setMatKhau(matKhau);
                nhanVien.setEmail(email);
                new DownLoadJsonPost(new DownLoadJsonPost.ProtocolDownLoadJsonPost() {
                    @Override
                    public void completeDownLoadJsonPost(String s) {
                        try {
                            System.out.println("JSON: " + s);
                            JSONObject jsonObject = new JSONObject(s);
                            String message = jsonObject.getString("result");
                            if(Integer.parseInt(message) == 1){
                                Toast.makeText(getActivity(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        mProtocolDangKyThanhCong.completeDangKyThanhCong(true, nhanVien);
                                    }
                                }, 2000);
                            }else{
                                Toast.makeText(getActivity(), "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).execute(ParseJson.BASE_URL + "dang-ky-thanh-vien.php", "tennv", nhanVien.getTen(), "tendangnhap", nhanVien.getEmail(),"matkhau", nhanVien.getMatKhau(), "maloainv", "2", "emaildocquyen", nhanVien.getEmailDocQuyen());
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

    public interface ProtocolDangKyThanhCong{
        void completeDangKyThanhCong(boolean isComplete, NhanVien nhanVien);
    }
}
