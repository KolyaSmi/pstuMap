package com.example.pstumap.source;

import static com.example.pstumap.data.Config.*;
import static com.example.pstumap.floorsfragment.FragmentManager.complex_a;
import static com.example.pstumap.floorsfragment.FragmentManager.mov;
import static com.example.pstumap.floorsfragment.FragmentManager.testMap;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

import com.example.pstumap.R;
import com.example.pstumap.data.Config;
import com.example.pstumap.floorsfragment.FragmentManager;
import com.example.pstumap.floorsfragment.TestMap;

public class Engine {

    private ImageView map;
    private TextView floor_number_text;

    private float dX = 0;
    private float dY = 0;


    public Engine (FragmentTransaction ft, TextView floor_number_text , int floor_number){
        this.floor_number_text = floor_number_text;

        floor_number_text.setText(floor_number + "");

        FragmentManager.initFragments(this, ft);

        FragmentManager.initFrames();
    }

    public void scaleMap(int index){
        float scale = map.getScaleX() + SCALE_STEP * index;
        if (scale >= Config.MIN_SIZE && scale <= Config.MAX_SIZE) {
            map.setScaleX(scale);
            map.setScaleY(scale);
        }
    }

    public void moveMap(float dx, float dy){
        mov(dx, dy);
        complex_a.getPlaces().setPos(dx - dX, dy - dY);
    }

    public void setDiffPos(float dX, float dY){
        this.dX = dX;
        this.dY = dY;
    }

    private void setImage(int image){
        map.setImageResource(image);
    }

    public void changeFloor(int dir){
        switch (dir){
            case UP:
                complex_a.upFloor();
                break;
            case DOWN:
                complex_a.downFloor();
                break;
        }
        setImage(complex_a.getImage());
        floor_number_text.setText(complex_a.getStrFloor());
    }

    public float getDX(){
        return dX;
    }

    public float getDY(){
        return dY;
    }
}
