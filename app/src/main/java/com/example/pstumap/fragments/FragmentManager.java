package com.example.pstumap.fragments;

import android.util.Log;

import com.example.pstumap.Config;
import com.example.pstumap.source.FrameManager;

public abstract class FragmentManager {

    public static MapComplexG1 map_complex_g_1;
    public static MapComplexG2 map_complex_g_2;

    private static int cur_count_fragment = 0;

    public static void initFragment(){
        map_complex_g_1 = new MapComplexG1();
        map_complex_g_2 = new MapComplexG2();
    }

    public static void add(){
        if (cur_count_fragment < Config.COUNT_FRAGMENTS){
            cur_count_fragment++;
        }
        if (cur_count_fragment == Config.COUNT_FRAGMENTS){
            Log.d("setFrames", "setFrames" + cur_count_fragment + "");
            FrameManager.setFrames();
        }
        Log.d("setFrames ", cur_count_fragment + "");
    }
}
