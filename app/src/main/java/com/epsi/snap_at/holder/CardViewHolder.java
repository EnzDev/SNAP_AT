package com.epsi.snap_at.holder;

import android.graphics.drawable.Drawable;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.R;

import java.util.Calendar;

/**
 * Created by Ptit-Biscuit on 04/10/2017.
 */

public class CardViewHolder extends RecyclerView.ViewHolder {
	private TextView tvCardTitle;
	private Drawable statusID;
	private Calendar date;
	private Location location;

	public CardViewHolder(View itemView) {
		super(itemView);

		tvCardTitle = (TextView) itemView.findViewById(R.id.card_title);
		statusID = ((View) itemView.findViewById(R.id.card_status)).getBackground();
		date = ((TextView) itemView.findViewById(R.id.card_date)).getText().toString();
		location = new Location(((TextView) itemView.findViewById(R.id.card_location)).getText().toString());
	}

	public void bind(Card card) {

		tvCardTitle.setText(card.getTitle());

		switch (card.getStatus()) {
			case OPEN:
				statusID = itemView.getResources().getDrawable(R.drawable.card_bubble_open);
				break;
			case WIN:
				statusID = itemView.getResources().getDrawable(R.drawable.card_bubble_win);
				break;
			case LOST:
				statusID = itemView.getResources().getDrawable(R.drawable.card_bubble_lost);
				break;
		}

		date = card.getDate();
	}
}
