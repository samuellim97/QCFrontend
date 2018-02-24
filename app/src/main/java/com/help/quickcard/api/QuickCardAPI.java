package com.help.quickcard.api;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.concurrent.Callable;

/**
 * QuickCardAPI is responsible for making remote
 * Web API calls, to the server.
 *
 * Created by shath ibrahim on 18/01/18.
 * A Simple implementation for the quickcard API
 */

public class QuickCardAPI extends WebAPI{
    private String TAG = "QuickCardAPI";

    public QuickCardAPI(RequestQueue queue) {
        super(queue);
    }

    public void login(String name, String password, Callable onSuccess){

    }

    public void addCard(String data, Callable onSuccess){

    }

    public void pollReady(){
        JsonObjectRequest req = new JsonObjectRequest(
                Request.Method.GET,
                "http://"+getUrl()+":"+getPort()+"/",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //logv response
                        Log.i(TAG, "onResponse: Response received: " + response);
                    }
                }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: error occurred: " + error);
            }
        }
        );
        queue.add(req);
    }

    public void isLoggedIn(){

    }
}
