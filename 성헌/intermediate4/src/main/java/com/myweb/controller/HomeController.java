package com.myweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.MemberDTO;
import com.myweb.dto.NameDTO;
import com.myweb.dto.QnaDTO;
import com.myweb.dto.ReplyDTO;
import com.myweb.service.ICartService;
import com.myweb.service.IImgService;
import com.myweb.service.IMemberService;
import com.myweb.service.INameService;

@Controller
public class HomeController {
	

	@Autowired
	@Qualifier("ImgMybatisMapperServiceImpl")
	IImgService i_service;
	
	@Autowired
	@Qualifier("NameMybatisMapperServiceImpl")
	INameService n_service;
	
	
	@Autowired
	@Qualifier("memberMybatisMapperServiceImpl")
	IMemberService m_service;
	

	
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public String home(Model model) {	
		System.out.println("하위");
		
		List<NameDTO> namelist =  n_service.getHomeRand();
		List<String> fnlist = new ArrayList<String>(); 
		
		for(NameDTO iname : namelist) {
			fnlist.add(i_service.getImgone(iname.getName()));
		}
		
		System.out.println(namelist +"namelist");
		System.out.println(fnlist +"fnlist");
		
		model.addAttribute("namelist",namelist);
		model.addAttribute("fnlist",fnlist);
		
		return "index";
	}
	
	
	
	@ResponseBody
	@RequestMapping("showQna")
	public List<QnaDTO> showQna(){
		
		QnaDTO dto = new QnaDTO();
		
		
		List<QnaDTO> QnaList = new ArrayList();
		
		QnaList = m_service.QnaList();
		
		
		
		
		
		return QnaList;
	}
	@ResponseBody
	@RequestMapping("showFree")
	public List<AdminNoticeDTO> showFree(){
		
		AdminNoticeDTO dto = new AdminNoticeDTO();
		
		
		List<AdminNoticeDTO> AdminList = new ArrayList();
		
		AdminList = m_service.AdminList();
		
		System.out.println(AdminList);
		
		
		
		
		return AdminList;
	}
	
	
	
	
}
