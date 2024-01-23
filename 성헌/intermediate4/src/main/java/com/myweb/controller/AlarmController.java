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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myweb.dto.AlarmDTO;
import com.myweb.dto.QnaDTO;
import com.myweb.dto.ReplyDTO;
import com.myweb.service.AlarmService;



@Controller
@RequestMapping("alarm")
public class AlarmController{
	
	String view;
	
	@Autowired
	@Qualifier("AlarmServiceImpl")
	AlarmService service;
	
	
	
	
	
	@RequestMapping("insertAlram")
	public void insertAlram(HttpSession session, int idx, int root) throws Exception {
		
		int alram = 1;
		QnaDTO Qna = new QnaDTO();
		
		Qna = service.getQnaOne(idx);
		String category = "Qna";
		String fromid  = (String) session.getAttribute("nickname");
		AlarmDTO dto = new AlarmDTO();
		dto.setToid(Qna.getWriter());
		dto.setBidx(Qna.getIdx());
		dto.setTitle(Qna.getTitle());
		dto.setFromid(fromid);
		dto.setCategory(category);
		dto.setStep(Qna.getStep());
		
		 service.insertAlram(dto);
		
		
	} 
	
	
	
	
	@GetMapping("myreplylist2")	
	public String myreplylist2(Model model,HttpSession session, 
			@RequestParam Map<String, String> map) throws Exception {	
		
	
		
		
		
		
		
		
		
		view = "membermybatis/myreplylist2";
		
		return view;		
		
	}	
	
	
	
	
	
	
	
	
		
	//알람목록
	@ResponseBody
	@RequestMapping("alramList")
	public List<AlarmDTO> alramList(String toid) throws Exception{
		
		return service.alramList(toid);
	}		
	
	
	//알람목록
	@ResponseBody
	@RequestMapping("checkcount")
	public int checkcount(String toid) throws Exception{
		
		int checkcount = 0;
		
		checkcount = service.checkcount(toid);
			
					
			
		
		return checkcount;
	}			
		
	//알람목록
	@RequestMapping("alarmRead")
	public void alarmRead(int idx) throws Exception{
		
		
		service.alarmRead(idx);
		//	service.alarmRemove(idx);
	
	
	}			
		
	@ResponseBody
	@RequestMapping("alarmClick")
	public QnaDTO alarmClick(int bidx) throws Exception{
	
		QnaDTO Qna = new QnaDTO();
		Qna.setIdx(bidx);
		Qna = service.getQnaOne(Qna.getIdx());
		//Qna.setStep(Step+1);
		
		Qna = service.alarmClick(Qna);
		
		
		return Qna;
	}			
	
	
	

	
	
	
	

}
