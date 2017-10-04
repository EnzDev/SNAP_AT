package com.epsi.snap_at.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.database.Dao;
import com.epsi.snap_at.R;
import com.epsi.snap_at.adapter.CardViewAdapter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewList extends AppCompatActivity {

	private RecyclerView crv;
	private List<Card> cards;
	private CardViewAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_main);

		this.cards = new ArrayList<>();
		this.adapter = new CardViewAdapter(cards);


		addCards();

		crv = (RecyclerView) findViewById(R.id.recyclerView);
		crv.setLayoutManager(new LinearLayoutManager(this));
		crv.setAdapter(adapter);

		System.out.println(adapter.getItemCount());
	}

	private void addCards() {
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... params) {
				Dao dao = new Dao();

				try {
					cards.addAll(dao.getDatabaseCard(ViewList.this.getApplicationContext()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void aVoid) {
				runOnUiThread(() -> adapter.notifyDataSetChanged());
			}
		}.execute();

	}
}
