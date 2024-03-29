package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.amitshekhar.DebugDB;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SwipeRoomsActivity extends FragmentActivity {
    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    private RoomPagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RoomViewModel roomViewModel;
    private SharedPreferences myPrefs;
    private ArrayList<String> selections;

    public void onCreate(Bundle savedInstanceState) {
        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        myPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        roomViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);
        roomViewModel.getName().observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(@Nullable ArrayList<String> s) {
                selections = s;
            }
        });

        pagerAdapter = new RoomPagerAdapter(getSupportFragmentManager());
        pagerAdapter.setContext(getApplicationContext());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(pagerAdapter);
        selections = new ArrayList<>();

    }

    public void confirmBooking(View ib) {
        int position = mViewPager.getCurrentItem();
        String room_name = Rooms.eid2room.get(myPrefs.getString("Room_" + position, null));

        Intent intent = new Intent(this, ConfirmPage.class);
        intent.putStringArrayListExtra("selections", selections);
        intent.putExtra("room_num", room_name);

        ArrayList<String> current = new ArrayList<>();
        try {
            current = (ArrayList<String>) ObjectSerializer.deserialize(myPrefs.getString("active_bookings", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if ((selections.size() == 0) || (selections.size() > 4)) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Invalid Request",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (current.size() + selections.size() > 4) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "You've reached the max number of bookings",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            startActivity(intent);
        }
    }
}