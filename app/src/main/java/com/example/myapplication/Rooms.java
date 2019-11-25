package com.example.myapplication;

import android.content.Context;

import java.io.Serializable;
import java.util.HashMap;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;

import org.json.JSONArray;

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

    public Rooms(int eid, JSONArray data) {
        this.eid = eid;
        this.name = eid2room.get(eid);
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
    public boolean twelveAM;

    public boolean twelveThirtyAM;

    public boolean oneAM;

    public boolean oneThirtyAM;

    public boolean twoAM;

    public boolean twoThirtyAM;

    public boolean threeAM;

    public boolean threeThirtyAM;

    public boolean fourAM;

    public boolean fourThirtyAM;

    public boolean fiveAM;

    public boolean fiveThirtyAM;

    public boolean sixAM;

    public boolean sixThirtyAM;

    public boolean sevenAM;

    public boolean sevenThirtyAM;

    public boolean eightAM;

    public boolean eightThirtyAM;

    public boolean nineAM;

    public boolean nineThirtyAM;

    public boolean tenAM;

    public boolean tenThirtyAM;

    public boolean elevenAM;

    public boolean elevenThirtyAM;

    //pms here
    public boolean twelvePM;

    public boolean twelveThirtyPM;

    public boolean onePM;

    public boolean oneThirtyPM;

    public boolean twoPM;

    public boolean twoThirtyPM;

    public boolean threePM;

    public boolean threeThirtyPM;

    public boolean fourPM;

    public boolean fourThirtyPM;

    public boolean fivePM;

    public boolean fiveThirtyPM;

    public boolean sixPM;

    public boolean sixThirtyPM;

    public boolean sevenPM;

    public boolean sevenThirtyPM;

    public boolean eightPM;

    public boolean eightThirtyPM;

    public boolean ninePM;

    public boolean nineThirtyPM;

    public boolean tenPM;

    public boolean tenThirtyPM;

    public boolean elevenPM;

    public boolean elevenThirtyPM;

}



