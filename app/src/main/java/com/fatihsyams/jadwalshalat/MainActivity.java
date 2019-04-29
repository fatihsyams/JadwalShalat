package com.fatihsyams.jadwalshalat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.fatihsyams.jadwalshalat.adapter.MainAdapter;
import com.fatihsyams.jadwalshalat.main.MainContract;
import com.fatihsyams.jadwalshalat.main.MainPresenter;
import com.fatihsyams.jadwalshalat.response.ItemsItem;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    CarouselView carouselView;
    int[] sampleImage = {R.drawable.bgslide, R.drawable.gb1};

    RecyclerView recMain;
    MainAdapter adapter;
    Button btnLogout;

    private ProgressDialog progressDialog;
    private MainPresenter mainPresenter = new MainPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setInit();
        customActionBar();
        mainPresenter.getData();

    }

    private void setInit() {
        recMain = findViewById(R.id.recMain);
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImage.length);
        btnLogout = findViewById(R.id.btn_logout);
        carouselView.setImageListener(imageListener);


    }

    private void customActionBar() {

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImage[position]);
        }
    };

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();

    }

    @Override
    public void loadData(List<ItemsItem> itemsItem) {
        adapter = new MainAdapter(MainActivity.this, itemsItem);
        recMain.setLayoutManager(new LinearLayoutManager(this));
        recMain.setAdapter(new MainAdapter(this, itemsItem));


    }

    @Override
    public void showSuccesMessage(String msg) {
        Toasty.success(this, "Data Berhasil di tambahkan..", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();


    }



    public void showAlert(View v) {
        mainPresenter.customAlertDialog(this);
    }

    public void Logout(View v){
        mainPresenter.logoutSession(this);
    }
    public void gantiBahasa(View v){
        Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
        startActivity(intent);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_logout:
//                mainPresenter.logoutSession(this);
//                finish();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//
//        }
//    }
}
