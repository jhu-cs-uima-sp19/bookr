package com.example.myapplication;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = BookingDatabase.TABLE_NAME_BOOKING)
public class Rooms implements Serializable{
    private static final int TOTALTIMESLOTS = 96;
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
        this.name = eid2room.get("" + eid);
        //no description, category, or capacity for now

        try {
            instantiate(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void instantiate(JSONArray data) throws JSONException {
        boolean[] array = makeBoolArray(data);

        int count = 0;
        this.twelveAMday1 = array[count]; this.twelveThirtyAMday1 = array[++count];
        this.oneAMday1 = array[++count]; this.oneThirtyAMday1 = array[++count];
        this.twoAMday1 = array[++count]; this.twoThirtyAMday1 = array[++count];
        this.threeAMday1 = array[++count]; this.threeThirtyAMday1 = array[++count];
        this.fourAMday1 = array[++count]; this.fourThirtyAMday1 = array[++count];
        this.fiveAMday1 = array[++count]; this.fiveThirtyAMday1 = array[++count];
        this.sixAMday1 = array[++count]; this.sixThirtyAMday1 = array[++count];
        this.sevenAMday1 = array[++count]; this.sevenThirtyAMday1 = array[++count];
        this.eightAMday1 = array[++count]; this.eightThirtyAMday1 = array[++count];
        this.nineAMday1 = array[++count]; this.nineThirtyAMday1 = array[++count];
        this.tenAMday1 = array[++count]; this.tenThirtyAMday1 = array[++count];
        this.elevenAMday1 = array[++count]; this.elevenThirtyAMday1 = array[++count];
        this.twelvePMday1 = array[++count]; this.twelveThirtyPMday1 = array[++count];
        this.onePMday1 = array[++count]; this.oneThirtyPMday1 = array[++count];
        this.twoPMday1 = array[++count]; this.twoThirtyPMday1 = array[++count];
        this.threePMday1 = array[++count]; this.threeThirtyPMday1 = array[++count];
        this.fourPMday1 = array[++count]; this.fourThirtyPMday1 = array[++count];
        this.fivePMday1 = array[++count]; this.fiveThirtyPMday1 = array[++count];
        this.sixPMday1 = array[++count]; this.sixThirtyPMday1 = array[++count];
        this.sevenPMday1 = array[++count]; this.sevenThirtyPMday1 = array[++count];
        this.eightPMday1 = array[++count]; this.eightThirtyPMday1 = array[++count];
        this.ninePMday1 = array[++count]; this.nineThirtyPMday1 = array[++count];
        this.tenPMday1 = array[++count]; this.tenThirtyPMday1 = array[++count];
        this.elevenPMday1 = array[++count]; this.elevenThirtyPMday1 = array[++count];
        this.twelveAMday2 = array[++count]; this.twelveThirtyAMday2 = array[++count];
        this.oneAMday2 = array[++count]; this.oneThirtyAMday2 = array[++count];
        this.twoAMday2 = array[++count]; this.twoThirtyAMday2 = array[++count];
        this.threeAMday2 = array[++count]; this.threeThirtyAMday2 = array[++count];
        this.fourAMday2 = array[++count]; this.fourThirtyAMday2 = array[++count];
        this.fiveAMday2 = array[++count]; this.fiveThirtyAMday2 = array[++count];
        this.sixAMday2 = array[++count]; this.sixThirtyAMday2 = array[++count];
        this.sevenAMday2 = array[++count]; this.sevenThirtyAMday2 = array[++count];
        this.eightAMday2 = array[++count]; this.eightThirtyAMday2 = array[++count];
        this.nineAMday2 = array[++count]; this.nineThirtyAMday2 = array[++count];
        this.tenAMday2 = array[++count]; this.tenThirtyAMday2 = array[++count];
        this.elevenAMday2 = array[++count]; this.elevenThirtyAMday2 = array[++count];
        this.twelvePMday2 = array[++count]; this.twelveThirtyPMday2 = array[++count];
        this.onePMday2 = array[++count]; this.oneThirtyPMday2 = array[++count];
        this.twoPMday2 = array[++count]; this.twoThirtyPMday2 = array[++count];
        this.threePMday2 = array[++count]; this.threeThirtyPMday2 = array[++count];
        this.fourPMday2 = array[++count]; this.fourThirtyPMday2 = array[++count];
        this.fivePMday2 = array[++count]; this.fiveThirtyPMday2 = array[++count];
        this.sixPMday2 = array[++count]; this.sixThirtyPMday2 = array[++count];
        this.sevenPMday2 = array[++count]; this.sevenThirtyPMday2 = array[++count];
        this.eightPMday2 = array[++count]; this.eightThirtyPMday2 = array[++count];
        this.ninePMday2 = array[++count]; this.nineThirtyPMday2 = array[++count];
        this.tenPMday2 = array[++count]; this.tenThirtyPMday2 = array[++count];
        this.elevenPMday2 = array[++count]; this.elevenThirtyPMday2 = array[++count];
    }

    private boolean[] makeBoolArray(JSONArray data) throws JSONException {
        boolean[] time_slots = new boolean[TOTALTIMESLOTS];
        int index = getCurrentIndex();

        for (int i = index; i < time_slots.length; i++) {
            time_slots[i] = true;
        }

        for (int j = 0; j < data.length(); j++) {
            JSONObject entry = data.getJSONObject(j);
            if (entry.getString("status").equals("Confirmed")) {
                int startIndex = getIndex(entry, "fromDate", false);
                int endIndex = getIndex(entry, "toDate", true);
                for (int i = startIndex; i <= endIndex; i++) {
                    time_slots[i] = false;
                }
            }

        }


        return time_slots;

    }

    private int getCurrentIndex() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        int currentIndex = getIndex(dateFormat.format(date).substring(0,2),
                dateFormat.format(date).substring(3), false, false);
        return currentIndex;
    }

    private int getIndex(String hour, String min, boolean isDay2, boolean isEndIndex) {
        int index = 2 * Integer.parseInt(hour);
        if (isEndIndex) {
            index--;
        }
        if (Integer.parseInt(min) >= 30) {
            index++;
        }
        if (isDay2) {
            index += 48;
        }

        return index;
    }

    private int getIndex(JSONObject input, String extra, boolean isEndIndex) throws JSONException {
        String hour = input.getString(extra).substring(11,13);
        String min = input.getString(extra).substring(14,16);
        DateFormat dateFormat2 = new SimpleDateFormat("dd");
        Date date = new Date();
        String currentDate = dateFormat2.format(date);
        String start_date = input.getString(extra).substring(8,10);
        return getIndex(hour, min, (start_date == currentDate), isEndIndex);
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





