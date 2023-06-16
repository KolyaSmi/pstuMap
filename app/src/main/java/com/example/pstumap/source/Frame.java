package com.example.pstumap.source;

import android.widget.ImageView;

public class Frame {

    private Floor[] floors;

    private int number_floor;

    public Frame(int count_floors) {
        floors = new Floor[count_floors];
        number_floor = -1;
    }

    public void up() {
        if(number_floor < floors.length)
            number_floor++;
    }

    public void down() {
        if(number_floor >= 0){
            number_floor--;
        }
    }

    public void addFloor() {
        number_floor++;
        floors[number_floor] = new Floor();
    }

    public Floor getFloor() {
        return floors[number_floor];
    }

}
