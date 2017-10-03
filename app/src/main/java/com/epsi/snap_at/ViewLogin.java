package com.epsi.snap_at;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ViewLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_view_login);

		// Remember that you should never show the action bar if the
		// status bar is hidden, so hide that too if necessary.
	    getSupportActionBar().hide();
    }

	public void checkMail(View v) {
		startActivity(new Intent(this, ViewMain.class));
	}
}
