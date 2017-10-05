package com.epsi.snap_at.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.Notifier;
import com.epsi.snap_at.R;
import com.epsi.snap_at.SnapAtApplication;
import com.epsi.snap_at.Status;
import com.epsi.snap_at.StatusID;
import com.epsi.snap_at.adapter.StatusViewAdapter;
import com.epsi.snap_at.database.DatabaseHandler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;


public class ViewMain extends AppCompatActivity {

    private RecyclerView rv;
    private List<Status> statuses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_main);
        StatusViewAdapter statusadapter = new StatusViewAdapter(statuses);
        addStatuses(statusadapter);

        rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(statusadapter);
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

    private void addStatuses(StatusViewAdapter statusadapter) {
        Set<Card> openNumber = ((SnapAtApplication) getApplication()).getHandler().getBaseWithCondition(
                (c) -> c.getStatus() == StatusID.OPEN
        );
        Set<Card> winNumber = ((SnapAtApplication) getApplication()).getHandler().getBaseWithCondition(
                (c) -> c.getStatus() == StatusID.WIN
        );
        Set<Card> lostNumber = ((SnapAtApplication) getApplication()).getHandler().getBaseWithCondition(
                (c) -> c.getStatus() == StatusID.LOST
        );

        statuses.add(new Status(openNumber.size(),
                (int) openNumber.stream().filter(
                        c -> c.getContactName().equals(((SnapAtApplication) getApplication()).getSetting().getString("user", ""))
                ).count(),
                openNumber.stream().reduce(BinaryOperator.maxBy((a, b) -> a.getDate().compareTo(b.getDate()))).map(Card::getDate).orElse(Calendar.getInstance()), StatusID.OPEN, this));
        statuses.add(new Status(winNumber.size(),
                (int) winNumber.stream().filter(
                        c -> c.getContactName().equals(((SnapAtApplication) getApplication()).getSetting().getString("user", ""))
                ).count(),
                winNumber.stream().reduce(BinaryOperator.maxBy((a, b) -> a.getDate().compareTo(b.getDate()))).map(Card::getDate).orElse(Calendar.getInstance()), StatusID.WIN, this));
        statuses.add(new Status(lostNumber.size(),
                (int) lostNumber.stream().filter(
                        c -> c.getContactName().equals(((SnapAtApplication) getApplication()).getSetting().getString("user", ""))
                ).count(),
                lostNumber.stream().reduce(BinaryOperator.maxBy((a, b) -> a.getDate().compareTo(b.getDate()))).map(Card::getDate).orElse(Calendar.getInstance()), StatusID.LOST, this));


        Notifier.todos.add(() -> {
            Set<Card> openNumberR = ((SnapAtApplication) getApplication()).getHandler().getBaseWithCondition(
                    (c) -> c.getStatus() == StatusID.OPEN
            );
            Set<Card> winNumberR = ((SnapAtApplication) getApplication()).getHandler().getBaseWithCondition(
                    (c) -> c.getStatus() == StatusID.WIN
            );
            Set<Card> lostNumberR = ((SnapAtApplication) getApplication()).getHandler().getBaseWithCondition(
                    (c) -> c.getStatus() == StatusID.LOST
            );
            statuses.clear();
            statuses.add(new Status(openNumberR.size(),
                    (int) openNumberR.stream().filter(
                            c -> c.getContactName().equals(((SnapAtApplication) getApplication()).getSetting().getString("user", ""))
                    ).count(),
                    openNumberR.stream().reduce(BinaryOperator.maxBy((a, b) -> a.getDate().compareTo(b.getDate()))).map(Card::getDate).orElse(Calendar.getInstance()), StatusID.OPEN, this));
            statuses.add(new Status(winNumberR.size(),
                    (int) winNumberR.stream().filter(
                            c -> c.getContactName().equals(((SnapAtApplication) getApplication()).getSetting().getString("user", ""))
                    ).count(),
                    winNumberR.stream().reduce(BinaryOperator.maxBy((a, b) -> a.getDate().compareTo(b.getDate()))).map(Card::getDate).orElse(Calendar.getInstance()), StatusID.WIN, this));
            statuses.add(new Status(lostNumberR.size(),
                    (int) lostNumberR.stream().filter(
                            c -> c.getContactName().equals(((SnapAtApplication) getApplication()).getSetting().getString("user", ""))
                    ).count(),
                    lostNumberR.stream().reduce(BinaryOperator.maxBy((a, b) -> a.getDate().compareTo(b.getDate()))).map(Card::getDate).orElse(Calendar.getInstance()), StatusID.LOST, this));
            runOnUiThread(statusadapter::notifyDataSetChanged);
        });
    }

    private void add() {}

    private void search() {
        Toast.makeText(this, "recherche", Toast.LENGTH_SHORT).show();
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 42) {
			if(resultCode == Activity.RESULT_OK){
				String result = data.getStringExtra("result");
			}
			if (resultCode == Activity.RESULT_CANCELED) {
				//Write your code if there's no result
			}
		}
	}
}
