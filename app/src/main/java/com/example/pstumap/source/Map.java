package com.example.pstumap.source;

import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import java.util.HashMap;

class Map {

    private HashMap<Integer, Frame> frames;

    private FrameLayout frame_layout;

    private int id;

    protected Map(FrameLayout frame_layout) {
        frames = new HashMap<>();
        this.frame_layout = frame_layout;
        id = 0;
    }

    protected int addFrame(int count_floors) {
        id++;
        frames.put(id, new Frame(count_floors, frame_layout));
        return id;
    }

    protected Frame getFrame(int frame) {
        return frames.get(frame);
    }
}
