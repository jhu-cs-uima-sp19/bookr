package com.example.myapplication;

import android.content.Context;

import java.io.Serializable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;

@Entity(tableName = BookingDatabase.TABLE_NAME_BOOKING)
public class Rooms implements Serializable{
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



