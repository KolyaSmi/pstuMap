package com.example.pstumap.floorsfragment;

import static com.example.pstumap.data.Config.COMPLEX_A_ID;
import static com.example.pstumap.data.Config.DOWN;
import static com.example.pstumap.data.Config.UP;

import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pstumap.R;
import com.example.pstumap.source.Frame;

public abstract class FragmentManager {

    private static FragmentTransaction ft;

    public static Frame complex_a;

    private static int current_frame_id;

    private static TestMap testMap;
    private static TestMap2 testMap2;

    public static void initFrames(){
        complex_a = new Frame(1, 3, COMPLEX_A_ID);

        current_frame_id = COMPLEX_A_ID;
    }

    public static void initFragments() {
        testMap = new TestMap();
        testMap2 = new TestMap2();

        complex_a.addFragment(testMap);
        complex_a.addFragment(testMap2);

//        ft
//                .add(R.id.frame_layout, testMap)
//                .add(R.id.frame_layout, testMap2)
//                .commit();
//        ft.show(testMap);
//        ft.remove()
        ft.replace(R.id.frame_layout, testMap);
//        ft.replace(R.id.frame_layout, testMap2);
//        ft.show(testMap);
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
        switch (current_frame_id){
            case COMPLEX_A_ID: complex_a.movCurrentFloor(dx, dy);
        }
    }

    public static void setDiffPos() {
        switch (current_frame_id){
            case COMPLEX_A_ID: complex_a.setCurrentDiffPos();
        }
    }

    public static void scale(int index) {
        switch (current_frame_id){
            case COMPLEX_A_ID: complex_a.scaleCurrentFloor(index);
        }
    }

    private static void upFloor(){
        switch (current_frame_id){
            case COMPLEX_A_ID:
//                ft.replace(R.id.frame_layout, (Fragment) complex_a.upFloor());
//                ft.remove(testMap);
                ft.show(testMap2);
                ft.replace(R.id.frame_layout, testMap2);
//                ft.show((Fragment) complex_a.upFloor());
        }
    }

    private static void downFloor(){
        switch (current_frame_id){
            case COMPLEX_A_ID: complex_a.downFloor();
        }
    }

    public static void changeFloor(int dir) {
        switch (dir){
            case UP:
                upFloor();
                break;
            case DOWN:
                downFloor();
                break;
        }
//        setImage(complex_a.getImage());
    }
}
