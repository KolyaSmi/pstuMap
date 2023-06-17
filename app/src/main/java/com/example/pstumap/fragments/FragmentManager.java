package com.example.pstumap.fragments;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.example.pstumap.Config;
import com.example.pstumap.MapManager;
import com.example.pstumap.source.FrameManager;

import java.util.ArrayList;

/**
 *The FragmentManager stores all fragments of the map.
 *After all fragments are created, it gives the command to create the project structure in the FrameManager.
 *With COUNT_FRAGMENTS in Config the number of fragments after which the signal will be transmitted is regulated.
 */
public abstract class FragmentManager {

    public static ArrayList<Fragment> map_array;

    public static MapComplexA1 map_complex_a_1;

    public static MapComplexG1 map_complex_g_1;
    public static MapComplexG2 map_complex_g_2;

    private static int cur_count_fragment = 0;

    /**
     *Initialize all fragments.
     */
    public static void initFragment(){
        map_array = new ArrayList<>();
        map_complex_a_1 = new MapComplexA1();
        addMapInArray(map_complex_a_1);

        map_complex_g_1 = new MapComplexG1();
        addMapInArray(map_complex_g_1);
        map_complex_g_2 = new MapComplexG2();
        addMapInArray(map_complex_g_2);

    }

    private static void addMapInArray(Fragment fragment) {
        map_array.add(fragment);
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
//            FrameManager.setFrames();
            MapManager.initMap();
        }
        Log.d("setFrames ", cur_count_fragment + "");
    }
}
