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
import com.myweb.dto.CartDTO;
import com.myweb.dto.CultureDTO;
import com.myweb.dto.HotelDTO;
import com.myweb.dto.ImgDTO;
import com.myweb.dto.MemberDTO;
import com.myweb.dto.NameDTO;
import com.myweb.dto.PagingDTO;
import com.myweb.dto.RestaurantDTO;
import com.myweb.dto.TestDTO;
import com.myweb.dto.TourDTO;
import com.myweb.service.ICartService;
import com.myweb.service.ICultureService;
import com.myweb.service.IHotelService;
import com.myweb.service.IImgService;
import com.myweb.service.IMemberService;
import com.myweb.service.INameService;
import com.myweb.service.IRestaurantService;
import com.myweb.service.ITestService;
import com.myweb.service.ITourService;


@Controller
@RequestMapping("name")
public class NameMybatisMapperController{
	
	String view;
	
	@Autowired
	@Qualifier("TestMybatisMapperServiceImpl")
	ITestService service;
	
	@Autowired
	@Qualifier("ImgMybatisMapperServiceImpl")
	IImgService i_service;
	
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
	
	@Autowired
	@Qualifier("NameMybatisMapperServiceImpl")
	INameService n_service;

	@Autowired
	@Qualifier("CartMybatisMapperServiceImpl")
	ICartService cart_service;
	
	@RequestMapping("culturelist")
	public String CListpaging(Model model, 
			@RequestParam Map<String, String> map){
		System.out.println("culturelist 최초 불러짐");
		//리스트 가져오기
		List<CultureDTO> clist = c_service.getCulNameList(); // clist 값을 다가져옴

		System.out.println("map 불러옴"+map);
		System.out.println("clist 불러옴"+clist);
		
		//
		// 검색값 있는지 확인
		String search = "";
		if(map.get("slt") != null || map.get("str") != null ) {
		search = map.get("str"); // 검색 밸류
		}
		
		// 페이지값 확인
		int pageNum = 1;
		if(map.get("pageNum") != null ) {
			pageNum = Integer.parseInt(map.get("pageNum"));
		}
		

		
		//검색값에 페이지값 세팅
		if(map.get("str") != null) {
			model.addAttribute("str",search);
		}
		
		
		
		// 페이지값 초기화 |pageNum을 제외한
		int totalCount = c_service.getCulturetotalCount(search); // 컬쳐 총 밸류 수정 해야함
		
		int listNum = 10;
		if(map.get("listNum")!=null) {
			listNum = Integer.parseInt(map.get("listNum")); 
		}
		int blockNum = 10;
		PagingDTO pdto = new PagingDTO(totalCount, pageNum, listNum, blockNum);
		//페이징값 세팅
		pdto.setPaging();
		
		model.addAttribute("pdto",pdto); // xml 에 paging dto값을 주고 원하는 페이지의 memberlist값을 가져온다.
		
		// 있는 페이지 값으로 DB에서 원하는 List값 가져오기
		Map<String, Object> pstr= new HashMap<String, Object>();
		
		if(search == null) {
			search="";
		}
			pstr.put("search", search);
			pstr.put("listNum", pdto.getListNum());
			pstr.put("start_rownum", pdto.getStart_rownum()-1);
		
		//
			List<String> cnlist = new ArrayList<String>(); // 이름만 담을 리스트 만들고
			List<String> fnlist = new ArrayList<String>(); 
			
			// 페이징 값을 세팅 끝내고, name list 값을 가져옴
			
			cnlist = c_service.getCulturePaging(pstr);
			// name list 값에서 이미지 1개씩 이름을 찾아서 꺼내서 담음
			for(String iname : cnlist) {
				fnlist.add(i_service.getImgone(iname));	
			}
		
		model.addAttribute("cnlist",cnlist);
		model.addAttribute("fnlist",fnlist);
		model.addAttribute("listNum",listNum);
		
		for(String na :fnlist) {
			System.out.println(na);
		}
		for(String na :cnlist) {
			System.out.println(na);
		}
		
		
		
		view = "name/culturelist";
		return view;		
	}
		
