package com.example.pstumap.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pstumap.R;


public class MapComplexG3 extends Fragment {

    public ImageView map;

    public ImageView[] icons = new ImageView[6];
    public ImageView icon_wc_woman;
    public ImageView icon_wc_man;
    public ImageView icon_relaxing_place;
    public ImageView icon_caffe;
    public ImageView icon_stairs_1;
    public ImageView icon_stairs_2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_map_complex_g_3, container, false);

        map = rootView.findViewById(R.id.map);

        icon_wc_man = rootView.findViewById(R.id.icon_wc_man);
        icon_wc_woman = rootView.findViewById(R.id.icon_wc_woman);
        icon_relaxing_place = rootView.findViewById(R.id.icon_relaxing_place);
        icon_caffe = rootView.findViewById(R.id.icon_caffe);
        icon_stairs_1 = rootView.findViewById(R.id.icon_stairs_1);
        icon_stairs_2 = rootView.findViewById(R.id.icon_stairs_2);

        icons[0] = icon_wc_man;
        icons[1] = icon_wc_woman;
        icons[2] = icon_relaxing_place;
        icons[3] = icon_caffe;
        icons[4] = icon_stairs_1;
        icons[5] = icon_stairs_2;

        FragmentManager.add();

        Log.d("setFrames", "create fragment 1");
        return rootView;
    }
}