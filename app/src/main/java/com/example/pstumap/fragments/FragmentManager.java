package com.example.pstumap.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pstumap.MainActivity;
import com.example.pstumap.R;

/**
 *The FragmentManager stores all fragments of the map.
 *After all fragments are created, it gives the command to create the project structure in the FrameManager.
 *With COUNT_FRAGMENTS in Config the number of fragments after which the signal will be transmitted is regulated.
 */
public abstract class FragmentManager {

    public static IconWindow icon_window;
    public static ChangeFrameWindow change_frame_window;
    public static MapFragment map_fragment;

    private static AppCompatActivity main_activity;

    private static int cur_count_fragment = 0;

    /**
     *Initialize all fragments.
     */
    public static void initFragment(){
        map_fragment = new MapFragment();

        icon_window = new IconWindow();
        change_frame_window = new ChangeFrameWindow();
    }

    public static void setFragmentTransaction(AppCompatActivity _mainActivity) {
        main_activity = _mainActivity;
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame_layout, map_fragment).
                add(R.id.frame_up_window, icon_window).
                add(R.id.frame_up_window, change_frame_window).
                hide(icon_window).
                hide(change_frame_window).
                show(map_fragment).
                commit();
    }

    public static void showFragment(Fragment fragment) {
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.show(fragment).commit();
    }

    public static void hideFragment(Fragment fragment) {
        FragmentTransaction ft = main_activity.getSupportFragmentManager().beginTransaction();
        ft.hide(fragment).commit();
    }

    public static void setDescriptionFragment(String header, String description, int image_id) {
        icon_window.text_header.setText(header);
        icon_window.text_description.setText(description);
        icon_window.image.setImageResource(image_id);
    }

    public static void checkOpenChangeWindow() {
        if (MainActivity.onClick){
            hideFragment(change_frame_window);
            MainActivity.onClick = false;
        }
    }
}
