package com.example.demo.api;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.DataNotFoundException;
import com.example.demo.user.SiteUser;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class PlanService {
	
	
	private final Member_plan_Repository member_plan_Repository;
	private final Plan_each_day_Repository plan_each_day_Repository;
	private final Each_day_detail_Repository each_day_detail_Repository;
	
	
	
	
	public Long  create_member(SiteUser user) {
		
		Member_plan p = new Member_plan();
			p.setSiteUser(user);
			
			member_plan_Repository.save(p);
			
		
		
		return p.getId();
	}
	
	public Member_plan getmember_plan(Long id) {
         Member_plan member_plan = this.member_plan_Repository.findWithId(id);
        if (member_plan.getId() != null) {
            return member_plan;
        } else {
            throw new DataNotFoundException("member_plan not found");
        }
    }

	public Long save_first(Member_plan member_plan, String day, String day_location_x, String day_location_y,
			String day_location, String day_Num) {
		
		Plan_each_day each = new Plan_each_day();
		each.setDay(day);
		each.setDay_location(day_location);
		each.setDay_location_x(day_location_x);
		each.setDay_location_y(day_location_y);
		each.setDay_Num(day_Num);
		each.setMember_plan(member_plan);
		
		plan_each_day_Repository.save(each);
		
		return each.getIdx();
	}

	public Plan_each_day get_each_day(Long each) {
		Plan_each_day plan_each_day = this.plan_each_day_Repository.findEachId(each);
		if (plan_each_day.getIdx() != null) {
			return plan_each_day;
		} else {
			throw new DataNotFoundException("member_plan not found");
		}
	}

	public Long save_second(Plan_each_day plan_each_day, String number1, String number2, String title, String cat1_K,
			String cat2_K, String cat1, String cat2, String location_y, String location_x, String content_id,
			String img, String budget, String memo) {
		
		Each_day_detail detail = new Each_day_detail();
		detail.setBudget(budget);
		detail.setCat1(cat1);
		detail.setCat1_K(cat1_K);
		detail.setCat2(cat2);
		detail.setCat2_K(cat2_K);
		detail.setContent_id(content_id);
		detail.setImg(img);
		detail.setLocation_x(location_x);
		detail.setLocation_y(location_y);
		detail.setMemo(memo);
		detail.setNumber1(number1);
		detail.setNumber2(number2);
		detail.setPlan_each_day(plan_each_day);
		detail.setTitle(title);
		each_day_detail_Repository.save(detail);
		
		return detail.getIdx();
	}
	
	
	
}
