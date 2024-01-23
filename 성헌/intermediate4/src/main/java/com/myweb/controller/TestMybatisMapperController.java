package com.myweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.myweb.dto.CultureDTO;
import com.myweb.dto.HotelDTO;
import com.myweb.dto.ImgDTO;
import com.myweb.dto.MemberDTO;
import com.myweb.dto.PagingDTO;
import com.myweb.dto.RestaurantDTO;
import com.myweb.dto.TestDTO;
import com.myweb.dto.TourDTO;
import com.myweb.service.ICultureService;
import com.myweb.service.IHotelService;
import com.myweb.service.IImgService;
import com.myweb.service.IMemberService;
import com.myweb.service.IRestaurantService;
import com.myweb.service.ITestService;
import com.myweb.service.ITourService;


@Controller
@RequestMapping("test")
public class TestMybatisMapperController{
	
	String view;
	
	@Autowired
	@Qualifier("TestMybatisMapperServiceImpl")
	ITestService service;
	
	@Autowired
	@Qualifier("ImgMybatisMapperServiceImpl")
	IImgService servicefile;
	
	
	@Autowired
	@Qualifier("CultureMybatisMapperServiceImpl")
	ICultureService c_service;
	
	@Autowired
	@Qualifier("HotelMybatisMapperServiceImpl")
	IHotelService h_service;
	
	@Autowired
	@Qualifier("RestaurantMybatisMapperServiceImpl")
	IRestaurantService r_service;
	
	@Autowired
	@Qualifier("TourMybatisMapperServiceImpl")
	ITourService t_service;
	
	
//	@RequestMapping(value = "request", method = RequestMethod.GET)
//	public String request() {
//		System.out.println("request");
//		
//		return "test/request";
//		
//	}
	
//	@RequestMapping(value = "get", method = RequestMethod.GET)
//	public String get(@RequestParam String id) {
//		System.out.println("getRequst");
//		System.out.println("id : " + id);
//		return "test/request";		
//	}
	
	@RequestMapping("response")
	public String memberListpaging(Model model, 
			@RequestParam Map<String, String> map){
		
		System.out.println("response이 최초 불러짐");
		System.out.println(map); // 현재 맵에 들어있는값 모두
		TestDTO tdto = null;
		Map<String, Object> pstr= new HashMap<String, Object>();
		
		//리스트 가져오기
		List<TestDTO> list = service.getTestList();

		List<CultureDTO> clist = c_service.getCulNameList();
		List<HotelDTO> hlist = h_service.getHotelNmaeList();
		List<RestaurantDTO> rlist = r_service.getResNameList();
		List<TourDTO> tlist = t_service.getTourNameList();
		
		List<String> cnname = new ArrayList<String>(); 
		List<ImgDTO> allflist = new ArrayList<ImgDTO>();
		String onefname = "";
		
		List<String> listfname = new ArrayList<String>(); 
		
		for(CultureDTO cdto : clist) {
			cnname.add( cdto.getCul_name());
			allflist =  servicefile.getImgList(cdto.getCul_name());
		}
		onefname = allflist.get(0).getFile_name();
		
		System.out.println(allflist +"allflist 내용");
		System.out.println(onefname +" : onefname 내용");
		
		
		model.addAttribute("list",list); // xml 에 paging dto값을 주고 원하는 페이지의 TestList값을 가져온다.
		
		model.addAttribute("onefname",onefname);
		model.addAttribute("cnname",cnname);
		model.addAttribute("clist",clist);
		model.addAttribute("hlist",hlist);
		model.addAttribute("rlist",rlist);
		model.addAttribute("tlist",tlist);
		
		
		System.out.println(list.get(0).getName());
		
		String name = clist.get(0).getCul_name();
		
		
		List<ImgDTO> flist =  servicefile.getImgList(name);
		
		
		model.addAttribute("flist",flist); 
		
		view = "test/response";
		return view;		
	}
		
	


}
