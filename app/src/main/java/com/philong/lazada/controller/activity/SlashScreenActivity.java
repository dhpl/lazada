package com.philong.lazada.controller.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.philong.lazada.R;
import com.philong.lazada.util.CheckInternet;

public class SlashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash_screen);
        if(CheckInternet.isInternet(this)){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(MainActivity.newIntent(SlashScreenActivity.this));
                    finish();
                }
            }, 2000);
        }else{
            Toast.makeText(this, "Không có kết nối Internet.", Toast.LENGTH_SHORT).show();
        }
       
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerChangeInternet();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mChangeInternetBroadcastReceiver);
    }

    private BroadcastReceiver mChangeInternetBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(CheckInternet.isInternet(SlashScreenActivity.this)){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(MainActivity.newIntent(SlashScreenActivity.this));
                        finish();
                    }
                }, 2000);
            }
        }
    };

    private void registerChangeInternet(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(mChangeInternetBroadcastReceiver, intentFilter);
    }
}
