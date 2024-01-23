<%@page import="com.myweb.dto.AdminNoticeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
request.setCharacterEncoding("utf-8");

AdminNoticeDTO one = (AdminNoticeDTO) request.getAttribute("one");

int lastidx = Integer.parseInt(request.getAttribute("lastidx").toString());
int nextidx = Integer.parseInt(request.getAttribute("nextidx").toString());
int lasttotalcount = Integer.parseInt(request.getAttribute("lasttotalcount").toString());
int nexttotalcount = Integer.parseInt(request.getAttribute("nexttotalcount").toString());
String lasttitle = (String) request.getAttribute("lasttitle");
String nexttitle = (String) request.getAttribute("nexttitle");

String nickname = (String) session.getAttribute("nickname");
%>
<!--String before = (String)request.getAttribute("before");
	
	String next = (String)request.getAttribute("next"); -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminview.jsp</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/top2.css">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css?v=<%=new java.util.Date().getTime() %>">
</head>
<body>

	<%@include file="../topmenu.jsp"%>
	<main>
<div class="AdminViewjsp">
<div class="AdminViewtopjsp">
<div class="maintitle">

		<h2>자유게시판</h2>
</div>

		<table class="AdminViewlList">
		<tr>
		<td class="Adminviewline " style="padding-left: 25px;width: 130.646;"><%=one.getTitle()%></td>
		<td class="Adminviewline inputsomething"><%=one.getNickname()%></td>
		<td class="Adminviewline right " style="padding-right : 25px;"><%=one.getRegdate()%></td>
		</tr>
		<tr>
		<td   colspan="3" class="left Viewtd"><%=one.getContent()%></td>
		</tr>
		
		</table>





	





<div class="nextjsp">
		<table class="AdminViewlList">
			<c:choose>
				<c:when test="${nexttitle != null}">
					<tr>
					<th class="nextline"><a href="/web/adminnotice/adminview?idx=<%=nextidx%>&totalcount=<%=nexttotalcount%>">다음글</a></th>
					<td class="nextlinetd"><%=nexttitle%></td>
					</tr>
				</c:when>
				<c:when test="${nexttitle == null}">
					<tr>
					<th class="nextline"><a disabled>다음글이 없습니다</a></th>
					<td class="nextlinetd"></td>
					</tr>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${lasttitle != null}">
					<tr>
					<th class="nextline"><a href="/web/adminnotice/adminview?idx=<%=lastidx%>&totalcount=<%=lasttotalcount%>">이전글</a></th>
					<td class="nextlinetd"><%=lasttitle%></td>
					</tr>
				</c:when>
				

				<c:when test="${lasttitle == null}">
					<tr>
					<th class="nextline"><a>이전글이 없습니다</a></th>
					<td class="nextlinetd"></td>
					</tr>
				</c:when>
			</c:choose>

		</table>
</div>
</div>
</div>

		
		<div class="writebtn" style="padding-top: 10px;margin-left: 50px; ">
			<ul>
				<li style="padding: 5px 25px"><a href="../adminnotice/adminlist">목록</a></li>
			</ul>
		</div>


		

		<!-- 댓글 -->

		<div class="replylist" id="reply_card${one.idx }">
			<section class="modal-section">
			
					<!-- 댓글 작성 => 로그인한 상태여야만 댓글 작성 칸이 나온다. -->
					<c:if test="${not empty sessionScope.nickname}">
						<div class="reply_write">

							<div class="input_reply_div">
								<!-- input_reply  -->
							<span class="nickname" >${nickname}&nbsp;&nbsp;</span>
							<input class="form-control" id="input_reply${one.idx }" type="text" placeholder="댓글 추가..."  oninput="writecheck()">
							</div>

							<div class="form-control-btn">
								<button type="button" class="cancelbtn" onclick="cancelComment()" >취소</button>
								<button type="button" title ="${one.title}" fromid="${nickname}" toid="${one.nickname}" idx="${one.idx}" class="write_reply" >댓글&nbsp;달기</button>
							</div>

						</div>
					</c:if>
					
				
				
				<div class="card-body">
				
						<div class="reply-list${one.idx }">
						<!-- 댓글이 들어가는 곳 -->
						
						
						</div>
				
				</div>

			</section>
		</div>



	</main>
