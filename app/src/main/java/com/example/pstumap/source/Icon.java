package com.example.pstumap.source;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.pstumap.Config;
import com.example.pstumap.fragments.FragmentManager;

/**
 * This class is responsible for the icons on the floor.
 */
class Icon {

    private ImageView icon;

    private String header;
    private String description;

    private boolean onTouch = false;
    private float scale;
    private float cur_scale;
    private float x;
    private float y;

    protected void setIcon(ImageView icon, float x, float y) {
        this.icon = icon;
        this.x = x;
        this.y = y;

        this.icon.setX(x);
        this.icon.setY(y);
        scale = icon.getScaleX();
        cur_scale = icon.getScaleX();

        this.icon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    if (onTouch) {
                        setScale(-1);
                        FragmentManager.removeFragmentInUpWindow(FragmentManager.icon_window);
                        onTouch = false;
                    } else {
                        setScale(1);
                        FragmentManager.replaceFragmentInUpWindow(FragmentManager.icon_window, header, description);
                        onTouch = true;
                    }
                }
                return true;
            }
        });
    }

    protected void setDescription(String header, String description) {
        this.header = header;
        this.description = description;
    }

    protected void setPos() {
        x = icon.getX();
        y = icon.getY();
    }

    protected void setPos(int _x, int _y) {
        x = _x;
        y = _y;
    }

    protected void scaleIcon(float index, float wight_map, float height_map, float x_map, float y_map) {

        scale = scale + Config.SCALE_STEP * index;

        float cX = x_map + (wight_map)/2;
        float cY = y_map + (height_map)/2;

        if(index > 0) {
            icon.setX(cX + ((icon.getX() - cX) * (1 + Config.SCALE_STEP)));
            icon.setY(cY + ((icon.getY() - cY) * (1 + Config.SCALE_STEP)));
        }else {
            icon.setX(cX + ((icon.getX() - cX) / (1 + Config.SCALE_STEP)));
            icon.setY(cY + ((icon.getY() - cY) / (1 + Config.SCALE_STEP)));
        }
        setPos();

        Log.d("scale icon", "x_map = " + x_map + " y_map = " + y_map + " w = " + wight_map + " h = " + height_map);
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

    protected String getHeader(){
        return header;
    }

    protected String getDescription(){
        return description;
    }
}
