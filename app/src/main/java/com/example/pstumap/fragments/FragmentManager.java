package com.example.pstumap.fragments;

import android.util.Log;

import com.example.pstumap.Config;
import com.example.pstumap.source.FrameManager;

public abstract class FragmentManager {

    public static MapComplexG1 map_complex_g_1;

    private static int cur_count_fragment = 0;

    public static void initFragment(){
        map_complex_g_1 = new MapComplexG1();
    }

    public static void addFloorInFrame(){
        if (cur_count_fragment <= Config.COUNT_FRAGMENTS){
            cur_count_fragment++;
        }
        if (cur_count_fragment == Config.COUNT_FRAGMENTS){
            FrameManager.setFrames();
        }
        Log.d("setFrames", cur_count_fragment + "");
    }
}
