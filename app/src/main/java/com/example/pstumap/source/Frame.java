package com.example.pstumap.source;

import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.example.pstumap.MainActivity;
import com.example.pstumap.R;

/**
 * This class is responsible for one building and stores the floors.
 * This class implements methods for navigating through the floors of a building.
 */
class Frame {

    private Floor[] floors;

    private FrameLayout frame_layout;

    private int number_floor;

    /**
     * Method creates an array of floors.
     * @param count_floors number of floors in the building.
     */
    protected Frame(int count_floors, FrameLayout frame_layout) {
        floors = new Floor[count_floors];
        this.frame_layout = frame_layout;
        number_floor = -1;
    }

    /**
     * Raises the floor by 1.
     */
    protected void up() {
        if(number_floor < floors.length - 1)
            number_floor++;
    }

    /**
     * Lowers the floor by 1.
     */
    protected void down() {
        if(number_floor > 0){
            number_floor--;
        }
    }

    /**
     *Goes up one floor and creates a new floor.
     */
    protected void addFloor(int map_id) {
        number_floor++;
        floors[number_floor] = new Floor(frame_layout);
        floors[number_floor].setMap(map_id);
    }

    /**
     *
     * @return Transmits the current floor.
     */
    protected Floor getFloor() {
        return floors[number_floor];
    }

    protected int getNumberFloor() {
        return number_floor;
    }
}
