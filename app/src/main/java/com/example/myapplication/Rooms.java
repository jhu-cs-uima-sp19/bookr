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
        boolean[] array = new boolean[]{this.twelveAMday1, this.twelveThirtyAMday1, this.oneAMday1, this.oneThirtyAMday1,
                this.twoAMday1, this.twoThirtyAMday1, this.threeAMday1, this.threeThirtyAMday1,
                this.fourAMday1, this.fourThirtyAMday1, this.fiveAMday1, this.fiveThirtyAMday1,
                this.sixAMday1, this.sixThirtyAMday1, this.sevenAMday1, this.sevenThirtyAMday1,
                this.eightAMday1, this.eightThirtyAMday1, this.nineAMday1, this.nineThirtyAMday1,
                this.tenAMday1, this.tenThirtyAMday1, this.elevenAMday1, this.elevenThirtyAMday1,
                this.twelvePMday1, this.twelveThirtyPMday1, this.onePMday1, this.oneThirtyPMday1,
                this.twoPMday1, this.twoThirtyPMday1, this.threePMday1, this.threeThirtyPMday1,
                this.fourPMday1, this.fourThirtyPMday1, this.fivePMday1, this.fiveThirtyPMday1,
                this.sixPMday1, this.sixThirtyPMday1, this.sevenPMday1, this.sevenThirtyPMday1,
                this.eightPMday1, this.eightThirtyPMday1, this.ninePMday1, this.nineThirtyPMday1,
                this.tenPMday1, this.tenThirtyPMday1, this.elevenPMday1, this.elevenThirtyPMday1,
                this.twelveAMday2, this.twelveThirtyAMday2, this.oneAMday2, this.oneThirtyAMday2,
                this.twoAMday2, this.twoThirtyAMday2, this.threeAMday2, this.threeThirtyAMday2,
                this.fourAMday2, this.fourThirtyAMday2, this.fiveAMday2, this.fiveThirtyAMday2,
                this.sixAMday2, this.sixThirtyAMday2, this.sevenAMday2, this.sevenThirtyAMday2,
                this.eightAMday2, this.eightThirtyAMday2, this.nineAMday2, this.nineThirtyAMday2,
                this.tenAMday2, this.tenThirtyAMday2, this.elevenAMday2, this.elevenThirtyAMday2,
                this.twelvePMday2, this.twelveThirtyPMday2, this.onePMday2, this.oneThirtyPMday2,
                this.twoPMday2, this.twoThirtyPMday2, this.threePMday2, this.threeThirtyPMday2,
                this.fourPMday2, this.fourThirtyPMday2, this.fivePMday2, this.fiveThirtyPMday2,
                this.sixPMday2, this.sixThirtyPMday2, this.sevenPMday2, this.sevenThirtyPMday2,
                this.eightPMday2, this.eightThirtyPMday2, this.ninePMday2, this.nineThirtyPMday2,
                this.tenPMday2, this.tenThirtyPMday2, this.elevenPMday2, this.elevenThirtyPMday2};
        System.arraycopy(makeBoolArray(data), 0, array, 0, TOTALTIMESLOTS);
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
                int startIndex = getIndex(entry, "fromDate");
                int endIndex = getIndex(entry, "toDate");
                for (int i = startIndex; i < endIndex; i++) {
                    time_slots[i] = false;
                }
            }

        }
        return time_slots;
    }

    private int getCurrentIndex() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return getIndex(dateFormat.format(date).substring(0,2),
                dateFormat.format(date).substring(3), false);
    }

    private int getIndex(String hour, String min, boolean isDay2) {
        int index = 2 * Integer.parseInt(hour);
        if (Integer.parseInt(min) >= 30) {
            index++;
        }
        if (isDay2) {
            index += 48;
        }
        return index;
    }

    private int getIndex(JSONObject input, String extra) throws JSONException {
        String hour = input.getString(extra).substring(11,13);
        String min = input.getString(extra).substring(14,16);

        DateFormat dateFormat2 = new SimpleDateFormat("dd");
        Date date = new Date();
        String currentDate = dateFormat2.format(date);
        String start_date = input.getString(extra).substring(8,10);
        return getIndex(hour, min, !(start_date == currentDate));
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





