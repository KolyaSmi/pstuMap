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

    private Button complex_a_button;
    private Button complex_g_button;

    public ImageView ledge;

    public float y;

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
                complex_a_button.setBackgroundResource(R.drawable.blocked_back_button_in_up_window);
                complex_g_button.setBackgroundResource(R.drawable.back_button_in_up_window);
            }
        });

        complex_g_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameManager.changeFrame(MapManager.complex_g);
                complex_g_button.setBackgroundResource(R.drawable.blocked_back_button_in_up_window);
                complex_a_button.setBackgroundResource(R.drawable.back_button_in_up_window);
            }
        });

        ledge = rootView.findViewById(R.id.ledge);

        ledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager.hideFragment(FragmentManager.change_frame_window);
                MainActivity.onClick = false;
            }
        });

        return rootView;
    }
}