	@RequestMapping("tourlist")
	public String TListpaging(Model model, 
			@RequestParam Map<String, String> map){
		
		System.out.println("Tourlist 최초 불러짐");
		//리스트 가져오기
		List<TourDTO> tlist = t_service.getTourNameList(); // clist 값을 다가져옴

		System.out.println("map 불러옴"+map);
		System.out.println("tlist 불러옴"+tlist);
		
		//
		// 검색값 있는지 확인
		String search = "";
		if(map.get("slt") != null || map.get("str") != null ) {
		search = map.get("str"); // 검색 밸류
		}
		
		// 페이지값 확인
		int pageNum = 1;
		if(map.get("pageNum") != null ) {
			pageNum = Integer.parseInt(map.get("pageNum"));
		}
		

		
		//검색값에 페이지값 세팅
		if(map.get("str") != null) {
			model.addAttribute("str",search);
		}
		
		
		
		// 페이지값 초기화 |pageNum을 제외한
		int totalCount = t_service.getTourtotalCount(search); // 컬쳐 총 밸류 수정 해야함
		
		int listNum = 10;
		if(map.get("listNum")!=null) {
			listNum = Integer.parseInt(map.get("listNum")); 
		}
		int blockNum = 10;
		PagingDTO pdto = new PagingDTO(totalCount, pageNum, listNum, blockNum);
		//페이징값 세팅
		pdto.setPaging();
		
		model.addAttribute("pdto",pdto); // xml 에 paging dto값을 주고 원하는 페이지의 memberlist값을 가져온다.
		
		// 있는 페이지 값으로 DB에서 원하는 List값 가져오기
		Map<String, Object> pstr= new HashMap<String, Object>();
		
		if(search == null) {
			search="";
		}
			pstr.put("search", search);
			pstr.put("listNum", pdto.getListNum());
			pstr.put("start_rownum", pdto.getStart_rownum()-1);
		
		//
			List<String> tnlist = new ArrayList<String>(); // 이름만 담을 리스트 만들고
			List<String> fnlist = new ArrayList<String>(); 
			
			// 페이징 값을 세팅 끝내고, name list 값을 가져옴
			
			tnlist = t_service.getTourPaging(pstr);
			// name list 값에서 이미지 1개씩 이름을 찾아서 꺼내서 담음
			for(String iname : tnlist) {
				fnlist.add(i_service.getImgone(iname));	
			}
		
		model.addAttribute("tnlist",tnlist);
		model.addAttribute("fnlist",fnlist);
		model.addAttribute("listNum",listNum);
		
		for(String na :fnlist) {
			System.out.println(na);
		}
		for(String na :tnlist) {
			System.out.println(na);
		}
		
		view = "name/tourlist";
		return view;
	}

	
	@RequestMapping("hotellist")
	public String HListpaging(Model model, 
			@RequestParam Map<String, String> map){
		
		System.out.println("hotellist 최초 불러짐");
		//리스트 가져오기
		List<HotelDTO> Hlist = h_service.getHotelList(); // clist 값을 다가져옴

		System.out.println("map 불러옴"+map);
		System.out.println("Hlist 불러옴"+Hlist);
		
		//
		// 검색값 있는지 확인
		String search = "";
		if(map.get("slt") != null || map.get("str") != null ) {
		search = map.get("str"); // 검색 밸류
		}
		
		// 페이지값 확인
		int pageNum = 1;
		if(map.get("pageNum") != null ) {
			pageNum = Integer.parseInt(map.get("pageNum"));
		}
		
		

		
		//검색값에 페이지값 세팅
		if(map.get("str") != null) {
			model.addAttribute("str",search);
		}
		
		
		
		// 페이지값 초기화 |pageNum을 제외한
		int totalCount = h_service.getHoteltotalCount(search); // 컬쳐 총 밸류 수정 해야함
		
		int listNum = 10;
		if(map.get("listNum")!=null) {
			listNum = Integer.parseInt(map.get("listNum")); 
		}
		int blockNum = 10;
		PagingDTO pdto = new PagingDTO(totalCount, pageNum, listNum, blockNum);
		//페이징값 세팅
		pdto.setPaging();
		
		model.addAttribute("pdto",pdto); // xml 에 paging dto값을 주고 원하는 페이지의 memberlist값을 가져온다.
		
		// 있는 페이지 값으로 DB에서 원하는 List값 가져오기
		Map<String, Object> pstr= new HashMap<String, Object>();
		
		if(search == null) {
			search="";
		}
			pstr.put("search", search);
			pstr.put("listNum", pdto.getListNum());
			pstr.put("start_rownum", pdto.getStart_rownum()-1);
		
		//
			List<String> hnlist = new ArrayList<String>(); // 이름만 담을 리스트 만들고
			List<String> fnlist = new ArrayList<String>(); 
			
			// 페이징 값을 세팅 끝내고, name list 값을 가져옴
			
			hnlist = h_service.getHotelPaging(pstr);
			// name list 값에서 이미지 1개씩 이름을 찾아서 꺼내서 담음
			for(String iname : hnlist) {
				fnlist.add(i_service.getImgone(iname));	
			}
		
		model.addAttribute("hnlist",hnlist);
		model.addAttribute("fnlist",fnlist);
		model.addAttribute("listNum",listNum);
		
		for(String na :fnlist) {
			System.out.println(na);
		}
		for(String na :hnlist) {
			System.out.println(na);
		}
		
		
		view = "name/hotellist";
		return view;
	}
	
	
	@RequestMapping("reslist")
	public String RListpaging(Model model, 
			@RequestParam Map<String, String> map){
		
		System.out.println("resllist 최초 불러짐");
		//리스트 가져오기
		List<RestaurantDTO> rlist = r_service.getResNameList(); // clist 값을 다가져옴

		System.out.println("map 불러옴"+map);
		System.out.println("rlist 불러옴"+rlist);
		
		//
		// 검색값 있는지 확인
		String search = "";
		if(map.get("slt") != null || map.get("str") != null ) {
		search = map.get("str"); // 검색 밸류
		}
		
		// 페이지값 확인
		int pageNum = 1;
		if(map.get("pageNum") != null ) {
			pageNum = Integer.parseInt(map.get("pageNum"));
		}
		
		//검색값에 페이지값 세팅
		if(map.get("str") != null) {
			model.addAttribute("str",search);
		}
		
		// 페이지값 초기화 |pageNum을 제외한
		int totalCount = r_service.getRestotalCount(search); // 컬쳐 총 밸류 수정 해야함
		
		int listNum = 10;
		if(map.get("listNum")!=null) {
			listNum = Integer.parseInt(map.get("listNum")); 
		}
		int blockNum = 10;
		PagingDTO pdto = new PagingDTO(totalCount, pageNum, listNum, blockNum);
		//페이징값 세팅
		pdto.setPaging();
		
		model.addAttribute("pdto",pdto); // xml 에 paging dto값을 주고 원하는 페이지의 memberlist값을 가져온다.
		
		// 있는 페이지 값으로 DB에서 원하는 List값 가져오기
		Map<String, Object> pstr= new HashMap<String, Object>();
		
		if(search == null) {
			search="";
		}
			pstr.put("search", search);
			pstr.put("listNum", pdto.getListNum());
			pstr.put("start_rownum", pdto.getStart_rownum()-1);
		
		//
			List<String> rnlist = new ArrayList<String>(); // 이름만 담을 리스트 만들고
			List<String> fnlist = new ArrayList<String>(); 
			
			// 페이징 값을 세팅 끝내고, name list 값을 가져옴
			
			rnlist = r_service.getResPaging(pstr);
			// name list 값에서 이미지 1개씩 이름을 찾아서 꺼내서 담음
			for(String iname : rnlist) {
				fnlist.add(i_service.getImgone(iname));	
			}
		
		model.addAttribute("rnlist",rnlist);
		model.addAttribute("fnlist",fnlist);
		model.addAttribute("listNum",listNum);
		
		for(String na :fnlist) {
			System.out.println(na);
		}
		for(String na :rnlist) {
			System.out.println(na);
		}
		
		view = "name/reslist";
		return view;
	}
	
	
	@RequestMapping("cview")
	public String cview(Model model, 
			@RequestParam Map<String, String> map){
		System.out.println("view 왔음");
		System.out.println("map 왔음"+map);
		String name = map.get("name");
		System.out.println(name);
		
		CultureDTO cdto =c_service.getCulNameSelec(name);
		System.out.println(cdto);
		
		List<ImgDTO> ilist = new ArrayList<ImgDTO>();
		ilist = i_service.getImgList(name);
		System.out.println(ilist);
		
		model.addAttribute("cdto",cdto);
		model.addAttribute("ilist",ilist);
		
		view = "name/cview";
		return view;
	}
	
