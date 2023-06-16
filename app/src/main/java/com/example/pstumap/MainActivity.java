package com.example.pstumap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.pstumap.fragments.FragmentManager;
import com.example.pstumap.fragments.MapComplexG1;
import com.example.pstumap.source.FrameManager;

public class MainActivity extends AppCompatActivity {

    private Button plus_button;
    private Button minus_button;
    private Button floor_up_button;
    private Button floor_down_button;

    private FrameLayout frame_layout;

    private float X;
    private float Y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager.initFragment();

        initElement();
        setTouchListener();
        setButtonEvents();
    }

    private void setTouchListener() {
        frame_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    FrameManager.setPos();
                    X = event.getX();
                    Y = event.getY();
                }
                if (MotionEvent.ACTION_MOVE == event.getAction()) {
                    FrameManager.moveMap(event.getX() - X, event.getY() - Y);
                }
                return true;
            }
        });
    }

    private void initElement() {
        plus_button = findViewById(R.id.scale_plus);
        minus_button = findViewById(R.id.scale_minus);

        floor_up_button = findViewById(R.id.floor_up_button);
        floor_down_button = findViewById(R.id.floor_down_button);

        frame_layout = findViewById(R.id.frame_layout);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FrameManager.setFragmentTransaction(ft);
        //закончил тут
        ft.add(R.id.frame_layout, FragmentManager.map_complex_g_1)
                .add(R.id.frame_layout, FragmentManager.map_complex_g_2).commit();
        ft.hide(FragmentManager.map_complex_g_1);
        Log.d("setFrames", "add fragments");
//        ft.replace(R.id.frame_layout, FragmentManager.map_complex_g_1).commit();
//        ft.replace(R.id.frame_layout, FragmentManager.map_complex_g_2).commit();
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
                FrameManager.upFloor();
            }
        });

        floor_down_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameManager.downFloor();
            }
        });
    }
}