package com.fatihsyams.jadwalshalat.main;

import android.content.Context;

import com.fatihsyams.jadwalshalat.response.ItemsItem;

import java.util.List;

public interface MainContract {

    interface View{
        void showProgress();
        void hideProgress();
        void loadData(List<ItemsItem> itemsItem);
        void showSuccesMessage(String msg);
        void showFailedMessage(String msg);

    }

    interface Presenter{
        void getData();
        void customAlertDialog(Context context);
        void logoutSession(Context context);
    }
}