	@RequestMapping("hview")
	public String hview(Model model, 
			@RequestParam Map<String, String> map){
		System.out.println("view 왔음");
		System.out.println("map 왔음"+map);
		String name = map.get("name");
		System.out.println(name);
		
		HotelDTO hdto = h_service.getHotelNameSelec(name);
		System.out.println(hdto);
		
		
		
		List<ImgDTO> ilist = new ArrayList<ImgDTO>();
		ilist = i_service.getImgList(name);
		System.out.println(ilist);
		
		model.addAttribute("hdto",hdto);
		model.addAttribute("ilist",ilist);
		
		view = "name/hview";
		return view;
	}
	
	@RequestMapping("rview")
	public String rview(Model model, 
			@RequestParam Map<String, String> map){
		System.out.println("view 왔음");
		System.out.println("map 왔음"+map);
		String name = map.get("name");
		System.out.println(name);
		
		RestaurantDTO rdto =r_service.getResNameSelec(name);
		System.out.println(rdto);
		
		List<ImgDTO> ilist = new ArrayList<ImgDTO>();
		ilist = i_service.getImgList(name);
		System.out.println(ilist);
		
		model.addAttribute("rdto",rdto);
		model.addAttribute("ilist",ilist);
		
		view = "name/rview";
		return view;
	}
	
