package com.fatihsyams.jadwalshalat.login;

import com.fatihsyams.jadwalshalat.response.User;

public interface LoginContract {
    interface View {
        void showProgress();
        void hideProgress();
        void onSukses(String msg, User user);
        void onFailed(String msg);

    }
    interface Presenter {
        void whenLogin(String email, String password);
    }
}
