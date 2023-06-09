package com.example.pstumap.source;

import android.widget.ImageView;

public class Frame {

    private Floor[] floors;

    public Frame(int count_floors) {
        floors = new Floor[count_floors];
    }

    public void addFloor(int number_floor) {
        floors[number_floor - 1] = new Floor();
    }

    public Floor getFloor(int number_floor) {
        return floors[number_floor - 1];
    }

}
