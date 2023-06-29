package com.example.pstumap.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.Button;

import com.example.pstumap.MainActivity;
import com.example.pstumap.MapManager;
import com.example.pstumap.R;
import com.example.pstumap.source.FrameManager;

public class ChangeFrameWindow extends Fragment {

    private Button complex_a_button;
    private Button complex_g_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_change_frame_window, container, false);

        complex_a_button = rootView.findViewById(R.id.change_complex_a_button);
        complex_g_button = rootView.findViewById(R.id.change_complex_g_button);

        complex_a_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameManager.changeFrame(MapManager.complex_a);
            }
        });

        complex_g_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameManager.changeFrame(MapManager.complex_g);
            }
        });

        return rootView;
    }
}