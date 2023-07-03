package com.example.pstumap.fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.pstumap.MapManager;
import com.example.pstumap.R;

public class MapFragment extends Fragment {

    public FrameLayout frame_layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map_fragment, container, false);

        frame_layout = rootView.findViewById(R.id.frame_layout);

        MapManager.initMap(frame_layout);

        Log.d("setFrames", "create fragment 2");
        return rootView;
    }
}