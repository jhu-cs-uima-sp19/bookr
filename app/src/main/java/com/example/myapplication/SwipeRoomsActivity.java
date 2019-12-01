package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class SwipeRoomsActivity extends FragmentActivity {
    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    RoomPagerAdapter mDemoCollectionPagerAdapter;
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        mDemoCollectionPagerAdapter =
                new RoomPagerAdapter(
                        getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);

        Intent intent = getIntent();
        ArrayList<String> filtered_eids = intent.getStringArrayListExtra("filtered_eids");
    }

    public void confirmBooking(View ib) {
        //nothing for now
    }
}