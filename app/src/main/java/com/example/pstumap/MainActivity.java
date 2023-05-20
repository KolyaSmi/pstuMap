package com.example.pstumap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pstumap.data.Config;
import com.example.pstumap.floorsfragment.TestMap;
import com.example.pstumap.source.Engine;

public class MainActivity extends AppCompatActivity{

    private Button plus_button;
    private Button minus_button;
    private Button floor_up_button;
    private Button floor_down_button;
    private TextView floor_number;
    private FrameLayout frame_layout;

    //test
    private TextView text;

    float X = 0;
    float Y = 0;
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

        text = findViewById(R.id.textView2);
        //end test

        frame_layout = findViewById(R.id.frame_layout);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        engine = new Engine(ft, floor_number, 1);

        frame_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    engine.setDiffPos();
                    X = event.getX();
                    Y = event.getY();
                }
                if (MotionEvent.ACTION_MOVE == event.getAction()) {
                    //test
                    text.setText((event.getX() - X) + " " + (event.getY() - Y));
                    //end test
                    engine.moveMap(event.getX() - X, event.getY() - Y);
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

        floor_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                engine.changeFloor(Config.UP);
            }
        });

        floor_down_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                engine.changeFloor(Config.DOWN);
            }
        });
    }
}