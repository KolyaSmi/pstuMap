package com.example.pstumap.source;

import android.util.Log;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class Floor {

    private ImageView map;
    private Places places;

    private float cur_x;
    private float cur_y;

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

    public ImageView getFragment() {
        return map;
    }

    public Places getPlaces() {
        return places;
    }
}
