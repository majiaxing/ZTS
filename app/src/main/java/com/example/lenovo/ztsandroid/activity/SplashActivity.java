package com.example.lenovo.ztsandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.lenovo.ztsandroid.R;


/**
 * Created by Lenovo on 2017/6/14.
 */
public class SplashActivity extends Activity {
    private SharedPreferences mShared;

    private String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qdy_activity);

        mShared=getSharedPreferences("data",MODE_PRIVATE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                uid=mShared.getString("uid","");

                if (uid.isEmpty()){

                    Intent intent = new Intent(SplashActivity.this, YindaoActivity.class);
                    startActivity(intent);
                    finish();

                }else {

                    Intent intent=new Intent(SplashActivity.this, Login_Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },3000);

    }


}
