package com.example.pstumap.floorsfragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pstumap.R;
import com.example.pstumap.source.Engine;

public class TestMap extends Fragment {

    private ImageView map;
    private Engine engine;

    private ImageView icon_1;

    public void setEngine(Engine engine){
        this.engine = engine;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_test_map, container, false);
        View rootView = inflater.inflate(R.layout.fragment_test_map, container, false);

        map = rootView.findViewById(R.id.test_map);
        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    engine.setDiffPos(event.getX(), event.getY());
                }
                if (MotionEvent.ACTION_MOVE == event.getAction()) {
                    engine.moveMap(event.getX(), event.getY());
                }
                return true;
            }
        });

        icon_1 = rootView.findViewById(R.id.icon_1);
        initPlace();
        Log.i("app_log", "create icon");
        return rootView;
    }

    public void initPlace(){
        engine.complex_a.addPlace(icon_1, 1, 0, 0);
    }

    public void mov(float dx, float dy){
        float x = map.getX();
        float y = map.getY();
        map.setX(x + dx - engine.getDX());
        map.setY(y + dy - engine.getDY());
    }

    public ImageView getMap(){
        return map;
    }

    public ImageView getIcon(){
        return icon_1;
    }
}