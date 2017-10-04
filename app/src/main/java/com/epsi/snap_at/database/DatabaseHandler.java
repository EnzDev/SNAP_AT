package com.epsi.snap_at.database;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.Notifier;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by root on 10/4/17.
 */

public class DatabaseHandler {
    private static Dao dao = null;
    private Context context;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mStatusChecker;
    private int UPDATE_INTERVAL = 10000;
    private volatile HashSet<Card> cardBase = new HashSet<>();
    Runnable sync = () -> {
        try {
            if (cardBase.addAll(dao.getDatabaseCard(context))) Notifier.notifydata();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };

    public DatabaseHandler(Context context) {
        this.context = context;
        mStatusChecker = new Runnable() {
            @Override
            public void run() {
                if (dao == null || dao.isClosed())
                    dao = new Dao();

                // Run the passed runnable
                Log.d("Synchronizer", "Beginning sync");
                new Thread(sync).start();

                // Re-run it after the update interval
                mHandler.postDelayed(this, UPDATE_INTERVAL);
            }
        };
    }

    /**
     * Starts the periodical update routine (mStatusChecker
     * adds the callback to the handler).
     */
    public synchronized void startUpdates() {
        new Thread(mStatusChecker).start();
    }

    /**
     * Stops the periodical update routine from running,
     * by removing the callback.
     */
    public synchronized void stopUpdates() {
        mHandler.removeCallbacks(mStatusChecker);
    }

    public HashSet<Card> getBase() {
        return cardBase;
    }

    public synchronized Set<Card> getBaseWithCondition(Predicate<Card> condition) {
        HashSet<Card> t = new HashSet<>();
        t.addAll(cardBase);
        return t.stream().filter(condition).collect(Collectors.toSet());
    }
}
