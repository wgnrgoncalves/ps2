package br.com.fiap.microservicos.PS2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;

@Data
@Document
public class Sdg {
	
	@Id
	private String id;
	private String title;
	private boolean isFinished;
	private String country;
	private String date;
	private double waterPh;
	
	
	//private double waterPhReport;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getWaterPh() {
		return waterPh;
	}

	public void setWaterPh(double waterPh) {
		this.waterPh = waterPh;
	}

	
	public double getWaterPhReport() {
		return this.waterPh * 100 / 14;
	}

	
	
}
