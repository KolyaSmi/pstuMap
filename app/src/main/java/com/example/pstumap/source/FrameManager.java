package com.example.pstumap.source;

import static com.example.pstumap.Config.COUNT_COMPLEX;

import android.util.Log;

import androidx.fragment.app.FragmentTransaction;

import com.example.pstumap.Config;
import com.example.pstumap.R;
import com.example.pstumap.fragments.FragmentManager;

public abstract class FrameManager {

    private static Frame[] frames = new Frame[COUNT_COMPLEX];

    private static Frame complex_g;

    private static FragmentTransaction ft;

    public static void setFrames() {
        complex_g = new Frame(2);
        complex_g.addFloor();
        complex_g.getFloor().setMap(FragmentManager.map_complex_g_1.map);
        complex_g.getFloor().setIcons(FragmentManager.map_complex_g_1.icons, 300, 600);

        complex_g.addFloor();
        complex_g.getFloor().setMap(FragmentManager.map_complex_g_2.map);

        frames[0] = complex_g;


        Log.d("setFrames", "init");
    }

    public static void setFragmentTransaction(FragmentTransaction _ft) {
        ft = _ft;
//        ft.replace(R.id.frame_layout, FragmentManager.map_complex_g_2).commit();
    }

    public static void scaleMapPlus() {
        frames[0].getFloor().scaleMap(1);
        Log.d("scaleMap", "index " + Config.SCALE_STEP);

    }

    public static void scaleMapMinus() {
        frames[0].getFloor().scaleMap(-1);
        Log.d("scaleMap", "index " + (-Config.SCALE_STEP));
    }

    public static void upFloor() {
        frames[0].up();
    }

    public static void downFloor() {
        frames[0].down();

    }

    public static void moveMap(float dx, float dy) {
        frames[0].getFloor().movMap(dx, dy);
    }

    public static void setPos() {
        frames[0].getFloor().setPos();
    }
}
