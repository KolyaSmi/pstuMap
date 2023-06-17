package com.example.pstumap.source;

import java.util.HashMap;

class Map {

    private HashMap<Integer, Frame> frames;

    private int id;

    public Map() {
        frames = new HashMap<>();
        id = 0;
    }

    public int addFrame(int count_floors) {
        id++;
        frames.put(id, new Frame(count_floors));
        return id;
    }

    public Frame getFrame(int frame) {
        return frames.get(frame);
    }
}
