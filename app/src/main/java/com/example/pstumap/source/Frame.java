package com.example.pstumap.source;

import androidx.fragment.app.Fragment;

/**
 * This class is responsible for one building and stores the floors.
 * This class implements methods for navigating through the floors of a building.
 */
public class Frame {

    private Floor[] floors;

    private int number_floor;

    /**
     * Method creates an array of floors.
     * @param count_floors number of floors in the building.
     */
    public Frame(int count_floors) {
        floors = new Floor[count_floors];
        number_floor = -1;
    }

    /**
     * Raises the floor by 1.
     */
    public void up() {
        if(number_floor < floors.length)
            number_floor++;
    }

    /**
     * Lowers the floor by 1.
     */
    public void down() {
        if(number_floor >= 0){
            number_floor--;
        }
    }

    /**
     *Goes up one floor and creates a new floor.
     * @param fragment Link to the fragment for further reference.
     */
    public void addFloor(Fragment fragment) {
        number_floor++;
        floors[number_floor] = new Floor(fragment);
    }

    /**
     *
     * @return Transmits the current floor.
     */
    public Floor getFloor() {
        return floors[number_floor];
    }

}
