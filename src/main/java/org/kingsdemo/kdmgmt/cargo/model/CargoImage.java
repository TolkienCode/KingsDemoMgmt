package org.kingsdemo.kdmgmt.cargo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CargoImage {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String imgURL;
	private String description;
	
	@ManyToOne
	private Cargo cargo;
	
	public CargoImage() {
		
	}
	
	public CargoImage(Long id, String imgURL, String description, Long cargoId) {
		super();
		this.id = id;
		this.imgURL = imgURL;
		this.description = description;
		this.cargo = new Cargo("", cargoId, 0.00F, "");
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
}
