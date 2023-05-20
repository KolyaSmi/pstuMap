package com.example.pstumap.floorsfragment;

import static com.example.pstumap.data.Config.MAX_FLOOR;
import static com.example.pstumap.data.Config.MIN_FLOOR;

import androidx.fragment.app.FragmentTransaction;

import com.example.pstumap.R;
import com.example.pstumap.source.Engine;
import com.example.pstumap.source.Frame;

public abstract class FragmentManager {

    public static Frame complex_a;

    public static void initFrames(){
        complex_a = new Frame(1, 3);
    }

    public static void initFragments(Engine engine, FragmentTransaction ft) {
        complex_a.addFloorFragment(new TestMap());
//        testMap.setEngine(engine);
        ft.replace(R.id.frame_layout, complex_a.getFloorFragment(1)).commit();
    }

//    public abstract void initPlaces();
//    public static void mov(float dx, float dy){
//        testMap.mov(dx, dy);
//    }
}
