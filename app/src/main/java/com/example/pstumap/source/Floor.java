package com.example.pstumap.source;

import android.util.Log;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.pstumap.Config;

/**
 * This class is responsible for the construction of the floor.
 * It contains the map itself, the fragment and the icons.
 */
public class Floor {

    private Icon[] icons;

    private ImageView map;

    private Fragment fragment;

    private float scale;
    private float x;
    private float y;

    /**
     * Creates a new floor.
     * @param _fragment Link to the fragment for further reference.
     */
    public Floor(Fragment _fragment) {
        fragment = _fragment;
    }

    /**
     * Sets the picture for the floor from the fragment.
     * @param imageView Map picture.
     */
    public void setMap(ImageView imageView) {
        map = imageView;
        scale = map.getScaleX();
    }

    /**
     * Sets the icons on the floor.
     * @param dest_icons Icon Array.
     * @param x Initial coordinates x.
     * @param y Initial coordinates y.
     */
    public void setIcons(ImageView[] dest_icons, float x, float y) {
        icons = new Icon[dest_icons.length];
        for (int i = 0; i < dest_icons.length; i++){
            icons[i] = new Icon();
            icons[i].setIcon(dest_icons[i], x, y);
        }
    }

    /**
     * Sets the start position before moving the object.
     */
    public void setPos() {
        if(icons != null)
            for(Icon icon : icons){
                icon.setPos();
            }
        x = map.getX();
        y = map.getY();
    }

    /**
     * Changes the scale of the map.
     * @param index 1 increases the picture -1 decreases the picture.
     */
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

    /**
     * Moves the map behind the cursor.
     * @param dx Change of coordinate in x.
     * @param dy Changing the coordinate by y.
     */
    public void movMap(float dx, float dy) {
        if(icons != null)
            for(Icon icon : icons){
                icon.movIcon(dx, dy);
            }
        map.setX(x + dx);
        map.setY(y + dy);
    }

    /**
     *
     * @return Returns a fragment with a map.
     */
    public Fragment getFragment() {
        return fragment;
    }
}
