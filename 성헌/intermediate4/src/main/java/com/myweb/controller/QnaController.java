package com.myweb.controller;

import java.io.File;
import java.net.http.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.PagingDTO;
import com.myweb.dto.QnaDTO;
import com.myweb.service.CommonService;
import com.myweb.service.QnaService;
import com.oreilly.servlet.MultipartRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("Qna")
public class QnaController{
	
	String view;
	
	@Autowired
	@Qualifier("QnaServiceImpl")
	QnaService service;
	
	@Autowired
	@Qualifier("CommonServiceImpl")
	CommonService common;
	
	
	
	
	//공지사항 목록화면 요청
	@RequestMapping("Qna")
	public String list(Model model,HttpSession session, 
			@RequestParam Map<String, String> map) throws Exception {
	
		
		QnaDTO dto = new QnaDTO();
		
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
				
			int totalCount = service.getQnacount(search); // 멤버 총인원
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
			
			if(search == null) {
				search="";
			}
				pstr.put("search", search);
				pstr.put("listNum", pdto.getListNum());
				pstr.put("start_rownum", pdto.getStart_rownum()-1);
				
				List<QnaDTO> list = service.getMemberPaging(pstr);
			
				model.addAttribute("list",list);
		
		
		
		
		//DB에서 공지 글 목록을 조회해와 목록 화면에 출력
		
		session.setAttribute("category", "no");
		
		
		
		
		
		
		return "Qna/Qna";
		
	}
	//신규 공지 글 작성 화면 요청
	@RequestMapping("New")
	public String New() {
		
		return "Qna/New";
	}
	
	//신규 공지 글 저장 처리 요청
		@RequestMapping("/insert")
		public String insert(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
			
			try {
				String saveDirectory = "D:\\kdigital12307\\spring2\\spring2\\intermediate3\\file\\";  // 저장할 디렉터리
				int maxPostSize = 1024 * 1000;  // 파일 최대 크기(1MB)
				String encoding = "UTF-8";  // 인코딩 방식
			    // 1. MultipartRequest 객체 생성
			    MultipartRequest mrequest = new MultipartRequest(request, saveDirectory,
			                                               maxPostSize, encoding);

			    // 2. 새로운 파일명 생성
			    String fileName = mrequest.getFilesystemName("file");  // 현재 파일 이름
			    String ext = fileName.substring(fileName.lastIndexOf("."));  // 파일 확장자
			    String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			    String newFileName = now + ext;  // 새로운 파일 이름("업로드일시.확장자")
			    // 3. 파일명 변경
			    File oldFile = new File(saveDirectory + File.separator + fileName);
			    File newFile = new File(saveDirectory + File.separator + newFileName);
			    oldFile.renameTo(newFile);

			    // 4. 다른 폼값 받기
			    String content = mrequest.getParameter("content");
			    String title = mrequest.getParameter("title");
			    String Writer  = (String) session.getAttribute("nickname");
			    
			    // 5. DTO 생성
			    int idx = 1;
			    QnaDTO dto = new QnaDTO();
			    dto.setWriter(Writer);
			    dto.setTitle(title);
			    dto.setFilename(newFileName);
			    dto.setContent(content);
			    dto.setFilepath(saveDirectory);
			 
			    
			    
			    // 6. DAO를 통해 데이터베이스에 반영
			      service.insertFile(dto);
			     
			      service.rootupdate();
			      
			    request.setAttribute("success", "파일 업로드 성공");

			    // 7. 파일 목록 JSP로 리디렉션
			    view = "redirect:Qna";
			}
			catch (Exception e) {
			    e.printStackTrace();
			    request.setAttribute("errorMessage", "파일 업로드 오류");
			    view = "Qna/New";
			}
			return view;	
			}
		
	
	
		// 상세 화면 요청
		@RequestMapping("detail")
		public String detail(@RequestParam int idx, Model model) throws Exception  {
			//선택한 공지글에 대한 조회수 증가 처리
			service.read(idx);
			
			//선택한 공지글 정보를 DB에서 조회해와 상세 화면에 출력
			
			model.addAttribute("dto", service.detail(idx));
			model.addAttribute("crlf", "\r\n");
			
			return "Qna/detail";
		}
		
