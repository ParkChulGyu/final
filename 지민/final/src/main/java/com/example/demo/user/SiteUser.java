package com.example.demo.user;



import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
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

    @Column
    private String password;

    @Column(unique = true)
    private String email;
    private String registerId;
    
    @Column(unique = true)
    private String phone;
    
    public boolean isValidPhoneNumber() {
    	  return phone != null && !phone.trim().isEmpty();
    }
    
    @Column(unique = true)
    private String nick;
    
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @Builder
    public SiteUser() {
    }
    @Builder
    public SiteUser(String username, String email) {
        this.username = username;
        this.email = email;

    }
}
