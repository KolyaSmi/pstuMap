package com.example.pstumap.source;

import static com.example.pstumap.Config.COUNT_COMPLEX;

import android.util.Log;

import com.example.pstumap.Config;
import com.example.pstumap.fragments.FragmentManager;

public abstract class FrameManager {

    private static Frame[] frames = new Frame[COUNT_COMPLEX];

    private static Frame complex_g;

    public static void setFrames() {
        complex_g = new Frame(1);
        complex_g.addFloor(1);
        complex_g.getFloor(1).setMap(FragmentManager.map_complex_g_1.map);
        complex_g.getFloor(1).setIcons(FragmentManager.map_complex_g_1.icons, 300, 600);


        frames[0] = complex_g;
        Log.d("setFrames", "init");
    }

    public static void scaleMapPlus() {
        frames[0].getFloor(1).scaleMap(1);
        Log.d("scaleMap", "index " + Config.SCALE_STEP);

    }

    public static void scaleMapMinus() {
        frames[0].getFloor(1).scaleMap(-1);
        Log.d("scaleMap", "index " + (-Config.SCALE_STEP));
    }

    public static void upFloor() {
    }

    public static void downFloor() {
    }

    public static void moveMap(float dx, float dy) {
        frames[0].getFloor(1).movMap(dx, dy);
    }

    public static void setPos() {
        frames[0].getFloor(1).setPos();
    }
}
