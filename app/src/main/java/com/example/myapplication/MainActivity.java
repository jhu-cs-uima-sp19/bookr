package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.amitshekhar.DebugDB;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    BookingDatabase bdatabase;
    DatePickerDialog picker;
    EditText eText;
    private SharedPreferences myPrefs;
    BidiMap<Double, String> map1 = new DualHashBidiMap(); // for duration filtering (Nik)


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
        map();
    }

    public void bookRooms(View ib) {
        filter();
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

    public ArrayList<String> filter() {
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



        ArrayList<Set<String>> matched_rooms = new ArrayList<>(); // rooms that match filter
        for (int i = 0; i < duration*2; i++) {
            String time = map1.get(map1.getKey(start_time) + 0.5*i); // uses the bi-directional map
            List<Rooms> toAdd = match(time);
            Set<String> eids_matched = new HashSet<String>();
            for (Rooms room : toAdd) { //extract eid
                eids_matched.add(room.eid + "");
            }
            matched_rooms.add(eids_matched);
        }

        Set<String> running = null;
        if (matched_rooms != null) {
            running = matched_rooms.get(0);
        }

        for (int j = 1; j < matched_rooms.size(); j++) {
            if (matched_rooms.get(j) != null) {
                running.retainAll(matched_rooms.get(j));
            }
        }

        ArrayList<String> eids = new ArrayList<>();
        eids.addAll(running); // THIS IS THE FINAL ARRAYLIST WITH BOTH FILTERS APPLIED!
        System.out.println(eids);

/*      // This just applies the time filter (backup).
        ArrayList<String> eids2 = new ArrayList<>();
        List<Rooms> start_room = match(start_time);
        for (Rooms room : start_room) {
            eids2.add(room.eid + "");
        }*/
        return eids;

    }


    public void map() {
        map1.put(0.0, "00:00 - Today");
        map1.put(0.5, "00:30 - Today");
        map1.put(1.0, "01:00 - Today");
        map1.put(1.5, "01:30 - Today");
        map1.put(2.0, "02:00 - Today");
        map1.put(2.5, "02:30 - Today");
        map1.put(3.0, "03:00 - Today");
        map1.put(3.5, "03:30 - Today");
        map1.put(4.0, "04:00 - Today");
        map1.put(4.5, "04:30 - Today");
        map1.put(5.0, "05:00 - Today");
        map1.put(5.5, "05:30 - Today");
        map1.put(6.0, "06:00 - Today");
        map1.put(6.5, "06:30 - Today");
        map1.put(7.0, "07:00 - Today");
        map1.put(7.5, "07:30 - Today");
        map1.put(8.0, "08:00 - Today");
        map1.put(8.5, "08:30 - Today");
        map1.put(9.0, "09:00 - Today");
        map1.put(9.5, "09:30 - Today");
        map1.put(10.0, "10:00 - Today");
        map1.put(10.5, "10:30 - Today");
        map1.put(11.0, "11:00 - Today");
        map1.put(11.5, "11:30 - Today");
        map1.put(12.0, "12:00 - Today");
        map1.put(12.5, "12:30 - Today");
        map1.put(13.0, "13:00 - Today");
        map1.put(13.5, "13:30 - Today");
        map1.put(14.0, "14:00 - Today");
        map1.put(14.5, "14:30 - Today");
        map1.put(15.0, "15:00 - Today");
        map1.put(15.5, "15:30 - Today");
        map1.put(16.0, "16:00 - Today");
        map1.put(16.5, "16:30 - Today");
        map1.put(17.0, "17:00 - Today");
        map1.put(17.5, "17:30 - Today");
        map1.put(18.0, "18:00 - Today");
        map1.put(18.5, "18:30 - Today");
        map1.put(19.0, "19:00 - Today");
        map1.put(19.5, "19:30 - Today");
        map1.put(20.0, "20:00 - Today");
        map1.put(20.5, "20:30 - Today");
        map1.put(21.0, "21:00 - Today");
        map1.put(21.5, "21:30 - Today");
        map1.put(22.0, "22:00 - Today");
        map1.put(22.5, "22:30 - Today");
        map1.put(23.0, "23:00 - Today");
        map1.put(23.5, "23:30 - Today");
        map1.put(24.0, "00:00 - Tomorrow");
        map1.put(24.5, "00:30 - Tomorrow");
        map1.put(25.0, "01:00 - Tomorrow");
        map1.put(25.5, "01:30 - Tomorrow");
        map1.put(26.0, "02:00 - Tomorrow");
        map1.put(26.5, "02:30 - Tomorrow");
        map1.put(27.0, "03:00 - Tomorrow");
        map1.put(27.5, "03:30 - Tomorrow");
        map1.put(28.0, "04:00 - Tomorrow");
        map1.put(28.5, "04:30 - Tomorrow");
        map1.put(29.0, "05:00 - Tomorrow");
        map1.put(29.5, "05:30 - Tomorrow");
        map1.put(30.0, "06:00 - Tomorrow");
        map1.put(30.5, "06:30 - Tomorrow");
        map1.put(31.0, "07:00 - Tomorrow");
        map1.put(31.5, "07:30 - Tomorrow");
        map1.put(32.0, "08:00 - Tomorrow");
        map1.put(32.5, "08:30 - Tomorrow");
        map1.put(33.0, "09:00 - Tomorrow");
        map1.put(33.5, "09:30 - Tomorrow");
        map1.put(34.0, "10:00 - Tomorrow");
        map1.put(34.5, "10:30 - Tomorrow");
        map1.put(35.0, "11:00 - Tomorrow");
        map1.put(35.5, "11:30 - Tomorrow");
        map1.put(36.0, "12:00 - Tomorrow");
        map1.put(36.5, "12:30 - Tomorrow");
        map1.put(37.0, "13:00 - Tomorrow");
        map1.put(37.5, "13:30 - Tomorrow");
        map1.put(38.0, "14:00 - Tomorrow");
        map1.put(38.5, "14:30 - Tomorrow");
        map1.put(39.0, "15:00 - Tomorrow");
        map1.put(39.5, "15:30 - Tomorrow");
        map1.put(40.0, "16:00 - Tomorrow");
        map1.put(40.5, "16:30 - Tomorrow");
        map1.put(41.0, "17:00 - Tomorrow");
        map1.put(41.5, "17:30 - Tomorrow");
        map1.put(42.0, "18:00 - Tomorrow");
        map1.put(42.5, "18:30 - Tomorrow");
        map1.put(43.0, "19:00 - Tomorrow");
        map1.put(43.5, "19:30 - Tomorrow");
        map1.put(44.0, "20:00 - Tomorrow");
        map1.put(44.5, "20:30 - Tomorrow");
        map1.put(45.0, "21:00 - Tomorrow");
        map1.put(45.5, "21:30 - Tomorrow");
        map1.put(46.0, "22:00 - Tomorrow");
        map1.put(46.5, "22:30 - Tomorrow");
        map1.put(47.0, "23:00 - Tomorrow");
        map1.put(47.5, "23:30 - Tomorrow");
    }
    public List<Rooms> match(String input) {
        List<Rooms> rooms = null;
        switch(input) {
            case "00:00 - Today":
                rooms = bdatabase.daoAccess().fetchByTwelveAMday1(true);
                break;
            case "00:30 - Today":
                rooms = bdatabase.daoAccess().fetchByTwelveThirtyAMday1(true);
                break;
            case "01:00 - Today":
                rooms = bdatabase.daoAccess().fetchByoneAMday1(true);
                break;
            case "01:30 - Today":
                rooms = bdatabase.daoAccess().fetchByoneThirtyAMday1(true);
                break;
            case "02:00 - Today":
                rooms = bdatabase.daoAccess().fetchBytwoAMday1(true);
                break;
            case "02:30 - Today":
                rooms = bdatabase.daoAccess().fetchBytwoThirtyAMday1(true);
                break;
            case "03:00 - Today":
                rooms = bdatabase.daoAccess().fetchBythreeAMday1(true);
                break;
            case "03:30 - Today":
                rooms = bdatabase.daoAccess().fetchBythreeThirtyAMday1(true);
                break;
            case "04:00 - Today":
                rooms = bdatabase.daoAccess().fetchByfourAMday1(true);
                break;
            case "04:30 - Today":
                rooms = bdatabase.daoAccess().fetchByfourThirtyAMday1(true);
                break;
            case "05:00 - Today":
                rooms = bdatabase.daoAccess().fetchByfiveAMday1(true);
                break;
            case "05:30 - Today":
                rooms = bdatabase.daoAccess().fetchByfiveThirtyAMday1(true);
                break;
            case "06:00 - Today":
                rooms = bdatabase.daoAccess().fetchBysixAMday1(true);
                break;
            case "06:30 - Today":
                rooms = bdatabase.daoAccess().fetchBysixThirtyAMday1(true);
                break;
            case "07:00 - Today":
                rooms = bdatabase.daoAccess().fetchBysevenAMday1(true);
                break;
            case "07:30 - Today":
                rooms = bdatabase.daoAccess().fetchBysevenThirtyAMday1(true);
                break;
            case "08:00 - Today":
                rooms = bdatabase.daoAccess().fetchByeightAMday1(true);
                break;
            case "08:30 - Today":
                rooms = bdatabase.daoAccess().fetchByeightThirtyAMday1(true);
                break;
            case "09:00 - Today":
                rooms = bdatabase.daoAccess().fetchBynineAMday1(true);
                break;
            case "09:30 - Today":
                rooms = bdatabase.daoAccess().fetchBynineThirtyAMday1(true);
                break;
            case "10:00 - Today":
                rooms = bdatabase.daoAccess().fetchBytenAMday1(true);
                break;
            case "10:30 - Today":
                rooms = bdatabase.daoAccess().fetchBytenThirtyAMday1(true);
                break;
            case "11:00 - Today":
                rooms = bdatabase.daoAccess().fetchByelevenAMday1(true);
                break;
            case "11:30 - Today":
                rooms = bdatabase.daoAccess().fetchByelevenThirtyAMday1(true);
                break;
            case "12:00 - Today":
                rooms = bdatabase.daoAccess().fetchByTwelvePMday1(true);
                break;
            case "12:30 - Today":
                rooms = bdatabase.daoAccess().fetchByTwelveThirtyPMday1(true);
                break;
            case "13:00 - Today":
                rooms = bdatabase.daoAccess().fetchByonePMday1(true);
                break;
            case "13:30 - Today":
                rooms = bdatabase.daoAccess().fetchByoneThirtyPMday1(true);
                break;
            case "14:00 - Today":
                rooms = bdatabase.daoAccess().fetchBytwoPMday1(true);
                break;
            case "14:30 - Today":
                rooms = bdatabase.daoAccess().fetchBytwoThirtyPMday1(true);
                break;
            case "15:00 - Today":
                rooms = bdatabase.daoAccess().fetchBythreePMday1(true);
                break;
            case "15:30 - Today":
                rooms = bdatabase.daoAccess().fetchBythreeThirtyPMday1(true);
                break;
            case "16:00 - Today":
                rooms = bdatabase.daoAccess().fetchByfourPMday1(true);
                break;
            case "16:30 - Today":
                rooms = bdatabase.daoAccess().fetchByfourThirtyPMday1(true);
                break;
            case "17:00 - Today":
                rooms = bdatabase.daoAccess().fetchByfivePMday1(true);
                break;
            case "17:30 - Today":
                rooms = bdatabase.daoAccess().fetchByfiveThirtyPMday1(true);
                break;
            case "18:00 - Today":
                rooms = bdatabase.daoAccess().fetchBysixPMday1(true);
                break;
            case "18:30 - Today":
                rooms = bdatabase.daoAccess().fetchBysixThirtyPMday1(true);
                break;
            case "19:00 - Today":
                rooms = bdatabase.daoAccess().fetchBysevenPMday1(true);
                break;
            case "19:30 - Today":
                rooms = bdatabase.daoAccess().fetchBysevenThirtyPMday1(true);
                break;
            case "20:00 - Today":
                rooms = bdatabase.daoAccess().fetchByeightPMday1(true);
                break;
            case "20:30 - Today":
                rooms = bdatabase.daoAccess().fetchByeightThirtyPMday1(true);
                break;
            case "21:00 - Today":
                rooms = bdatabase.daoAccess().fetchByninePMday1(true);
                break;
            case "21:30 - Today":
                rooms = bdatabase.daoAccess().fetchBynineThirtyPMday1(true);
                break;
            case "22:00 - Today":
                rooms = bdatabase.daoAccess().fetchBytenPMday1(true);
                break;
            case "22:30 - Today":
                rooms = bdatabase.daoAccess().fetchBytenThirtyPMday1(true);
                break;
            case "23:00 - Today":
                rooms = bdatabase.daoAccess().fetchByelevenPMday1(true);
                break;
            case "23:30 - Today":
                rooms = bdatabase.daoAccess().fetchByelevenThirtyPMday1(true);
                break;
            case "00:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByTwelveAMday2(true);
                break;
            case "00:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByTwelveThirtyAMday2(true);
                break;
            case "01:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByoneAMday2(true);
                break;
            case "01:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByoneThirtyAMday2(true);
                break;
            case "02:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBytwoAMday2(true);
                break;
            case "02:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBytwoThirtyAMday2(true);
                break;
            case "03:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBythreeAMday2(true);
                break;
            case "03:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBythreeThirtyAMday2(true);
                break;
            case "04:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByfourAMday2(true);
                break;
            case "04:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByfourThirtyAMday2(true);
                break;
            case "05:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByfiveAMday2(true);
                break;
            case "05:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByfiveThirtyAMday2(true);
                break;
            case "06:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBysixAMday2(true);
                break;
            case "06:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBysixThirtyAMday2(true);
                break;
            case "07:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBysevenAMday2(true);
                break;
            case "07:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBysevenThirtyAMday2(true);
                break;
            case "08:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByeightAMday2(true);
                break;
            case "08:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByeightThirtyAMday2(true);
                break;
            case "09:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBynineAMday2(true);
                break;
            case "09:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBynineThirtyAMday2(true);
                break;
            case "10:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBytenAMday2(true);
                break;
            case "10:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBytenThirtyAMday2(true);
                break;
            case "11:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByelevenAMday2(true);
                break;
            case "11:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByelevenThirtyAMday2(true);
                break;
            case "12:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByTwelvePMday2(true);
                break;
            case "12:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByTwelveThirtyPMday2(true);
                break;
            case "13:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByonePMday2(true);
                break;
            case "13:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByoneThirtyPMday2(true);
                break;
            case "14:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBytwoPMday2(true);
                break;
            case "14:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBytwoThirtyPMday2(true);
                break;
            case "15:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBythreePMday2(true);
                break;
            case "15:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBythreeThirtyPMday2(true);
                break;
            case "16:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByfourPMday2(true);
                break;
            case "16:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByfourThirtyPMday2(true);
                break;
            case "17:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByfivePMday2(true);
                break;
            case "17:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByfiveThirtyPMday2(true);
                break;
            case "18:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBysixPMday2(true);
                break;
            case "18:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBysixThirtyPMday2(true);
                break;
            case "19:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBysevenPMday2(true);
                break;
            case "19:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBysevenThirtyPMday2(true);
                break;
            case "20:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByeightPMday2(true);
                break;
            case "20:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByeightThirtyPMday2(true);
                break;
            case "21:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByninePMday2(true);
                break;
            case "21:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBynineThirtyPMday2(true);
                break;
            case "22:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBytenPMday2(true);
                break;
            case "22:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchBytenThirtyPMday2(true);
                break;
            case "23:00 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByelevenPMday2(true);
                break;
            case "23:30 - Tomorrow":
                rooms = bdatabase.daoAccess().fetchByelevenThirtyPMday2(true);
                break;
            default:
                
        }
        return rooms;
    }
}

