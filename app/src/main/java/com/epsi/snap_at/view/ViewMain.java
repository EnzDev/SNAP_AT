package com.epsi.snap_at.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.epsi.snap_at.R;
import com.epsi.snap_at.Status;
import com.epsi.snap_at.StatusID;
import com.epsi.snap_at.adapter.StatusViewAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ViewMain extends AppCompatActivity {

    private RecyclerView rv;
    private List<Status> statuses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_main);

        addCards();

        rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new StatusViewAdapter(statuses));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de main_menu à l'ActionBar
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //gère le click sur une action de l'ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                search();
                return true;
            case R.id.action_add:
                add();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addCards() {
        statuses.add(new Status(0, 0, Calendar.getInstance(), StatusID.OPEN, this));
        statuses.add(new Status(0, 0, Calendar.getInstance(), StatusID.WIN, this));
        statuses.add(new Status(0, 0, Calendar.getInstance(), StatusID.LOST, this));
    }

    private void add() {
        Toast.makeText(this, "ajout d'une fiche client", Toast.LENGTH_SHORT).show();
    }

    private void search() {
        Toast.makeText(this, "recherche", Toast.LENGTH_SHORT).show();
    }
}
