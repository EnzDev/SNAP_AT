package com.epsi.snap_at.view;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.R;
import com.epsi.snap_at.StatusID;

import java.util.Calendar;

public class ViewDetail extends AppCompatActivity {

	private Card card;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_detail);

		//findViewById(R.id.card_detail_save).setOnClickListener(this::onSaveClick);

		if (getIntent().getBooleanExtra("add", false)) {
			Editable.Factory factory = Editable.Factory.getInstance();

			((TextView) findViewById(R.id.card_detail_title)).setEditableFactory(factory);
			((TextView) findViewById(R.id.card_detail_desc)).setEditableFactory(factory);
			((TextView) findViewById(R.id.card_detail_client)).setEditableFactory(factory);
			((TextView) findViewById(R.id.card_detail_contact)).setEditableFactory(factory);
			((TextView) findViewById(R.id.card_detail_date)).setEditableFactory(factory);
			((TextView) findViewById(R.id.card_detail_location)).setEditableFactory(factory);
			((TextView) findViewById(R.id.card_detail_success)).setEditableFactory(factory);
			((TextView) findViewById(R.id.card_detail_rate)).setEditableFactory(factory);
		}
	}

	public void onSaveClick(View v) {
		String title = ((TextView) v.findViewById(R.id.card_detail_title)).getText().toString();
		String desc = ((TextView) v.findViewById(R.id.card_detail_desc)).getText().toString();
		String client = ((TextView) v.findViewById(R.id.card_detail_client)).getText().toString();
		String contact = ((TextView) v.findViewById(R.id.card_detail_contact)).getText().toString();
		String location = ((TextView) v.findViewById(R.id.card_detail_location)).getText().toString();
		String success = ((TextView) v.findViewById(R.id.card_detail_success)).getText().toString();
		float rate = Float.valueOf(((TextView) v.findViewById(R.id.card_detail_rate)).getText().toString());


		card = new Card(
				StatusID.OPEN,
				title,
				desc,
				client,
				contact,
				rate,
				success,
				0f, // duration (float)
				null, // startLatest (Date)
				new Location(location),
				null, //descFile (File)
				"", // consultName (String)
				Calendar.getInstance(),
				this);
	}
}
