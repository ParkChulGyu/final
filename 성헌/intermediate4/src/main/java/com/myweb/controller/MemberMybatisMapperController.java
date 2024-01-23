package com.myweb.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.MemberDTO;
import com.myweb.dto.MywritelistDTO;
import com.myweb.dto.PagingDTO;
import com.myweb.dto.QnaDTO;
import com.myweb.dto.ReplyDTO;
import com.myweb.service.AdminNoticeService;
import com.myweb.service.IMemberService;
import com.myweb.service.QnaService;


@Controller
@RequestMapping("membermybatis")
public class MemberMybatisMapperController{
	
	String view;
	
	@Autowired
	@Qualifier("memberMybatisMapperServiceImpl")
	IMemberService service;
	
	@Autowired
	@Qualifier("QnaServiceImpl")
	QnaService Qnaservice;
	
	@Autowired
	@Qualifier("AdminNoticeServiceImpl")
	AdminNoticeService Adminservice;
	

	
	
	@RequestMapping("memberList-paging")
	public String memberListpaging(Model model, 
			@RequestParam Map<String, String> map){
		
		System.out.println("memberList-paging 최초 페이징이 불러짐");
		System.out.println(map); // 현재 맵에 들어있는값 모두
		System.out.println(map.get("pageNum"));
		System.out.println("체크하자 체크" +map.get("pageNum"));

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
		int totalCount = service.totalCount(search); // 멤버 총인원
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
		
		
		List<MemberDTO> list = service.getMemberPaging(pstr);
		
		model.addAttribute("list",list); // xml 에 paging dto값을 주고 원하는 페이지의 memberlist값을 가져온다.
		System.out.println(list);
		
		
		view = "membermybatis/memberList-paging";
		return view;		
	}
	
			
	@GetMapping("main-mapper")
	public String mainInteface(Model model,HttpSession session) throws Exception {
		System.out.println("main-mapper");		
		
		MemberDTO dto = new MemberDTO();
		dto.setUser_id((String)session.getAttribute("user_id"));
		
	model.addAttribute(	"dto",service.getMembermapper(dto));

		
		view = "membermybatis/main-mapper";
		
		return view;				
	}
		
	
	@GetMapping("memberList-mapper")
	public String memberList(Model model) throws Exception {
		System.out.println("memberList-mapper");
		
		List<MemberDTO> list = service.getMemberList();		
		model.addAttribute("list", list);
		view = "membermybatis/memberList-mapper";
		
		return view;		
		
	}
	
	

	@ResponseBody
	@PostMapping(value = "memberdelete")
	public int memberdelete(String[] user_id ,MemberDTO dto)  throws Exception {

		
		
		
		
			int result = 0;
		for(int i=0 ; i<user_id.length; i++) {
				
				dto.setUser_id(user_id[i]);
					System.out.println("dto체크해보자 : " + dto);
				result = service.deleteMember(dto);
				System.out.println("result 확인 : " + result);
				
				
				
		}
			return result;	
		
	}
	
	@ResponseBody
	@PostMapping(value = "mywritelistD")
	public int mywritelistD(String[] qna , String[] admin)  throws Exception {
		
		
	System.out.println("dfdfd" + qna[0]);
	System.out.println("dfdfddfdfddfdfd" + admin[0]);
	
	int result = 0;
	if (!"nop".equals(qna[0])) {
		
	    for (int i = 0; i < qna.length; i++) {
	    	int idx = Integer.parseInt(qna[i]);
	    	result = service.removeqnaone(idx);
	    
	    }
	}
	
if (!"nop".equals(admin[0])) {
		
	    for (int i = 0; i < admin.length; i++) {
	    	int idx = Integer.parseInt(admin[i]);
	    	result = service.removeadminone(idx);
	    
	    }
	}
	
	
	
	
	
	
		return result;	
		
	}
	
	
	//회원가입
	@GetMapping("join-mapper")
	public String join() {
		
		view = "membermybatis/join-mapper";
		
		return view;		
	}

	
	
