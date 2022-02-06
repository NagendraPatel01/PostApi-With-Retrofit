package com.example.postapiragister2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClint {

    private static Retrofit retrofit ;

 public  static Retrofit getRetrofit(){

     if (retrofit==null){


         return retrofit=new Retrofit.Builder().baseUrl("http://restapi.adequateshop.com/api/")
                 .addConverterFactory(GsonConverterFactory.create()).build();


     }
     return retrofit;
    }
}
