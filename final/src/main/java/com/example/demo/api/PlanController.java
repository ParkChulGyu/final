package com.example.demo.api;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.user.SiteUser;
import com.example.demo.user.UserService;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/plan")
public class PlanController {

	private final OpenApiManager openApiManager;
	private final ApiSearchBlog apisearchblog;
	private final UserService userService;
	private final PlanService planservice;
	


//	@GetMapping("result")
//	public String result(Model model) throws Exception {
//
//		List<placeDTO> tests = openApiController.fetchAll();
//		String Contentid;
//		String overview;
//		System.out.println("몇개 오는 지 확인 해보자   : " + tests.size());
//
//		for (placeDTO test : tests) {
//			Contentid = test.getContentid();
//			overview = openApiController.fetchOne(Contentid);
//			test.setOverview(overview);
//
//			System.out.println("한 번 체 크 해 보 자 : " + test.getCat3());
//
//			// planService.create(test);
//		}
//
////	    	model.addAttribute("responseData", tests);
//
//		return "qna/test";
//	}

	@ResponseBody
	@GetMapping("call_list_box")
	public List<list_boxDTO> call_list_box(@RequestParam(value = "city_lat") String city_lat,
			@RequestParam(value = "city_lng") String city_lng) throws Exception {
		// 위치기반 관광정보조회
		List<list_boxDTO> list_box = openApiManager.xy_call(city_lat, city_lng);

		return list_box;
	}

	@ResponseBody
	@GetMapping("search_blog")
	public List<search_blogDTO> search_blog(@RequestParam(value = "title") String title) throws Exception {
		// 위치기반 관광정보조회

		List<search_blogDTO> list_box = apisearchblog.main(title);

		return list_box;
	}

	@ResponseBody
	@GetMapping("detail")
	public list_boxDTO detail(@RequestParam(value = "contentid") String contentid) throws Exception {
		// 위치기반 관광정보조회
		list_boxDTO box = openApiManager.detail_call(contentid);

		return box;
	}

	@ResponseBody
	@GetMapping("contenttype_id")
	public List<list_boxDTO> contenttype_id(@RequestParam(value = "areaCode") String areaCode,
			@RequestParam(value = "contenttype_id") String contenttype_id) throws Exception {
		// 위치기반 관광정보조회
		List<list_boxDTO> list_box = openApiManager.location_contenttype_call(areaCode, contenttype_id);

		return list_box;
	}

	@ResponseBody
	@GetMapping("cat3")
	public List<list_boxDTO> cat3(@RequestParam(value = "cat3") String cat3,
			@RequestParam(value = "areaCode") String areaCode,
			@RequestParam(value = "contenttype_id") String contenttype_id) throws Exception {
		// 위치기반 관광정보조회
		List<list_boxDTO> list_box = openApiManager.location_cat3_call(cat3, areaCode, contenttype_id);

		return list_box;
	}

	@GetMapping("save_first")
	@ResponseBody
	public long save_first( @RequestParam(value = "id") String id, @RequestParam(value = "day") String day,
			@RequestParam(value = "day_location_x") String day_location_x,
			@RequestParam(value = "day_location_y") String day_location_y,
			@RequestParam(value = "day_location") String day_location, @RequestParam(value = "day_Num") String day_Num)
			throws Exception {
		
		System.out.println(id);
			Member_plan member_plan = planservice.getmember_plan(Long.parseLong(id));
			System.out.println(member_plan);
			Long each = this.planservice.save_first(member_plan,day,day_location_x,day_location_y,day_location,day_Num);
		
		
		

		return each;
	}
	@GetMapping("save_second")
	@ResponseBody
	public long save_second( @RequestParam(value = "each") String each, @RequestParam(value = "number1") String number1,
			@RequestParam(value = "number2") String number2,@RequestParam(value = "title") String title,
			@RequestParam(value = "cat1_K") String cat1_K,
			@RequestParam(value = "cat2_K") String cat2_K,@RequestParam(value = "cat1") String cat1,
			@RequestParam(value = "cat2") String cat2,@RequestParam(value = "location_y") String location_y,
			@RequestParam(value = "location_x") String location_x,@RequestParam(value = "content_id") String content_id,
			@RequestParam(value = "img") String img,@RequestParam(value = "budget") String budget,
			@RequestParam(value = "memo") String memo)
					throws Exception {
		
		System.out.println(each);
		Plan_each_day plan_each_day = planservice.get_each_day(Long.parseLong(each));
		System.out.println(plan_each_day);
		
		Long detail = this.planservice.save_second(plan_each_day,number1,number2,title,cat1_K,cat2_K,cat1,cat2,location_y,location_x,content_id,img,budget,memo);
		
		
		
		
		return 1;
	}
	
	
	
	
	
	@ResponseBody
	@GetMapping("plan_location_ajax")
	public long plan_location_ajax(Principal principal) throws Exception {
		SiteUser siteUser = this.userService.getUser(principal.getName());
			Long id = this.planservice.create_member(siteUser);
			

		
		
		return id;
	}
	
	

	@ResponseBody
	@GetMapping("searchKeyword")
	public List<list_boxDTO> searchKeyword(@RequestParam(value = "keyword") String keyword) throws Exception {
		// 위치기반 관광정보조회
		List<list_boxDTO> list_box = openApiManager.searchKeyword(keyword);

		return list_box;
	}

	@GetMapping("plan_day")
	public String plan_day() {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();

		// Principal 객체를 통해 현재 사용자를 가져옴
		// 사용자가 로그인되어 있는 경우 Principal은 인증된 사용자를 나타내고, 로그인되어 있지 않은 경우 null일 수 있음
		if (authentication.getPrincipal() != "anonymousUser") {
			// 사용자가 로그인되어 있는 경우
			System.out.println("authentication.getPrincipal()" + authentication.getPrincipal());
			return "plan/plan_day";
		} else {
			// 사용자가 로그인되어 있지 않은 경우
			return "redirect:/user/login?loginRequired=true";
		}

	}

	

	@GetMapping("plan_location")
	public String plan_location(Model model, @RequestParam(value = "start_day") String start_day,
			@RequestParam(value = "start") String start, @RequestParam(value = "end") String end,
			@RequestParam(value = "id_is") String id_is,
			@RequestParam(value = "locations_where") ArrayList<String> locations_where,
			@RequestParam(value = "locations_day") ArrayList<String> locations_day,
			@RequestParam(value = "lattis") ArrayList<String> lattis,
			@RequestParam(value = "lngis") ArrayList<String> lngis) {

		List<set_dayDTO> set_daylist = new ArrayList<>();
		System.out.println(locations_where);

		for (int i = 0; i < locations_where.size(); i++) {

			set_dayDTO set_day = new set_dayDTO();
			set_day.setDay(locations_day.get(i));
			set_day.setLocation(locations_where.get(i));
			set_day.setLat(lattis.get(i));
			set_day.setLng(lngis.get(i));
			set_daylist.add(set_day);

		}

		model.addAttribute("set_daylist", set_daylist);
		model.addAttribute("end", end);
		model.addAttribute("id_is", id_is);
		model.addAttribute("start", start);
		model.addAttribute("start_day", start_day);

		return "plan/plan_location";
	}

}
