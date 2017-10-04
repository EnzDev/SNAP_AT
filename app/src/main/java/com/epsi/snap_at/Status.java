package com.epsi.snap_at;

import android.content.Context;

import java.util.Calendar;

/**
 * Created by Ptit-Biscuit on 03/10/2017.
 */

public class Status {
	private String title;
	private int color;
	private int globalItemNumber;
	private int selfItemNumber;
	private Calendar dateLast;
	private StatusID statusId;

	public Status(int globalItemNumber, int selfItemNumber, Calendar dateLast, StatusID statusId, Context context) {
		this.globalItemNumber = globalItemNumber;
		this.selfItemNumber = selfItemNumber;
		this.dateLast = dateLast;
		this.statusId = statusId;

		switch (statusId) {
			case OPEN:
				this.title = context.getResources().getString(R.string.openLabel);
				this.color = context.getResources().getColor(R.color.open);
				break;
			case WIN:
				this.title = context.getResources().getString(R.string.winLabel);
				this.color = context.getResources().getColor(R.color.win);
				break;
			case LOST:
				this.title = context.getResources().getString(R.string.lostLabel);
				this.color = context.getResources().getColor(R.color.lost);
				break;
			default:
				this.title = "Default";
				this.color = context.getResources().getColor(android.R.color.transparent);
		}
	}

	public String getTitle() {
		return title;
	}

	public int getColor() {
		return color;
	}

	public int getGlobalItemNumber() {
		return globalItemNumber;
	}

	public int getSelfItemNumber() {
		return selfItemNumber;
	}

	public Calendar getDateLast() {
		return dateLast;
	}

	public StatusID getStatusId() {
		return statusId;
	}
}
