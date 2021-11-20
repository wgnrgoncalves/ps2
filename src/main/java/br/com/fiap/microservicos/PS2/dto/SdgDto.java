package br.com.fiap.microservicos.PS2.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

public class SdgDto {

	@Id
	private String id;
	
	@NotNull
	@NotBlank
	private String title;
	private boolean isFinished;
	
	@NotNull
	@NotBlank
	private String country;
	
	@NotNull
	@NotBlank
	@Length(min = 4, max = 4)
	private String date;
	
	@Range(min= 0, max= 14)
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

	
	
}
