package com.example.pstumap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private Button plus_button;
    private Button minus_button;
    private Button up_button;
    private Button down_button;
    private Button left_button;
    private Button right_button;
    private Button flor_1_button;
    private Button flor_2_button;
    //test
    private TextView text;
    //end test

    private ImageView map;
    private TestMap testMap = new TestMap();
    private final float SCALE_STEP = 0.5F;
    private final float MOV_STEP = 25f;

    private float dX = 0;
    private float dY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initElement();
        setButtonEvents();

//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.frame_layout, testMap);
    }



    private void initElement(){
        plus_button = findViewById(R.id.scale_plus);
        minus_button = findViewById(R.id.scale_minus);

        up_button = findViewById(R.id.up_button);
        down_button = findViewById(R.id.down_button);
        left_button = findViewById(R.id.left_button);
        right_button = findViewById(R.id.right_button);

        flor_1_button = findViewById(R.id.floor_1_button);
        flor_2_button = findViewById(R.id.floor_2_button);

        //test
        text = findViewById(R.id.textView2);
        //end test

        map = findViewById(R.id.test_map);
        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    dX = event.getX();
                    dY = event.getY();
                }
                if (MotionEvent.ACTION_MOVE == event.getAction()) {
                    //test
                    text.setText(event.getX() + " " + event.getY());
                    //end test
                    movMap(event.getX() - dX, event.getY() - dY);
                }
                return true;
            }
        });
    }

    private void scaleMap(float scale){
        map.setScaleX(map.getScaleX() + scale);
        map.setScaleY(map.getScaleY() + scale);
    }

    private void movMap(float dx, float dy){
        float x = map.getX();
        float y = map.getY();
        map.setX(x + dx);
        map.setY(y + dy);
    }

    private void setImage(int image){
        map.setImageResource(image);
    }

    private void setButtonEvents(){
        plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleMap(SCALE_STEP);
            }
        });

        minus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleMap(-SCALE_STEP);
            }
        });

        up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movMap(0, -MOV_STEP);
            }
        });

        down_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movMap(0, MOV_STEP);
            }
        });

        left_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movMap(-MOV_STEP, 0);
            }
        });

        right_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movMap(MOV_STEP, 0);
            }
        });

        flor_1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setImage(R.drawable.test_map);
            }
        });

        flor_2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setImage(R.drawable.test_map_2);
            }
        });
    }
}