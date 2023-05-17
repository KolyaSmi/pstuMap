package com.example.pstumap.source;

import android.widget.ImageView;

import java.util.ArrayList;

public class Places {

    private class Place{

        private ImageView icon;

        private float X;
        private float Y;

        public Place(ImageView icon, float x, float y) {
            X = x;
            Y = y;
            this.icon = icon;
        }

        protected void movIcon(float dx, float dy){
//            float x = icon.getX();
//            float y = icon.getY();
//            icon.setX(x + dx);
//            icon.setY(y + dy);
            X = icon.getX();
            Y = icon.getY();
            icon.setX(X + dx);
            icon.setY(Y + dy);
        }
    }

    private ArrayList<Place> places = new ArrayList<>();

    public void addPlace(ImageView icon, float x, float y){
        places.add(new Place(icon ,x, y));
    }

    public void setPos(float dx, float dy) {
        for (Place place : places){
            place.movIcon(dx, dy);
        }
    }
}
