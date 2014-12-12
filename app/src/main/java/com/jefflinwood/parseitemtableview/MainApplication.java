package com.jefflinwood.parseitemtableview;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by jlinwood on 12/12/14.
 */
public class MainApplication extends Application {
    public void onCreate() {
        Parse.initialize(this, "YYYYYYYYYYY", "ZZZZZZZZZ");

        ParseObject item1 = new ParseObject("Item");
        item1.put("name","Item 1");
        item1.saveInBackground();

        ParseObject item2 = new ParseObject("Item");
        item2.put("name","Item 2");
        item2.saveInBackground();

        ParseObject item3 = new ParseObject("Item");
        item3.put("name","Item 3");
        item3.saveInBackground();

        ParseObject item4 = new ParseObject("Item");
        item4.put("name","Item 4");
        item4.saveInBackground();
    }
}
