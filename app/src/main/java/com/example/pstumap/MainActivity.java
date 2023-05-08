package com.example.pstumap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button plus_button;
    private Button minus_button;
    private Button up_button;
    private Button down_button;
    private Button left_button;
    private Button right_button;

    private ImageView map;
    private TestMap testMap = new TestMap();
    private final float SCALE_STEP = 0.5F;
    private final float MOV_STEP = 10f;


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

        map = findViewById(R.id.test_map);
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
    }
}