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
			, File descFile, String consultName, Context context) {
		this.date = Calendar.getInstance();
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
}
