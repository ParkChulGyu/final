package com.example.demo.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TouristRepository {
	private int numOfRows;
	private int pageNo;
	private String mobileOS;
	private String mobileApp;
	private String type;
	private String listYN;
	private String arrange;
	private String keyword;
	private int contentTypeId;
	
	public TouristRepository() {
	}

}
