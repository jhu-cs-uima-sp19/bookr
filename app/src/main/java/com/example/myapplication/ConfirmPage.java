package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConfirmPage extends AppCompatActivity {

    private SharedPreferences myPrefs;
    private String room;
    private int num_selections;
    private String display = "";
    private String display2 = "";
    private int count;
    private ArrayList<String> parsedSelections;


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
        setMap(room);

        parsedSelections = old_intent.getStringArrayListExtra("selections");
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
        ArrayList<String> current = new ArrayList<>();
        try {
            current = (ArrayList<String>) ObjectSerializer.deserialize(myPrefs.getString("active_bookings", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < parsedSelections.size(); i++) {
            String temp = parsedSelections.get(i);
            parsedSelections.set(i, room + ": " + temp);
        }

        parsedSelections.addAll(current);
        try {
            editor.putString("active_bookings", ObjectSerializer.serialize(parsedSelections));
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.apply();

        startActivity(intent);
    }

    public void cancelRoom(View ib) {
        finish();
    }

    private void setTitle(String input) {
        this.getSupportActionBar().setTitle(input);
    }

    private void setMap(String room_num) {
        ImageView map = findViewById(R.id.room_image);
        switch (room_num) {
            case "BLC 1030": map.setImageResource(R.drawable.blc1030); break;
            case "BLC 1031": map.setImageResource(R.drawable.blc1031); break;
            case "BLC 2003": map.setImageResource(R.drawable.blc2003); break;
            case "BLC 2005": map.setImageResource(R.drawable.blc2005); break;
            case "BLC 2006": map.setImageResource(R.drawable.blc2006); break;
            case "BLC 2007": map.setImageResource(R.drawable.blc2007); break;
            case "BLC 2010": map.setImageResource(R.drawable.blc2010); break;
            case "BLC 3010": map.setImageResource(R.drawable.blc3010); break;
            case "BLC 4031": map.setImageResource(R.drawable.blc4031); break;
            case "BLC 4043": map.setImageResource(R.drawable.blc4043); break;
            case "BLC 4045": map.setImageResource(R.drawable.blc4045); break;
            case "BLC 4047": map.setImageResource(R.drawable.blc4047); break;
            case "BLC 4049": map.setImageResource(R.drawable.blc4049); break;
            case "BLC 4051": map.setImageResource(R.drawable.blc4051); break;
            case "BLC 4053": map.setImageResource(R.drawable.blc4053); break;
            case "BLC 5010": map.setImageResource(R.drawable.blc5010); break;
            default: break;
        }
    }


}