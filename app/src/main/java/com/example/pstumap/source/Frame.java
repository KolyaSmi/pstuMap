package com.example.pstumap.source;

import android.widget.ImageView;

public class Frame {

    private Places[] places;

    private int min_floor;
    private int max_floor;

    private int[] images;
    private int current_floor;
    private int current_image;

    public Frame(int[] images, int min_floor, int max_floor){
        this.images = images;
        this.max_floor = max_floor;
        this.min_floor = min_floor;

        places = new Places[max_floor - min_floor + 1];

        current_floor = min_floor;
        current_image = images[0];
    }

    public void upFloor(){
        if (max_floor != current_floor){
            current_floor++;
            current_image = images[current_floor - 1];
        }
    }

    public void downFloor(){
        if (min_floor != current_floor){
            current_floor--;
            current_image = images[current_floor - 1];
        }
    }

    public int getFloor(){
        return current_floor;
    }

    public String getStrFloor(){
        return Integer.toString(current_floor);
    }

    public int getImage(){
        return current_image;
    }

    public void addPlace(ImageView icon, int floor, float x, float y){
        places[floor - 1] = new Places();
        places[floor - 1].addPlace(icon, x, y);
    }

    public Places getPlaces(){
        return places[current_floor - 1];
    }
}
