package com.cookandroid.project11_2_customexam;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhoneAdapter extends BaseAdapter {

    Context pContext;
    ArrayList<Phone> pData;

    public PhoneAdapter(Context context, ArrayList<Phone> pData){
        this.pContext = context;
        this.pData = pData;
    }

    @Override
    public int getCount() {
        return pData.size();
    }

    @Override
    public Object getItem(int position) {
        return pData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = View.inflate(pContext, R.layout.item, null);
        }
        ImageView image = convertView.findViewById(R.id.itemImg);
        TextView title = convertView.findViewById(R.id.itemTextV);

        image.setImageDrawable(pData.get(position).image);
        title.setText(pData.get(position).PName);

        return convertView;
    }
}
