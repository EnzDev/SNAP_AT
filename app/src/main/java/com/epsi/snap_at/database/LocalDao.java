package com.epsi.snap_at.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import android.provider.BaseColumns;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.StatusID;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by root on 10/4/17.
 */

public class LocalDao extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (\n" +
                    // FeedEntry.DATE + " date NOT NULL,\n" +
                    FeedEntry.CLIENT + " text NOT NULL,\n" +
                    FeedEntry.CONTACT_NAME + " text NOT NULL,\n" +
                    FeedEntry.TITLE + " text NOT NULL,\n" +
                    FeedEntry.FULL_DESCRIPTION + " text NOT NULL,\n" +
                    FeedEntry.SUCCESS + " text NOT NULL,\n" +
                    FeedEntry.START_AT + " date NOT NULL,\n" +
                    FeedEntry.DURATION + " text NOT NULL,\n" +
                    FeedEntry.LOCATION + " text NOT NULL,\n" +
                    FeedEntry.RATE + " text NOT NULL,\n" +
                    FeedEntry.FILE_DESC + " text NOT NULL,\n" +
                    FeedEntry.CONSULTANTS + " text NOT NULL,\n" +
                    FeedEntry.STATUS + " int(11) NOT NULL,\n" +
                    FeedEntry.DATE_CREATED + " timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY\n" +
                    ")";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "localsave.db";

    public LocalDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        System.out.println(context.getDatabasePath(DATABASE_NAME).getAbsolutePath());
    }

    public HashSet<Card> getDatabaseCard(Context originContext) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor result = db.rawQuery("SELECT * FROM " + FeedEntry.TABLE_NAME, new String[]{});
        HashSet<Card> cards = new HashSet<>();
        while (result.moveToNext()) {

            Calendar date = Calendar.getInstance();
//            date.setTimeInMillis(result.getString(result.getColumnIndex(FeedEntry.DATE_CREATED)) != null ? Long.parseLong(result.getString(result.getColumnIndex(FeedEntry.DATE_CREATED))) : new Date().getTime());

            cards.add(new Card(
                    StatusID.values()[result.getInt(result.getColumnIndex(FeedEntry.STATUS))],
                    result.getString(result.getColumnIndex(FeedEntry.TITLE)),
                    result.getString(result.getColumnIndex(FeedEntry.FULL_DESCRIPTION)),
                    result.getString(result.getColumnIndex(FeedEntry.CLIENT)),
                    result.getString(result.getColumnIndex(FeedEntry.CONTACT_NAME)),
                    result.getFloat(result.getColumnIndex(FeedEntry.RATE)),
                    result.getString(result.getColumnIndex(FeedEntry.SUCCESS)),
                    result.getInt(result.getColumnIndex(FeedEntry.DURATION)),
                    new Date(result.getLong(result.getColumnIndex(FeedEntry.START_AT))),
                    new Location(result.getString(result.getColumnIndex(FeedEntry.LOCATION))),
                    null,
                    result.getString(result.getColumnIndex(FeedEntry.CONSULTANTS)),
                    date,
                    originContext));
        }

        result.close();
        return cards;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void addCard(Card c, SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        // values.put(FeedEntry.DATE, c.);
        values.put(FeedEntry.CLIENT, c.getClient());
        values.put(FeedEntry.CONTACT_NAME, c.getContactName());
        values.put(FeedEntry.TITLE, c.getTitle());
        values.put(FeedEntry.FULL_DESCRIPTION, c.getDesc());
        values.put(FeedEntry.SUCCESS, c.getSuccessFactor());
        values.put(FeedEntry.START_AT, String.valueOf(c.getStartLatest()));
        values.put(FeedEntry.DURATION, c.getDuration());
        values.put(FeedEntry.LOCATION, c.getLocation().getProvider());
        values.put(FeedEntry.RATE, c.getRate());
        values.put(FeedEntry.FILE_DESC, "");
        values.put(FeedEntry.CONSULTANTS, c.getConsultName());
        values.put(FeedEntry.STATUS, c.getStatus().ordinal());
        values.put(FeedEntry.DATE_CREATED, String.valueOf(c.getDate()));


        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
    }

    public void update(HashSet<Card> l) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES);
        l.forEach((c) -> addCard(c, db));
    }

    private static class FeedEntry implements BaseColumns {
        static final String TABLE_NAME = "snappat";

        static final String DATE = "Date";
        static final String CLIENT = "Client";
        static final String CONTACT_NAME = "ContactName";
        static final String TITLE = "Title";
        static final String FULL_DESCRIPTION = "FullDescription";
        static final String SUCCESS = "Succes";
        static final String START_AT = "StartAt";
        static final String DURATION = "Duration";
        static final String LOCATION = "Location";
        static final String RATE = "Rate";
        static final String FILE_DESC = "DescriptionFile";
        static final String CONSULTANTS = "Consultants";
        static final String STATUS = "Status";
        static final String DATE_CREATED = "Created";
    }

}
