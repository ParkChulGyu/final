package com.myweb.serviceimpl;

import java.awt.Window;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.MemberDTO;
import com.myweb.dto.QnaDTO;
import com.myweb.mybatis.mapper.MemberMapper;
import com.myweb.service.IMemberService;

@Service
public class MemberMybatisMapperServiceImpl implements IMemberService{
	
	@Autowired
	MemberMapper dao;

	@Override
	public int totalCount(String search) {
		return dao.totalCount(search);
	} 
	
	public List<MemberDTO> getMemberPaging(Map<String, Object> pstr) {
		return dao.getMemberPaging(pstr);
	} 
	
	@Override
	public List<MemberDTO> getMemberList() {
		return dao.getMemberList();
	}

	@Override
	public MemberDTO getMembermapper(MemberDTO dto) throws Exception{
		return dao.getMembermapper(dto);
	}
	
		//사용중
	@Override
	public int insertmember(MemberDTO dto)  throws Exception{
		return dao.insertmember(dto);
	}

	@Override
	public int update(MemberDTO dto) {
		
		return dao.update(dto);
	}

	@Override
	public int delete(MemberDTO dto) {
		
		return dao.delete(dto);
	}
	@Override
	public int deleteMember(MemberDTO dto) throws Exception {
		
		return dao.deleteMember(dto);
	}
	
	@Override
	public String idfind(String email) throws Exception {
		return dao.idfind(email);
	}

	@Override
	public int idfindcount(String email) throws Exception {
		return dao.nameCheck(email);
	}

	@Override
	public int nameCheck(String name) throws Exception {
		return dao.nameCheck(name);
	}

	@Override
	public int checkId(String user_id) throws Exception {
		
		return dao.checkId(user_id);
	}
	
	@Override
	public int removeqnaone(int idx) throws Exception {
		
		return dao.removeqnaone(idx);
	}
	
	@Override
	public int removeadminone(int idx) throws Exception {
		
		return dao.removeadminone(idx);
	}
	
	@Override
	public
	List<QnaDTO> QnaList() {
		return dao.QnaList();
		
	}
	
	@Override
	public
	List<AdminNoticeDTO> AdminList() {
		return dao.AdminList();
		
	}
	
	
	
//비밀번호 찾기 이메일발송
	@Override
	public void sendEmail(MemberDTO dto, String div) throws Exception {
		
		
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com"; //네이버 이용시 smtp.naver.com  smtp.gmail.com
		String hostSMTPid = "tjdgjsqkr1@naver.com";
		String hostSMTPpwd = "qoraksdls1";
		
		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "tjdgjsqkr1@naver.com";
		String fromName = "32번가 구석구석";
		String subject = "";
		String msg = "";
		
		if(div.equals("findpw")) {
			subject = "회원님의 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += dto.getUser_id() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += dto.getPw() + "</p></div>";
		}
		
		// 받는 사람 E-Mail 주소
		String mail = dto.getEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587); //네이버 이용시 587    // 465
			
			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}
	
	//비밀번호찾기
	@Override
	public void findPw(HttpServletResponse response, MemberDTO dto) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		MemberDTO ck = dao.readMember(dto.getUser_id());
		PrintWriter out = response.getWriter();
		// 가입된 아이디가 없으면
		if(dao.checkId(dto.getUser_id()) == 0) {
			out.print("등록되지 않은 아이디입니다.");
			out.close();
		}
		// 가입된 이메일이 아니면
		else if(!dto.getEmail().equals(ck.getEmail())) {
			out.print("등록되지 않은 이메일입니다.");
			out.close();
		}else {
			// 임시 비밀번호 생성
			String pw = "";
			for (int i = 0; i < 12; i++) {
				pw += (char) ((Math.random() * 26) + 97);
			}
			dto.setPw(pw);
			// 비밀번호 변경
			dao.updatePw(dto);
			// 비밀번호 변경 메일 발송
			sendEmail(dto, "findpw");

			out.print("이메일로 임시 비밀번호를 발송하였습니다.");
			//out.println("<script> window.close();</script>");
			out.flush();
			out.close();
			
		}
	}



}