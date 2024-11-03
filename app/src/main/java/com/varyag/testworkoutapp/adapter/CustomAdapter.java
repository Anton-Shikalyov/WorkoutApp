package com.varyag.testworkoutapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.varyag.testworkoutapp.R;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {

    private Context context;
    private int mResource;
    private int dropDownResource;
    private List<String> items;

    public CustomAdapter(@NonNull Context context, int mResource, int dropDownResource, List<String> items) {
        super(context, mResource, items);
        this.context = context;
        this.mResource = mResource;
        this.dropDownResource = dropDownResource;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(mResource, parent, false);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        tvTitle.setText(items.get(position));
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(dropDownResource, parent, false);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        tvTitle.setText(items.get(position));
        return view;
    }
}
