package com.example.pstumap.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pstumap.R;

public class IconWindow extends Fragment {

    public TextView text_header;
    public TextView text_description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_icon_window, container, false);

        text_header = rootView.findViewById(R.id.text_header);
        text_description = rootView.findViewById(R.id.text_description);

        return rootView;
    }
}