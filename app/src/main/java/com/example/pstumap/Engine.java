package com.example.pstumap;

import android.widget.ImageView;
import android.widget.TextView;

public class Engine {

    private ImageView map;
    private TextView floor_number;

    private float dX = 0;
    private float dY = 0;

    private int[] mass_floor;
    private int floor;

    public Engine (ImageView map, TextView floor_number , int floor){
        this.map = map;
        this.floor = floor;
        this.floor_number = floor_number;
        floor_number.setText(floor + "");
        mass_floor = new int[Config.MAX_FLOOR - Config.MIN_FLOOR + 1];
        mass_floor[0] = R.drawable.test_map;
        mass_floor[1] = R.drawable.test_map_2;
    }

    protected void scaleMap(int index){
        float scale = map.getScaleX() + Config.SCALE_STEP * index;
        if (scale >= Config.MIN_SIZE && scale <= Config.MAX_SIZE) {
            map.setScaleX(scale);
            map.setScaleY(scale);
        }
    }

    protected void moveMap(float dx, float dy){
        float x = map.getX();
        float y = map.getY();
        map.setX(x + dx - dX);
        map.setY(y + dy - dY);
    }

    protected void moveMap(int dir){
        float x = map.getX();
        float y = map.getY();
        switch (dir){
            case Config.UP:
                map.setY(y - Config.MOVE_STEP - dY);
                break;
            case Config.DOWN:
                map.setY(y + Config.MOVE_STEP - dY);
                break;
            case Config.LEFT:
                map.setX(x - Config.MOVE_STEP - dX);
                break;
            case Config.RIGHT:
                map.setX(x + Config.MOVE_STEP - dX);
                break;
        }
    }

    protected void setDiffPos(float dX, float dY){
        this.dX = dX;
        this.dY = dY;
    }

    protected void setImage(int image){
        map.setImageResource(image);
    }

    protected void setFloor(int dir){
        switch (dir){
            case Config.UP:
                if (Config.MAX_FLOOR != floor) {
                    floor++;
                    setImage(mass_floor[floor - 1]);
                    floor_number.setText(floor + "");
                }
                break;
            case Config.DOWN:
                if (Config.MIN_FLOOR != floor) {
                    floor--;
                    setImage(mass_floor[floor - 1]);
                    floor_number.setText(floor + "");
                }
                break;
        }
    }
}
