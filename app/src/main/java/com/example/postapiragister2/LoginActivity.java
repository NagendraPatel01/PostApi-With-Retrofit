package com.example.postapiragister2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button btn, btn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);



        SharedPreferences sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(email.getText().toString())) {

                    Toast.makeText(LoginActivity.this, "enter email", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {

                    Toast.makeText(LoginActivity.this, "enter valid email ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password.getText().toString())) {

                    Toast.makeText(LoginActivity.this, "enter password", Toast.LENGTH_SHORT).show();

                } else if (password.getText().toString().length() < 6) {

                    Toast.makeText(LoginActivity.this, "enter 6 digit password or more then", Toast.LENGTH_SHORT).show();

                } else {


                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("email",email.getText().toString());
                    editor.putString("password",password.getText().toString());



                    SendModel sendModel = new SendModel(email.getText().toString(), password.getText().toString());

                    RetrofitClint.getRetrofit()
                            .create(Myinterface.class)
                            .postdata(sendModel)
                            .enqueue(new Callback<getmodel>() {
                                @Override
                                public void onResponse(Call<getmodel> call, Response<getmodel> response) {
                                    Log.d("sdfghjk", "awertyuio" + response);
                                    Log.d("sertyuioiuytr", "drtyuiuytre" + response.body());





                                    if (response.code()==200){
                                        Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                                        if (response.body().getData()!=null){

                                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                            intent.putExtra("token",response.body().getData().getToken());
                                            editor.putString("tokeni",response.body().getData().getToken());
                                            editor.commit();
                                            Log.d("ftyuio", "dfghjkjhgfdfgh"+response.body().getData().getToken());
                                            startActivity(intent);

                                            finish();


                                        }

                                        else {
                                            Toast.makeText(LoginActivity.this, "pls valid user name or password", Toast.LENGTH_SHORT).show();
                                        }
                                    }else {
                                        Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                }

                                @Override
                                public void onFailure(Call<getmodel> call, Throwable t) {
                                    Log.d("sdfghjkl", "asdertyuio" + t.getMessage());

                                    Toast.makeText(LoginActivity.this, "login field", Toast.LENGTH_SHORT).show();

                                }
                            });
                }
            }
        });
    }
}