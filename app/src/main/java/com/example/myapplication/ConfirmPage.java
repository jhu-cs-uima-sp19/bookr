package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ConfirmPage extends AppCompatActivity {

    private SharedPreferences myPrefs;
    private int num_selections = 0;
    private String room;
    private String display = "";
    private String display2 = "";
    private int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_page);

        Intent old_intent = getIntent();
        Bundle extras = old_intent.getExtras();
        if (extras != null) {
            room = extras.getString("room_num");
        }

        setTitle(room);

        ArrayList<String> parsedSelections = old_intent.getStringArrayListExtra("selections");
        myPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        count = myPrefs.getInt("total_bookings", 0);

        num_selections = parsedSelections.size();

        for (int k = 0; k < parsedSelections.size(); k++) {
            display = display + "   " + parsedSelections.get(k) + "\n";
            display2 = display2 + room + ": " + "   " + parsedSelections.get(k) + "\n";
            count++;
        }

        TextView toDisplay = findViewById(R.id.selections);
        toDisplay.setText(display);

    }


    public void confirmRooms(View ib) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("invisible", false);

        SharedPreferences.Editor editor = myPrefs.edit();
        String current = myPrefs.getString("active_bookings", "");
        current = current + display2;
        editor.putString("active_bookings", current);
        editor.putInt("total_bookings", count);
        editor.apply();

        startActivity(intent);
    }

    public void cancelRoom(View ib) {
        finish();
    }

    private void setTitle(String input) {
        this.getSupportActionBar().setTitle(input);
    }

}