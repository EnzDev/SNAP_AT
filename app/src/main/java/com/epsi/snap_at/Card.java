package com.epsi.snap_at;

import android.content.Context;
import android.location.Location;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ptit-Biscuit on 04/10/2017.
 */

public class Card {
	private Calendar date;
	private StatusID status;
	private String title;
	private String desc;
	private String client;
	private String contactName;
	private float rate;
	private String successFactor;
	private float duration;
	private Date startLatest;
	private Location location;
	private File descFile;
	private String consultName;

	public Card(StatusID status, String title, String desc, String client, String contactName
			, float rate, String successFactor, float duration, Date startLatest, Location location
			, File descFile, String consultName, Calendar date, Context context) {
		this.date = date;
		this.title = title;
		this.status = status;
		this.desc = desc;
		this.client = client;
		this.contactName = contactName;
		this.rate = rate;
		this.successFactor = successFactor;
		this.duration = duration;
		this.startLatest = startLatest;
		this.location = location;
		this.descFile = descFile;
		this.consultName = consultName;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public StatusID getStatus() {
		return status;
	}

	public void setStatus(StatusID status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getSuccessFactor() {
		return successFactor;
	}

	public void setSuccessFactor(String successFactor) {
		this.successFactor = successFactor;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public Date getStartLatest() {
		return startLatest;
	}

	public void setStartLatest(Date startLatest) {
		this.startLatest = startLatest;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public File getDescFile() {
		return descFile;
	}

	public void setDescFile(File descFile) {
		this.descFile = descFile;
	}

	public String getConsultName() {
		return consultName;
	}

	public void setConsultName(String consultName) {
		this.consultName = consultName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Card card = (Card) o;

		if (Float.compare(card.rate, rate) != 0) return false;
		if (Float.compare(card.duration, duration) != 0) return false;
		if (status != card.status) return false;
		if (!title.equals(card.title)) return false;
		if (!desc.equals(card.desc)) return false;
		if (!client.equals(card.client)) return false;
		if (!contactName.equals(card.contactName)) return false;
		if (!successFactor.equals(card.successFactor)) return false;
		if (!startLatest.equals(card.startLatest)) return false;
		if (descFile != null ? !descFile.equals(card.descFile) : card.descFile != null)
			return false;
		return consultName.equals(card.consultName);

	}

	@Override
	public int hashCode() {
		int result = status.hashCode();
		result = 31 * result + title.hashCode();
		result = 31 * result + desc.hashCode();
		result = 31 * result + client.hashCode();
		result = 31 * result + contactName.hashCode();
		result = 31 * result + (rate != +0.0f ? Float.floatToIntBits(rate) : 0);
		result = 31 * result + successFactor.hashCode();
		result = 31 * result + (duration != +0.0f ? Float.floatToIntBits(duration) : 0);
		result = 31 * result + startLatest.hashCode();
		result = 31 * result + (descFile != null ? descFile.hashCode() : 0);
		result = 31 * result + consultName.hashCode();

		return result;
	}
}
