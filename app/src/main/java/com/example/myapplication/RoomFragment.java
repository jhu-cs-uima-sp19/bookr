package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

// Instances of this class are fragments representing a single
// object in our collection.
public class RoomFragment extends Fragment {
    public static final String ARG_OBJECT = "object";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(
                R.layout.activity_rooms, container, false);
        Bundle args = getArguments();
        //((TextView) rootView.findViewById(android.R.id.text1)).setText(
        //        Integer.toString(args.getInt(ARG_OBJECT)));
        return rootView;
    }
}