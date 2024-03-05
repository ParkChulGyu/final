package com.example.demo.user;

import java.util.List;

import com.example.demo.answer.Answer;
import com.example.demo.api.Member_plan;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;
    
    @OneToMany(mappedBy = "SiteUser", cascade = CascadeType.REMOVE) 
    private List<Member_plan> member_plan;

}
