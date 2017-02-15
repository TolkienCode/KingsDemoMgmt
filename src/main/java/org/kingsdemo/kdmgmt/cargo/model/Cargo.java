package org.kingsdemo.kdmgmt.cargo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cargo {
	public Cargo() {
	}
	
	public Cargo(String description, long id, float price, String imgURL) {
		this.description = description;
		this.id = id;
		this.price = price;
		this.imgURL = imgURL;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the imgURL
	 */
	public String getImgURL() {
		return imgURL;
	}
	/**
	 * @param imgURL the imgURL to set
	 */
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String description;
	private float price;
	private String imgURL;
}
