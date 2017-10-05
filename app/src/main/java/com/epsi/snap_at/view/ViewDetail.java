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

		if (getIntent().getBooleanExtra("add", false)) {
			setContentView(R.layout.activity_view_detail_modif);
			findViewById(R.id.card_detail_save).setOnClickListener(this::onSaveClick);
		} else {
			setContentView(R.layout.activity_view_detail);

		}
	}

	private void onSaveClick(View view) {

	}
}
