package com.epsi.snap_at;

import android.content.Context;
import android.location.Location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/4/17.
 */

public class Dao {
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

    public List<Card> getDatabaseCard(Context originContext) throws SQLException {
        ResultSet result = this.con.prepareStatement("SELECT * FROM snappat").executeQuery();
        List<Card> cards = new ArrayList<>();

        while (result.next()) {
            cards.add(new Card(
                    StatusID.values()[result.getInt("Status")],
                    result.getString("Title"),
                    result.getString("FullDescription"),
                    result.getString("Client"),
                    result.getString("ContactName"),
                    result.getFloat("Rate"),
                    result.getString("Succes"),
                    result.getInt("Duration"),
                    result.getDate("StartAt"),
                    new Location(result.getString("Location")),
                    null,
                    result.getString("Consultant"),
                    originContext));
        }

        return cards;
    }
}
