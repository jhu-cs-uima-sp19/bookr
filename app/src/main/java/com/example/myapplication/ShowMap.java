package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ShowMap extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent old_intent = getIntent();
        Bundle extras = old_intent.getExtras();
        String room_num = extras.getString("room_num");
        setMap(room_num);
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
