package com.cookandroid.martmall_0826;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GoodsAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<Goods> mData;

    public GoodsAdapter(Context mContext, ArrayList<Goods> mData) {
        this.mContext = mContext; // 메인 액티버티 컨텍스트를 저장
        this.mData = mData; // ListViewItem 아이템 데이터를 저장한 배열리스트를 저장
    }

    @Override
    public int getCount() { // 리스트 내의 아이템 개수 반환
        return mData.size();
    }

    @Override
    public Object getItem(int i) { // 전달받은 i 위치의 리스트 개게의 아이템 반환
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) { // 전달받은 i 위치에 해당하는 리스트 객체의 해당하는 행번호를 반환
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){ // 재사용 되는 view가 없을 때
            view = view.inflate(mContext, R.layout.listitem, null); // listitem.xml 레이아웃을 inflate
        }

        ImageView goodsImg = (ImageView)view.findViewById(R.id.imgPoster);
        TextView goodTitle = (TextView)view.findViewById(R.id.txtTitle);
        TextView goodPrice = (TextView)view.findViewById(R.id.txtPrice);

        goodsImg.setImageResource(mData.get(i).getImage_id());
        goodTitle.setText(mData.get(i).getTitle());
        goodPrice.setText(mData.get(i).getPrice()+"원");

        return view;
        }
}
