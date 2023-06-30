package com.example.pstumap.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pstumap.R;

public class MapComplexG1 extends Fragment {

    public ImageView map;

    public ImageView[] icons = new ImageView[5];
    private ImageView icon_wc_woman;
    private ImageView icon_caffe;
    private ImageView icon_stairs_1;
    private ImageView icon_stairs_2;
    private ImageView icon_stairs_3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map_complex_g_1, container, false);

        map = rootView.findViewById(R.id.map);

        icon_wc_woman = rootView.findViewById(R.id.icon_wc_woman);
        icon_caffe = rootView.findViewById(R.id.icon_caffe);
        icon_stairs_1 = rootView.findViewById(R.id.icon_stairs_1);
        icon_stairs_2 = rootView.findViewById(R.id.icon_stairs_2);
        icon_stairs_3 = rootView.findViewById(R.id.icon_stairs_3);
        icons[0] = icon_wc_woman;
        icons[1] = icon_caffe;
        icons[2] = icon_stairs_1;
        icons[3] = icon_stairs_2;
        icons[4] = icon_stairs_3;

        FragmentManager.add();

        Log.d("setFrames", "create fragment 1");
        return rootView;
    }
}