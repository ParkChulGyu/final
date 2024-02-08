package com.example.demo.api.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class TourDetailDTO {
	private String title;
	private String addr1;
	private String addr2;
	private String booktour;
	private String contentid;
    private String contenttypeid;
    private String createdtime;
    private String modifiedtime;
    private String tel;
    private String telname;
    private String homepage;
    private String firstimage;
    private String firstimage2;
    private String cpyrhtDivCd;
    private String zipcode;
    private String mapx;
    private String mapy;
    private String mlevel;
    private String overview;
	
	public TourDetailDTO() {
	}

	// 생성자
	public TourDetailDTO(String contentid, String contenttypeid, String title, String createdtime, String modifiedtime,
			String tel, String telname, String homepage, String booktour, String firstimage, String firstimage2,
			String cpyrhtDivCd, String addr1, String addr2, String zipcode, String mapx, String mapy, String mlevel,
			String overview) {
		super();
		this.contentid = contentid;
		this.contenttypeid = contenttypeid;
		this.title = title;
		this.createdtime = createdtime;
		this.modifiedtime = modifiedtime;
		this.tel = tel;
		this.telname = telname;
		this.homepage = homepage;
		this.booktour = booktour;
		this.firstimage = firstimage;
		this.firstimage2 = firstimage2;
		this.cpyrhtDivCd = cpyrhtDivCd;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.mapx = mapx;
		this.mapy = mapy;
		this.mlevel = mlevel;
		this.overview = overview;
	}
	// 생성자
	
	

}