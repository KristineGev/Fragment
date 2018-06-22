package com.app.viewgroup.fragments.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.app.viewgroup.fragments.R;


public class Fragment_Two extends android.app.Fragment{
    public static final String TEXT2 = "B";




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment__two, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            String text = getArguments().getString(TEXT2);
            ((TextView) view.findViewById(R.id.text2))
                    .setText(text);

     int color=getArguments().getInt("color2");
     FrameLayout fl=  ((FrameLayout)view.findViewById(R.id.frameLayout2));
     fl.setBackgroundColor(color);

        }
    }}


