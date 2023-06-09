package com.example.pstumap.source;

import android.widget.ImageView;

import com.example.pstumap.Config;

public class Icon {

    private ImageView icon;

    private float scale;
    private float x;
    private float y;

    public void setIcon(ImageView icon, float x, float y) {
        this.icon = icon;
        this.x = x;
        this.y = y;

        this.icon.setX(x);
        this.icon.setY(y);
        scale = icon.getScaleX();
    }

    public void setPos() {
        x = icon.getX();
        y = icon.getY();
    }

    public void scaleIcon(float index, float wight_map) {
        setPos();
        movIcon((Config.SCALE_STEP * wight_map / 2) * -index, (Config.SCALE_STEP * wight_map / 2) * -index);
    }

    public void movIcon(float dx, float dy) {
        icon.setX(x + dx);
        icon.setY(y + dy);
    }
}
