package com.example.demo.api;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Plan_each_day {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
	
	@Column
    private String day;
	@Column
	private String day_location_x;
	@Column
	private String day_location_y;
	@Column
	private String day_location;
	@Column
	private String day_Num;
	
	
	@ManyToOne
	private Member_plan member_Plan;
	
	@OneToMany(mappedBy = "plan_each_day", cascade = CascadeType.REMOVE) 
    private List<Each_day_detail> each_day_detail;
	

}
