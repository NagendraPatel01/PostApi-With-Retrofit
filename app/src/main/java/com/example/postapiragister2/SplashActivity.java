package com.example.postapiragister2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        SharedPreferences sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);

        String ankit=sharedPreferences.getString("name","");
        Log.d("sdfghjk", "dfghjk"+ankit);
        String bhup=sharedPreferences.getString("password","");
        Log.d("sdfghjk", "ntfghytghg"+bhup);


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (bhup!=null && !bhup.equals("")){

                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }
                else {

                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));

                    finish();
                }

            }
        },2000);
    }
}