package com.example.pstumap.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.pstumap.MainActivity;
import com.example.pstumap.MapManager;
import com.example.pstumap.R;
import com.example.pstumap.source.FrameManager;

public class ChangeFrameWindow extends Fragment {

    private Button complex_a_button;
    private Button complex_g_button;
    private LinearLayout linear_layout;

    public ImageView ledge;

    public float y;
    public float Y;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_change_frame_window, container, false);

        complex_a_button = rootView.findViewById(R.id.change_complex_a_button);
        complex_g_button = rootView.findViewById(R.id.change_complex_g_button);
        linear_layout = rootView.findViewById(R.id.linear_layout);

        complex_a_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameManager.changeFrame(MapManager.complex_a);
                complex_a_button.setBackgroundResource(R.drawable.blocked_back_button_in_up_window);
                complex_g_button.setBackgroundResource(R.drawable.back_button_in_up_window);
                MainActivity.changeTitle(MapManager.complex_a);
            }
        });

        complex_g_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameManager.changeFrame(MapManager.complex_g);
                complex_g_button.setBackgroundResource(R.drawable.blocked_back_button_in_up_window);
                complex_a_button.setBackgroundResource(R.drawable.back_button_in_up_window);
                MainActivity.changeTitle(MapManager.complex_g);
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

//        ledge.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent event) {
//                if (MotionEvent.ACTION_DOWN == event.getAction()){
//                    y = event.getY();
//                    Y = MainActivity.frame_up_window.getY();
//                    MainActivity.frame_up_window.setY(Y);
//                }
//                if (MotionEvent.ACTION_MOVE == event.getAction()){
////                    MainActivity.frame_up_window.setY(y + linear_layout.getHeight() + linear_layout.getY());
////                    MainActivity.frame_up_window.setY(Y - (y - event.getY()));
//                    if(event.getY() >= Y) {
//                        MainActivity.frame_up_window.setY(event.getY() + Y);
//                        Y = MainActivity.frame_up_window.getY();
//                    }
//                }
//                Log.d("ledge", event.getY() +"");
//                return true;
//            }
//        });

        return rootView;
    }
}