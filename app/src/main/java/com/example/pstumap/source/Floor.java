package com.example.pstumap.source;

import static com.example.pstumap.Config.MAX_SCALE;
import static com.example.pstumap.Config.MIN_SCALE;

import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.pstumap.Config;
import com.example.pstumap.fragments.FragmentManager;

/**
 * This class is responsible for the construction of the floor.
 * It contains the map itself, the fragment and the icons.
 */
class Floor {

    private Icon[] icons;

    private ImageView map;

    private FrameLayout frame_layout;

    private ScaleGestureDetector scaleGestureDetector;

    private float scale;

    private float mouse_x;
    private float mouse_y;
    private float x;
    private float y;

    /**
     * Creates a new floor.
     * @param frame_layout Link to the fragment for further reference.
     */
    protected Floor(FrameLayout frame_layout) {
        this.frame_layout = frame_layout;
    }

    /**
     * Sets the picture for the floor from the fragment.
     * @param map_id Map picture id.
     */
    protected void setMap(int map_id) {
        map = new ImageView(frame_layout.getContext());
        map.setImageResource(map_id);
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(228, 1194);
        map.setLayoutParams(layoutParams);
        hide();
        scale = 1f;
        frame_layout.addView(map);
        scaleGestureDetector = new ScaleGestureDetector(frame_layout.getContext(), new ScaleListener());



        setPos();
        setListener();

        scale = map.getScaleX();
        Log.d("map image", "set");
    }

    private void setListener() {
//        frame_layout.setOnTouchEvent(new View.OnTouchEvent() {
//            @Override
//            public boolean onTouchEvent(MotionEvent motionEvent) {
//                scaleGestureDetector.onTouchEvent(motionEvent);
//                return true;
//            }
//        });

        map.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int pointer_count = event.getPointerCount();
                if(pointer_count == 1) {
                    if (MotionEvent.ACTION_DOWN == event.getAction()) {
                        mouse_x = event.getX();
                        mouse_y = event.getY();
                    }
                    if (MotionEvent.ACTION_MOVE == event.getAction()) {
                        movMap(event.getX() - mouse_x, event.getY() - mouse_y);
                    }
                    if (MotionEvent.ACTION_UP == event.getAction()) {
                        setPos();
                    }
                }else {
//                    scaleGestureDetector.onTouchEvent(event);
                }
                Log.d("onTouch", "dx " + (event.getX() - mouse_x) + " dy " + (event.getY() - mouse_y));
                return true;
            }
        });

    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            scale *= scaleGestureDetector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 10.0f));
//            map.setScaleX(scale);
//            map.setScaleY(scale);
            scaleMapForScale();
            return true;
        }
    }

    /**
     * Sets the icons on the floor.
     * @param dest_icons Icon Array.
     * @param x Initial coordinates x.
     * @param y Initial coordinates y.
     */
    protected void setIcons(int[] dest_icons, float[] x, float[] y) {
        icons = new Icon[dest_icons.length];
        for (int i = 0; i < dest_icons.length; i++){
            icons[i] = new Icon();
            icons[i].setIcon(dest_icons[i], x[i], y[i], frame_layout);
        }
    }

    protected void setDescriptionsIcons(String[] headers, String[] descriptions, int[] images_id){
        for (int i = 0; i < headers.length; i++){
            icons[i].setDescription(headers[i], descriptions[i], images_id[i]);
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
        if(Config.SCALE_STEP  * index + scale <= MAX_SCALE && Config.SCALE_STEP * index + scale >= MIN_SCALE) {
            if (icons != null)
                for (Icon icon : icons) {
                    icon.scaleIcon(index, map.getWidth(), map.getHeight(), map.getX(), map.getY());
                }

            if(index > 0)
                scale = scale * (1 + Config.SCALE_STEP);
            else
                scale = scale / (1 + Config.SCALE_STEP);

            map.setScaleX(scale);
            map.setScaleY(scale);
        }
        Log.d("scaleMap", "scale: " + scale);
    }

    public void scaleMapForScale(){
        if(Config.SCALE_STEP  * scale + scale <= MAX_SCALE && Config.SCALE_STEP * scale + scale >= MIN_SCALE) {
//            if (icons != null)
//                for (Icon icon : icons) {
//                    icon.scaleIcon(index, map.getWidth(), map.getHeight(), map.getX(), map.getY());
//                }

            map.setScaleX(scale);
            map.setScaleY(scale);
        }
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
        setPos();
        Log.d("move map", "x: " + map.getX() + " y: " + map.getY());
    }

    protected void show() {
        if(icons != null) {
            for (Icon icon : icons) {
                icon.show();
            }
        }
        map.setVisibility(View.VISIBLE);
    }

    protected void hide() {
        if(icons != null) {
            for (Icon icon : icons) {
                icon.hide();
            }
        }
        map.setVisibility(View.INVISIBLE);
    }

    public void checkOpenIcons() {
        if(icons != null) {
            for (Icon icon : icons) {
                if (icon.onTouch) {
                    icon.setScale(-1);
                    icon.onTouch = false;
                    FragmentManager.hideFragment(FragmentManager.icon_window);
                }
            }
        }
    }
}
