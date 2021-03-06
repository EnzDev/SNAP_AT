package com.epsi.snap_at.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.epsi.snap_at.R;
import com.epsi.snap_at.SnapAtApplication;

public class ViewLogin extends AppCompatActivity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_view_login);

		// Remember that you should never show the action bar if the
		// status bar is hidden, so hide that too if necessary.
	    getSupportActionBar().hide();

		SharedPreferences settings = ((SnapAtApplication) getApplication()).getSetting();
		if (!settings.getBoolean("isRegistered", false))
			settings.edit().putBoolean("isRegistered", false).apply();
		else {
			startActivity(new Intent(this, ViewMain.class));
			finish();
		}

		EditText et = (EditText) findViewById(R.id.basemail);
		et.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				et.setHint(s.toString().equals("")
						? getResources().getString(R.string.emailplaceholder)
						: "");

				et.setTextColor(getResources().getColor((s.toString() + "@gfi.fr").matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")
						? R.color.light
						: R.color.red));
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		findViewById(R.id.savemailButton).setOnClickListener(this::saveMail);
    }

	public void saveMail(View v) {
		SharedPreferences settings = ((SnapAtApplication) getApplication()).getSetting();

		EditText input = ((EditText) ((View) v.getParent()).findViewById(R.id.basemail));

		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean("isRegistered", true)
				.putString("user", input.getText().toString())
				.apply();

		startActivity(new Intent(this, ViewMain.class));
		finish();
	}
}
