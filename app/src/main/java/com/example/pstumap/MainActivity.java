package com.example.pstumap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pstumap.fragments.FragmentManager;
import com.example.pstumap.source.FrameManager;

public class MainActivity extends AppCompatActivity {

    private ImageButton plus_button;
    private ImageButton minus_button;
    private ImageButton floor_up_button;
    private ImageButton floor_down_button;
    private ImageButton change_frame_button;

    public TextView floor_number;

    private FrameLayout frame_layout;
    private static FrameLayout frame_up_window;

    private FragmentTransaction ft;

    public static boolean onClick;

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
//        frame_layout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent event) {
//                if (MotionEvent.ACTION_DOWN == event.getAction()) {
//                    X = event.getX();
//                    Y = event.getY();
//                }
//                if (MotionEvent.ACTION_MOVE == event.getAction()) {
//                    FrameManager.moveMap(event.getX() - X, event.getY() - Y);
//                }
//                if (MotionEvent.ACTION_UP == event.getAction()) {
//                    FrameManager.setPos();
//                }
//                return true;
//            }
//        });
    }

    private void initElement() {
        plus_button = findViewById(R.id.scale_plus);
        minus_button = findViewById(R.id.scale_minus);

        floor_up_button = findViewById(R.id.floor_up_button);
        floor_down_button = findViewById(R.id.floor_down_button);

        floor_number = findViewById(R.id.floor_number);
//        floor_number.setText( "");

        change_frame_button = findViewById(R.id.change_frame_button);

        frame_layout = findViewById(R.id.frame_layout);
        frame_up_window = findViewById(R.id.frame_up_window);

        onClick = false;

        ft = getSupportFragmentManager().beginTransaction();
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
                    FragmentManager.removeFragmentInUpWindow(FragmentManager.change_frame_window);
                    onClick = false;
                }else {
                    FragmentManager.replaceFragmentInUpWindow(FragmentManager.change_frame_window);
                    onClick = true;
                }
            }
        });
    }

    public static FrameLayout getFrameUpWindow(){
        return frame_up_window;
    }
}