package com.example.antinolabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewUserInfo;
    private LinearLayoutManager linearLayoutManager;

    String url, userName, userAge, userImage, userLocation;
    Context context;

    UserListData userListData;

    private ArrayList<UserListData> userList;

    private RecyclerView.Adapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = new ArrayList<UserListData>();

        context = getApplicationContext();

        recyclerViewUserInfo =(RecyclerView) findViewById(R.id.recyclerViewUserInfo);

        linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
        recyclerViewUserInfo.setLayoutManager(linearLayoutManager);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        url = "http://demo8716682.mockable.io/cardData";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Log.i("fff",response.toString());

                for (int i = 0; i < response.length(); i++){

                    try {

                        JSONObject obj1 = response.getJSONObject(i);
                        userName = obj1.getString("name");
                        userAge = obj1.getString("age");
                        userImage = obj1.getString("url");
                        userLocation = obj1.getString("location");

                        userListData = new UserListData(userName, userAge, userImage, userLocation);
                        userList.add(userListData);
                        userAdapter = new UserAdapter(context, userList, MainActivity.this);
                        recyclerViewUserInfo.setAdapter(userAdapter);
                        userAdapter.notifyDataSetChanged();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
