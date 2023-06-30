package com.example.pstumap.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.pstumap.MainActivity;
import com.example.pstumap.MapManager;
import com.example.pstumap.R;
import com.example.pstumap.source.FrameManager;

public class ChangeFrameWindow extends Fragment {

    private ImageButton complex_a_button;
    private ImageButton complex_g_button;

    public ImageView ledge;

    private ImageButton des_button;

    public float y;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_change_frame_window, container, false);

        complex_a_button = rootView.findViewById(R.id.change_complex_a_button);
        complex_g_button = rootView.findViewById(R.id.change_complex_g_button);

        if(des_button == null) {
            complex_a_button.setBackgroundResource(R.drawable.back_button_in_up_window_select);
            des_button = complex_a_button;
        }

        complex_a_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameManager.changeFrame(MapManager.complex_a);
                togleButton(complex_a_button);
                MainActivity.onClick = false;
            }
        });

        complex_g_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameManager.changeFrame(MapManager.complex_g);
                togleButton(complex_g_button);
                MainActivity.onClick = false;
            }
        });

        ledge = rootView.findViewById(R.id.ledge);

        ledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager.hideFragmentInUpWindow(FragmentManager.change_frame_window);
                MainActivity.onClick = false;
            }
        });

        return rootView;
    }

    private void togleButton(ImageButton select_button){
        des_button.setBackgroundResource(R.drawable.back_button_in_up_window);
        select_button.setBackgroundResource(R.drawable.back_button_in_up_window_select);
        des_button = select_button;
    }
}