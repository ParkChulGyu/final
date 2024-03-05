package com.example.demo.api;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class PlanService {
	
	
	public final PlanRepository planRepository;
	
	
	public void create(placeDTO test) {
		
		planRepository.save(test);
	}
	
}
