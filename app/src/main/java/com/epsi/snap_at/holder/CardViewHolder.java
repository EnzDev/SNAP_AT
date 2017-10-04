package com.epsi.snap_at.holder;

import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.R;
import com.epsi.snap_at.StatusID;

import java.text.DateFormat;

/**
 * Created by Ptit-Biscuit on 04/10/2017.
 */

public class CardViewHolder extends RecyclerView.ViewHolder {
	private TextView tvCardTitle;
	private StatusID statusID;
	private DateFormat date;
	private Location location;

	public CardViewHolder(View itemView) {
		super(itemView);

		tvCardTitle = (TextView) itemView.findViewById(R.id.);
		statusID = (StatusID) itemView.findViewById(R.id.);
		date = () itemView.findViewById(R.id.);
		location = () itemView.findViewById(R.id.);
	}

	public void bind(Card card) {

	}
}
