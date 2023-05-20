package com.example.pstumap.source;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Iterator;

public class Places {

    private class Place{

        protected ImageView icon;

        protected float X;
        protected float Y;

        public Place(ImageView icon, float x, float y) {
            X = x;
            Y = y;
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
}
