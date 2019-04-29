package com.fatihsyams.jadwalshalat.network;

import com.fatihsyams.jadwalshalat.response.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiLoginInterface {

    @FormUrlEncoded
    @POST("rpld/login.php")
    Call<User> loginUser (@Field("email") String email,
                          @Field("pass") String pass);

}
