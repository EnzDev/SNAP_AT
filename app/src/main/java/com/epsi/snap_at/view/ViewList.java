package com.epsi.snap_at.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.Dao;
import com.epsi.snap_at.R;
import com.epsi.snap_at.adapter.CardViewAdapter;

import java.sql.SQLException;
import java.util.List;

public class ViewList extends AppCompatActivity {

	private RecyclerView crv;
	private List<Card> cards;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_main);

		addCards();

		crv = (RecyclerView) findViewById(R.id.recyclerView);
		crv.setLayoutManager(new LinearLayoutManager(this));
		crv.setAdapter(new CardViewAdapter(cards));
	}

	private void addCards() {
		Dao dao = new Dao();

		try {
			cards.addAll(dao.getDatabaseCard(this.getApplicationContext()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
