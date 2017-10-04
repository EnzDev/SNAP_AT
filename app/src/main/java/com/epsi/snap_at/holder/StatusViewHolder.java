package com.epsi.snap_at.holder;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epsi.snap_at.R;
import com.epsi.snap_at.Status;
import com.epsi.snap_at.view.ViewList;

import java.text.DateFormat;

/**
 * Created by Ptit-Biscuit on 03/10/2017.
 */

public class StatusViewHolder extends RecyclerView.ViewHolder {
    private TextView tvTitle;
    private TextView tvGlobalItemNumber;
    private TextView tvSelfItemNumber;
    private TextView tvDateLast;

    public StatusViewHolder(View itemView) {
        super(itemView);

        tvTitle = (TextView) itemView.findViewById(R.id.status_title);
        tvGlobalItemNumber = (TextView) itemView.findViewById(R.id.status_totalnumber);
        tvSelfItemNumber = (TextView) itemView.findViewById(R.id.status_creatednumber);
        tvDateLast = (TextView) itemView.findViewById(R.id.status_datelast);
    }

    public void bind(Status status) {
        ((CardView) itemView.findViewById(R.id.status)).setCardBackgroundColor(status.getColor());
        tvTitle.setText(status.getTitle());
        tvGlobalItemNumber.setText(status.getGlobalItemNumber() + " " + tvGlobalItemNumber.getResources().getString(R.string.global));
        tvSelfItemNumber.setText(status.getSelfItemNumber() + " " + tvGlobalItemNumber.getResources().getString(R.string.created));
        tvDateLast.setText(
                DateFormat
                        .getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, tvDateLast.getResources().getConfiguration().locale)
                        .format(status.getDateLast().getTime()));

	    Intent it = new Intent(itemView.getContext(), ViewList.class);
        it.putExtra("status", status.getStatusId());
        itemView.findViewById(R.id.status).setOnClickListener(
                v -> v.getContext().startActivity(it));
    }
}
