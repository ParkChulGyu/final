package com.example.demo.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.question.Question;
import com.example.demo.user.SiteUser;

public interface Plan_each_day_Repository extends JpaRepository<Plan_each_day, Long> {
	
	
	@Query("SELECT m FROM Plan_each_day m WHERE m.idx = :idx")
	Plan_each_day findEachId(@Param("idx") Long each);

	@Query("SELECT p FROM Plan_each_day p WHERE p.member_Plan.id = :memberPlanId")
	List<Plan_each_day> findByMemberPlanId(@Param("memberPlanId") Long memberPlanId);


	


	

}
