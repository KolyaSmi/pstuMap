package com.example.pstumap;

import android.widget.ImageView;
import android.widget.TextView;

public class Engine {

    private ImageView map;
    private TextView floor_number_text;

    private float dX = 0;
    private float dY = 0;

    private Frame complex_a;

    public Engine (ImageView map, TextView floor_number_text , int floor_number){
        this.map = map;
        this.floor_number_text = floor_number_text;
        floor_number_text.setText(floor_number + "");
        createFrames();
    }

    private void createFrames(){
        int[] mass_images = new int[Config.MAX_FLOOR - Config.MIN_FLOOR + 1];

        mass_images[0] = R.drawable.test_map;
        mass_images[1] = R.drawable.test_map_2;
        mass_images[2] = R.drawable.test_map_3;
        complex_a = new Frame(mass_images, 1, 3);

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

    protected void changeFloor(int dir){
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
}
