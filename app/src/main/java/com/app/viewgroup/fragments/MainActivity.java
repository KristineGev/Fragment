package com.app.viewgroup.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.viewgroup.fragments.Fragment.Fragment_One;
import com.app.viewgroup.fragments.Fragment.Fragment_Three;
import com.app.viewgroup.fragments.Fragment.Fragment_Two;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String abc;
    Button add, play;
    ImageView image;
    MediaPlayer abcSong;
    Random rnd = new Random();
    FrameLayout frameLayout1;
    FrameLayout frameLayout2;
    FrameLayout frameLayout3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.add);
        play = (Button) findViewById(R.id.playBtn);

        frameLayout1=(FrameLayout)findViewById(R.id.container1);
        frameLayout2=(FrameLayout)findViewById(R.id.container2);
        frameLayout3=(FrameLayout)findViewById(R.id.container3);

        image = (ImageView) findViewById(R.id.photo);
        abcSong = MediaPlayer.create(this, R.raw.abc);

        abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_One fragment_one = new Fragment_One();
                Fragment_Two fragment_two = new Fragment_Two();
                Fragment_Three fragment_three = new Fragment_Three();
                openFragment(fragment_one, Fragment_One.TEXT, "color", R.id.container1);
                openFragment(fragment_two, Fragment_Two.TEXT2, "color2", R.id.container2);
                openFragment(fragment_three, Fragment_Three.TEXT3, "color3", R.id.container3);

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // openPlayFragment();
                abcSong.start();

            }
        });
    }


    private void openFragment(Fragment fragment, String keyForText, String keyForColor, int container) {
        Bundle arguments = new Bundle();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        arguments.putString(keyForText, String.valueOf(abc.charAt(rnd.nextInt(abc.length()))));
        arguments.putInt(keyForColor, Color.argb(200, rnd.nextInt(256),
                rnd.nextInt(256), rnd.nextInt(256)));
        fragment.setArguments(arguments);
        fragmentTransaction.replace(container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

 public void onFrameLayoutClicked(View view){
     Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();

 }
    }

