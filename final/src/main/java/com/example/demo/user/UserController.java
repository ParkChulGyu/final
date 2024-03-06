package com.example.demo.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.api.Member_plan;
import com.example.demo.api.PlanService;
import com.example.demo.api.Plan_each_day;
import com.example.demo.api.set_dayDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	private final PlanService planservice;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", 
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }
        try {
        userService.create(userCreateForm.getUsername(), 
                userCreateForm.getEmail(), userCreateForm.getPassword1());
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }
        
        return "redirect:/";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login_form";
    }
    
    @GetMapping("/my_plan_list")
    public String my_plan_list(Principal principal, Model model ) {
    	
    	SiteUser siteuser = this.userService.getUser(principal.getName());
    				
    	List<Member_plan> member_plan = new ArrayList<>();
    	
    	member_plan = this.planservice.getAllplan(siteuser); 	
    	List<Plan_each_day> plan_each_day = new ArrayList<>();
    	
    		for( Member_plan dto :member_plan) {
    			List<Plan_each_day> day = new ArrayList<>();
    			day = this.planservice.getAlleachday(dto);
    			System.out.println(day.size());
    			
    			plan_each_day.add(day.get(0));
    		}
    		
    		
    	
    		model.addAttribute("plan_each_day", plan_each_day);
    	model.addAttribute("siteUser", siteuser);
    	model.addAttribute("member_plan", member_plan);
    	
    	return "my_plan_list";
    }
    
    
    @GetMapping("/my_plan_detail")
    public String my_plan_detail( @RequestParam("planId") Long planId,Model model ) {
    	
    				
    	List<Member_plan> member_plan = new ArrayList<>();
    	
    	List<Plan_each_day> plan_each_day = new ArrayList<>();
    	
    			List<Plan_each_day> day = new ArrayList<>();
    			day = this.planservice.getAlleachday_for_detail(planId);
    			System.out.println(day.size());
    			
    		
    			model.addAttribute("day", day);
    		
    	
    	
    	return "my_plan_detail";
    }
    
    
    
    
    
  
}
