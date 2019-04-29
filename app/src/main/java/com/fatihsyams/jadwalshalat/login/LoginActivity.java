package com.fatihsyams.jadwalshalat.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fatihsyams.jadwalshalat.MainActivity;
import com.fatihsyams.jadwalshalat.R;
import com.fatihsyams.jadwalshalat.response.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.edt_email_login)
    EditText edtEmailLogin;
    @BindView(R.id.edt_pass_login)
    EditText edtPassLogin;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private ProgressDialog progressDialog;
    LoginPresenter loginPresenter = new LoginPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }


    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(" Loading .. ");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void onSukses(String msg, User user) {
        Toasty.success(this, "Login Anda Berhasil", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onFailed(String msg) {
        Toasty.error(this, " Login Anda Gagal", Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        loginPresenter.whenLogin(edtEmailLogin.getText().toString(), edtPassLogin.getText().toString());
    }
}
