package com.example.pstumap.source;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.pstumap.Config;
import com.example.pstumap.MainActivity;
import com.example.pstumap.R;
import com.example.pstumap.fragments.FragmentManager;

/**
 * This class is responsible for the icons on the floor.
 */
class Icon {

    private ImageView icon;

    private String header;
    private String description;
    private int image_id;

    protected boolean onTouch = false;
    private float scale;
    private float x;
    private float y;

    protected void setIcon(int icon, float x, float y, FrameLayout frame_layout) {
        this.x = x;
        this.y = y;
        scale = 1f;

        this.icon = new ImageView(frame_layout.getContext());
        this.icon.setImageResource(icon);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Config.ICON_SIZE_WIGHT, Config.ICON_SIZE_HEIGHT);
        this.icon.setLayoutParams(layoutParams);
        this.icon.setScaleX(scale);
        this.icon.setScaleY(scale);
        hide();
        frame_layout.addView(this.icon);

        this.icon.setX(x);
        this.icon.setY(y);

        header = "Заголовок";
        description = "Описание";
        image_id = R.drawable.default_image_icon;

        setListener();
    }

    private void setListener() {
        icon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    if (onTouch) {
                        setScale(-1);
                        FragmentManager.hideFragment(FragmentManager.icon_window);
                        onTouch = false;
                    } else {
                        setScale(1);
                        FragmentManager.checkOpenChangeWindow();
                        FrameManager.checkOpenIcons();
                        FragmentManager.setDescriptionFragment(header, description, image_id);
                        FragmentManager.showFragment(FragmentManager.icon_window);
                        MainActivity.onClick = false;
                        onTouch = true;
                    }
                }
                return true;
            }
        });
    }

    protected void setDescription(String header, String description, int image_id) {
        this.header = header;
        this.description = description;
        this.image_id = image_id;
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
        float scale = icon.getScaleX() + (index * Config.ICON_SIZE_ON_CLICK);
        icon.setScaleX(scale);
        icon.setScaleY(scale);
        if(index > 0)
            icon.setY(icon.getY() + (1 - (index * (1+Config.ICON_SIZE_ON_CLICK))) * icon.getHeight()/2);
        else
            icon.setY(icon.getY() - (1 - (-index * (1+Config.ICON_SIZE_ON_CLICK))) * icon.getHeight()/2);
    }

    protected void movIcon(float dx, float dy) {
        icon.setX(x + dx);
        icon.setY(y + dy);
    }

    protected void show() {
        icon.setVisibility(View.VISIBLE);
    }

    protected void hide() {
        icon.setVisibility(View.INVISIBLE);
    }
}
