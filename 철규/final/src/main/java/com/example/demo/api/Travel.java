package com.example.demo.api;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
public class Travel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contentid;
    private String title;
    private String addr1;
    private String addr2;
    private String cat1;
    private String cat2;
    private String cat3;
    private String firstimage;
    private String firstimage2;
    private String mapx;
    private String mapy;
    
    @Column(length = 1000)
    private String overview;
    
    
    @Builder
	public  Travel(String title, String addr1,String addr2, String cat1,String cat2, String cat3, String contentid ,String firstimage, String firstimage2, String mapx, String mapy, String overview) {
			this.title = title;
			this.addr1 = addr1;
			this.addr2 = addr2;
			this.cat1 = cat1;
			this.cat2 = cat2;
			this.cat3 = cat3;
			this.contentid = contentid;
			this.firstimage = firstimage;
			this.firstimage2 = firstimage2;
			this.mapx = mapx;
			this.mapy = mapy;
			this.overview = overview;
    }


	public Travel() {
	}
}
