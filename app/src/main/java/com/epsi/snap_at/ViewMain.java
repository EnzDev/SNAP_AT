package com.epsi.snap_at;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class ViewMain extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_main);

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
