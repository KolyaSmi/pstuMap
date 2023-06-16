package com.example.pstumap.source;

import static com.example.pstumap.Config.COUNT_COMPLEX;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pstumap.Config;
import com.example.pstumap.R;
import com.example.pstumap.fragments.FragmentManager;

/**
  FrameManager is responsible for managing the hierarchy and adding various elements to it.
  Also implements the interface of interaction with different map structures, such as: Frame, Floor, Icon.
 */
public abstract class FrameManager {

    private static Frame[] frames = new Frame[COUNT_COMPLEX];

    private static Frame complex_g;

    private static AppCompatActivity main_activity;

    private static Fragment previous_fragment;

    /**
     * setFrames is a method in which all map levels are defined and the map structure is created.
     */
    public static void setFrames() {
        complex_g = new Frame(2);
        complex_g.addFloor(FragmentManager.map_complex_g_1);
        complex_g.getFloor().setMap(FragmentManager.map_complex_g_1.map);
        complex_g.getFloor().setIcons(FragmentManager.map_complex_g_1.icons, 300, 600);

        complex_g.addFloor(FragmentManager.map_complex_g_2);
        complex_g.getFloor().setMap(FragmentManager.map_complex_g_2.map);

        frames[0] = complex_g;


        Log.d("setFrames", "init");
    }

    public static void setFragmentTransaction(AppCompatActivity _mainActivity) {
        main_activity = _mainActivity;
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame_layout, FragmentManager.map_complex_g_1)
                .add(R.id.frame_layout, FragmentManager.map_complex_g_2).commit();
        ft.hide(FragmentManager.map_complex_g_1);
        ft.show(FragmentManager.map_complex_g_2);
        previous_fragment = FragmentManager.map_complex_g_2;
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
        setVisibleFragment();
    }

    public static void downFloor() {
        frames[0].down();
        setVisibleFragment();
    }

    public static void moveMap(float dx, float dy) {
        frames[0].getFloor().movMap(dx, dy);
    }

    public static void setPos() {
        frames[0].getFloor().setPos();
    }

    private static void setVisibleFragment() {
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.hide(previous_fragment)
                .show(frames[0].getFloor().getFragment()).commit();
        previous_fragment = frames[0].getFloor().getFragment();
    }
}
