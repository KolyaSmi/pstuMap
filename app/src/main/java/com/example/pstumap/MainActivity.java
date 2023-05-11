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
    private Button floor_up_button;
    private Button floor_down_button;
    private TextView floor_number;
    private ImageView map;

    //test
    private Button up_button;
    private Button down_button;
    private Button left_button;
    private Button right_button;
    private TextView text;
    //end test

    private Engine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initElement();
        setButtonEvents();

    }

    private void initElement(){
        plus_button = findViewById(R.id.scale_plus);
        minus_button = findViewById(R.id.scale_minus);

        floor_up_button = findViewById(R.id.floor_up_button);
        floor_down_button = findViewById(R.id.floor_down_button);
        floor_number = findViewById(R.id.floor_number);

        //test
        up_button = findViewById(R.id.up_button);
        down_button = findViewById(R.id.down_button);
        left_button = findViewById(R.id.left_button);
        right_button = findViewById(R.id.right_button);

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

        //test
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
        //end test

        floor_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                engine.setFloor(Config.UP);
            }
        });

        floor_down_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                engine.setFloor(Config.DOWN);
            }
        });
    }
}