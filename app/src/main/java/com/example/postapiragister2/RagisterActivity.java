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

public class RagisterActivity extends AppCompatActivity {

    EditText name,email,password;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragister);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(RagisterActivity.this,LoginActivity.class));

            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(email.getText().toString())){

                    Toast.makeText(RagisterActivity.this, "please enter email", Toast.LENGTH_SHORT).show();
                }

                else  if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){

                    Toast.makeText(RagisterActivity.this, "please enter valid email", Toast.LENGTH_SHORT).show();
                }


                else if (TextUtils.isEmpty(name.getText().toString())){

                    Toast.makeText(RagisterActivity.this, "please enter name", Toast.LENGTH_SHORT).show();

                }

                else if (TextUtils.isEmpty(password.getText().toString())){

                    Toast.makeText(RagisterActivity.this, "please enter Password", Toast.LENGTH_SHORT).show();

                }

                else if (password.getText().toString().length()<6){

                    Toast.makeText(RagisterActivity.this, "please enter 6 digit or more then password", Toast.LENGTH_SHORT).show();

                }

                else {

                  PostModel postModel=new PostModel(name.getText().toString(),email.getText().toString()
                  ,password.getText().toString());

                    RetrofitClint.getRetrofit().create(Myinterface.class)
                            .getdata(postModel).enqueue(new Callback<getmodel>() {
                        @Override
                        public void onResponse(Call<getmodel> call, Response<getmodel> response) {

                            Log.d("dfghjk", "sdfuytyujghj"+response);
                            Log.d("dfghjk", "sdfsdsghjk"+response.body());




                            Toast.makeText(RagisterActivity.this, "ragister success", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(RagisterActivity.this,LoginActivity.class));

                            finish();
                        }

                        @Override
                        public void onFailure(Call<getmodel> call, Throwable t) {
                            Log.d("sdfghjk", "sdfghjkl"+t.getMessage());

                            Toast.makeText(RagisterActivity.this, "ragister field", Toast.LENGTH_SHORT).show();


                        }
                    });

                }


            }
        });
    }
}