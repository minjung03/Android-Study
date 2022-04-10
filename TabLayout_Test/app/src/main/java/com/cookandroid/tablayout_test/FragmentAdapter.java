package com.cookandroid.tablayout_test;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentPagerAdapter {

    //프레그먼트를 생성하여 저장할 ArrayList
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();

    // 생성자를 만들어 줘야 한다.
    public FragmentAdapter(FragmentManager fm) {
        super(fm);

        // ArrayList에 프레그먼트를 생성하여 저장
        fragmentList.add(new FragExam1_1());
        fragmentList.add(new FragExam1_2());
    }

    // ViewPager의 화면이 변경될 때 n번째 해당 위치에 따른 Fragment 객체를 리턴
    @Override
    public Fragment getItem(int position) { // getItem 오버라이딩
        return fragmentList.get(position);
    }

    // ViewPager에 넣을 화면의 갯수를 리턴
    @Override
    public int getCount() { // getCount 오버라이딩
        return fragmentList.size();
    }
}
