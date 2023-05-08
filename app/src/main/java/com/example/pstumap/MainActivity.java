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
    private ImageView map;
    private TestMap testMap = new TestMap();
    private final float SCALE_STEP = 0.5F;


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
        map = findViewById(R.id.test_map);
    }

    private void scaleMap(float scale){
        map.setScaleX(map.getScaleX() + scale);
        map.setScaleY(map.getScaleY() + scale);
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
    }
}