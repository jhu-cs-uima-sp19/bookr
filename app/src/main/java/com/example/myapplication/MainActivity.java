package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

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
import java.util.Map;

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
                BookingDatabase.DB_NAME).fallbackToDestructiveMigration().build();
        createDatabase();

        Intent intent = getIntent();
        boolean inactive = intent.getBooleanExtra("invisible", true);
        View top = findViewById(R.id.hasBooked);
        if (inactive) {
            top.setVisibility(View.INVISIBLE);
        }


        TextView tvw =(TextView)findViewById(R.id.timer);
        eText = (EditText) findViewById(R.id.editText2);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                                eText.setGravity(Gravity.CENTER_VERTICAL);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
//        btnGet=(Button)findViewById(R.id.button1);
//        btnGet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvw.setText("Selected Date: "+ eText.getText());
//            }
//        });
    }

    public void bookRooms(View ib) {
        Intent intent = new Intent(this, SwipeRoomsActivity.class);
        startActivity(intent);
    }

    public void editRooms(View ib) {
        Intent intent = new Intent(this, ChangePage.class);
        startActivity(intent);
    }

    public void createDatabase() {
        for (int eid= 7909; eid < 7925; eid++) {
            getRoomData(eid); //adds data to SharedPreferences
            String string_data = myPrefs.getString(eid + "", "DNE"); // gets data from SharedPreferences
            JSONArray data = recoverJSON(string_data); // converts back to JSON
            Rooms room = new Rooms(eid, data); // instantiates Rooms class for database
            bdatabase.daoAccess().insertRoom(room);
        }
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
}

