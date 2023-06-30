package com.example.pstumap;

import static com.example.pstumap.source.FrameManager.*;

import com.example.pstumap.fragments.FragmentManager;

public abstract class MapManager {

    public static int complex_a;

    public static int complex_g;

    public static void initMap() {
        createMap();

        complex_a = createFrame(2);
        addFloor(complex_a, FragmentManager.map_complex_a_1);
        setImageMap(complex_a, FragmentManager.map_complex_a_1.map);
        setIcon(complex_a, FragmentManager.map_complex_a_1.icon_1, 0, 0);
        setDescriptionIcon(complex_a, "1", "1");

        addFloor(complex_a, FragmentManager.map_complex_a_2);
        setImageMap(complex_a, FragmentManager.map_complex_a_2.map);
        setIcon(complex_a, FragmentManager.map_complex_a_2.icon, 170, 70);
        setDescriptionIcon(complex_a, "Столовая", "Какое то описание");

        complex_g = createFrame(2);
        addFloor(complex_g, FragmentManager.map_complex_g_1);
        setImageMap(complex_g, FragmentManager.map_complex_g_1.map);
        setIcons(complex_g, FragmentManager.map_complex_g_1.icons, new float[]{300, 300}, new float[]{600, 100});

        addFloor(complex_g, FragmentManager.map_complex_g_2);
        setImageMap(complex_g, FragmentManager.map_complex_g_2.map);

        addFloor(complex_g, FragmentManager.map_complex_g_3);
        setImageMap(complex_g, FragmentManager.map_complex_g_3.map);
        setIcons(complex_g, FragmentManager.map_complex_g_3.icons, new float[]{38, 42, 173, 15, 35, 28}, new float[]{71, 938, 413, 806, 880, 12});
    }
}
