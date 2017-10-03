package com.epsi.snap_at.holder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.R;

/**
 * Created by Ptit-Biscuit on 03/10/2017.
 */

public class CardViewHolder extends RecyclerView.ViewHolder {
	private TextView titre;
	private TextView itemLabel;
	private TextView dateLast;

	public CardViewHolder(View itemView) {
		super(itemView);

		titre = (TextView) itemView.findViewById(R.id.titre);
		itemLabel = (TextView) itemView.findViewById(R.id.itemLabel);
		dateLast = (TextView) itemView.findViewById(R.id.dateLast);
	}

	public void bind(Card card) {
		titre.setText(card.getTitre());
		itemLabel.setText(card.getItemLabel());
		dateLast.setText(card.getDateLast());
	}
}