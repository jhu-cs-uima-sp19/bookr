package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChangePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_page);
    }

    public void cancelRooms(View ib) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("invisible", true);
        startActivity(intent);
    }
}