	@RequestMapping("tview")
	public String tview(Model model, 
			@RequestParam Map<String, String> map){
		System.out.println("view 왔음");
		System.out.println("map 왔음"+map);
		String name = map.get("name");
		System.out.println(name);
		
		TourDTO tdto = t_service.getTourNameSelec(name);
		System.out.println(tdto);
		
		List<ImgDTO> ilist = new ArrayList<ImgDTO>();
		ilist = i_service.getImgList(name);
		System.out.println(ilist);
		
		model.addAttribute("tdto",tdto);
		model.addAttribute("ilist",ilist);
		
		view = "name/tview";
		return view;
	}
	
	
	@RequestMapping("namelist")
	public String Namepaging(Model model, HttpSession session,
			@RequestParam Map<String, String> map){
		
		System.out.println("namelist 최초 불러짐");

		System.out.println("map 불러옴"+map);
		// 검색값 있는지 확인
		String search = "";
		String region =	"";
		if(map.get("slt") != null || map.get("str") != null ) {
		search = map.get("str"); // 검색 밸류
		region = map.get("region"); // 검색 밸류
		}
		System.out.println(search+"검색값"); 
		System.out.println(region+"지역값");
		// 페이지값 확인
		int pageNum = 1;
		if(map.get("pageNum") != null ) {
			pageNum = Integer.parseInt(map.get("pageNum"));
		}
		
		//검색값에 페이지값 세팅
		if(map.get("str") != null) {
			model.addAttribute("str",search);
		}
		if(map.get("region") != null) {
			model.addAttribute("region",region);
		}
		
		// 페이지값 초기화 |pageNum을 제외한
		
		Map<String, String> semap = new HashMap<String, String>();
		semap.put("search", search);
		semap.put("region", region);
		
		System.out.println(n_service.getNametotalCount(semap)+"토탈 카운트");
		int totalCount = n_service.getNametotalCount(semap); //  총 밸류 수정 해야함
		
		int listNum = 10;
		if(map.get("listNum")!=null) {
			listNum = Integer.parseInt(map.get("listNum")); 
		}
		int blockNum = 10;
		PagingDTO pdto = new PagingDTO(totalCount, pageNum, listNum, blockNum);
		//페이징값 세팅
		pdto.setPaging();
		
		System.out.println(pdto);
		model.addAttribute("pdto",pdto); // xml 에 paging dto값을 주고 원하는 페이지의 list값을 가져온다.
		
		
		// 있는 페이지 값으로 DB에서 원하는 List값 가져오기
		Map<String, Object> pstr= new HashMap<String, Object>();
		
		if(search == null) {
			search="";
		}
			pstr.put("search", search);
			pstr.put("region", region);
			pstr.put("listNum", pdto.getListNum());
			pstr.put("start_rownum", pdto.getStart_rownum()-1);
		
		//
			List<NameDTO> ndtolist = new ArrayList<NameDTO>(); // 이름만 담을 리스트 만들고
			List<String> fnlist = new ArrayList<String>(); 
			
			// 페이징 값을 세팅 끝내고, name list 값을 가져옴
			
			ndtolist = n_service.getNamePaging(pstr);
			// name list 값에서 이미지 1개씩 이름을 찾아서 꺼내서 담음
			
			// 여기는 세션에 유저 id 값을 가져와서 list 맵에 user_id + ndtolist.name 을 넣고 
			//  cart서비스에서 검색돌려서 카운트를 0 또는 1로 리턴받는다.
			
			//우선 세션에 id값을 가져온다.
			String user_id = (String)session.getAttribute("user_id");
			
			// 버튼에 담을 카운트 값을 선언해둔다.
			 List<Integer> like_num = new ArrayList<Integer>();		
			 
			if(user_id!=null) {// id 값이 있으면 해야할일
				
				Map<String , Object> like_map = new HashMap<String, Object>();
				
				System.out.println(like_map+"유저 id");
						for(NameDTO iname : ndtolist) {
							String title_name = iname.getName();
							like_map.put("user_id", user_id);
							like_map.put("title_name", title_name);
							like_num.add(cart_service.getLike(like_map));
						}
						
						System.out.println(like_map+"like_map for 문 이후에 찍어봄");
						}else {// 최초 페이징에 id 값이 없을떄 like _ num 세팅
						for(int i=0; i<10; i++) {
						like_num.add(0);
						}			}
			
			// 그림 파일 찾아오기
			for(NameDTO iname : ndtolist) {
				fnlist.add(i_service.getImgone(iname.getName()));
			}
			
			System.out.println(ndtolist+"ndtolist값 찍어봄");
			for(NameDTO iname : ndtolist) {
				fnlist.add(i_service.getImgone(iname.getName()));
				
			}
			
			System.out.println(like_num+"like_num 찍기");
			
		
		model.addAttribute("like_num",like_num);
		model.addAttribute("ndtolist",ndtolist);
		model.addAttribute("fnlist",fnlist);
		model.addAttribute("listNum",listNum);
		
		view = "name/namelist";
		
		return view;
		
	}
	
	
	
