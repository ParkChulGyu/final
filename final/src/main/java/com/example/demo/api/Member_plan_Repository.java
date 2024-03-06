package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.question.Question;
import com.example.demo.user.SiteUser;

public interface Member_plan_Repository extends JpaRepository<Member_plan, Long> {

	@Query("SELECT m FROM Member_plan m WHERE m.id = :id")
	Member_plan findWithId(@Param("id") Long id);

	
	List<Member_plan> findBySiteUser(SiteUser siteUser);


	

}
