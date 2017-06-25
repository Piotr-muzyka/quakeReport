/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_list);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();


//        earthquakes.add("London");
//        earthquakes.add("Tokyo");
//        earthquakes.add("Mexico City");
//        earthquakes.add("Moscow");
//        earthquakes.add("Rio de Janeiro");
//        earthquakes.add("Paris");

        // Find a reference to the {@link ListView} in the layout
        EarthquakeAdapter itemsAdapter = new EarthquakeAdapter(this, earthquakes, R.color.colorAccent);
        // Get a reference to the ListView, and attach the adapter to the listView.
        //Layout for the main screen -->
        ListView listView = (ListView) findViewById(R.id.listview_earthquake);
        listView.setAdapter(itemsAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            public void onItemClick(AdapterView<?> parent, View selectedView, int position, long id) {
//
////                Log.d("ON ITEM CLICK...", " ON ITEM CLICK... "+ position + words.get(position).getMusicId());
//                Log.v("NumbersActivity", "Current word: " + earthquakes);
//                // here we are referencing a certain Word Object inside a ListView. We are referencing a method which returns songId
//            }
//        });
    }
}
