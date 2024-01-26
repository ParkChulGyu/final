package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TouristAttraction {
	private int numOfRows;
	private int pageNo;
	private String mobileOS;
	private String mobileApp;
	private String type;
	private String listYN;
	private String arrange;
	private String keyword;
	private int contentTypeId;
	
	public TouristAttraction() {
	}

}
