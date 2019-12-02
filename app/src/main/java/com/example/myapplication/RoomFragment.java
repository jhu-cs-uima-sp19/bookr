package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

// Instances of this class are fragments representing a single
// object in our collection.
public class RoomFragment extends Fragment {
    public static final String ARG_OBJECT = "eid";
    private BookingDatabase bookingDatabase;

    // Store instance variables
    private int eid;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(
                R.layout.activity_rooms, container, false);
        Bundle args = getArguments();
/*
        eid = Integer.parseInt(args.getString(ARG_OBJECT));
        bookingDatabase = BookingDatabase.getBookingDatabase(getActivity());
        Rooms room = bookingDatabase.daoAccess().fetchById(eid);
*/
        return rootView;
    }
}