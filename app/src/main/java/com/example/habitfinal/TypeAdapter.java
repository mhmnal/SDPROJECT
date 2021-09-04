package com.example.habitfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TypeAdapter extends ArrayAdapter<TypeItem> {

    public TypeAdapter(Context context, ArrayList<TypeItem> TypeList){
        super(context, 0, TypeList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.type_spinner,parent,false
            );
        }

        TextView textViewName = convertView.findViewById(R.id.txspinner);
        TypeItem currentItem = getItem(position);

        if(currentItem != null) {
            textViewName.setText(currentItem.getTypeName());
        }
        return convertView;
    }
}
