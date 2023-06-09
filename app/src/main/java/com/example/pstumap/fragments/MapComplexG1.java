package com.example.pstumap.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pstumap.R;

public class MapComplexG1 extends Fragment {

    public ImageView map;

    public ImageView[] icons = new ImageView[1];
    private ImageView icon_1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map_complex_g_1, container, false);

        map = rootView.findViewById(R.id.map);

        icon_1 = rootView.findViewById(R.id.icon_1);
        icons[0] = icon_1;

        FragmentManager.addFloorInFrame();

        return rootView;
    }

    private void addFloor(){

    }
}