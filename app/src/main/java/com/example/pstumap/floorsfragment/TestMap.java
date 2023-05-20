package com.example.pstumap.floorsfragment;

import static com.example.pstumap.data.Config.COMPLEX_A_ID;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pstumap.R;
import com.example.pstumap.source.Engine;

public class TestMap extends Fragment {

    private ImageView map;

    public ImageView icon_1;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_test_map, container, false);

        map = rootView.findViewById(R.id.map);

        icon_1 = rootView.findViewById(R.id.icon_1);
        FragmentManager.setFragment(map, COMPLEX_A_ID);
        initPlaces();
        Log.i("app_log", "create icon");

        return rootView;
    }

    public void initPlaces(){
        FragmentManager.complex_a.getFloor(1).getPlaces().addPlace(icon_1, 0, 0);
    }
}