package com.example.pstumap.source;

import android.util.Log;
import android.widget.FrameLayout;
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
    public static Map createMap(FrameLayout frame_layout) {
        map = new Map(frame_layout);
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
     */
    public static void addFloor(int id, int map_id){
        map.getFrame(id).addFloor(map_id);
    }

//    /**
//     * Assigns the desired floor picture to the current floor.
//     * @param id Frame ID.
//     * @param image A map from the desired frame is transmitted.
//     */
//    public static void setImageMap(int id, ImageView image) {
//        map.getFrame(id).getFloor().setMap(image);
//    }

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

    public static void setDescriptionsIcons(int id, String[] headers, String[] descriptions, int[] images_id){
        if (headers.length != descriptions.length) {
            Log.e("error", "The arrays do not match each other in the icon description.");
            return;
        }
        map.getFrame(id).getFloor().setDescriptionsIcons(headers, descriptions, images_id);
    }

    public static void setDescriptionIcon(int id, String header, String description, int image_id){
        String[] headers = new String[1];
        headers[0] = header;
        String[] descriptions = new String[1];
        descriptions[0] = description;
        int[] images_id = new int[1];
        images_id[0] = image_id;
        map.getFrame(id).getFloor().setDescriptionsIcons(headers, descriptions, images_id);
    }

    public static void scaleMapPlus() {
        map.getFrame(cur_frame_id).getFloor().scaleMap(1);
        Log.d("scaleMap", "index " + Config.SCALE_STEP);

    }

    public static void scaleMapMinus() {
        map.getFrame(cur_frame_id).getFloor().scaleMap(-1);
        Log.d("scaleMap", "index " + (-Config.SCALE_STEP));
    }

    public static int upFloor() {
        map.getFrame(cur_frame_id).up();
//        FragmentManager.setVisibleFragment(map.getFrame(cur_frame_id).getFloor().getFragment());
        return map.getFrame(cur_frame_id).getNumberFloor();
    }

    public static int downFloor() {
        map.getFrame(cur_frame_id).down();
//        FragmentManager.setVisibleFragment(map.getFrame(cur_frame_id).getFloor().getFragment());
        return map.getFrame(cur_frame_id).getNumberFloor();
    }

    public static int getNumberFloor() {
        return map.getFrame(cur_frame_id).getNumberFloor();
    }

    public static void moveMap(float dx, float dy) {
        map.getFrame(cur_frame_id).getFloor().movMap(dx, dy);
    }

    public static void setPos() {
        map.getFrame(cur_frame_id).getFloor().setPos();
    }

    public static void changeFrame(int frame_id) {
//        if (cur_frame_id == 1) {
//            cur_frame_id = 2;
//        }else if (cur_frame_id == 2) {
//            cur_frame_id = 1;
//        }
        cur_frame_id = frame_id;
//        FragmentManager.setVisibleFragment(map.getFrame(cur_frame_id).getFloor().getFragment());
        FragmentManager.removeFragmentInUpWindow(FragmentManager.change_frame_window);
    }

    public static void checkOpenIcons() {
        map.getFrame(cur_frame_id).getFloor().checkOpenIcons();
    }
}
