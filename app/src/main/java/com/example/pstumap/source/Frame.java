package com.example.pstumap.source;


import android.util.Log;
import android.widget.ImageView;

public class Frame {

    private Floor[] floors;

    private int min_floor;
    private int max_floor;
    private int id;

    private int current_floor;

    public Frame(int min_floor, int max_floor, int id){
        this.max_floor = max_floor;
        this.min_floor = min_floor;
        this.id = id;

        floors = new Floor[max_floor - min_floor + 1];

        current_floor = min_floor;
    }

    public void addFloorFragment(ImageView map_fragment){
        if(current_floor < max_floor) {
            floors[current_floor - 1] = new Floor(map_fragment);
            current_floor++;
        }
    }

    public String getStrFloor() {
        return Integer.toString(current_floor);
    }

    public Floor getFloor(int floor){
        return floors[floor - 1];
    }

    public void movCurrentFloor(float dx, float dy) {
//        floors[current_floor - 1].mov(dx, dy);

        floors[0].mov(dx, dy);
        Log.d("move", "move current floor " + current_floor);
    }

    public void setCurrentDiffPos(){
        floors[0].setPos();
    }

    public void scaleCurrentFloor(int index) {
//        floors[0].getFragment().setScaleX(SCALE_STEP);
//        floors[0].getFragment().setScaleY(SCALE_STEP);
        floors[0].scale(index);
    }
}
