package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.amitshekhar.DebugDB;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    BookingDatabase bdatabase;
    DatePickerDialog picker;
    EditText eText;
    private SharedPreferences myPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        // create database
        bdatabase = Room.databaseBuilder(getApplicationContext(), BookingDatabase.class,
                BookingDatabase.DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        class createDatabase extends AsyncTask<Void, Void, Void> // Need to run database inserts in async thread
        {
            @Override
            protected Void doInBackground(Void... arg0) {
                for (int eid = 7909; eid < 7925; eid++) {
                    String string_data = myPrefs.getString(eid + "", "DNE"); // gets data from SharedPreferences
                    JSONArray data = recoverJSON(string_data); // converts back to JSON
                    Rooms room = new Rooms(eid, data); // instantiates Rooms class for database
                    bdatabase.daoAccess().insertRoom(room);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result1) {
                //System.out.println(bdatabase.daoAccess().fetchAllRooms().toString());
            }
        }
        new createDatabase().execute();
        System.out.println(DebugDB.getAddressLog());

        Intent intent = getIntent();
        boolean inactive = intent.getBooleanExtra("invisible", true);
        View top = findViewById(R.id.hasBooked);
        if (inactive) {
            top.setVisibility(View.INVISIBLE);
        }
        //testmethod();
        //filter();
    }

    public void bookRooms(View ib) {
        Intent intent = new Intent(this, SwipeRoomsActivity.class);
        startActivity(intent);
    }

    public void editRooms(View ib) {
        Intent intent = new Intent(this, ChangePage.class);
        startActivity(intent);
    }


    public JSONArray recoverJSON(String input) {
        //Recover JSONArray from string data
        JSONArray data = null;
        if (input != "DNE") {
            try {
                data = new JSONArray(input);
                //System.out.println(data.toString());
            } catch (JSONException e) {
                Log.e("error", "could not recover JSONArray from SharedPref");
            }
        }
        return data;
    }
    public void testmethod() {
        Rooms room = bdatabase.daoAccess().fetchById(7910);
        System.out.println("3:00   " + room.threePMday1);
        System.out.println("3:30   " + room.threeThirtyPMday1);
        System.out.println("5:00   " + room.fivePMday1);
        System.out.println("5:30   " + room.fiveThirtyPMday1);
    }
    public void filter() {
        // Get start time
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        String start_time = mySpinner.getSelectedItem().toString();

        // Get duration
        CheckBox cb1 = (CheckBox) findViewById(R.id.hr5);
        CheckBox cb2 = (CheckBox) findViewById(R.id.hr1);
        CheckBox cb3 = (CheckBox) findViewById(R.id.hr15);
        CheckBox cb4 = (CheckBox) findViewById(R.id.hr2);

        double duration = 0;
        if (cb1.isChecked()) {
            duration = 0.5;
        } else if (cb2.isChecked()) {
            duration = 1;
        } else if (cb3.isChecked()) {
            duration = 1.5;
        } else if (cb4.isChecked()) {
            duration = 2;
        }


        System.out.println(start_time + ":" + duration);


    }
}

