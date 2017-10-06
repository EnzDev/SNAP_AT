package com.epsi.snap_at.view;

// workshopb3.1718@gmail.com

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.R;
import com.epsi.snap_at.SnapAtApplication;
import com.epsi.snap_at.StatusID;

import java.sql.Date;
import java.util.Calendar;

public class ViewDetail extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getIntent().getBooleanExtra("add", false)) {
			setContentView(R.layout.activity_view_detail_modif);
			findViewById(R.id.card_detail_save).setOnClickListener(this::onSaveClick);
		} else {
			setContentView(R.layout.activity_view_detail);

			Card c = SnapAtApplication.card;

			((TextView) findViewById(R.id.card_detail_title)).setText(c.getTitle());

			switch(c.getStatus()) {
				case OPEN:
					findViewById(R.id.card_detail_status).setBackground(
							getDrawable(R.drawable.card_bubble_open));
					break;
				case WIN:
					findViewById(R.id.card_detail_status).setBackground(
							getDrawable(R.drawable.card_bubble_win));
					break;
				case LOST:
					findViewById(R.id.card_detail_status).setBackground(
							getDrawable(R.drawable.card_bubble_lost));
					break;
			}

			((TextView) findViewById(R.id.card_detail_desc)).setText(c.getDesc());
			((TextView) findViewById(R.id.card_detail_client)).setText(c.getClient());
			((TextView) findViewById(R.id.card_detail_contact)).setText(c.getContactName());
			((TextView) findViewById(R.id.card_detail_date)).setText(c.getDate().getTime().toString());
			((TextView) findViewById(R.id.card_detail_location)).setText(c.getLocation().getProvider());
			((TextView) findViewById(R.id.card_detail_duration)).setText(Float.toString(c.getDuration()));
			//((TextView) findViewById(R.id.card_detail_duration2)).setText(Float.toString(c.getDuration2()));
			((TextView) findViewById(R.id.card_detail_success)).setText(c.getSuccessFactor());
			((TextView) findViewById(R.id.card_detail_consultant)).setText(c.getConsultName());
			((TextView) findViewById(R.id.card_detail_rate)).setText(Float.toString(c.getRate()));
		}
	}

	private void onSaveClick(View view) {
		View vc = ((View) view.getParent().getParent()).findViewById(R.id.card_detail);

		EditText title = (EditText) vc.findViewById(R.id.card_detail_title);
		EditText client = (EditText) vc.findViewById(R.id.card_detail_client);
		EditText consultant = (EditText) vc.findViewById(R.id.card_detail_consultant);
		EditText contact = (EditText) vc.findViewById(R.id.card_detail_contact);
		EditText date = (EditText) vc.findViewById(R.id.card_detail_date);
		EditText desc = (EditText) vc.findViewById(R.id.card_detail_desc);
		EditText duration = (EditText) vc.findViewById(R.id.card_detail_duration);
		EditText location = (EditText) vc.findViewById(R.id.card_detail_location);
		EditText rate = (EditText) vc.findViewById(R.id.card_detail_rate);
		EditText success = (EditText) vc.findViewById(R.id.card_detail_success);

		Card card = new Card(StatusID.OPEN, title.getText().toString(),
				desc.getText().toString(),
				client.getText().toString(),
				contact.getText().toString(),
				Float.parseFloat(rate.getText().toString()),
				success.getText().toString(),
				Float.parseFloat(duration.getText().toString()),
				new Date(Date.parse(date.getText().toString())),
				new Location(location.getText().toString()),
				null, consultant.getText().toString(),
				Calendar.getInstance(), getBaseContext());
		((SnapAtApplication) getApplication()).addNewCard(card);

		setResult(1);
		finish();
	}
}
