package com.example.pstumap.source;

import java.util.HashMap;

class Map {

    private HashMap<Integer, Frame> frames;

    private int id;

    protected Map() {
        frames = new HashMap<>();
        id = 0;
    }

    protected int addFrame(int count_floors) {
        id++;
        frames.put(id, new Frame(count_floors));
        return id;
    }

    protected Frame getFrame(int frame) {
        return frames.get(frame);
    }
}
