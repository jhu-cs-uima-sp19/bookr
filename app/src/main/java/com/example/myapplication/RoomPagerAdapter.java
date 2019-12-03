package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.room.Room;

// Since this is an object collection, use a FragmentStatePagerAdapter,
// and NOT a FragmentPagerAdapter.
public class RoomPagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private SharedPreferences myPrefs;

    public RoomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setContext(Context context){
        mContext = context;
        myPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return myPrefs.getInt("num_rooms",1);
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new RoomFragment();
        Bundle args = new Bundle();
        args.putString(RoomFragment.ARG_OBJECT, myPrefs.getString("Room_" + i, null));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Rooms.eid2room.get(myPrefs.getString("Room_" + position, null));
    }
}