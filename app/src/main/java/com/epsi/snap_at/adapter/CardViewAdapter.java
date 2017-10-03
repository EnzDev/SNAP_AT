package com.epsi.snap_at.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.R;
import com.epsi.snap_at.holder.CardViewHolder;

import java.util.List;

/**
 * Created by Ptit-Biscuit on 03/10/2017.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewHolder> {
	List<Card> cardList;

	public CardViewAdapter(List<Card> cardList) {
		this.cardList = cardList;
	}

	@Override
	public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
		return new CardViewHolder(view);
	}

	@Override
	public void onBindViewHolder(CardViewHolder holder, int position) {
		Card myObject = cardList.get(position);
		holder.bind(myObject);
	}

	@Override
	public int getItemCount() {
		return 0;
	}
}
