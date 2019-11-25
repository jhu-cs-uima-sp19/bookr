package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Pair;

import java.io.Serializable;
import java.util.HashMap;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;

import org.json.JSONArray;
import org.json.JSONException;

@Entity(tableName = BookingDatabase.TABLE_NAME_BOOKING)
public class Rooms implements Serializable{
    private static final HashMap<String, String> eid2room = new HashMap<String, String>() {{
        put("7909", "BLC 1030");
        put("7910", "BLC 1031");
        put("7911", "BLC 2003");
        put("7912", "BLC 2005");
        put("7913", "BLC 2006");
        put("7914", "BLC 2007");
        put("7915", "BLC 2010");
        put("7916", "BLC 3010");
        put("7917", "BLC 4031");
        put("7918", "BLC 4043");
        put("7919", "BLC 4045");
        put("7920", "BLC 4047");
        put("7921", "BLC 4049");
        put("7922", "BLC 4051");
        put("7923", "BLC 4053");
        put("7924", "BLC 5010");
    }};

    public Rooms() {

    }

    public Rooms(int eid, JSONArray data) {
        this.eid = eid;
        instantiate(data);
    }

    public void instantiate(JSONArray data) {
        this.name = eid2room.get(eid);
        Pair[] bookings = new Pair[data.length()]; // remove unnecessary details from JSONArray
        try {
            bookings = condense(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        boolean[] boolArray = makeBoolArray(bookings); // convert reduced data to boolean array
    }

    public boolean[] makeBoolArray(Pair[] input) {
        boolean[] grid = new boolean[96];
        return grid;
    }

    public Pair[] condense(JSONArray input) throws JSONException {
        Pair[] bookings = new Pair[input.length()];
        for (int i = 0; i < input.length(); i++) {
            bookings[i] = new Pair(input.getJSONObject(i).getString("toDate"),input.getJSONObject(i).getString("toDate"));
        }
        return bookings;
    }

    @PrimaryKey(autoGenerate = true)
    public int eid;

    // descriptions we don't need to change later on
    public String name;

    public String description;

    // filter by category or capacity
    public String category;

    public int capacity;

    // filter by time slots here
    public boolean twelveAMday1;

    public boolean twelveThirtyAMday1;

    public boolean oneAMday1;

    public boolean oneThirtyAMday1;

    public boolean twoAMday1;

    public boolean twoThirtyAMday1;

    public boolean threeAMday1;

    public boolean threeThirtyAMday1;

    public boolean fourAMday1;

    public boolean fourThirtyAMday1;

    public boolean fiveAMday1;

    public boolean fiveThirtyAMday1;

    public boolean sixAMday1;

    public boolean sixThirtyAMday1;

    public boolean sevenAMday1;

    public boolean sevenThirtyAMday1;

    public boolean eightAMday1;

    public boolean eightThirtyAMday1;

    public boolean nineAMday1;

    public boolean nineThirtyAMday1;

    public boolean tenAMday1;

    public boolean tenThirtyAMday1;

    public boolean elevenAMday1;

    public boolean elevenThirtyAMday1;

    //pms here
    public boolean twelvePMday1;

    public boolean twelveThirtyPMday1;

    public boolean onePMday1;

    public boolean oneThirtyPMday1;

    public boolean twoPMday1;

    public boolean twoThirtyPMday1;

    public boolean threePMday1;

    public boolean threeThirtyPMday1;

    public boolean fourPMday1;

    public boolean fourThirtyPMday1;

    public boolean fivePMday1;

    public boolean fiveThirtyPMday1;

    public boolean sixPMday1;

    public boolean sixThirtyPMday1;

    public boolean sevenPMday1;

    public boolean sevenThirtyPMday1;

    public boolean eightPMday1;

    public boolean eightThirtyPMday1;

    public boolean ninePMday1;

    public boolean nineThirtyPMday1;

    public boolean tenPMday1;

    public boolean tenThirtyPMday1;

    public boolean elevenPMday1;

    public boolean elevenThirtyPMday1;

    public boolean twelveAMday2;

    public boolean twelveThirtyAMday2;

    public boolean oneAMday2;

    public boolean oneThirtyAMday2;

    public boolean twoAMday2;

    public boolean twoThirtyAMday2;

    public boolean threeAMday2;

    public boolean threeThirtyAMday2;

    public boolean fourAMday2;

    public boolean fourThirtyAMday2;

    public boolean fiveAMday2;

    public boolean fiveThirtyAMday2;

    public boolean sixAMday2;

    public boolean sixThirtyAMday2;

    public boolean sevenAMday2;

    public boolean sevenThirtyAMday2;

    public boolean eightAMday2;

    public boolean eightThirtyAMday2;

    public boolean nineAMday2;

    public boolean nineThirtyAMday2;

    public boolean tenAMday2;

    public boolean tenThirtyAMday2;

    public boolean elevenAMday2;

    public boolean elevenThirtyAMday2;

    //pms here
    public boolean twelvePMday2;

    public boolean twelveThirtyPMday2;

    public boolean onePMday2;

    public boolean oneThirtyPMday2;

    public boolean twoPMday2;

    public boolean twoThirtyPMday2;

    public boolean threePMday2;

    public boolean threeThirtyPMday2;

    public boolean fourPMday2;

    public boolean fourThirtyPMday2;

    public boolean fivePMday2;

    public boolean fiveThirtyPMday2;

    public boolean sixPMday2;

    public boolean sixThirtyPMday2;

    public boolean sevenPMday2;

    public boolean sevenThirtyPMday2;

    public boolean eightPMday2;

    public boolean eightThirtyPMday2;

    public boolean ninePMday2;

    public boolean nineThirtyPMday2;

    public boolean tenPMday2;

    public boolean tenThirtyPMday2;

    public boolean elevenPMday2;

    public boolean elevenThirtyPMday2;

}





