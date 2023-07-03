package com.example.pstumap;

import static com.example.pstumap.source.FrameManager.*;

import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.example.pstumap.fragments.FragmentManager;

public abstract class MapManager {

    public static int complex_a;

    public static int complex_g;

    public static void initMap(FrameLayout frame_layout) {
        createMap(frame_layout);

        complex_a = createFrame(Config.COUNT_FLOOR_COMPLEX_A);
        addFloor(complex_a, R.drawable.map_complex_a_1);

        addFloor(complex_a, R.drawable.map_complex_a_2);
        setIcon(complex_a, R.drawable.icon_caffe, 170, 70);

        setVisibleFloor();
//        setImageMap(complex_a, FragmentManager.map_fragment.map);
//        setIcon(complex_a, FragmentManager.map_fragment.icon_1, 0, 0);
//        setDescriptionIcon(complex_a, "1", "1", R.drawable.test_image);
//
//        addFloor(complex_a, FragmentManager.map_complex_a_2);
//        setImageMap(complex_a, FragmentManager.map_complex_a_2.map);
//        setIcon(complex_a, FragmentManager.map_complex_a_2.icon, 170, 70);
//        setDescriptionIcon(complex_a, "Мужской туалет", "тут можна пописять).", R.drawable.test_image_2);
//
//        complex_g = createFrame(3);
//        addFloor(complex_g, FragmentManager.map_complex_g_1);
//        setImageMap(complex_g, FragmentManager.map_complex_g_1.map);
//        setIcons(complex_g, FragmentManager.map_complex_g_1.icons, new float[]{38 + 150, 220 + 150, 220 + 150, 145, 35 + 150}, new float[]{80, 350, 580, 0, 950 + 300});
//
//        addFloor(complex_g, FragmentManager.map_complex_g_2);
//        setImageMap(complex_g, FragmentManager.map_complex_g_2.map);
//
//        addFloor(complex_g, FragmentManager.map_complex_g_3);
//        setImageMap(complex_g, FragmentManager.map_complex_g_3.map);
//        setIcons(complex_g, FragmentManager.map_complex_g_3.icons, new float[]{38 + 150, 42 + 150, 220 + 150, 145, 35 + 150, 20 + 150}, new float[]{80, 1040 + 300, 580, 815 + 300, 950 + 300, 12});
    }
}
