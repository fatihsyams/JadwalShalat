package com.fatihsyams.jadwalshalat.Utils;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.fatihsyams.jadwalshalat.login.LoginActivity;

public class SessionManager {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private final Context context;

    public SessionManager(Context context) {
        this.context = context;

        pref = context.getSharedPreferences(Constant.pref_name, 0);
        editor = pref.edit();
    }

    public void logout() {
        editor.clear();
        editor.clear();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
