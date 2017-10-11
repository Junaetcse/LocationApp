package com.bangladesh.user.locationapp;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText name, fname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        fname = (EditText) findViewById(R.id.fname);


    }

    public void save(View view){

        String url = "http://techborno.com/locations/insert.php";
        StringRequest sq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            protected Map<String, String > getParams(){
                Map<String, String> parr = new HashMap<String, String>();

                parr.put("textnames", name.getText().toString());
                parr.put("fathername", fname.getText().toString());

                return parr;

            }

        };
        AppController.getInstance().addToRequestQueue(sq);
        Toast.makeText(getApplicationContext(), "Vua news published Successfully!", Toast.LENGTH_LONG).show();

    }



    }

