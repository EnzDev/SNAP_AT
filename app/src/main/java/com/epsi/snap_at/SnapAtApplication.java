package com.epsi.snap_at;

/**
 * Created by root on 10/4/17.
 */

import android.app.Application;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.epsi.snap_at.database.DatabaseHandler;


public class SnapAtApplication extends Application {
    public static final String PREFS_NAME = "user";
    private DatabaseHandler handler;
    private SharedPreferences setting;

    @Override
    public void onCreate() {
        super.onCreate();

        handler = new DatabaseHandler(this);

        handler.startUpdates();

        setting = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
    }

    public DatabaseHandler getHandler() {
        return handler;
    }

    public SharedPreferences getSetting() {
        return setting;
    }

    @Override
    public void onTerminate() {
        Toast.makeText(this, "Exited", Toast.LENGTH_SHORT).show();
        super.onTerminate();
    }
}
