package com.example.pstumap;

import static com.example.pstumap.source.FrameManager.*;

import android.widget.FrameLayout;

public abstract class MapManager {

    public static int complex_a;

    public static int complex_g;

    public static void initMap(FrameLayout frame_layout) {
        createMap(frame_layout);

        complex_a = createFrame(Config.COUNT_FLOOR_COMPLEX_A);
        setTitle(complex_a, "Корпус А");
        addFloor(complex_a, R.drawable.map_complex_a_1);

        addFloor(complex_a, R.drawable.map_complex_a_2);
        setIcons(complex_a, new int[]{R.drawable.icon_caffe, R.drawable.icon_caffe}, new float[]{170, 300}, new float[]{70, 70});
        setDescriptionIcon(complex_a, "Лестница", "Не очень удобная лестница." , R.drawable.test_image);

        complex_g = createFrame(Config.COUNT_FLOOR_COMPLEX_G);
        setTitle(complex_g, "Корпус Г");
        addFloor(complex_g, R.drawable.map_complex_g_1);

        addFloor(complex_g, R.drawable.map_complex_a_1);

        setVisibleFloor();
        MainActivity.changeTitle(complex_g);
        MainActivity.floor_number.setText(getNumberFloor() + "");
    }
}
