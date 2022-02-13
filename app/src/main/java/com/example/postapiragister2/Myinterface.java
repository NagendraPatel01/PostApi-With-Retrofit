package com.example.postapiragister2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Myinterface {

    @POST("authaccount/registration")
    Call<getmodel> getdata(@Body PostModel postModel);

    @POST("authaccount/login")
    Call<getmodel>postdata(@Body SendModel sendModel);

    
    @GET("users")
    Call<OneModel>retrivedata(@Header("Authorization")String Authorization, @Query("page")int page);

}
