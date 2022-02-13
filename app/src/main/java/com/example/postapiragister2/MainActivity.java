package com.example.postapiragister2;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle=findViewById(R.id.recycle);

        SharedPreferences sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);

        String abhi;
       abhi= sharedPreferences.getString("tokeni","");
        Log.d("sdfghjk", "sdfghjkl"+abhi);


      /*  String ravi;
        ravi=getIntent().getStringExtra("token");
        Log.d("sdertyui", "sdfghjksdfg"+ravi);*/

     RetrofitClint.getRetrofit().create(Myinterface.class).retrivedata("bearer "+abhi,1)
             .enqueue(new Callback<OneModel>() {
                 @Override
                 public void onResponse(Call<OneModel> call, Response<OneModel> response) {

                     Log.d("asdfghjk", "swertyuiokjhg"+response);
                     Log.d("loiuyghjt", "dfghnmmnb"+response.body());

                     LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                     recycle.setLayoutManager(linearLayoutManager);

                     Adapter adapter=new Adapter(MainActivity.this,response.body());
                     recycle.setAdapter(adapter);
                 }

                 @Override
                 public void onFailure(Call<OneModel> call, Throwable t) {
                     Log.d("drtyu", "sdftgyhuj"+t.getMessage());

                 }
             });

    }
}