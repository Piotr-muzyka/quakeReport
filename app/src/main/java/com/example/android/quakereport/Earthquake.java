package com.example.android.quakereport;

/**
 * Created by PMUZYKA on 2017-05-25.
 */

public class Earthquake {

    private String mLocation;
    private String mDate;
    private String mMagnitude;
    private long mTimeInMilliseconds;

    public Earthquake(String mag, String place, long time){
        mLocation = place;
        mTimeInMilliseconds = time;
        mMagnitude = mag;
    }

    public String getLocation(){
        return mLocation;
    }
    public String getDate(){
        return mDate;
    }
    public String getmMagnitude() {
        return mMagnitude;
    }
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

}
