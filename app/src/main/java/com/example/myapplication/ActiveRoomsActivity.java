package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class ActiveRoomsActivity extends FragmentActivity {

    private SharedPreferences myPrefs;

    public void onCreate(Bundle savedInstanceState) {
        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_rooms);

        myPrefs = PreferenceManager.getDefaultSharedPreferences(this);



    }
}