package com.cookandroid.project11_2_gallery;

import android.content.Context;
import android.media.Image;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MyGalleryAdapter extends BaseAdapter {

    Context context;
    Integer[] poster;

     MyGalleryAdapter(Context c, Integer[] p) {
        context = c;
        poster = p;
    }

    @Override
    public int getCount() {
        return poster.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {

         /* 이런 방법도 가능
         if(converView==null){
             converView = View.inflate(parent.getContext(), R.layout.item, null);
             ImageView imgV = converView.findViewById(R.id.ivMovie);
             imgV.setImageResource(poster[position]);
         }
          */
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new Gallery.LayoutParams(100,200));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(poster[position]);
        return imageView;
    }
}
