package com.example.pstumap.floorsfragment;

import static com.example.pstumap.data.Config.MAX_FLOOR;
import static com.example.pstumap.data.Config.MIN_FLOOR;

import android.widget.ImageView;

import androidx.fragment.app.FragmentTransaction;

import com.example.pstumap.R;
import com.example.pstumap.source.Engine;
import com.example.pstumap.source.Frame;

public abstract class FragmentManager {

    public static Frame complex_a;

    public static TestMap testMap;

    public static void initFrames(){
        int[] mass_images = new int[MAX_FLOOR - MIN_FLOOR + 1];

        mass_images[0] = R.drawable.test_map;
        mass_images[1] = R.drawable.test_map_2;
        mass_images[2] = R.drawable.test_map_3;
        complex_a = new Frame(mass_images, 1, 3);
    }

    public static void initFragments(Engine engine, FragmentTransaction ft) {
        testMap = new TestMap();
        testMap.setEngine(engine);
        ft.replace(R.id.frame_layout, testMap).commit();
    }

//    public abstract void initPlaces();
    public static void mov(float dx, float dy){
        testMap.mov(dx, dy);
    }
}
