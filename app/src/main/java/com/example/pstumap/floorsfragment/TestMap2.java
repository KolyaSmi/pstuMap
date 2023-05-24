package com.example.pstumap.floorsfragment;

import static com.example.pstumap.data.Config.COMPLEX_A_ID;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pstumap.R;

public class TestMap2 extends Fragment {

    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_test_map2, container, false);
        View rootView = inflater.inflate(R.layout.fragment_test_map, container, false);

        map = rootView.findViewById(R.id.map);

        FragmentManager.setFragment(map, COMPLEX_A_ID);

        initPlaces();

        return rootView;
    }

    public void initPlaces(){
//        FragmentManager.complex_a.getFloor(1).getPlaces().addPlace(icon_1, 100, 100);
    }
}