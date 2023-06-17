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
//    private static Frame[] frames = new Frame[COUNT_COMPLEX];
//
//    private static Frame complex_a;
//    private static Frame complex_g;

    private static AppCompatActivity main_activity;

    private static Fragment previous_fragment;

    private static int cur_frame_id = 1;

//    /**
//     * setFrames is a method in which all map levels are defined and the map structure is created.
//     */
//    public static void setFrames() {
//        complex_a = new Frame(1);
//        complex_a.addFloor(FragmentManager.map_complex_a_1);
//        complex_a.getFloor().setMap(FragmentManager.map_complex_a_1.map);
//
//        complex_g = new Frame(2);
//        complex_g.addFloor(FragmentManager.map_complex_g_1);
//        complex_g.getFloor().setMap(FragmentManager.map_complex_g_1.map);
//        complex_g.getFloor().setIcons(FragmentManager.map_complex_g_1.icons, 300, 600);
//
//        complex_g.addFloor(FragmentManager.map_complex_g_2);
//        complex_g.getFloor().setMap(FragmentManager.map_complex_g_2.map);
//
//        frames[0] = complex_a;
//        frames[1] = complex_g;
//
//
//        Log.d("setFrames", "init");
//    }

    public static Map createMap() {
        map = new Map();
        return map;
    }

    public static int createFrame(int count_floors) {
        return map.addFrame(count_floors);
    }

    public static void addFloor(int id, Fragment fragment){
        map.getFrame(id).addFloor(fragment);
    }

    public static void setImageMap(int id, ImageView image) {
        map.getFrame(id).getFloor().setMap(image);
    }

    public static void setIcons(int id, ImageView[] icons, int x, int y) {
        map.getFrame(id).getFloor().setIcons(icons, x, y);
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
//        ft.add(R.id.frame_layout, FragmentManager.map_complex_a_1)
//                .add(R.id.frame_layout, FragmentManager.map_complex_g_1)
//                .add(R.id.frame_layout, FragmentManager.map_complex_g_2).commit();
//        ft.hide(FragmentManager.map_complex_g_2);
//        ft.hide(FragmentManager.map_complex_g_1);
//        ft.show(FragmentManager.map_complex_a_1);
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

    public static void changeFrame() {
        if (cur_frame_id == 1) {
            cur_frame_id = 2;
        }else if (cur_frame_id == 2) {
            cur_frame_id = 1;
        }
        setVisibleFragment();
    }
}
