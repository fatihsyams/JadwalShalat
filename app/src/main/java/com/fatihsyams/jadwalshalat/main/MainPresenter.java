package com.fatihsyams.jadwalshalat.main;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.fatihsyams.jadwalshalat.MainActivity;
import com.fatihsyams.jadwalshalat.R;
import com.fatihsyams.jadwalshalat.Utils.SessionManager;
import com.fatihsyams.jadwalshalat.network.ApiClient;
import com.fatihsyams.jadwalshalat.network.ApiInterface;
import com.fatihsyams.jadwalshalat.response.ResponseSholat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getData() {
        view.showProgress();

        Call<ResponseSholat> call = apiInterface.getJadwalShalat();
        call.enqueue(new Callback<ResponseSholat>() {
            @Override
            public void onResponse(Call<ResponseSholat> call, Response<ResponseSholat> response) {
                view.hideProgress();
                if (response.body() != null && response.isSuccessful()){
                    view.loadData(response.body().getItems());
                    view.showSuccesMessage("Data berhasil ditampilkan");
                }else {
                    view.showFailedMessage("Data kosong");
                }
            }

            @Override
            public void onFailure(Call<ResponseSholat> call, Throwable t) {
                view.hideProgress();

            }
        });

    }

    @Override
    public void customAlertDialog(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.cutom_alertdialog, null, false);

        android.support.v7.app.AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setView(view);

        final Dialog dialog = alert.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        dialog.show();

    }

    @Override
    public void logoutSession(Context context) {
        SessionManager mSessionManager = new SessionManager(context);
        mSessionManager.logout();
    }

}