	@RequestMapping(value = "/checkid", method = {RequestMethod.GET})
	public @ResponseBody int idCheck(String mId) throws Exception {
		String user_id = mId;
		if(user_id == null || user_id == "")
			return -1;
		else
		return service.checkId(user_id);
	}
	
	
	@ResponseBody
	@PostMapping("signup")
	public int insertMember(HttpServletRequest request, HttpServletResponse response, MemberDTO dto) throws Exception {

		
			dto.setBirth("2003/4/9");
			System.out.println("dtk check : " + dto);
		//생년월일 구하기 ( 10보다 작으면 앞에 0 붙이기)
//		String years = request.getParameter("years"); //년도
//		String month =request.getParameter("month"); //월
//		String	day = request.getParameter("day");  //일
		
		//String user_id = request.getParameter("mId"); //아이디
		//System.out.println("mid 체크 : " + user_id );
		//String pw = request.getParameter("mPwd"); //비밀번호
		//String name = request.getParameter("mName"); //이름
		//String nickname = request.getParameter("mNickName"); //닉네임
		//String email = request.getParameter("mEmail"); //닉네임
	//	String birth = years +"년" + month +"월" + day+"일"; // 년 월 일 합친 생년월일.
		//String PhoneNumber = request.getParameter("mTel"); // 전화번호
		
	//	dto.setUser_id(user_id);
	//	dto.setPw(pw);
	//	dto.setName(name);
	//	dto.setNickname(nickname);
	//	dto.setEmail(email);
	//	dto.setPhoneNumber(PhoneNumber);
	//	dto.setBirth(birth);
		// 회원 정보들 세팅
		//this.mNum = mNum; this.mPwd = mPwd; ... mRole=mRole; 
		int rowcount = service.insertmember(dto); // 세팅해둔 dto객체를 넣었다.
		
		
		
		
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html; charset=UTF-8");
//
//		if(rowcount > 0) { //값이 데이터베이스에 저장이 되었을 때
//			
//			
//			out.println("<script>alert('계정이 등록 되었습니다'); location.href='/web/membermybatis/main-mapper';</script>");
//			
//			out.flush();
//		}else if(rowcount == 0) {
//			
//			out.println("<script>alert('회원가입에 실패하셨습니다'); location.href='/web/membermybatis/join-mapper';</script>");
//			out.flush();
//		}
		System.out.println("rowcount check " + rowcount);
		return rowcount;
	}
	
	
	
	
					
			

				
	
	@ResponseBody
	@PostMapping(value = "getMemberdata")
	public int getMemberdata(String user_id, MemberDTO dto) throws Exception{
				
						System.out.println("user_id : "  + user_id);
				int rs=0;
				if(!(user_id.equals(""))) {
					dto.setUser_id(user_id);
				dto = service.getMembermapper(dto);
			
				if(dto != null) {
					rs = 1;
				}
				}
				return rs;
				
				
	} 
		
	
	
	
	
	
	
	
	//로그인
	@GetMapping("login-mapper")
	public String login() {
		
		view = "membermybatis/login-mapper";		
		
		return view;		
	}
	
	@ResponseBody
	@PostMapping(value = "loginP")
	public int loginAction(MemberDTO dto, HttpSession session) throws Exception{
	
		System.out.println("dto check : " + dto);
		String user_id = dto.getUser_id();
		String pw = dto.getPw();		
		
		int result = 0;
		dto = service.getMembermapper(dto);
		System.out.println("dto check : " + dto);
		
		if (dto != null) {
			if (dto.getPw().equals(pw)) {
				
				session.setAttribute("user_id", user_id);
				session.setAttribute("nickname", dto.getNickname());
				session.setAttribute("grade", dto.getGrade());
				
				result = 1;
				
			}
		}else if (dto == null) {
			
			
			result = 0;
		}
			
		
		System.out.println("view check : " + result);
		
		return result;		
	}
			
		
	
	@GetMapping("idfind")
	public String idfind() {
		
		view = "membermybatis/idfind";		
		
		return view;	
	}
	@PostMapping("idfindP")
	public String idfindP(String str_email01,String str_email02,@RequestParam Map<String,String> map, Model model) throws Exception {
		
		System.out.println(map);
		
		
		System.out.println(map.get("selectEmail"));
		
		if(str_email02 == null) {
			str_email02 = map.get("selectEmail");
		}
		
		String email = str_email01+"@"+str_email02;
			System.out.println(email);
		
		String user_id = service.idfind(email);
		
		if (user_id == null) {
			model.addAttribute("msg", "이메일을 확인해주세요");
			view = "membermybatis/idfind";
		}else {
		
		
		
		model.addAttribute("msg", "당신의 아이디는  " + user_id + " 입니다");
		view = "membermybatis/idfind";		
		}		
		
	
		return view;	
	}
	
