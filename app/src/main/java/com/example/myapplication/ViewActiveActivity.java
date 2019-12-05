package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActiveActivity extends AppCompatActivity {

    private SharedPreferences myPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_rooms);

        myPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String display = myPrefs.getString("active_bookings", "");

        TextView textView = findViewById(R.id.textView);
        textView.setText(display);
    }
}
