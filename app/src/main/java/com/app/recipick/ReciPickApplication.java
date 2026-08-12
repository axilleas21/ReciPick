package com.app.recipick;

import android.app.Application;
import com.app.recipick.data.AppDatabase;

public class ReciPickApplication extends Application {
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the database once when the app starts
        database = AppDatabase.getInstance(this);
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
