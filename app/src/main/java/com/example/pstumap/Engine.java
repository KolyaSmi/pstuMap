package com.example.pstumap;

import android.widget.ImageView;

public class Engine {

    private ImageView map;

    private float dX = 0;
    private float dY = 0;

    public Engine (ImageView map){
        this.map = map;
    }

    protected void scaleMap(int scale){
        map.setScaleX(map.getScaleX() + Config.SCALE_STEP * scale);
        map.setScaleY(map.getScaleY() + Config.SCALE_STEP * scale);
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
}
