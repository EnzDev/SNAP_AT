package com.epsi.snap_at.database;

import android.content.Context;
import android.location.Location;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.StatusID;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by root on 10/4/17.
 */

public class Dao {
    public static final String STATUS = "Status";
    public static final String TITLE = "Title";
    public static final String FULL_DESCRIPTION = "FullDescription";
    public static final String CLIENT = "Client";
    public static final String CONTACT_NAME = "ContactName";
    public static final String RATE = "Rate";
    public static final String SUCCESS = "Succes";
    public static final String DURATION = "Duration";
    public static final String START_AT = "StartAt";
    public static final String LOCATION = "Location";
    public static final String CONSULTANTS = "Consultants";
    public static final String DATE = "Created";

    private Connection con;

    public Dao() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://keken.fr:3306/snapat?user=ro_user&password=");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HashSet<Card> getDatabaseCard(Context originContext) throws SQLException {
        ResultSet result = this.con.prepareStatement("SELECT * FROM snappat").executeQuery();
        HashSet<Card> cards = new HashSet<>();
        while (result.next()) {

            Calendar date = Calendar.getInstance();
            date.setTimeInMillis(result.getTimestamp(DATE) != null ? result.getTimestamp(DATE).getTime() : new Date().getTime());

            cards.add(new Card(
                    StatusID.values()[result.getInt(STATUS)],
                    result.getString(TITLE),
                    result.getString(FULL_DESCRIPTION),
                    result.getString(CLIENT),
                    result.getString(CONTACT_NAME),
                    result.getFloat(RATE),
                    result.getString(SUCCESS),
                    result.getInt(DURATION),
                    result.getDate(START_AT),
                    new Location(result.getString(LOCATION)),
                    null,
                    result.getString(CONSULTANTS),
                    date,
                    originContext));
        }
        return cards;
    }

    public boolean isClosed() {
        try {
            return con == null || con.isClosed();
        } catch (SQLException e) {
            return true;
        }
    }
}
