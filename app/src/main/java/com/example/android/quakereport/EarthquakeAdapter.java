package com.example.android.quakereport;

/**
 * Created by PiotrM on 24.06.2017.
 */

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    //private static final String LOG_TAG =WordAdapter.class.getSimpleName();
    private int colour;

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> words, int mColour){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0, words);
        colour = mColour;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake currentData = getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView Magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        Double magnitude = currentData.getmMagnitude();
        Double truncatedDouble = BigDecimal.valueOf(magnitude)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();

        String magnitude2 = Double.toString(truncatedDouble);

        Magnitude.setText(magnitude2);


        String primaryLocation1 = formatPrimary(currentData.getLocation());
        String additionalLocation = formatPrimary2(currentData.getLocation());
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView Location = (TextView) listItemView.findViewById(R.id.location1);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        Location.setText(primaryLocation1);

        TextView Location1 = (TextView) listItemView.findViewById(R.id.location);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        Location1.setText(additionalLocation+"of");


        Date dateObject = new Date(currentData.getTimeInMilliseconds());
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

//        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
//        int magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
//        // Get the appropriate background color based on the current earthquake magnitude
//        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

//        // Set the color on the magnitude circle
//        magnitudeCircle.setColor(magnitudeColor);

//        int testColour = ContextCompat.getColor(getContext(), colour);
//        View textView = listItemView.findViewById(R.id.text);
//        textView.setBackgroundColor(testColour);

        return listItemView;
    }


    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatPrimary(String setlocation) {
        String [] primaryLocation = setlocation.split("of");

        return primaryLocation[1];
    }

    private String formatPrimary2(String setlocation) {
        String [] primaryLocation = setlocation.split("of");

        return primaryLocation[0];
    }

//    }
//
//    /**
//     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
//     */
//    private String formatTime(String setlocation) {
//        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
//        return timeFormat.format(dateObject);
//    }

}
