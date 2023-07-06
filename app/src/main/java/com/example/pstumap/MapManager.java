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

        int[] icons = new int[]{
                R.drawable.icon_caffe,
                R.drawable.icon_stairs,
                R.drawable.icon_stairs,
                R.drawable.icon_wc_women,
                R.drawable.icon_stairs
        };

        float[][] xy = new float[][]{
                {110, -30, 110, -20, -30},
                {200, -45, 335, 0, 820}
        };

        String[][] description = new String[][]{
                {"Каффе", "Лестница", "Лестница", "Женский туалет", "Лестница",},
                {"Лучшее место чтобы поесть", "Первая", "Лестница ведет на цокольный этаж", "Женский туалет на первом этаже", "Третья",}
        };

        int [] images = new int[]{
                R.drawable.default_image_icon,
                R.drawable.default_image_icon,
                R.drawable.default_image_icon,
                R.drawable.default_image_icon,
                R.drawable.default_image_icon
        };

        addFloor(complex_g, R.drawable.map_complex_g_1);
        setIcons(complex_g, icons, xy[0], xy[1]);
        setDescriptionsIcons(complex_g, description[0], description[1], images);

        icons = new int[]{
                R.drawable.icon_relax_place,
                R.drawable.icon_stairs,
                R.drawable.icon_relax_place,
                R.drawable.icon_stairs,
                R.drawable.icon_wc_men,
                R.drawable.icon_wc_women
        };

        xy = new float[][]{
                {-30, -30, 110, -30, -20, -30},
                {740, -45, 335, 820, 0, 870}
        };

        addFloor(complex_g, R.drawable.map_complex_g_2);
        setIcons(complex_g, icons, xy[0], xy[1]);

        icons = new int[]{
                R.drawable.icon_caffe,
                R.drawable.icon_stairs,
                R.drawable.icon_relax_place,
                R.drawable.icon_stairs,
                R.drawable.icon_wc_men,
                R.drawable.icon_wc_women
        };

        xy = new float[][]{
                {-50, -30, 110, -30, -20, -30},
                {730, -45, 335, 820, 0, 870}
        };

        addFloor(complex_g, R.drawable.map_complex_g_3);
        setIcons(complex_g, icons, xy[0], xy[1]);

        icons = new int[]{
                R.drawable.icon_stairs,
                R.drawable.icon_stairs,
                R.drawable.icon_wc_men,
                R.drawable.icon_wc_women
        };

        xy = new float[][]{
                {-30, -30, -20, -30},
                {-45,820, 0, 870}
        };

        addFloor(complex_g, R.drawable.map_complex_g_4);
        setIcons(complex_g, icons, xy[0], xy[1]);


        setVisibleFloor();

        MainActivity.changeTitle(complex_g);
        MainActivity.floor_number.setText((getNumberFloor() + 1) + "");
    }
}