	@RequestMapping("cartlist")
	public String cartlist(Model model, HttpSession session,
			@RequestParam Map<String, String> map){
		
		System.out.println("cartlist 최초 불러짐");

		System.out.println("map 불러옴"+map);
		// 값 있는지 확인

		// 페이지값 확인
		
		Map <String , Object> id = new HashMap<String, Object>();
		
		String user_id = (String)session.getAttribute("user_id");
		
		id.put("user_id", user_id);
		
		// 페이지값 초기화 |pageNum을 제외한
		int totalCount = cart_service.getCarttotalCount(id); // 컬쳐 총 밸류 수정 해야함
		int pageNum = 1;
		if(map.get("pageNum") != null ) {
			pageNum = Integer.parseInt(map.get("pageNum"));
		}
		int listNum = 10;
		if(map.get("listNum")!=null) {
			listNum = Integer.parseInt(map.get("listNum")); 
		}
		int blockNum = 10;

		PagingDTO pdto = new PagingDTO(totalCount, pageNum, listNum, blockNum);
		//페이징값 세팅
		pdto.setPaging();
		
		System.out.println(pdto);
		model.addAttribute("pdto",pdto); // xml 에 paging dto값을 주고 원하는 페이지의 list값을 가져온다.
		
		
		// 있는 페이지 값으로 DB에서 원하는 List값 가져오기
		Map<String, Object> pstr= new HashMap<String, Object>();
		
			pstr.put("listNum", pdto.getListNum());
			pstr.put("start_rownum", pdto.getStart_rownum()-1);
			pstr.put("user_id", user_id);
		//
			List<CartDTO> cartdtolist = new ArrayList<CartDTO>(); // 이름만 담을 리스트 만들고
			List<String> fnlist = new ArrayList<String>(); 
			
			// 페이징 값을 세팅 끝내고, name list 값을 가져옴
			System.out.println(pstr + "pstr값 찍는데 페이징 cart dto로 꺼냄");
			
			cartdtolist = cart_service.getCartPaging(pstr);
			// name list 값에서 이미지 1개씩 이름을 찾아서 꺼내서 담음
			
			// 여기는 세션에 유저 id 값을 가져와서 list 맵에 user_id + ndtolist.name 을 넣고 
			//  cart서비스에서 검색돌려서 카운트를 0 또는 1로 리턴받는다.
			
			
			// 버튼에 담을 카운트 값을 선언해둔다.
			 List<Integer> like_num = new ArrayList<Integer>();		
			 
			if(user_id!=null) {// id 값이 있으면 해야할일
				
				Map<String , Object> like_map = new HashMap<String, Object>();
				
				System.out.println(like_map+"유저 id");
						for(CartDTO iname : cartdtolist) {
							String title_name = iname.getTitle_name();
							like_map.put("user_id", user_id);
							like_map.put("title_name", title_name);
							like_num.add(cart_service.getLike(like_map));
						}
						
						System.out.println(like_map+"like_map for 문 이후에 찍어봄");
						}else {// 최초 페이징에 id 값이 없을떄 like _ num 세팅
						for(int i=0; i<10; i++) {
						like_num.add(0);
						}			}
			
			// 그림 파일 찾아오기
			for(CartDTO iname : cartdtolist) {
				fnlist.add(i_service.getImgone(iname.getTitle_name()));
			}
			
			System.out.println(cartdtolist+"cartdtolist값 찍어봄");
			for(CartDTO iname : cartdtolist) {
				fnlist.add(i_service.getImgone(iname.getTitle_name()));
				
			}
			
			System.out.println(like_num+"like_num 찍기");
			
		
		model.addAttribute("like_num",like_num);
		model.addAttribute("cartdtolist",cartdtolist);
		model.addAttribute("fnlist",fnlist);
		model.addAttribute("listNum",listNum);
		
		view = "name/cartlist";
		
		return view;
		
	}
	
	
	
