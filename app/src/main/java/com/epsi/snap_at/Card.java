package com.epsi.snap_at;

/**
 * Created by Ptit-Biscuit on 03/10/2017.
 */

public class Card {
	private String titre;
	private int color;
	private String itemLabel;
	private String dateLast;

	public Card(String titre, int color, String itemLabel, String dateLast) {
		this.titre = titre;
		this.color = color;
		this.itemLabel = itemLabel;
		this.dateLast = dateLast;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getItemLabel() {
		return itemLabel;
	}

	public void setItemLabel(String itemLabel) {
		this.itemLabel = itemLabel;
	}

	public String getDateLast() {
		return dateLast;
	}

	public void setDateLast(String dateLast) {
		this.dateLast = dateLast;
	}
}
