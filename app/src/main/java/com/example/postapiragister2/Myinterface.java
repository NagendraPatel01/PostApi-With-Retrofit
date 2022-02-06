package com.example.postapiragister2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Myinterface {

    @POST("authaccount/registration")
    Call<getmodel> getdata(@Body PostModel postModel);

    @POST("authaccount/login")
    Call<getmodel>postdata(@Body SendModel sendModel);

}
