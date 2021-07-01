package com.connect.svecw;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import co.uk.rushorm.android.AndroidInitializeConfig;
import co.uk.rushorm.core.Rush;
import co.uk.rushorm.core.RushCore;



public class Event extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        List<Class<? extends Rush>> rushClasses = new ArrayList<>();
        rushClasses.add(EventHelper.class);
        AndroidInitializeConfig config=new AndroidInitializeConfig(getApplicationContext(),rushClasses);
        RushCore.initialize(config);
    }
}
