package com.cookandroid.tablayout_test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {

    // 여기 안에 커서를 두고 위 code에서 ovrride methods 선택 => onCreateView 선택

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            super.onCreateView(inflater, container, savedInstanceState);

            View v = inflater.inflate(R.layout.frag1, container, false);
            return v;
        }
}
