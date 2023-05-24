package com.example.pstumap.source;


import android.util.Log;
import android.widget.ImageView;

public class Frame {

    private Floor[] floors;

    private Object[] frames;

    private int min_floor;
    private int max_floor;
    private int id;

    private int current_floor;

    private int number_add_floor;
    private int number_add_fragment;

    public Frame(int min_floor, int max_floor, int id){
        this.max_floor = max_floor;
        this.min_floor = min_floor;
        this.id = id;

        floors = new Floor[max_floor - min_floor + 1];
        frames = new Object[max_floor - min_floor + 1];

        current_floor = min_floor;
        number_add_floor = 0;
        number_add_fragment = 0;
    }

    public void addFragment(Object frame){
        frames[number_add_fragment] = frame;
        number_add_fragment++;
    }

    public void addFloorFragment(ImageView map_fragment){
        if(number_add_floor < max_floor) {
            floors[number_add_floor] = new Floor(map_fragment);
            number_add_floor++;
        }
    }

    public Object upFloor(){
        if (current_floor + 1 <= max_floor && current_floor + 1 >= min_floor)
            current_floor++;
        return frames[current_floor - 1];
    }

    public Object downFloor() {
        if (current_floor - 1 <= max_floor && current_floor - 1 >= min_floor)
            current_floor--;
        return frames[current_floor - 1];
    }

    public String getStrFloor() {
        return Integer.toString(current_floor);
    }

    public Floor getFloor(int floor){
        return floors[floor - 1];
    }

    public void movCurrentFloor(float dx, float dy) {
//        floors[current_floor - 1].mov(dx, dy);

        floors[current_floor - 1].mov(dx, dy);
        Log.d("move", "move current floor " + current_floor);
    }

    public void setCurrentDiffPos(){
        floors[current_floor - 1].setPos();
    }

    public void scaleCurrentFloor(int index) {
//        floors[0].getFragment().setScaleX(SCALE_STEP);
//        floors[0].getFragment().setScaleY(SCALE_STEP);
        floors[current_floor - 1].scale(index);
    }
}
