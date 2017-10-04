package com.epsi.snap_at.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epsi.snap_at.R;

public class ViewList extends AppCompatActivity {

	private RecyclerView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_list);

		lv = (RecyclerView) findViewById(R.id.recyclerView);
		lv.setLayoutManager(new LinearLayoutManager(this));
		lv.setAdapter(null);
	}
}
