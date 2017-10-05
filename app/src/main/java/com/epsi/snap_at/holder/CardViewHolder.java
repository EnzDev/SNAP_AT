package com.epsi.snap_at.holder;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.R;
import com.epsi.snap_at.view.ViewDetail;

import java.text.DateFormat;

/**
 * Created by Ptit-Biscuit on 04/10/2017.
 */

public class CardViewHolder extends RecyclerView.ViewHolder {
	private TextView tvCardTitle;
	private Drawable drawableStatus;
	private TextView date;
	private TextView client;
	private TextView location;

	public CardViewHolder(View itemView) {
		super(itemView);

		tvCardTitle = (TextView) itemView.findViewById(R.id.card_title);
		drawableStatus = itemView.findViewById(R.id.card_status).getBackground();
		date = ((TextView) itemView.findViewById(R.id.card_date));
		client = ((TextView) itemView.findViewById(R.id.card_client));
		location = ((TextView) itemView.findViewById(R.id.card_location));
	}

	public void bind(Card card) {

		tvCardTitle.setText(card.getTitle());

		switch (card.getStatus()) {
			case OPEN:
				drawableStatus = itemView.getResources().getDrawable(R.drawable.card_bubble_open);
				break;
			case WIN:
				drawableStatus = itemView.getResources().getDrawable(R.drawable.card_bubble_win);
				break;
			case LOST:
				drawableStatus = itemView.getResources().getDrawable(R.drawable.card_bubble_lost);
				break;
		}

		itemView.findViewById(R.id.card_status).setBackground(drawableStatus);

		client.setText(card.getClient());

		date.setText(DateFormat
				.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, itemView.getResources().getConfiguration().locale)
				.format(card.getDate().getTime()));

		location.setText(card.getLocation().getProvider());

		Intent it = new Intent(itemView.getContext(), ViewDetail.class);

		itemView.findViewById(R.id.card).setOnClickListener(
				v -> v.getContext().startActivity(it));
	}
}
