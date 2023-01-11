package com.example.myparking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myparking.EntityClass.UserModel;
import com.example.myparking.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context context;
    List<UserModel> list;

    public UserAdapter(Context context, List<UserModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.kodelahan.setText(list.get(position).getKd_lahan());
        holder.nmpemilik.setText(list.get(position).getNmpemilik());
        holder.merkmobil.setText(list.get(position).getMerkmobil());
        holder.warnamobil.setText(list.get(position).getWarnamobil());
        holder.platnomor.setText(list.get(position).getPlatnomor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView kodelahan,nmpemilik,merkmobil,warnamobil,platnomor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            kodelahan =itemView.findViewById(R.id.kodelahan);
            nmpemilik = itemView.findViewById(R.id.nmpemilik);
            merkmobil = itemView.findViewById(R.id.merkmobil);
            warnamobil = itemView.findViewById(R.id.warnamobil);
            platnomor = itemView.findViewById(R.id.platnomor);

        }
    }
}

