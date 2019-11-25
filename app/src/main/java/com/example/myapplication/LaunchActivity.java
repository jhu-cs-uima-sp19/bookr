package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class LaunchActivity extends AppCompatActivity {

    private SharedPreferences myPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        getSupportActionBar().hide();

        Context context = getApplicationContext(); // app level storage
        myPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        getDatafromAPI();

    }

    public void goToFilters(View view) {
        Intent intent = new Intent(this, MainActivity.class); //RoomsActivity.class);
        startActivity(intent);
    }

    public void getDatafromAPI() {
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
                        editor.putString("Response", response.toString());
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
}
