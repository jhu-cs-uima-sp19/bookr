package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ConfirmPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_page);

        Intent old_intent = getIntent();
        Bundle extras = old_intent.getExtras();
        String room_num = null;
        if(extras != null) {
            room_num = extras.getString("room_num");
        }

        setTitle(room_num);

        ArrayList<String> parsedSelections = old_intent.getStringArrayListExtra("selections");

        // Build string
        String display = "";

        for (int k = 0; k < parsedSelections.size(); k++) {
            display = display + "   " + parsedSelections.get(k) + "\n";
        }

        TextView toDisplay = findViewById(R.id.selections);
        toDisplay.setText(display);

    }



    public void confirmRooms(View ib) {
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);
    }
    public void cancelRoom(View ib) {
        finish();
    }

    private void setTitle(String input) {
        this.getSupportActionBar().setTitle(input);
    }


    private String parseSelection(String input) {
        switch (input) {
            case "8.0":
                return "8:00 - 8:30";
            case "8.5":
                return "8:30 - 9:00";
            case "9.0":
                return "9:00 - 9:30";
            case "9.5":
                return "9:30 - 10:00";
            case "10.0":
                return "10:00 - 10:30";
            case "10.5":
                return "10:30 - 11:00";
            case "11.0":
                return "11:00 - 11:30";
            case "11.5":
                return "11:30 - 12:00";
            case "12.0":
                return "12:00 - 12:30";
            case "12.5":
                return "12:30 - 1:00";
            case "13.0":
                return "1:00 - 1:30";
            case "13.5":
                return "1:30 - 2:00";
            case "14.0":
                return "2:00 - 2:30";
            case "14.5":
                return "2:30 - 3:00";
            case "15.0":
                return "3:00 - 3:30";
            case "15.5":
                return "3:30 - 4:00";
            case "16.0":
                return "4:00 - 4:30";
            case "16.5":
                return "4:30 - 5:00";
            case "17.0":
                return "5:00 - 5:30";
            case "17.5":
                return "5:30 - 6:00";
        }
        return "error";
    }
}
