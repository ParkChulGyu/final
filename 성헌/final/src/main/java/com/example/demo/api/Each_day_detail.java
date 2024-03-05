package com.example.demo.api;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Each_day_detail {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
	
	@Column
    private String number1;
	@Column
	private String number2;
	@Column
	private String title;
	@Column
	private String cat1_K;
	@Column
	private String cat2_K;
	@Column
	private String cat1;
	@Column
	private String cat2;
	@Column
	private String location_y;
	@Column
	private String location_x;
	@Column
	private String content_id;
	@Column
	private String img;
	@Column
	private String budget;
	@Column
	private String memo;
	
	
	
	@ManyToOne
	private Plan_each_day plan_each_day;
	

}
