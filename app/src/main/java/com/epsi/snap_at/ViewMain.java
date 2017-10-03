package com.epsi.snap_at;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import drawable.Card;

public class ViewMain extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_main);

		Card cvOpen = new Card();
		cvOpen.newInstance();
		CardView cvOpenCard = ((CardView) cvOpen.getActivity().findViewById(R.id.cardView));
		cvOpenCard.setRadius(4f);
		cvOpenCard.setCardBackgroundColor(getResources().getColor(R.color.blue));
		((TextView) cvOpen.getActivity().findViewById(R.id.titre)).setText(R.string.openLabel);

		Card cvWin = new Card();
		cvWin.newInstance();
		CardView cvWinCard = ((CardView) cvWin.getActivity().findViewById(R.id.cardView));
		cvWinCard.setRadius(4f);
		cvWinCard.setCardBackgroundColor(getResources().getColor(R.color.green));
		((TextView) cvWin.getActivity().findViewById(R.id.titre)).setText(R.string.winLabel);

		Card cvLost = new Card();
		cvLost.newInstance();
		CardView cvLostCard = ((CardView) cvLost.getActivity().findViewById(R.id.cardView));
		cvLostCard.setRadius(4f);
		cvLostCard.setCardBackgroundColor(getResources().getColor(R.color.red));
		((TextView) cvLost.getActivity().findViewById(R.id.titre)).setText(R.string.lostLabel);
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
		switch (item.getItemId()){
			case R.id.action_search:
				search();
				return true;
			case R.id.action_add:
				add();
				return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private void add() {
		Toast.makeText(this, "ajout d'une fiche client", Toast.LENGTH_SHORT).show();
	}

	private void search() {
		Toast.makeText(this, "recherche", Toast.LENGTH_SHORT).show();
	}
}
