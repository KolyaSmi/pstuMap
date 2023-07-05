package com.example.pstumap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pstumap.fragments.FragmentManager;
import com.example.pstumap.source.FrameManager;

public class MainActivity extends AppCompatActivity {

    private ImageButton plus_button;
    private ImageButton minus_button;
    private ImageButton floor_up_button;
    private ImageButton floor_down_button;
    private ImageButton change_frame_button;
    private static TextView building;

    public static TextView floor_number;

    public static FrameLayout frame_up_window;

    public static boolean onClick;

    public static float stand_y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager.initFragment();

        initElement();
        setButtonEvents();
    }

    private void initElement() {
        plus_button = findViewById(R.id.scale_plus);
        minus_button = findViewById(R.id.scale_minus);

        floor_up_button = findViewById(R.id.floor_up_button);
        floor_down_button = findViewById(R.id.floor_down_button);

        floor_number = findViewById(R.id.floor_number);
//        floor_number.setText( "");

        change_frame_button = findViewById(R.id.change_frame_button);
        building = findViewById(R.id.building);

        frame_up_window = findViewById(R.id.frame_up_window);

        onClick = false;

        FragmentManager.setFragmentTransaction(this);
        Log.d("setFrames", "add fragments");
    }

    private void setButtonEvents(){
        plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameManager.scaleMapPlus();
            }
        });

        minus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameManager.scaleMapMinus();
            }
        });

        floor_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               floor_number.setText((FrameManager.upFloor() + 1) + "");
            }
        });

        floor_down_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floor_number.setText((FrameManager.downFloor() + 1) + "");
            }
        });

        change_frame_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                

                FrameManager.checkOpenIcons();
                if(onClick) {
                    FragmentManager.hideFragment(FragmentManager.change_frame_window);
//                    frame_up_window.setY(stand_y);
                    onClick = false;
                }else {
                    FragmentManager.showFragment(FragmentManager.change_frame_window);
                    onClick = true;
                }
            }
        });
    }

    public static FrameLayout getFrameUpWindow(){
        return frame_up_window;
    }

    public static void changeTitle(int frame){
        building.setText(FrameManager.getTitle(frame));
    }
}