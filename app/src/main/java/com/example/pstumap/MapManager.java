package com.example.pstumap;

import static com.example.pstumap.source.FrameManager.*;

import com.example.pstumap.fragments.FragmentManager;

public abstract class MapManager {

    static int complex_a;

    static int complex_g;

    public static void initMap() {
        createMap();

        complex_a = createFrame(2);
        addFloor(complex_a, FragmentManager.map_complex_a_1);
        setImageMap(complex_a, FragmentManager.map_complex_a_1.map);
        addFloor(complex_a, FragmentManager.map_complex_a_2);
        setImageMap(complex_a, FragmentManager.map_complex_a_2.map);

        complex_g = createFrame(2);
        addFloor(complex_g, FragmentManager.map_complex_g_1);
        setImageMap(complex_g, FragmentManager.map_complex_g_1.map);
        setIcons(complex_g, FragmentManager.map_complex_g_1.icons, new float[]{300, 300}, new float[]{600, 100});
        addFloor(complex_g, FragmentManager.map_complex_g_2);
        setImageMap(complex_g, FragmentManager.map_complex_g_2.map);
    }
}
