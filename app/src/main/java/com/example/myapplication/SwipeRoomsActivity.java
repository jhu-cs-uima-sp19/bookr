package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amitshekhar.DebugDB;

import java.util.ArrayList;

public class SwipeRoomsActivity extends FragmentActivity {
    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    RoomPagerAdapter pagerAdapter;
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        pagerAdapter = new RoomPagerAdapter(getSupportFragmentManager());
        pagerAdapter.setContext(getApplicationContext());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(pagerAdapter);

    }

    public void confirmBooking(View ib) {
        //nothing for now
    }
}