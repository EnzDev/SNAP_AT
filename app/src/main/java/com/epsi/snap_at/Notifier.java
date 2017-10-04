package com.epsi.snap_at;

import java.util.ArrayList;

/**
 * Created by root on 10/4/17.
 */

public class Notifier {
    public static ArrayList<Runnable> todos = new ArrayList<>();

    public static void notifydata() {
        todos.forEach((t) -> new Thread(t).start());
    }
}
