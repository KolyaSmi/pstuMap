package com.example.pstumap.source;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.pstumap.Config;

/**
 * This class is responsible for the icons on the floor.
 */
class Icon {

    private ImageView icon;

    private boolean onTouch = false;
    private float scale;
    private float x;
    private float y;

    protected void setIcon(ImageView icon, float x, float y) {
        this.icon = icon;
        this.x = x;
        this.y = y;

        this.icon.setX(x);
        this.icon.setY(y);
        scale = icon.getScaleX();

        this.icon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    if (onTouch) {
                        setScale(-1);
                        onTouch = false;
                    } else {
                        setScale(1);
                        onTouch = true;
                    }
                }
                return true;
            }
        });
    }

    protected void setPos() {
        x = icon.getX();
        y = icon.getY();
    }

    protected void setPos(int _x, int _y) {
        x = _x;
        y = _y;
    }

    protected void scaleIcon(float index, float wight_map) {
        setPos();
        movIcon((Config.SCALE_STEP * wight_map / 2) * -index, (Config.SCALE_STEP * wight_map / 2) * -index);
    }

    protected void setScale(int index){
        float scale = icon.getScaleX() + (index * 1.3f);
        icon.setScaleX(scale);
        icon.setScaleY(scale);
    }

    protected void movIcon(float dx, float dy) {
        icon.setX(x + dx);
        icon.setY(y + dy);
    }
}