</body>

<script>
//댓글
// 게시물의 댓글 목록을 불러오는 함수
const ReplyList = function(idx) {
	
	var number = 0;
	
	
	
	 $.ajax({
		 url : 'picture_replyList',
	 	type : 'get',
	 	data : {
	 		idx : idx
	 	},
	 	success : function(data) {
	 		let listHtml = "";
	 		for(const i in data){
	 			let idx = data[i].idx;
	 			let bidx = data[i].bidx;
	 			let grp = data[i].grp;
	 			let grps = data[i].grps;
	 			let grpl = data[i].grpl;
	 			let writer = data[i].writer;
	 			let content = data[i].content;
	 			let regdate = data[i].regdate;
	 			let wgap = data[i].wgap;
	 			let next_grps = data[i].next_grps;
	 			
	 			
	 		listHtml += "<div class='replyrow replystart" + idx + "'>";
				
				if (content == "") { // 삭제된 댓글일 때
 				   listHtml += "       <div>";
  				  listHtml += "            (삭제된 댓글입니다)";
  				  listHtml += "       </div>";
						
				} else {
				    if (grpl == 0) { // 모댓글일 때
				     
				        listHtml += ' <div class="rereply-content'+ number + ' rereply-content left" >';
				        listHtml += ' <div>';
				        listHtml += ' <span>';
				        listHtml += ' <b>' + writer + '</b>';
				        listHtml += ' </span>';
				        listHtml += ' </div>';
				        listHtml += ' <div>';
				        listHtml += ' <span>';
				        listHtml += content;
				        listHtml += ' </span>';
				        listHtml += ' </div>';
	 					//현재 로그인 상태일때 답글작성 버튼이 나온다
	 				listHtml += "<div class='buttoncontroll'>"
	 					if ("${nickname}" !== "") {
	 						<!--if("${nickname}" != writer){-->
	 							
	 						
	 			listHtml += "            <div>";
				listHtml += "                    <a href='javascript:' idx='" + idx +"' grpl='" + grpl +"' bidx='" + bidx + "' grp='" + grp +"' class='rerewritebutton'>답글</a>";
				listHtml += "            </div>";

    					
	 						
	 				          	}
	 				
	 					
	 					if ("${nickname}" !== "") {
	 					if("${nickname}" == writer){
	 						
   							 listHtml += "            <div>";
   							 listHtml += "                    <a href='javascript:' idx='" + idx +"' grpl='" + grpl +"' bidx='" + bidx + "' grp='" + grp +"' class='reply_delete'>삭제</a>";
    						 listHtml += "            </div>";
	 					}
	 				}
    						 listHtml += "            </div>";
	 					
	 					
	 					if(next_grps != 0){
	 						listHtml += "<a  id='svgicon" + idx + "'style='color : #065fd4' href='javascript:' idx='" + idx + "' grpl='" + grpl + "' bidx='" + bidx + "' grp='" + grp + "' class='showrereply'>";
	 						listHtml += "  <div class='viewbtn'>";
	 						listHtml += "    <svg name='downview' xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' style='fill: #065fd4' class='bi bi-caret-down-fill' viewBox='0 0 16 16'>";
	 						listHtml += "      <path d='M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z'/>";
	 						listHtml += "    </svg>";
	 						listHtml += "    답글" + next_grps + "개";
	 						listHtml += "  </div>";
	 						listHtml += "</a>";
	 					}

	 					listHtml +="<div class='rerewritebutton"+ idx + "'>"
	 					
	 					listHtml += "</div>"
						<!-- 댓댓글이 들어가는 곳 -->
	 					listHtml += "<div class='rereply-list"+ idx + "'>"
		 					
	 					
	 					listHtml += "</div>"
	 			        	}
	 			
				    listHtml += "    </div>";
				 // 댓글에 답글달기를 누르면 답글입력란이 나온다.
				 // ------답글입력란
				 
				number++;
				 
	 				// 답글입력란 끝
	 				
	 			}
				listHtml += "</div>";
	 		};

	 		// 댓글 리스트 부분에 받아온 댓글 리스트를 넣기
	 		$(".reply-list"+idx).html(listHtml);

	 		// 답글을 작성한 후 답글달기 버튼을 눌렀을 때 그 click event를 아래처럼 jQuery로 처리한다.
	 		$('.write_rereply').on('click', function() {
	 		    // 답글을 DB에 저장하는 함수를 호출한다. bidx와 idx를 같이 넘겨준다.
	 		    WriteReReply($(this).attr('bidx'), $(this).attr('idx'));
	 		});

	 		$('.showrereply').on('click', function() {
	 			 var idx= $(this).attr('idx');
	 			 var svgname = $(this).find("svg").attr("name");
	 		    
	 			if(svgname==="downview"){
	 				
	 		    	 var newSVG = '<svg name="upview" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-up-fill" viewBox="0 0 16 16">';
	 		         newSVG += '<path d="m7.247 4.86-4.796 5.481c-.566.647-.106 1.659.753 1.659h9.592a1 1 0 0 0 .753-1.659l-4.796-5.48a1 1 0 0 0-1.506 0z"/>';
	 		         newSVG += '</svg>';
	 		     	$('#svgicon' + idx + ' svg').replaceWith(newSVG); 
	 		    // 답글을 DB에 저장하는 함수를 호출한다. bidx와 idx를 같이 넘겨준다.
	 		    showrereply($(this).attr('bidx'), $(this).attr('idx'),$(this).attr('grp'),$(this).attr('grpl'));
	 		     	
	 			}else if(svgname==="upview"){
	 				var newSvgs = '<svg  name="downview" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down-fill" viewBox="0 0 16 16"><path d="M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z"/></svg>';
	 				$('#svgicon' + idx + ' svg').replaceWith(newSvgs);
	 				
	 				$(".rereply-list"+idx).html('');
	 				return;
	 				
	 			}
	 			
	 			
	 		});
	 		
	 		$('.rerewritebutton').on('click', function() {
	 		
	 		    rerewritebutton($(this).attr('bidx'), $(this).attr('idx'),$(this).attr('grp'),$(this).attr('grpl'));
	 		   
	 		 
	 		    
	 		  });
	 		
	 		$('.reply_delete').on('click', function() {
	 		    // 모댓글 삭제일 때
	 		    if ($(this).attr('grpl') == 0) {
	 		        DeleteReply($(this).attr('idx'), $(this).attr('bidx'));
	 		    } 
	 		    
	 		    
	 		    
	 		    
	 		    
	 		    
	 		    
	 		    
	 		    
	 })
	 
	 
	 
	 
},
	 		
	 		
	 	

	error : function() {
		alert('서버 에러');
		}
	 });
};




//대댓글 입력
const WriteReReply = function(bidx,idx,content,grpl) {
	
		
	
	var grpls = grpl;
	
	
	// 댓글 입력란의 내용을 가져온다.
	// "" 를 붙인 이유 => 앞뒤 공백을 제거한다.(띄어쓰기만 입력했을때 댓글작성안되게 처리하기 위함)
	
	if(content==""){
		
	content = $("#input_rereply"+idx).val();
	}
//	content = content.trim();
	
	
	if(content ==""){ // 입력된게 없을 때
		alert("글을 입력하세요!");
	}else{
		// 입력란 비우기
		$("#input_rereply" + idx).val("");
		
		//reply+1 하고 그 값을 가져옴
		$.ajax({
			url : 'picture_write_rereply',
			type : 'get',
			data : {
				
				idx : idx,
				bidx : bidx,
				content : content,
				grpls : grpls
			},
			success : function(pto){
				//let reply = pto.reply;
				//페이지, 모달창에 댓글수 갱신
			//	$('#m_reply' + bidx).text(reply);
			//	$('#reply'+bidx).text(reply);
				
				//게시물 번호(bidx)에 해당하는 댓글리스트를 새로 받아오기
				var bidx = pto.bidx;
				var idx = pto.idx;
				var grp = pto.grp;
				var grpl = pto.grpl;
				
				ReplyList(bidx);
				showrereply(bidx,idx,grp,grpl);
			
				
				
			},
			error : function() {
				alert('서버 에러');
			}
		});
	};
};











 // 취소 버튼 클릭 시 호출되는 함수
    function cancelComment() {
      // 입력 상자를 초기화
      document.querySelector('.form-control').value = '';

      // 버튼 숨기기
      document.querySelector('.form-control-btn').style.display = 'none';
    }
 
 //글이 채워지면 적을 수 있게 해줌
 
 	function writecheck() {
	 
 		if($(".form-control").val() != ""){
 			
 			$('.write_reply').css('backgroundColor', '#3367d6');
 			$('.write_reply').css('color', '#fff');
 		    
 		}else{
 		
 			$('.write_reply').css('backgroundColor', '#0000000D');
 			$('.write_reply').css('color', '#909090');
 		     }
	 
 }
 
 

//모댓글 작성


const writeReply = function(bidx,idx,title,toid,fromid) {
	
	
	// 댓글 입력란의 내용을 가져온다.
	// "" 를 붙인 이유 => 앞뒤 공백을 제거한다.(띄어쓰기만 입력했을때 댓글작성안되게 처리하기 위함)
	let content = $("#input_reply" + idx).val();
	
	
	if(content ==""){ // 입력된게 없을 때
		alert("글을 입력하세요!");
	}else{
		// 입력란 비우기
		$("#input_reply" + idx).val("");
		
		//reply+1 하고 그 값을 가져옴
		$.ajax({
			url : 'picture_write_reply',
			type : 'get',
			data : {
				
				idx : idx,
				toid,
				fromid,
				title,
				
				content : content
			},
			success : function(pto){
			//	let reply = pto.reply;
				//페이지, 모달창에 댓글수 갱신
			//	$('#m_reply' + bidx).text(reply);
			//	$('#reply'+bidx).text(reply);
				
				//게시물 번호(bidx)에 해당하는 댓글리스트를 새로 받아오기
				ReplyList(idx);
			
				
				
			},
			error : function() {
				alert('서버 에러');
			}
		});
	};
};


//모댓글 삭제
const DeleteReply = function(bidx,idx) {
	
	
		$.ajax({
			url : 'picture_delete_reply',
			type : 'get',
			data : {
				
				idx : idx,
				bidx : bidx
			},
			success : function(result){
				

				
				if (result=1){
					alert("삭제 성공");
				}else {
					alert("실패");
				}
			
				//게시물 번호(bidx)에 해당하는 댓글리스트를 새로 받아오기
				ReplyList(idx);
			
				
				
			},
			error : function() {
				alert('서버 에러');
			}
		});
	};






	const changespan = function(contentDiv) {
		
	
	    // Get the content from the div
	    var content = contentDiv.innerText;

	    
	    // Use regular expression to find @mentions
	    var mentionRegex = /@(\S+)/g;
	    var mentions = content.match(mentionRegex);

	    
	    // Wrap @mentions with span elements
	    if (mentions) {
	        mentions.forEach(function (mention) {
	            const spanElement = document.createElement('span');
	            spanElement.className = 'mention'; // Add a class for styling
	            spanElement.innerText = mention;
	            contentDiv.innerHTML = contentDiv.innerHTML.replace(mention, spanElement.outerHTML);
	        });
	    }
	};

	










//대댓글 보여 주기

const showrereply = function(bidx,idx,grp,grpl) {
	
	
	
	const grol = +grpl;
	grpl = grol + 1;
	
	$.ajax({
		url : 'showrereply',
		type : 'get',
		data : {
			
			grp : grp,
			grpl : grpl,
			idx : idx
			
		},
		success : function(data){
		var number = 0;
			let listHtml = "";
			for(const i in data){
				
	 			let idx = data[i].idx;
	 			let bidx = data[i].bidx;
	 			let bbidx = data[i].bbidx;
	 			let grp = data[i].grp;
	 			let grps = data[i].grps;
	 			let grpl = data[i].grpl;
	 			let writer = data[i].writer;
	 			let content = data[i].content;
	 			let regdate = data[i].regdate;
	 			let wgap = data[i].wgap;
			
	 			
	 			
				listHtml += '<div class="rerereplyall">';
	 			listHtml += ' <div class="  rerereply-content left">';
		        listHtml += ' <div class="rerereply-content'+ number + '">';
		        listHtml += ' <span>';
		        listHtml += ' <b>' + writer + '</b>';
		        listHtml += ' </span>';
		        listHtml += ' </div>';
		        listHtml += ' <div id="content"style="padding-top: 7px; padding-bottom: 7px;">';
		        listHtml += ' <span  style="padding-left: 10px;" class="rerereply-content-span">';
		        listHtml += content;
		        listHtml += ' </span>';
		        listHtml += ' </div>';
	 			
		        <!-- 세로 정렬 다시 해보기 -->
		        listHtml += '<div class="buttoncontroll">';
		        if ("${nickname}" !== "") {
							
						
			listHtml += "            <div>";
			listHtml += "                    <a href='javascript:' bbidx='" + bbidx + "' idx='" + idx +"' grpl='" + grpl +"' bidx='" + bidx + "' grp='" + grp +"' class='rererewritebutton'>답글</a>";
			listHtml += "            </div>";
						
				          	}
		        
		        
		        
		        
			        if("${nickname}" == writer){
 						
							 listHtml += "            <div>";
							 listHtml += "                    <a href='javascript:' idx='" + idx +"' grpl='" + grpl +"' bidx='" + bidx + "' grp='" + grp +"' class='rereply_delete'>삭제</a>";
						 listHtml += "            </div>";
					}
			        
 					listHtml += "</div>";
					
			        
 					
 					
			        listHtml +="<div class='rererewritebutton"+ idx + "'>";
 					
 					listHtml += "</div>";
			        
			        
			        listHtml += '</div>';
					listHtml += '</div>';
			
					
					
					
					
				number++;
			}
			
			
			$(".rereply-list"+idx).html(listHtml);
			
			
			$('.rereply_delete').on('click', function() {
	 		    // 답글을 DB에 저장하는 함수를 호출한다. bidx와 idx를 같이 넘겨준다.
	 		    rereply_delete($(this).attr('idx'),$(this).attr('bidx'),$(this).attr('grpl'));
				
	 		});
			
			$('.rererewritebutton').on('click', function() {
	 		    //  대댓글에 댓글을 달때
				 rererewritebutton($(this).attr('bidx'), $(this).attr('idx'),$(this).attr('grp'),$(this).attr('grpl'),$(this).attr('bbidx'));
				
	 		    
							});
			
			
		
			// showrereply 함수 내에서 contentDiv에 대해 changespan 함수 호출
			var contentDivs = document.querySelectorAll('.rerereply-content-span');
			contentDivs.forEach(function (contentDiv) {
				changespan(contentDiv);
			});
			
			
			
			    
			    
			    
			    
			    
			    
			
			
			
			
			
			
		},
		error : function() {
			alert('서버 에러');
		}
	});
};

//대댓글 삭제
const rereply_delete = function(idx, bidx,grpl) {

	
	var grpls = grpl;
		$.ajax({
			url : 'rereply_delete',
			type : 'get',
			data : {
				
				idx : idx,
				bidx : bidx,
				grpls : grpls
			
			},
			success : function(result){
				
				
				
				if (result=1){
					alert("삭제 성공");
				}else {
					alert("실패");
				}
				
				
			
				//게시물 번호(bidx)에 해당하는 댓글리스트를 새로 받아오기
				ReplyList(bidx);
			
				
				
			},
			error : function() {
				alert('서버 에러');
			}
		});
	};

	


	
	
	
	// 취소 버튼 클릭 시 호출되는 함수
    function cancelreComment(idx) {
      // 입력 상자를 초기화
      document.querySelector('.reform-control').value = '';

      // 버튼 숨기기
      document.querySelector('.reform-control-btn').style.display = 'none';
      $(".rerewritebutton"+idx).html('');
      
    }
 
 //글이 채워지면 적을 수 있게 해줌
 
 	function rewritecheck() {
	 
 		if($(".reform-control").val() != ""){
 			
 			$('.write_rereply').css('backgroundColor', '#3367d6');
 			$('.write_rereply').css('color', '#fff');
 		    
 		}else{
 		
 			$('.write_rereply').css('backgroundColor', '#0000000D');
 			$('.write_rereply').css('color', '#909090');
 		     }
	 
 }
	
	
	
	
	
	
const rerewritebutton = function(bidx,idx,grp,grpl) {
	
	const grol = +grpl;
	grpl = grol + 1;
	$.ajax({
		url : 'rerewritebutton',
		type : 'get',
		data : {
			
			grp : grp,
			grpl : grpl,
			idx : idx,
			bidx: bidx
			
		},
		success : function(data){
			let listHtml = "";
		
	 			var idx = data.idx;
	 			var bidx = data.bidx;
	 			var grp = data.grp;
	 			var grpl = data.grpl;
	 			var writer = data.writer;
			
	 			 // 댓글에 답글달기를 누르면 답글입력란이 나온다.
				 // ------답글입력란
				 
					 
				
				 
	 			 listHtml += " <div class='rereply_write' id='re_reply" + idx + "'>";
	 			 
				 listHtml += " <div class='input_rereply_div'>";
				 listHtml += "   <input class='reform-control' id='input_rereply" + idx + "' oninput='rewritecheck()' type='text' placeholder='댓글입력...'>";
				 listHtml += " </div>";
				 
				 listHtml += "  <div class='reform-control-btn'>";
				 
				 listHtml += "<div>"
				 listHtml += "<button type='button' class='cancelrebtn' onclick='cancelreComment("+idx+")' >취소</button>"
				 listHtml += "</div>"
				 
				 listHtml += "<div>"
				 listHtml += "<button type='button' class='write_rereply' grpl='" +grpl+ "' idx='" + idx + "' bidx='" + bidx + "'>답글&nbsp;달기</button>";
				 listHtml += "</div>"
				 
				 listHtml += " </div>";

				 listHtml += "</div>";
	 				// 답글입력란 끝
			
			
			
			
			
			
			$(".rerewritebutton"+idx).html(listHtml);
	 				
	 				
	 				
			// 답글을 작성한 후 답글달기 버튼을 눌렀을 때 그 click event를 아래처럼 jQuery로 처리한다.
	 		$('.write_rereply').on('click', async function() {
	 		    // 답글을 DB에 저장하는 함수를 호출한다. bidx와 idx를 같이 넘겨준다.
	 		    var content = "";
	 		   await WriteReReply($(this).attr('bidx'), $(this).attr('idx'), content, $(this).attr('grpl'))
	 	          

	 		  
	 		  
	 		
	 		});
	 		 function showreCommentButtons() {
	 		      // 버튼 보이기
	 		      document.querySelector('.reform-control-btn').style.display = 'flex';
	 		    }
	 		    // 댓글 입력 상자에 이벤트 리스너 등록
	 		    document.querySelector('.reform-control').addEventListener('focus', showreCommentButtons);
			
		},
		error : function() {
			alert('서버 에러');
		}
	});
};








// 취소 버튼 클릭 시 호출되는 함수
function cancelrereComment(idx) {
  // 입력 상자를 초기화
  document.querySelector('.rereform-control').value = '';

  // 버튼 숨기기
  document.querySelector('.rereform-control-btn').style.display = 'none';
  $(".rererewritebutton"+idx).html('');
  
}

//글이 채워지면 적을 수 있게 해줌

	function rerewritecheck() {
 
		if($(".rereform-control").val() != ""){
			
			$('.write_rerereply').css('backgroundColor', '#3367d6');
			$('.write_rerereply').css('color', '#fff');
		    
		}else{
		
			$('.write_rerereply').css('backgroundColor', '#0000000D');
			$('.write_rerereply').css('color', '#909090');
		     }
 
}

const rererewritebutton = function(bidx,idx,grp,grpl,bbidx) {
	

	const grol = +grpl;
	grpl = grol + 1;

	
	
	$.ajax({
		url : 'rererewritebutton',
		type : 'get',
		data : {
			
			grp : grp,
			grpl : grpl,
			idx : idx,
			bidx: bidx,
			bbidx : bbidx
			
		},
		success : function(data){
			let listHtml = "";
		
	 			var idx = data.bbidx;
	 			var realidx = data.idx;
	 			var bidx = data.bidx;
	 			var grp = data.grp;
	 			var grpl = data.grpl;
	 			var toname = data.writer;
			
	 			 // 댓글에 답글달기를 누르면 답글입력란이 나온다.
				 // ------답글입력란
				 
					 
				
				 
	 			 listHtml += " <div class='rerereply_write' id='re_re_reply" + idx + "'>";
	 			 
				 listHtml += " <div class='input_rerereply_div'>";
				 
				 listHtml += "<span id='tonameSpan'> @"+toname+"</span> <textarea oninput='rerewritecheck()'class='rereform-control'  id='userInput'></textarea>";
				 listHtml += " </div>";
				 
				 listHtml += "  <div class='rereform-control-btn'>";
				 
				 listHtml += "<div>"
				 listHtml += "<button type='button' class='cancelrerebtn' onclick='cancelrereComment("+idx+")' >취소</button>"
				 listHtml += "</div>"
				 
				 listHtml += "<div>"
				 listHtml += "<button type='button' class='write_rerereply' grpl='" + grpl + "' idx='" + idx + "' bidx='" + bidx + "'>답글&nbsp;달기</button>";
				 listHtml += "</div>"	
				 
				 
				
				 
				 
				 listHtml += " </div>";

				 listHtml += "</div>";
	 				// 답글입력란 끝
			
			
			
			
			
			
			$(".rererewritebutton"+realidx).html(listHtml);
	 				
	 				
	 				
			// 답글을 작성한 후 답글달기 버튼을 눌렀을 때 그 click event를 아래처럼 jQuery로 처리한다.
	 		$('.write_rerereply').on('click', function() {
	 			
	 			var toname = document.getElementById('tonameSpan').innerText;
	 			  var userInput = document.getElementById('userInput').value;
	 				 var content = toname + ' ' + userInput;
	 			  
	 			   WriteReReply($(this).attr('bidx'), $(this).attr('idx'),content,$(this).attr('grpl'));
	 		 
	 		
	 		});
	 		
					
	 		 function showrereCommentButtons() {
	 		      // 버튼 보이기
	 		      document.querySelector('.rereform-control-btn').style.display = 'flex';
	 		    }
	 		    // 댓글 입력 상자에 이벤트 리스너 등록
	 		    document.querySelector('.rereform-control').addEventListener('focus', showrereCommentButtons);
					
	 		
	 		
	 		
		},
		error : function() {
			alert('서버 에러');
		}
	});
};













//알람에 넣기


		

	
		



			
			
			
			



$(function(){ // onload
		
	$('.write_reply').on('click', function() {
	    // 답글을 DB에 저장하는 함수를 호출한다. bidx와 idx를 같이 넘겨준다.
	    writeReply($(this).attr('bidx'), $(this).attr('idx'),$(this).attr('title'),$(this).attr('toid'),$(this).attr('fromid'));

	  
	});
	
	
	
	

	
	
	
		ReplyList(${one.idx });
	


		

		
		
		

	
	 // 댓글 입력 상자를 클릭할 때 호출되는 함수
    function showCommentButtons() {
      // 버튼 보이기
      document.querySelector('.form-control-btn').style.display = 'block';
    }
    // 댓글 입력 상자에 이벤트 리스너 등록
    document.querySelector('.form-control').addEventListener('focus', showCommentButtons);

   
		});		

   
			
   
    
   
	

</script>








</html>