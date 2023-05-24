package com.example.pstumap.source;

import static com.example.pstumap.data.Config.SCALE_STEP;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Iterator;

public class Places {

    private class Place{

        protected ImageView icon;

        protected float X;
        protected float Y;

        protected float cur_scale;

        public Place(ImageView icon, float x, float y) {
            X = x;
            Y = y;
            icon.setX(X);
            icon.setY(Y);
            cur_scale = icon.getScaleX();
            this.icon = icon;
        }
    }

    private ArrayList<Place> places = new ArrayList<>();

    public void addPlace(ImageView icon, float x, float y){
        places.add(new Place(icon ,x, y));
    }

    public void setPos() {
        for (Place place : places){
            place.X = place.icon.getX();
            place.Y = place.icon.getY();
        }
    }

    public void mov(float dx, float dy){
        for (Place place : places){
            place.icon.setX(place.X + dx);
            place.icon.setY(place.Y + dy);
        }
    }

    public void scale(int index, float scale_floor) {
        setPos();
//        mov(scale_floor * (SCALE_STEP - 1), scale_floor * (SCALE_STEP - 1));
        mov((SCALE_STEP * scale_floor / 2) * -index, (SCALE_STEP * scale_floor / 2) * -index);
//        for (Place place : places){
//            mov((SCALE_STEP * 20f), SCALE_STEP * 20f);
//        }
    }
}
