package com.example.pstumap.source;

import android.util.Log;
import android.widget.ImageView;

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

    private static Map map;

    private static AppCompatActivity main_activity;

    private static Fragment previous_fragment;

    private static int cur_frame_id = 1;

    /**
     * Getting Started with the Map.
     * @return Returns a link to the map.
     */
    public static Map createMap() {
        map = new Map();
        return map;
    }

    /**
     * Creates a new frame on which all the floors of the building are placed.
     * @param count_floors The number of floors in the building.
     * @return Returns the building ID.
     */
    public static int createFrame(int count_floors) {
        return map.addFrame(count_floors);
    }

    /**
     * Adds a floor to a building.
     * The addition takes place one step at a time.
     * After each added floor, you must set the other characteristics of the floor.
     * @param id Frame ID.
     * @param fragment Link to the fragment for further reference.
     */
    public static void addFloor(int id, Fragment fragment){
        map.getFrame(id).addFloor(fragment);
    }

    /**
     * Assigns the desired floor picture to the current floor.
     * @param id Frame ID.
     * @param image A map from the desired frame is transmitted.
     */
    public static void setImageMap(int id, ImageView image) {
        map.getFrame(id).getFloor().setMap(image);
    }

    /**
     * Assigns to the current floor an array of icons for that floor.
     * The three arrays must be the same size.
     * For example, the coordinates of the first icon (icon[0]) are x[0], y[0]
     * @param id Frame ID.
     * @param icons An array of floor icons.
     * @param x An array of initial x coordinates for each icon.
     * @param y An array of initial y coordinates for each icon.
     */
    public static void setIcons(int id, ImageView[] icons, float[] x, float[] y) {
        if (icons.length != x.length || icons.length != y.length) {
            Log.e("error", "The arrays do not match each other in the icon installation.");
            return;
        }
        map.getFrame(id).getFloor().setIcons(icons, x, y);
    }

    /**
     * Assigns to the current floor an array of icons for that floor.
     * The three arrays must be the same size.
     * For example, the coordinates of the first icon (icon[0]) are x[0], y[0]
     * @param id Frame ID.
     * @param icon An array of floor icons.
     * @param x An array of initial x coordinates for each icon.
     * @param y An array of initial y coordinates for each icon.
     */
    public static void setIcon(int id, ImageView icon, float x, float y) {
        ImageView[] icons = new ImageView[1];
        icons[0] = icon;
        float[] xs = new float[1];
        xs[0] = x;
        float[] ys = new float[1];
        ys[0] = y;
        map.getFrame(id).getFloor().setIcons(icons, xs, ys);
    }

    /**
     * This method goes through all fragments and adds them to the FragmentTransaction stack.
     * @param _mainActivity Transmitted in order to create a FragmentTransaction.
     */
    public static void setFragmentTransaction(AppCompatActivity _mainActivity) {
        main_activity = _mainActivity;
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : FragmentManager.map_array) {
            ft.add(R.id.frame_layout, fragment);
            ft.hide(fragment);
        }
        ft.show(FragmentManager.map_complex_a_1);
        ft.commit();
        previous_fragment = FragmentManager.map_complex_a_1;
    }

    public static void scaleMapPlus() {
        map.getFrame(cur_frame_id).getFloor().scaleMap(1);
        Log.d("scaleMap", "index " + Config.SCALE_STEP);

    }

    public static void scaleMapMinus() {
        map.getFrame(cur_frame_id).getFloor().scaleMap(-1);
        Log.d("scaleMap", "index " + (-Config.SCALE_STEP));
    }

    public static void upFloor() {
        map.getFrame(cur_frame_id).up();
        setVisibleFragment();
    }

    public static void downFloor() {
        map.getFrame(cur_frame_id).down();
        setVisibleFragment();
    }

    public static void moveMap(float dx, float dy) {
        map.getFrame(cur_frame_id).getFloor().movMap(dx, dy);
    }

    public static void setPos() {
        map.getFrame(cur_frame_id).getFloor().setPos();
    }

    private static void setVisibleFragment() {
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.hide(previous_fragment)
                .show(map.getFrame(cur_frame_id).getFloor().getFragment()).commit();
        previous_fragment = map.getFrame(cur_frame_id).getFloor().getFragment();
    }

    public static void setFragmentInUpWindow() {
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_up_window, FragmentManager.icon_window).commit();
        Log.d("fragment up", "replace up window");
    }

    public static void changeFrame() {
        if (cur_frame_id == 1) {
            cur_frame_id = 2;
        }else if (cur_frame_id == 2) {
            cur_frame_id = 1;
        }
        setVisibleFragment();
    }
}
