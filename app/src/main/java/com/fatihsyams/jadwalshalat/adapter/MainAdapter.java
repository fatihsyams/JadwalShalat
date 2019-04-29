package com.fatihsyams.jadwalshalat.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fatihsyams.jadwalshalat.MainActivity;
import com.fatihsyams.jadwalshalat.R;
import com.fatihsyams.jadwalshalat.response.ItemsItem;
import com.google.gson.annotations.JsonAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final Context context;
    private final List<ItemsItem> itemsItemList;


    public MainAdapter(Context context, List<ItemsItem> itemsItemList) {
        this.context = context;
        this.itemsItemList = itemsItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.rec_main, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.jadwalShalatSubuh.setText(itemsItemList.get(0).getFajr());
        viewHolder.dzhur.setText(itemsItemList.get(0).getDhuhr());
        viewHolder.ashar.setText(itemsItemList.get(0).getAsr());
        viewHolder.magrib.setText(itemsItemList.get(0).getMaghrib());
        viewHolder.isya.setText(itemsItemList.get(0).getIsha());


    }

    @Override
    public int getItemCount() {
        if (itemsItemList == null) return 0;
        return itemsItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView jadwalShalatSubuh, dzhur, ashar, magrib, isya;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jadwalShalatSubuh = itemView.findViewById(R.id.jadwalShalat);
            dzhur = itemView.findViewById(R.id.jadwalShalatDzhur);
            ashar = itemView.findViewById(R.id.jadwalShalatAshar);
            magrib = itemView.findViewById(R.id.jadwalShalatMagrib);
            isya = itemView.findViewById(R.id.jadwalShalatISYA);
        }
    }
}
