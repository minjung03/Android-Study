package com.cookandroid.project11_2_gridview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MovieAdpter extends BaseAdapter {

    Integer[] img;

    /*
    getCount( )와 getView( ) 메소드 오버라이딩

    • getCount( ) : 그리드뷰에 보여질 이미지의 개수를
    반환하도록 수정
    • getView( ) : 영화 포스터를 각 그리드뷰의 칸마다
    이미지뷰를 생성해서 보여주게 함
     */
    MovieAdpter(Integer[] img){
        this.img = img;
    }

    @Override
    public int getCount() {
        return img.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imgV;

        if(view==null){
            view = View.inflate(viewGroup.getContext(), R.layout.item, null);
        }
        imgV = view.findViewById(R.id.imgMovie);
        imgV.setImageResource(img[i]);
        return view;
    }

}
