package com.example.covid_19.FragmentStatisticsGable;

public class Models {

    String mConrtyflag, mCases, mRecvid, mDeath;

    public Models(String mConrtyflag, String mCases, String mRecvid, String mDeath) {
        this.mConrtyflag = mConrtyflag;
        this.mCases = mCases;
        this.mRecvid = mRecvid;
        this.mDeath = mDeath;
    }

    public String getmConrtyflag() {
        return mConrtyflag;
    }

    public String getmCases() {
        return mCases;
    }

    public String getmRecvid() {
        return mRecvid;
    }

    public String getmDeath() {
        return mDeath;
    }



}
