package com.example.pstumap.floorsfragment;

import static com.example.pstumap.data.Config.COMPLEX_A_ID;
import static com.example.pstumap.data.Config.MAX_FLOOR;
import static com.example.pstumap.data.Config.MIN_FLOOR;

import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pstumap.R;
import com.example.pstumap.source.Engine;
import com.example.pstumap.source.Frame;

public abstract class FragmentManager {

    private static FragmentTransaction ft;

    public static Frame complex_a;

    private static int current_frame;

    private static TestMap testMap;

    public static void initFrames(){
        complex_a = new Frame(1, 3, COMPLEX_A_ID);

        current_frame = COMPLEX_A_ID;
    }

    public static void initFragments() {
        testMap = new TestMap();

        ft.replace(R.id.frame_layout, testMap).commit();
    }

    public static void setFragment(ImageView map, int id){
        switch (id){
            case COMPLEX_A_ID: complex_a.addFloorFragment(map);
        }

    }

    public static void setFragmentTransaction(FragmentTransaction _ft) {
        ft = _ft;
    }

    public static void mov (float dx, float dy){
        switch (current_frame){
            case COMPLEX_A_ID: complex_a.movCurrentFloor(dx, dy);
        }
    }

    public static void setDiffPos() {
        switch (current_frame){
            case COMPLEX_A_ID: complex_a.setCurrentDiffPos();
        }
    }
}
