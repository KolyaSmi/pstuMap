package com.example.pstumap.source;

import android.util.Log;
import android.widget.ImageView;

import com.example.pstumap.Config;

public class Floor {

    private Icon[] icons;

    private ImageView map;

    private float scale;
    private float x;
    private float y;

    public Floor() {

    }

    public void setMap(ImageView imageView) {
        map = imageView;
        scale = map.getScaleX();
    }

    public void setIcons(ImageView[] dest_icons, float x, float y) {
        icons = new Icon[dest_icons.length];
        for (int i = 0; i < dest_icons.length; i++){
            icons[i] = new Icon();
            icons[i].setIcon(dest_icons[i], x, y);
        }
    }

    public void setPos() {
        if(icons != null)
            for(Icon icon : icons){
                icon.setPos();
            }
        x = map.getX();
        y = map.getY();
    }

    public void scaleMap(float index){
        if(icons != null)
            for(Icon icon : icons){
                icon.scaleIcon(index, map.getWidth());
            }
        scale = Config.SCALE_STEP * index + scale;
        map.setScaleX(scale);
        map.setScaleY(scale);
        Log.d("scaleMap", "scale: " + scale);
    }

    public void movMap(float dx, float dy) {
        if(icons != null)
            for(Icon icon : icons){
                icon.movIcon(dx, dy);
            }
        map.setX(x + dx);
        map.setY(y + dy);
    }
}
