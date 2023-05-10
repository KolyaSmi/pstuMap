package com.example.pstumap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
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
    private TextView floor_number;
    //test
    private TextView text;
    //end test

    private Engine engine;

    private ImageView map;

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
        floor_number = findViewById(R.id.floor_number);

        //test
        text = findViewById(R.id.textView2);
        //end test

        map = findViewById(R.id.test_map);

        engine = new Engine(map, floor_number, 1);

        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    engine.setDiffPos(event.getX(), event.getY());
                }
                if (MotionEvent.ACTION_MOVE == event.getAction()) {
                    //test
                    text.setText(event.getX() + " " + event.getY());
                    //end test
                    engine.moveMap(event.getX(), event.getY());
                }
                return true;
            }
        });
    }



    private void setButtonEvents(){
        plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                engine.scaleMap(1);
            }
        });

        minus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                engine.scaleMap(-1);
            }
        });

        up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                engine.moveMap(Config.UP);
            }
        });

        down_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                engine.moveMap(Config.DOWN);
            }
        });

        left_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                engine.moveMap(Config.LEFT);
            }
        });

        right_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                engine.moveMap(Config.RIGHT);
            }
        });

        flor_1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                engine.setImage(R.drawable.test_map);
                engine.setFloor(Config.UP);
            }
        });

        flor_2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                engine.setImage(R.drawable.test_map_2);
                engine.setFloor(Config.DOWN);
            }
        });
    }
}