	@GetMapping("pwfind")
	public String pwfind() {
		
		view = "membermybatis/pwfind";		
		
		return view;	
	}
	
	
	@PostMapping("pwfindP")
	public void pwfindP(@ModelAttribute MemberDTO member, HttpServletResponse response) throws Exception{
		service.findPw(response, member);
	}
	
	
	
	
	
	
	@GetMapping("update-mapper")
	public String update(Model model, HttpSession session) throws Exception{
		
		String user_id = (String)session.getAttribute("user_id");

		MemberDTO dto = new MemberDTO();
		dto.setUser_id(user_id);

		model.addAttribute("dto", service.getMembermapper(dto));
		
		view = "membermybatis/update-mapper";		
		
		return view;		
	}
	
	@PostMapping("updateP")
	public String updateAction(MemberDTO dto, HttpSession session) {
		
		String user_id = (String)session.getAttribute("user_id");
		dto.setUser_id(user_id);
		System.out.println(dto);
		service.update(dto);
		
		session.setAttribute("nickname", dto.getNickname());
		
		view = "redirect:update-mapper";
		
		return view;
	}
	
	@GetMapping("delete-mapper")	
	public String delete() {		
		
		view = "membermybatis/delete-mapper";
		
		return view;		
		
	}
	
	@PostMapping("deleteP")
	public String deleteAction(MemberDTO dto, HttpSession session)  throws Exception{
		System.out.println("delete - post");
		
		String user_id = (String)session.getAttribute("user_id");
		String pw = dto.getPw();
		dto.setUser_id(user_id);		
		
		dto = service.getMembermapper(dto);
		
		if (dto != null) {
			if (dto.getPw().equals(pw)) {
				
				service.delete(dto);				
				session.invalidate();
				
				view = "redirect:main-mapper";
			}
		}
		
		return view;		
	}
	@GetMapping("logout-mapper")	
	public String logout(HttpSession session) {		
		System.out.println("logout - get");
		
		session.invalidate();
		
		view = "redirect:/";
		
		return view;		
		
	}	
	
	@GetMapping("myqnalist")	
	public String myqnalist(Model model,HttpSession session, 
			@RequestParam Map<String, String> map) throws Exception {	
		
		System.out.println("memberList-paging 최초 페이징이 불러짐");
		System.out.println(map); // 현재 맵에 들어있는값 모두
		System.out.println(map.get("pageNum"));
		
		QnaDTO dto = new QnaDTO();
		
		
		String nickname=(String)session.getAttribute("nickname");
		
		// 페이지값 확인
				int pageNum = 1;
				System.out.println("체크하자 체크1212" +map.get("pageNum"));
				if(map.get("pageNum") != null ) {
					pageNum = Integer.parseInt(map.get("pageNum"));
				}
				
				
		//검색값에 페이지값 세팅
				
			int totalCount = Qnaservice.getinfoQnacount(nickname); // 멤버 총인원
			int listNum = 10;
			
			if(map.get("listNum")!=null) {
				listNum = Integer.parseInt(map.get("listNum")); 
			}
			
			int blockNum = 10;
			PagingDTO pdto = new PagingDTO(totalCount, pageNum, listNum, blockNum);
			//페이징값 세팅
			pdto.setPaging();
			
			model.addAttribute("pdto",pdto);
			
			Map<String, Object> pstr= new HashMap<String, Object>();
			
				pstr.put("nickname", nickname);
				pstr.put("listNum", pdto.getListNum());
				pstr.put("start_rownum", pdto.getStart_rownum()-1);
				
				List<QnaDTO> list = Qnaservice.getinformationqnalist(pstr);
			
				model.addAttribute("list",list);
		
		
		
		System.out.println(list); 

		
		view = "membermybatis/myqnalist";
		
		return view;		
		
	}	
	@GetMapping("myadminlist")	
	public String myadminlist(Model model,HttpSession session, 
			@RequestParam Map<String, String> map) throws Exception {	
	
		
		AdminNoticeDTO mdto = null;
		// 검색값 있는지 확인
	
		
		// 페이지값 확인
		int pageNum = 1;
		if(map.get("pageNum") != null ) {
			pageNum = Integer.parseInt(map.get("pageNum"));
		}
		
		String nickname=(String)session.getAttribute("nickname");
		
		
		// 페이지값 초기화 |pageNum을 제외한
		int totalCount = Adminservice.getinfoadmincount(nickname); // 멤버 총인원
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
		
		
			pstr.put("nickname", nickname);
			pstr.put("listNum", pdto.getListNum());
			pstr.put("start_rownum", pdto.getStart_rownum()-1);
		
		
		List<AdminNoticeDTO> list = Adminservice.getinformationadminPaging(pstr);
		
		
		model.addAttribute("list",list); // xml 에 paging dto값을 주고 원하는 페이지의 memberlist값을 가져온다.
		
		
		
		
		view = "membermybatis/myadminlist";
		
		return view;		
		
	}	
	@GetMapping("myreplylist")	
	public String myreplylist(Model model,HttpSession session, 
			@RequestParam Map<String, String> map) throws Exception {	
		
		AdminNoticeDTO mdto = null;
		// 검색값 있는지 확인
	
		
		// 페이지값 확인
		int pageNum = 1;
		if(map.get("pageNum") != null ) {
			pageNum = Integer.parseInt(map.get("pageNum"));
		}
		
		String nickname=(String)session.getAttribute("nickname");
		
		
		// 페이지값 초기화 |pageNum을 제외한
		int totalCount = Adminservice.getinforeplycount(nickname); // 멤버 총인원
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
		
		
		
		
			pstr.put("nickname", nickname);
			pstr.put("listNum", pdto.getListNum());
			pstr.put("start_rownum", pdto.getStart_rownum()-1);
		
		
		List<ReplyDTO> list = Adminservice.getinformationareplyPaging(pstr);
		
		String content = null;
		
		for (ReplyDTO replyDTO : list) {
		
			 content = replyDTO.getContent();
			content = content.replaceAll("@\\S+", ""); // @ 다음에 오는 모든 비공백 문자를 제거
			
			if(content.length() > 10) {
				
				content = content.substring(0, 10) + "...";
			
			}
				replyDTO.setContent(content);
			
			
		   
		}
			
		
		model.addAttribute("list",list); // xml 에 paging dto값을 주고 원하는 페이지의 memberlist값을 가져온다.
	
		System.out.println("dfdfd" + list);
		
		
		
		view = "membermybatis/myreplylist";
		
		return view;		
		
	}	

	
	
