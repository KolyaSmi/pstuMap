package com.example.pstumap.source;

import static com.example.pstumap.floorsfragment.FragmentManager.complex_a;

import android.util.Log;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

import com.example.pstumap.floorsfragment.FragmentManager;

public class Engine {

    private TextView floor_number_text;

    public Engine (FragmentTransaction ft, TextView floor_number_text , int floor_number){
        this.floor_number_text = floor_number_text;

        floor_number_text.setText(floor_number + "");

        FragmentManager.setFragmentTransaction(ft);

        FragmentManager.initFrames();

        FragmentManager.initFragments();
    }

    public void scaleMap(int index){
//        float scale = map.getScaleX() + SCALE_STEP * index;
//        if (scale >= Config.MIN_SIZE && scale <= Config.MAX_SIZE) {
//            map.setScaleX(scale);
//            map.setScaleY(scale);
//        }
    }

    public void moveMap(float dx, float dy){
        FragmentManager.mov(dx, dy);
        Log.d("move", "move map");
    }

    public void setDiffPos(){
        FragmentManager.setDiffPos();
    }

    private void setImage(int image){
//        map.setImageResource(image);
    }

    public void changeFloor(int dir){
//        switch (dir){
//            case UP:
//                complex_a.upFloor();
//                break;
//            case DOWN:
//                complex_a.downFloor();
//                break;
//        }
//        setImage(complex_a.getImage());
        floor_number_text.setText(complex_a.getStrFloor());
    }
}
