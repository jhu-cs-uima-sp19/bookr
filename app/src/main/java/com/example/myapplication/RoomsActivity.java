package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Minutes;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RoomsActivity extends AppCompatActivity {
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
    private HashMap<String, boolean[]> eid2time = new HashMap<>();
    private boolean[] time_slots = new boolean[TOTALTIMESLOTS];
    private int lowerBound = 16; // current active window - to be expanded in sprint 2
    private int upperBound = 35;
    private int previousSelection = -1;
    private ImageButton[] buttons;
    private int curr = 7914; // populated with real data
    private ArrayList<String> selections = new ArrayList<>();
    private HashMap<Integer, Double> idMap = new HashMap<>();
    private SharedPreferences myPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        myPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get data back from shared preferences
        String string_data = myPrefs.getString("Response", "DNE");

        //Recover JSONArray from string data
        JSONArray data = null;
        if (string_data != "DNE") {
            try {
                data = new JSONArray(string_data);
                //System.out.println(data.toString());
            } catch (JSONException e) {
                Log.e("error", "could not recover JSONArray from SharedPref");
            }
        }

        // map of "eid" to corresponding bookings (arraylist of pairs of start time/end time)
        HashMap<String, ArrayList<ArrayList<String>>> info;
        info = makeMap(data);

        // convert booking info to boolean array (for each eid)
        HashMap<String, boolean[]> availabilities = new HashMap<>();
        for (HashMap.Entry<String, ArrayList<ArrayList<String>>> entry : info.entrySet()) {
            boolean[] time_slots2 = roomAvailability(info, entry.getKey());
            availabilities.put(entry.getKey(), time_slots2);
        }

        // master contains real data from API
        boolean[] master = availabilities.get(curr + "");

        // fake data to demonstrate swipe functionality
        createCopies(master);

        // Make id to room name map
        makeIdMap();

        // Set action bar title
        setTitle(eid2room.get(curr + ""));
        reColorButtons(Arrays.copyOfRange(master, lowerBound, upperBound + 1));

        // Add swipe listeners
        findViewById(R.id.background).setOnTouchListener(new OnSwipeTouchListener(RoomsActivity.this) {

            public void onSwipeRight() {
                if ((curr - 1 >= 7909) && (curr - 1 <= 7924)) {
                    setTitle(eid2room.get(--curr + ""));
                    overridePendingTransition(R.anim.swipe_right, R.anim.swipe_left);
                    reColorButtons(Arrays.copyOfRange(eid2time.get(curr + ""), lowerBound, upperBound + 1));
                }
            }
            public void onSwipeLeft() {
                if ((curr + 1 >= 7909) && (curr + 1 <= 7924)) {
                    setTitle(eid2room.get(++curr + ""));
                    overridePendingTransition(R.anim.swipe_left, R.anim.swipe_right);
                    reColorButtons(Arrays.copyOfRange(eid2time.get(curr + ""), lowerBound, upperBound + 1));
                }
            }

        });
    }

    public void createCopies(boolean[] master) {
        boolean[] cp7909 = new boolean[TOTALTIMESLOTS];
        cp7909[16] = true;
        cp7909[18] = true;
        cp7909[25] = true;
        cp7909[26] = true;
        boolean[] cp7910 = new boolean[TOTALTIMESLOTS];
        cp7910[17] = true;
        boolean[] cp7911 = new boolean[TOTALTIMESLOTS];
        cp7911[23] = true;
        cp7911[24] = true;
        cp7911[25] = true;
        boolean[] cp7912 = new boolean[TOTALTIMESLOTS];
        cp7912[19] = true;
        cp7912[27] = true;
        boolean[] cp7913 = new boolean[TOTALTIMESLOTS];
        cp7913[20] = true;
        boolean[] cp7914 = new boolean[TOTALTIMESLOTS];
        cp7914[21] = true;
        cp7914[24] = true;
        cp7914[25] = true;
        cp7914[27] = true;
        cp7914[29] = true;

        boolean[] cp7916 = new boolean[TOTALTIMESLOTS];
        cp7916[31] = true;
        boolean[] cp7917 = new boolean[TOTALTIMESLOTS];
        cp7917[23] = true;
        cp7917[31] = true;
        cp7917[16] = true;
        boolean[] cp7918 = new boolean[TOTALTIMESLOTS];
        cp7918[24] = true;
        boolean[] cp7919 = new boolean[TOTALTIMESLOTS];
        cp7919[25] = true;
        boolean[] cp7920 = new boolean[TOTALTIMESLOTS];
        cp7920[26] = true;
        boolean[] cp7921 = new boolean[TOTALTIMESLOTS];
        cp7921[27] = true;
        boolean[] cp7922 = new boolean[TOTALTIMESLOTS];
        cp7922[28] = true;
        boolean[] cp7923 = new boolean[TOTALTIMESLOTS];
        cp7923[29] = true;
        boolean[] cp7924 = new boolean[TOTALTIMESLOTS];
        cp7924[30] = true;

        eid2time.put("7915", master);
        eid2time.put("7909", cp7909);
        eid2time.put("7910", cp7910);
        eid2time.put("7911", cp7911);
        eid2time.put("7912", cp7912);
        eid2time.put("7913", cp7913);
        eid2time.put("7914", cp7914);
        eid2time.put("7916", cp7916);
        eid2time.put("7917", cp7917);
        eid2time.put("7918", cp7918);
        eid2time.put("7919", cp7919);
        eid2time.put("7920", cp7920);
        eid2time.put("7921", cp7921);
        eid2time.put("7922", cp7922);
        eid2time.put("7923", cp7923);
        eid2time.put("7924", cp7924);
    }

    public void makeIdMap() {
        HashMap<Integer, Double> map = new HashMap<>();
        ImageButton[] buttons = new ImageButton[]{findViewById(R.id.eightaml), findViewById(R.id.eightamr),
                findViewById(R.id.nineaml), findViewById(R.id.nineamr),
                findViewById(R.id.tenaml), findViewById(R.id.tenamr),
                findViewById(R.id.elevenaml), findViewById(R.id.elevenamr),
                findViewById(R.id.twelvepml), findViewById(R.id.twelvepmr),
                findViewById(R.id.onepml), findViewById(R.id.onepmr),
                findViewById(R.id.twopml), findViewById(R.id.twopmr),
                findViewById(R.id.threepml), findViewById(R.id.threepmr),
                findViewById(R.id.fourpml), findViewById(R.id.fourpmr),
                findViewById(R.id.fivepml), findViewById(R.id.fivepmr)
        };

        double start = 8;
        for (int i = 0; i < buttons.length; i++) {
            idMap.put(buttons[i].getId(), start);
            start = start + 0.5;
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    
    public void confirmBooking(View ib) {
        buttons = new ImageButton[]{findViewById(R.id.eightaml), findViewById(R.id.eightamr),
                findViewById(R.id.nineaml), findViewById(R.id.nineamr),
                findViewById(R.id.tenaml), findViewById(R.id.tenamr),
                findViewById(R.id.elevenaml), findViewById(R.id.elevenamr),
                findViewById(R.id.twelvepml), findViewById(R.id.twelvepmr),
                findViewById(R.id.onepml), findViewById(R.id.onepmr),
                findViewById(R.id.twopml), findViewById(R.id.twopmr),
                findViewById(R.id.threepml), findViewById(R.id.threepmr),
                findViewById(R.id.fourpml), findViewById(R.id.fourpmr),
                findViewById(R.id.fivepml), findViewById(R.id.fivepmr)
        };

        selections.clear();
        // find the blue ones!
        for (ImageButton button : buttons) {
            if (button.getTag().equals(R.color.blue)) {
                selections.add(idMap.get(button.getId()) + "");
            }
        }

        Intent intent = new Intent(this, ConfirmPage.class);
        intent.putStringArrayListExtra("selections", selections);
        intent.putExtra("room_num", getSupportActionBar().getTitle());

        if ((selections.size() == 0) || (selections.size() > 4)) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Invalid Request",
                    Toast.LENGTH_SHORT);
            toast.show();
        } else {
            startActivity(intent);
        }
    }

    private void setTitle(String input) {
        this.getSupportActionBar().setTitle(input);
    }

    public void getRoomData(int eid) {
        String url = "https://jhu.libcal.com/1.1/oauth/token";
        String url2 = "https://jhu.libcal.com/1.1/space/bookings";

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest accessTokenRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                String access_token = response.substring(17, 57);
                JsonArrayRequest dataRequest = new JsonArrayRequest(Request.Method.GET, url2,
                        null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        SharedPreferences.Editor editor = myPrefs.edit();
                        editor.putString(eid + "", response.toString());
                        editor.apply();
                        System.out.println(myPrefs.getAll().toString());

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("failed", error.toString());
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("eid", eid + "");
                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Authorization", "Bearer " + access_token);
                        return params;
                    }
                };
                queue.add(dataRequest);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("test", "error");
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("grant_type", "client_credentials");
                params.put("client_id", "471");
                params.put("client_secret", "c642b905a3c947952dd49285625ee369");
                return params;
            }
        };

        queue.add(accessTokenRequest);

    }


    private HashMap<String, ArrayList<ArrayList<String>>> makeMap(JSONArray data) {
        HashMap<String, ArrayList<ArrayList<String>>> info = new HashMap<>();
        for (int i = 0; i < data.length(); i++) {
            try {
                String eid = data.getJSONObject(i).getString("eid");

                String startTime = data.getJSONObject(i).getString("fromDate");
                String endTime = data.getJSONObject(i).getString("toDate");
                ArrayList<String> times = new ArrayList<>();
                times.add(startTime);
                times.add(endTime);

                if (!info.containsKey(eid)) {
                    ArrayList<ArrayList<String>> current = new ArrayList<>();
                    current.add(times);
                    info.put(eid, current);
                } else {
                    ArrayList<ArrayList<String>> current = info.get(eid);
                    current.add(times);
                    info.put(eid,current);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return info;
    }

    private boolean[] roomAvailability(HashMap<String, ArrayList<ArrayList<String>>> info, String room_number) {

        // For one specific room
        boolean[] time_slots = new boolean[96];
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        DateFormat dateFormat2 = new SimpleDateFormat("dd");
        Date date = new Date();
        int index = 2 * Integer.parseInt(dateFormat.format(date).substring(0,2));
        if (Integer.parseInt(dateFormat.format(date).substring(3)) >= 30) {
            index++;
        }

        for (int i = index; i < time_slots.length; i++) {
            time_slots[i] = true;
        }

        ArrayList<ArrayList<String>> room_bookings = info.get(room_number);
        String currentDate = dateFormat2.format(date);
        for (int j = 0; j < room_bookings.size(); j++) {
            String start_date = room_bookings.get(j).get(0).substring(8,10);
            String end_date = room_bookings.get(j).get(1).substring(8,10);

            int startIndex = 2 * Integer.parseInt(room_bookings.get(j).get(0).substring(11,13));
            if (Integer.parseInt(room_bookings.get(j).get(0).substring(14,16)) >= 30) {
                startIndex++;
            }
            if (start_date != currentDate) {
                startIndex += 48;
            }

            int endIndex = 2 * Integer.parseInt(room_bookings.get(j).get(1).substring(11,13));
            if (Integer.parseInt(room_bookings.get(j).get(1).substring(14,16)) >= 30) {
                endIndex++;
            }
            if (end_date != currentDate) {
                endIndex += 48;
            }

            if (endIndex - startIndex > 4) {
                System.err.println("" + room_number);
            } else if (endIndex - startIndex < 0) {
                System.err.println("" + room_number);
            }
            for (int l = startIndex; l <= endIndex; l++) {
                time_slots[l] = false;
            }
        }
        return time_slots;
    }

    private void reColorButtons(boolean[] input) {
        buttons = new ImageButton[]{findViewById(R.id.eightaml), findViewById(R.id.eightamr),
                findViewById(R.id.nineaml), findViewById(R.id.nineamr),
                findViewById(R.id.tenaml), findViewById(R.id.tenamr),
                findViewById(R.id.elevenaml), findViewById(R.id.elevenamr),
                findViewById(R.id.twelvepml), findViewById(R.id.twelvepmr),
                findViewById(R.id.onepml), findViewById(R.id.onepmr),
                findViewById(R.id.twopml), findViewById(R.id.twopmr),
                findViewById(R.id.threepml), findViewById(R.id.threepmr),
                findViewById(R.id.fourpml), findViewById(R.id.fourpmr),
                findViewById(R.id.fivepml), findViewById(R.id.fivepmr)
        };
        // initialize time slots from api

        for (int i = 0; i < input.length; i++) {
            // Set color and OnClick for corresponding buttons
            //if (i >= lowerBound && i <= upperBound && input[i]) {
            if (input[i]) {
                ImageButton button = buttons[i];
                button.setImageResource(R.color.lightGreen);
                button.setTag(R.color.lightGreen);

                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v)
                    {
                        ImageButton button = findViewById(v.getId());
                        if (button.getTag().equals(R.color.blue)) {
                            button.setImageResource(R.color.lightGreen);
                            button.setTag(R.color.lightGreen);
                        }
                        else {
                            button.setImageResource(R.color.blue);
                            button.setTag(R.color.blue);
                        }
                    }
                });
            }
            //else if (i >= lowerBound && i <= upperBound) {
            else {
                ImageButton button = buttons[i];
                // Check if its before current time or not
                DateTime dt = new DateTime();
                DateTime back_date = new DateTime("2019-11-11T08:00:00.000");
                Duration duration = new Duration(back_date, dt);
                int cur_index = Minutes.minutesBetween(back_date, dt).getMinutes()/30;

                if (i > cur_index) {
                    button.setImageResource(R.color.darkRed);
                    button.setTag(R.color.darkRed);
                    button.setOnClickListener(null);
                } else {
                    button.setImageResource(R.color.inactive);
                    button.setTag(R.color.inactive);
                    button.setOnClickListener(null);
                }
            }
        }

    }
}
