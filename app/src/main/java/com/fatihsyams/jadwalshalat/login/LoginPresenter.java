package com.fatihsyams.jadwalshalat.login;

import android.content.Context;
import android.widget.Toast;

import com.fatihsyams.jadwalshalat.network.ApiLoginClient;
import com.fatihsyams.jadwalshalat.network.ApiLoginInterface;
import com.fatihsyams.jadwalshalat.response.Status;
import com.fatihsyams.jadwalshalat.response.User;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {
     LoginContract.View view;
     Status status;
     ApiLoginInterface apiLoginInterface = ApiLoginClient.getClient().create(ApiLoginInterface.class);


    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void whenLogin(String email, String password) {
        if (email == null || email.isEmpty()){
            view.onFailed("Masukan Email Anda");
            return;
        }
        if (password == null || password.isEmpty()) {
            view.onFailed("Masukan Password Anda");
            return;
        }
        view.showProgress();
        Call<User> login = apiLoginInterface.loginUser(email, password);
        login.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body() != null) {
                    view.onSukses("Data Berhasil di Tambahkan .. ", response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                view.hideProgress();
                view.onFailed("Login Anda Gagal .. ");
            }
        });
    }
}