	@GetMapping("mywritelist")	
	public String mywritelist(Model model,HttpSession session, 
			@RequestParam Map<String, String> map) throws Exception {	
		
		AdminNoticeDTO mdto = null;
		
		
		
		
		// 검색값 있는지 확인
		String search = "";
		if(map.get("slt") != null  ) {
			search = map.get("slt"); // 검색 밸류
		}
		
		
		String selectdate="";
		if(map.get("selectdate") != null) {
			selectdate = map.get("selectdate");
		}
		
		System.out.println(selectdate);
		
		// 페이지값 확인
		int pageNum = 1;
		if(map.get("pageNum") != null ) {
			pageNum = Integer.parseInt(map.get("pageNum"));
		}
		
		
		String nickname=(String)session.getAttribute("nickname");
		
		
		
		//검색값에 페이지값 세팅
				if(map.get("slt") != null) {
					model.addAttribute("slt",search);
				}
				
				
				if(map.get("selectdate") != null) {
					model.addAttribute("selectdate",selectdate);
				}
				
				
				
				if(search == null) {
					search="";
				}
				
				if(selectdate == null) {
					selectdate="최신순";
					
				}
				
		
		
				Map<String, Object> checkcount= new HashMap <String, Object>();
				
				
				checkcount.put("nickname", nickname);
				checkcount.put("search", search);
				System.out.println(checkcount);
		
		
		// 페이지값 초기화 |pageNum을 제외한
		int totalCount = Adminservice.getinformywritecount(checkcount); // 멤버 총인원
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
		
		
	
		 String selectdatesql = (selectdate.equals("최신순")) ? "regdate desc" : "regdate asc";
		
		 System.out.println(selectdatesql);
		 
		pstr.put("selectdatesql", selectdatesql);
		pstr.put("search", search);
		pstr.put("nickname", nickname);
		pstr.put("listNum", pdto.getListNum());
		pstr.put("start_rownum", pdto.getStart_rownum()-1);
		
		System.out.println(pstr);
		
		List<MywritelistDTO> list = Adminservice.getinfomywritelistPaging(pstr);
		
		
		model.addAttribute("list",list); // xml 에 paging dto값을 주고 원하는 페이지의 memberlist값을 가져온다.
		
		System.out.println("이거 오나?" + list);
		
		
		view = "membermybatis/mywritelist";
		
		return view;		
		
	}	
	
	
	
	


}
