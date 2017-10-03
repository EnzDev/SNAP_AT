package com.epsi.snap_at.holder;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.R;

import java.text.DateFormat;

/**
 * Created by Ptit-Biscuit on 03/10/2017.
 */

public class CardViewHolder extends RecyclerView.ViewHolder {
    private TextView tvTitle;


    private TextView tvGlobalItemNumber;
    private TextView tvSelfItemNumber;
    private TextView tvDateLast;

    public CardViewHolder(View itemView) {
        super(itemView);

        tvTitle = (TextView) itemView.findViewById(R.id.card_title);
        tvGlobalItemNumber = (TextView) itemView.findViewById(R.id.card_totalnumber);
        tvSelfItemNumber = (TextView) itemView.findViewById(R.id.card_creatednumber);
        tvDateLast = (TextView) itemView.findViewById(R.id.card_datelast);
    }

    public void bind(Card card) {
        ((CardView) itemView.findViewById(R.id.card)).setCardBackgroundColor(card.getColor());
        tvTitle.setText(card.getTitle());
        tvGlobalItemNumber.setText(card.getGlobalItemNumber() + " " + tvGlobalItemNumber.getResources().getString(R.string.global));
        tvSelfItemNumber.setText(card.getSelfItemNumber() + " " + tvGlobalItemNumber.getResources().getString(R.string.created));
        tvDateLast.setText(
                DateFormat
                        .getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, tvDateLast.getResources().getConfiguration().locale)
                        .format(card.getDateLast().getTime()));

        itemView.findViewById(R.id.card).setOnClickListener(v -> Toast.makeText(v.getContext(), card.getTitle(), Toast.LENGTH_SHORT).show());
    }
}
