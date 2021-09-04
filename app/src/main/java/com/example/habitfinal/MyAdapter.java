package com.example.habitfinal;

import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    private OnListListener mOnListListener;


    ArrayList<cHabitInfo> list;

    public MyAdapter(Context context, ArrayList<cHabitInfo> list, OnListListener onListListener) {
        this.context = context;
        this.list = list;
        this.mOnListListener = onListListener;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return new MyViewHolder(v, mOnListListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        cHabitInfo chabitInfo = list.get(position);
        holder.namehabittrv.setText(chabitInfo.getNameHabit());
        holder.habittype.setText(chabitInfo.getText1());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView namehabittrv;
        TextView habittype;
        OnListListener onListListener;


        public MyViewHolder(@NonNull View itemView, OnListListener onListListener) {
            super(itemView);

            namehabittrv = itemView.findViewById(R.id.namehabitrv);
            habittype = itemView.findViewById(R.id.habittype);
            this.onListListener = onListListener;

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            onListListener.onListClick(getAdapterPosition());
        }
    }

    public interface OnListListener{
        void onListClick(int position);
    }


}
