package com.example.btlandroid;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapter extends BaseAdapter{
    private Activity activity;
    private ArrayList<product> data;
    private LayoutInflater inflate;
    public adapter(Activity activity,ArrayList<product> item){
        this.activity = activity;
        this.data = item;
        inflate = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null){
            v = inflate.inflate(R.layout.layout,null);
        }

        TextView sp = v.findViewById(R.id.txtsp);
        TextView sl = v.findViewById(R.id.txtsl);
        TextView gia = v.findViewById(R.id.txtgia);
        ImageView img = v.findViewById(R.id.image);

        sp.setText(String.valueOf(data.get(position).getId()));
        sl.setText(String.valueOf(data.get(position).getSl()));
        gia.setText(String.valueOf(data.get(position).getPrice()));
        Uri path = Uri.parse(data.get(position).getImage());
        Glide.with(activity).load(path).into(img);
        return v;
    }
}
