package com.example.demo.user;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DataNotFoundException;
import com.example.demo.Member.Member;
import com.example.demo.Member.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	 private final UserRepository userRepository;
	 private final PasswordEncoder passwordEncoder;
	 private final MemberRepository memberRepository;
	 
	    public SiteUser create(String username, String email, String password) {
	        SiteUser user = new SiteUser();
	        Member  member = new Member();
	        user.setUsername(username);
	        member.setName(username);
	        
	        user.setEmail(email);
	        member.setEmail(email);
	        
	        //	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	        빈에 설정해놓고 new하지 않고 사용하는 거
	        user.setPassword(passwordEncoder.encode(password));
	        member.setPassword(passwordEncoder.encode(password));
	        
	        member.setContact("010-8259-7871");
	        
	        this.userRepository.save(user);
	        this.memberRepository.save(member);
	        return user;
	    }
	    public SiteUser getUser(String username) {
	        Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
	        if (siteUser.isPresent()) {
	            return siteUser.get();
	        } else {
	            throw new DataNotFoundException("siteuser not found");
	        }
	    }

}
