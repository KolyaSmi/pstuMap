package com.example.pstumap.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pstumap.R;
public class MapComplexG2 extends Fragment {

    public ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map_complex_g_2, container, false);

        map = rootView.findViewById(R.id.map);

        FragmentManager.add();

        Log.d("setFrames", "create fragment 2");
        return rootView;
    }
}