		@ResponseBody 
		@RequestMapping("download")
		public ResponseEntity<byte[]> download( int idx, HttpSession session, HttpServletResponse response) throws Exception{
			 
			System.out.println("하위ㅇㄹㅇㄹ");
			QnaDTO dto = service.detail(idx);
			
			
			String filePath = "D:\\kdigital12307\\spring2\\spring2\\intermediate3\\file\\";
			
			String fileName =  dto.getFilename();
			
		
			
			
			
			
			File file = new File(filePath + fileName);
			byte[] fileContent = Files.readAllBytes(file.toPath());
			
			
			
			
			org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			
			String encodedFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			headers.setContentDispositionFormData("attachment", encodedFileName);
			
			return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
			
			
			
			
			
			
			//ResponseEntity<byte[]> fileContnet = common.download(fileName, filePath, session, response);
					
				
			
			
			
			
			
		}
		
		
		 
		
//		
//		   @RequestMapping(value = "/downloadFile") 
//		   @ResponseBody
//		   public ResponseEntity<byte[]> downloadFile(@RequestParam String filename) throws Exception {
//		      
//			   String filePath = "D:\\kdigital12307\\spring2\\spring2\\intermediate2\\file\\";
//		      
//		      
//		   }
		
		
		
		
		
		
		
		
		
		
		
		
		
		// 삭제 처리 요청
		@RequestMapping("delete")
		public String delete(int idx, HttpSession session) throws Exception {
			//선택한 공지글에 첨부된 파일이 있다면 서버의 물리적 영역에서 해당 파일도 삭제한다
			QnaDTO dto = service.detail(idx);
			if(dto.getFilepath() != null) {
				File file = new File(session.getServletContext().getRealPath("resources") + dto.getFilepath());
				if( file.exists() ) { file.delete(); }
			}
			
			//선택한 공지글을 DB에서 삭제한 후 목록 화면으로 연결
			service.delete(idx);
			
			return "redirect:Qna";
		}
		
		
		
		// 수정 화면 요청
		@RequestMapping("modify")
		public String modify(int idx, Model model) throws Exception {
			//선택한 공지글 정보를 DB에서 조회해와 수정화면에 출력
			model.addAttribute("dto", service.detail(idx));
		
			return "Qna/modify";
		}
		
		// 수정 처리 요청
		@RequestMapping("update")
		public String update(  HttpServletRequest request,HttpSession session, String attach) throws Exception {
			//원래 공지글의 첨부 파일 관련 정보를 조회
			try {
				String saveDirectory = "D:/kdigital12307/spring2/spring2/intermediate3/file";  // 저장할 디렉터리
				int maxPostSize = 1024 * 1000;  // 파일 최대 크기(1MB)
				String encoding = "UTF-8";  // 인코딩 방식
			    // 1. MultipartRequest 객체 생성
			    MultipartRequest mrequest = new MultipartRequest(request, saveDirectory,
			                                               maxPostSize, encoding);

			    int idx =  Integer.parseInt(mrequest.getParameter("idx"));
			    QnaDTO dto = new QnaDTO();
			    dto.setIdx(idx);
			    dto = service.detail(dto.getIdx());
			    String title = mrequest.getParameter("title");
			    String content = mrequest.getParameter("content");
			    dto.setTitle(title);
			    dto.setContent(content);
			    
			    
			    //기존에 있던 파일
			    String fileName = mrequest.getFilesystemName("file");  // 현재 파일 이름
			    String ext = fileName.substring(fileName.lastIndexOf("."));  // 파일 확장자
			    String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			    String newFileName = now + ext;  // 새로운 파일 이름("업로드일시.확장자")
			    // 3. 파일명 변경
			    File oldFile = new File(saveDirectory + File.separator + fileName);
			    File newFile = new File(saveDirectory + File.separator + newFileName);
			    oldFile.renameTo(newFile);
			    
			    
			    
			    
			     //update될 파일
			     QnaDTO notice = service.detail(dto.getIdx());
   			     fileName = newFileName;  // 현재 파일 이름
   			  
			 
   			     
   			 
   			     
   			     
   			     
   			     
   			     if(fileName != null) {
   			    	 notice.setFilename(fileName);
   			     }else {
   			    	 notice.setFilename(null);
   			     }
   			     
   			     
			    	 
			   
			    // 5. DTO 생성
			    
				
				//파일을 첨부한 경우 - 없었는데 첨부 / 있던 파일을 바꿔서 첨부
			    if( notice.getFilename() != null ) {
			    	dto.setFilename(notice.getFilename());
					dto.setFilepath(saveDirectory);
			    	File f = new File(saveDirectory);
			    	if ( f.exists() ) { f.delete(); }
			    }
			    
			    
				if(notice.getFilename() != "")
				{
					dto.setFilename(notice.getFilename());
					dto.setFilepath(saveDirectory);
					
					//원래 있던 첨부 파일은 서버에서 삭제
					
				} else {
					//원래 있던 첨부 파일을 삭제됐거나 원래부터 첨부 파일이 없었던 경우
					if(attach.isEmpty()) {
						//원래 있던 첨부 파일은 서버에서 삭제
						if( notice.getFilename() != null ) {
							File f = new File(saveDirectory);
							if ( f.exists() ) { f.delete(); }
						}
						
					//원래 있던 첨부 파일을 그대로 사용하는 경우
					} else {
						dto.setFilename(dto.getFilename());
						dto.setFilepath(dto.getFilepath());
					}
					
				}
				
				//화면에서 변경한 정보를 DB에 저장한 후 상세 화면으로 연결
				
				service.update(dto);

			    
			    
			    
			    
			    // 6. DAO를 통해 데이터베이스에 반영
			    request.setAttribute("success", "파일 업로드 성공");

			    // 7. 파일 목록 JSP로 리디렉션
			    view =  "redirect:detail?idx=" + dto.getIdx();
			}
			catch (Exception e) {
			    e.printStackTrace();
			    request.setAttribute("errorMessage", "파일 업로드 오류");
			    view = "Qna/modify";
			}
		
			
			
		
			return view;
			
			
		}
		
		
		@RequestMapping("reply")
		public String reply(Model model, int idx) throws Exception {
			//원글의 정보를 답글 쓰기 화면에서 알 수 있도록 한다.
			model.addAttribute("dto", service.detail(idx));
			
			return "Qna/reply";
		} 
		
