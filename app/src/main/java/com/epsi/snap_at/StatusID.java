package com.epsi.snap_at;

/**
 * Created by xoman on 03/10/2017.
 */

public enum StatusID {
    OPEN,
    WIN,
    LOST;

    private int id;

    StatusID() {
        this.id = ordinal();
    }
}
