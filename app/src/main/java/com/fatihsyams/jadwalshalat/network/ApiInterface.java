package com.fatihsyams.jadwalshalat.network;

import com.fatihsyams.jadwalshalat.response.ItemsItem;
import com.fatihsyams.jadwalshalat.response.ResponseSholat;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("jakarta.json?key=1536ed325f6ab53238a6b7004fbd58f4")
    Call<ResponseSholat> getJadwalShalat();
}
