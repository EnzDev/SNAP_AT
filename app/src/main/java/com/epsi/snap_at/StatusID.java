package com.epsi.snap_at;

/**
 * Created by xoman on 03/10/2017.
 */

public enum StatusID {
    OPEN(0),
    WIN(1),
    LOST(2);

    private int id;

    StatusID(int i) {
        this.id = 1;
    }

    public int getId() {
        return id;
    }
}
