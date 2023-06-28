package com.example.pstumap.source;

import androidx.fragment.app.Fragment;

import com.example.pstumap.MainActivity;

/**
 * This class is responsible for one building and stores the floors.
 * This class implements methods for navigating through the floors of a building.
 */
class Frame {

    private Floor[] floors;

    private int number_floor;

    private MainActivity activity;

    /**
     * Method creates an array of floors.
     * @param count_floors number of floors in the building.
     */
    protected Frame(int count_floors) {
        floors = new Floor[count_floors];
        number_floor = -1;
    }

    protected Frame(MainActivity activity, int count_floors) {
        this.activity = activity;
        floors = new Floor[count_floors];
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
     * @param fragment Link to the fragment for further reference.
     */
    protected void addFloor(Fragment fragment) {
        number_floor++;
        floors[number_floor] = new Floor(fragment);
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
