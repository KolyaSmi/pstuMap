package com.example.pstumap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
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
    private ImageView map;

    //test
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

        text = findViewById(R.id.textView2);
        //end test

//        map = findViewById(R.id.test_map);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

//        engine = new Engine(map, floor_number, 1);
        engine = new Engine(ft, floor_number, 1);

//        map.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent event) {
//                if (MotionEvent.ACTION_DOWN == event.getAction()) {
//                    engine.setDiffPos(event.getX(), event.getY());
//                }
//                if (MotionEvent.ACTION_MOVE == event.getAction()) {
//                    //test
//                    text.setText(event.getX() + " " + event.getY());
//                    //end test
//                    engine.moveMap(event.getX(), event.getY());
//                }
//                return true;
//            }
//        });
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