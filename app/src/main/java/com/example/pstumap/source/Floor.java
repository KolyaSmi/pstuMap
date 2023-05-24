package com.example.pstumap.source;

import static com.example.pstumap.data.Config.MAX_SIZE;
import static com.example.pstumap.data.Config.MIN_SIZE;
import static com.example.pstumap.data.Config.SCALE_STEP;

import android.util.Log;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class Floor {

    private ImageView map;
    private Places places;

    private float cur_x;
    private float cur_y;

    private float cur_scale;

    public Floor(ImageView map) {
        this.map = map;

        places = new Places();
    }

    public void setPos(){
        places.setPos();
        cur_x = map.getX();
        cur_y = map.getY();
        Log.d("setPos", cur_x + "" + cur_y);
    }

    public void mov(float dx, float dy){
        places.mov(dx, dy);
        map.setX(cur_x + dx);
        map.setY(cur_y + dy);
        Log.d("move", cur_x + " " + cur_y + " " + dx + " " + dy);
    }

    public void scale(int index) {
        cur_scale = map.getScaleX();
        float mult = cur_scale + SCALE_STEP * index;
        if(mult <= MAX_SIZE && mult >= MIN_SIZE) {
            places.scale(index, map.getWidth());

            map.setScaleX(mult);
            map.setScaleY(mult);
        }
    }

    public ImageView getFragment() {
        return map;
    }

    public Places getPlaces() {
        return places;
    }
}
