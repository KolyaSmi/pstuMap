package com.example.pstumap.source;

import android.widget.ImageView;

import com.example.pstumap.Config;

/**
 * This class is responsible for the icons on the floor.
 */
class Icon {

    private ImageView icon;

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

    protected void movIcon(float dx, float dy) {
        icon.setX(x + dx);
        icon.setY(y + dy);
    }
}
