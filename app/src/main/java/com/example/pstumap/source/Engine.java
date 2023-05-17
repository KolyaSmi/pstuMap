package com.example.pstumap.source;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

import com.example.pstumap.R;
import com.example.pstumap.data.Config;
import com.example.pstumap.floorsfragment.TestMap;

public class Engine {

    private ImageView map;
    private TestMap testMap;
    private TextView floor_number_text;

    private float dX = 0;
    private float dY = 0;

    public Frame complex_a;

    public Engine (FragmentTransaction ft, TextView floor_number_text , int floor_number){
        this.floor_number_text = floor_number_text;

        testMap = new TestMap();
        testMap.setEngine(this);
        ft.replace(R.id.frame_layout, testMap).commit();

        floor_number_text.setText(floor_number + "");
        createFrames();
    }

    private void createFrames(){
        int[] mass_images = new int[Config.MAX_FLOOR - Config.MIN_FLOOR + 1];

        mass_images[0] = R.drawable.test_map;
        mass_images[1] = R.drawable.test_map_2;
        mass_images[2] = R.drawable.test_map_3;
        complex_a = new Frame(mass_images, 1, 3);
        Log.i("app_log", "create Place");
//        complex_a.addPlace(testMap.getIcon(), 1, 100, 100);
    }

    public void scaleMap(int index){
        float scale = map.getScaleX() + Config.SCALE_STEP * index;
        if (scale >= Config.MIN_SIZE && scale <= Config.MAX_SIZE) {
            map.setScaleX(scale);
            map.setScaleY(scale);
        }
    }

    public void moveMap(float dx, float dy){
        testMap.mov(dx, dy);
        complex_a.getPlaces().setPos(dx - dX, dy - dY);
    }

    public void setDiffPos(float dX, float dY){
        this.dX = dX;
        this.dY = dY;
    }

    private void setImage(int image){
        map.setImageResource(image);
    }

    public void changeFloor(int dir){
        switch (dir){
            case Config.UP:
                complex_a.upFloor();
                break;
            case Config.DOWN:
                complex_a.downFloor();
                break;
        }
        setImage(complex_a.getImage());
        floor_number_text.setText(complex_a.getStrFloor());
    }

    public float getDX(){
        return dX;
    }

    public float getDY(){
        return dY;
    }
}
