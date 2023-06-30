package com.example.pstumap.fragments;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pstumap.Config;
import com.example.pstumap.MapManager;
import com.example.pstumap.R;

import java.util.ArrayList;

/**
 *The FragmentManager stores all fragments of the map.
 *After all fragments are created, it gives the command to create the project structure in the FrameManager.
 *With COUNT_FRAGMENTS in Config the number of fragments after which the signal will be transmitted is regulated.
 */
public abstract class FragmentManager {

    public static IconWindow icon_window;
    public static ChangeFrameWindow change_frame_window;

    public static ArrayList<Fragment> map_array;

    public static MapComplexA1 map_complex_a_1;
    public static MapComplexA2 map_complex_a_2;

    public static MapComplexG1 map_complex_g_1;
    public static MapComplexG2 map_complex_g_2;
    public static MapComplexG3 map_complex_g_3;

    private static AppCompatActivity main_activity;

    private static int cur_count_fragment = 0;
    private static Fragment previous_fragment;
    private static Fragment des_icon_fragment;

    private static String header;
    private static String description;
    private static int image_id;

    /**
     *Initialize all fragments.
     */
    public static void initFragment(){
        map_array = new ArrayList<>();
        map_complex_a_1 = new MapComplexA1();
        addMapInArray(map_complex_a_1);
        map_complex_a_2 = new MapComplexA2();
        addMapInArray(map_complex_a_2);

        map_complex_g_1 = new MapComplexG1();
        addMapInArray(map_complex_g_1);
        map_complex_g_2 = new MapComplexG2();
        addMapInArray(map_complex_g_2);
        map_complex_g_3 = new MapComplexG3();
        addMapInArray(map_complex_g_3);

        icon_window = new IconWindow();
        change_frame_window = new ChangeFrameWindow();
    }

    private static void addMapInArray(Fragment fragment) {
        map_array.add(fragment);
    }

    /**
     * This method goes through all fragments and adds them to the FragmentTransaction stack.
     * @param _mainActivity Transmitted in order to create a FragmentTransaction.
     */
    public static void setFragmentTransaction(AppCompatActivity _mainActivity) {
        main_activity = _mainActivity;
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : map_array) {
            ft.add(R.id.frame_layout, fragment)
                    .hide(fragment);
        }
        ft.show(map_array.get(1))
            .commit();
        previous_fragment = map_array.get(1);
    }

    public static void setVisibleFragment(Fragment cur_fragment) {
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.hide(previous_fragment)
                .show(cur_fragment).commit();
        previous_fragment = cur_fragment;
    }

    public static void replaceFragmentInUpWindow(Fragment fragment) {
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_up_window, fragment).commit();
        Log.d("fragment up", "replace up window");
    }

    public static void replaceFragmentInUpWindow(Fragment fragment, String _header, String _description, int _image_id) {
        header = _header;
        description = _description;
        image_id = _image_id;
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.hide(change_frame_window).add(R.id.frame_up_window, fragment).show(fragment).commit();
        des_icon_fragment = fragment;
        Log.d("fragment up", "replace up window");
    }

    public static void setDescriptionInUpWindow(){
        icon_window.text_header.setText(header);
        icon_window.text_description.setText(description);
        icon_window.image.setImageResource(image_id);
    }

    public static void removeFragmentInUpWindow(Fragment fragment) {
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.remove(fragment).commit();
        Log.d("fragment up", "replace up window");
    }

    public static void hideFragmentInUpWindow(Fragment fragment) {
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.hide(fragment).commit();
        Log.d("fragment up", "replace up window");
    }

    public static void showFragmentInUpWindow(Fragment fragment) {
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.remove(des_icon_fragment).show(fragment).commit();
        Log.d("fragment up", "replace up window");
    }

    public static void addFragmentInUpWindow(Fragment fragment) {
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame_up_window ,fragment).hide(fragment).commit();
        Log.d("fragment up", "replace up window");
    }

    /**
     *Counts how many fragments are created.
     *Call in each fragment!
     */
    public static void add(){
        if (cur_count_fragment < Config.COUNT_FRAGMENTS){
            cur_count_fragment++;
        }
        if (cur_count_fragment == Config.COUNT_FRAGMENTS){
            Log.d("setFrames", "setFrames" + cur_count_fragment + "");
            MapManager.initMap();
        }
        Log.d("setFrames ", cur_count_fragment + "");
    }
}
