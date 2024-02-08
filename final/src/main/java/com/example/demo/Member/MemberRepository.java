package com.example.demo.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	 Member searchMemberById(Long memberId);

}