		//신규 답글 저장 처리 요청==============================================================
		@RequestMapping("reply_insert")
		public String reply_insert( HttpSession session,  HttpServletRequest request) {
		
			try {
				String saveDirectory = "D:/kdigital12307/spring2/spring2/intermediate3/file";  // 저장할 디렉터리
				int maxPostSize = 1024 * 1000;  // 파일 최대 크기(1MB)
				String encoding = "UTF-8";  // 인코딩 방식
			    // 1. MultipartRequest 객체 생성
			    MultipartRequest mrequest = new MultipartRequest(request, saveDirectory,
			                                               maxPostSize, encoding);

			    // 2. 새로운 파일명 생성
			    
			    
			    
			    String fileName = mrequest.getFilesystemName("file");  // 현재 파일 이름
			    String ext = fileName.substring(fileName.lastIndexOf("."));  // 파일 확장자
			    String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			    String newFileName = now + ext;  // 새로운 파일 이름("업로드일시.확장자")
			    // 3. 파일명 변경
			    File oldFile = new File(saveDirectory + File.separator + fileName);
			    File newFile = new File(saveDirectory + File.separator + newFileName);
			    oldFile.renameTo(newFile);
			    
			    
			    
			     fileName = newFileName;  // 현재 파일 이름
			    // 3. 파일명 변경

			    // 4. 다른 폼값 받기
			    String content = mrequest.getParameter("content");
			    String title = mrequest.getParameter("title");
			    String Writer  = (String) session.getAttribute("nickname");
			    int idx =  Integer.parseInt(mrequest.getParameter("idx"));
			    
			    int root =  Integer.parseInt(mrequest.getParameter("root"));
			    int step =  Integer.parseInt(mrequest.getParameter("step"));
			    int indent =  Integer.parseInt(mrequest.getParameter("indent"));
			    
			    
			    
			    // 5. DTO 생성
			    QnaDTO dto = new QnaDTO();
			    dto.setIdx(idx+1);
			    dto.setRoot(root);
			    dto.setStep(step+1);
			    dto.setIndent(indent+1);
			    dto.setWriter(Writer);
			    dto.setTitle(title);
			    dto.setFilename(fileName);
			    dto.setContent(content);
			    dto.setFilepath(saveDirectory);

			    //화면에서 입력한 정보를 DB에 저장한 후 목록 화면으로 연결
			    
			    service.stepupdate(dto);
			//    service.rootupdate();
			    service.insertQna(dto);
			    request.setAttribute("success", "파일 업로드 성공");

			    // 7. 파일 목록 JSP로 리디렉션
			    view = "redirect:Qna";
			}
			catch (Exception e) {
			    e.printStackTrace();
			    request.setAttribute("errorMessage", "파일 업로드 오류");
			    view = "Qna/reply";
			}
			
			return view;	
		
		}

	
	
	
	

}