	@RequestMapping("findview")
	public String findview(Model model, 
			@RequestParam Map<String, String> map){
		System.out.println("findview 왔음");
		System.out.println("map 왔음"+map);
		
		
		String name = map.get("name");
		String category = map.get("category");
		
		
		if(category.equals("c")) {
			CultureDTO cdto = c_service.getCulNameSelec(name);
			model.addAttribute("cdto",cdto);
			view = "name/cview";
			
		}else if(category.equals("h")) {
			HotelDTO hdto = h_service.getHotelNameSelec(name);
			model.addAttribute("hdto",hdto);
			view = "name/hview";
			
		}else if(category.equals("r")) {
			RestaurantDTO rdto = r_service.getResNameSelec(name);
			model.addAttribute("rdto",rdto);
			view = "name/rview";
			
		}else if(category.equals("t")) {
			TourDTO tdto = t_service.getTourNameSelec(name);
			model.addAttribute("tdto",tdto);
			view = "name/tview";
			
		}
			
		//이름 값으로 이미지  list 파일명을 가져옴
		List<ImgDTO> ilist = new ArrayList<ImgDTO>();
		ilist = i_service.getImgList(name);
		
		model.addAttribute("ilist",ilist);
		
		return view;
	}
	
	@ResponseBody
	@RequestMapping("like")
	public int like(Model model, 
			@RequestParam Map<String, Object> map){
		System.out.println("like 호출됨");
		System.out.println(map);
		String ret = "";
		int resert = cart_service.insertCart(map);
		
		
		return resert;
	}
	
	@ResponseBody
	@RequestMapping("unlike")
	public int unlike(Model model, 
			@RequestParam Map<String, Object> map){
		System.out.println("unlike 호출됨");
		System.out.println(map);
		
		int resert = cart_service.deleteCart(map);
		
		System.out.println(resert+ "unlike 리턴" );
		
		
		return resert;
	}
	

}
