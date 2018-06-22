package com.app.viewgroup.fragments.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.viewgroup.fragments.MainActivity;
import com.app.viewgroup.fragments.R;


public class Fragment_One extends Fragment {

    public static final String TEXT = "text";
    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment__one, container, false);


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        if (getArguments() != null) {
            String text = getArguments().getString(TEXT);
            int color = getArguments().getInt("color");
           textView= ((TextView) view.findViewById(R.id.text1));
           textView.setText(text);
            ((FrameLayout)view.findViewById(R.id.frameLayout1)).setBackgroundColor(color);



        }
    }


}
