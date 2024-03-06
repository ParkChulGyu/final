package com.example.demo.api;

import java.util.List;

import com.example.demo.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member_plan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	
	
	@ManyToOne
	private SiteUser siteUser;
	
	
	 @OneToMany(mappedBy = "member_Plan", cascade = CascadeType.REMOVE) 
	    private List<Plan_each_day> plan_each_day;
	
	
	
	
	

}
