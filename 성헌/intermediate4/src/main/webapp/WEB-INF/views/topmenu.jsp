<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<header>
        <div class="logo">
            <a href="${pageContext.request.contextPath}">
            
                <img  class = "logoimg"src="${pageContext.request.contextPath}/resources/img/main-logo4.jpg" alt="logo">
            </a>
        </div> <!--로고 영역-->
        <nav>
            <ul>
            
                <li style="right: 160px;">
                    <a href="${pageContext.request.contextPath}">Home</a>
                </li>
                <li style="right: 155px;">
                    <a href="${pageContext.request.contextPath}/name/namelist">목록 검색</a>
                </li>
                <li style="right: 155px;">
                    <!--주메뉴-->
                    <a href="#">게시판</a>
                    <!--서브메뉴-->
                    <ul class="sub">
                        <li><a href="${pageContext.request.contextPath}/adminnotice/adminlist">자유게시판</a></li>
                        <li><a href="${pageContext.request.contextPath}/Qna/Qna">QnA Board</a></li>
                    </ul>
                </li>
                <li style="right: 155px;">
                    <a href="#" >List List</a>
                    <ul class="sub">
                        <li><a href="${pageContext.request.contextPath}/name/culturelist">문 화</a></li>
                        <li><a href="${pageContext.request.contextPath}/name/tourlist">관 광</a></li>
                        <li><a href="${pageContext.request.contextPath}/name/reslist">음식점</a></li>
                        <li><a href="${pageContext.request.contextPath}/name/hotellist">숙 박</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" id = "" ></a>
                    <ul class="sub" id="">
                        
                    </ul>
                </li>
            </ul>
        </nav> <!--네비게이션(GNB) 영역 end-->
        
        <!-- 맴버 영역 -->
        


        
        
                <% if (session.getAttribute("user_id") == null) { %>
        <div class="top_menu">
            <ul>
                <li style="margin-left: 200px;" ><a href="${pageContext.request.contextPath}/membermybatis/login-mapper">로 그 인 |</a></li>
                <li style="margin-right: 170px;"><a href="${pageContext.request.contextPath}/membermybatis/login-mapper">회원 가입 |</a></li>
            </ul>
                <!-- 위 로그인 전 아래 로그인 후 -->
				<% } else { %>	
                <nav>
                <ul>
				
				<li style="right: 140px;" class="alarmcheck">
					
                   <%=session.getAttribute("nickname") %>(<%=session.getAttribute("user_id") %>)
                    
                </li>
                <li style="right: 140px;">
                	<a href="#" id = "nickname" >
                    <span id="bellimg">
                    <svg id="mySvg" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"  class="bi bi-bell-fill" viewBox="0 0 16 16">
  					<path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zm.995-14.901a1 1 0 1 0-1.99 0A5.002 5.002 0 0 0 3 6c0 1.098-.5 6-2 7h14c-1.5-1-2-5.902-2-7 0-2.42-1.72-4.44-4.005-4.901z"/>
					</svg>
                    </span>
                    </a>
                    <span id="checkcount"></span>
                    
                    
                    
                    <ul class="sub" id="myList" style="top: 50px;">
                        
                     </ul>
				</li>
			
                <li style="right: 140px;"><a href="${pageContext.request.contextPath}/membermybatis/logout-mapper">로그 아웃</a></li>
                <% if (session.getAttribute("grade").equals("Y")) { %>
                <li style="right: 140px;"><a href="${pageContext.request.contextPath}/membermybatis/memberList-paging">관리자 페이지</a></li>

				<% } else { %>	
                <li style="right: 140px;"><a href="${pageContext.request.contextPath}/membermybatis/main-mapper">내 정보</a></li>
				<% } %>

                 <li style="right: 140px;"><a href="${pageContext.request.contextPath}/name/cartlist"> 담아두기 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-hearts" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M4.931.481c1.627-1.671 5.692 1.254 0 5.015-5.692-3.76-1.626-6.686 0-5.015Zm6.84 1.794c1.084-1.114 3.795.836 0 3.343-3.795-2.507-1.084-4.457 0-3.343ZM7.84 7.642c2.71-2.786 9.486 2.09 0 8.358-9.487-6.268-2.71-11.144 0-8.358Z"/>
</svg>|</a></li>
                  

            </ul>
                </nav>
        </div> <!--로그인 회원가입 주문내역 마이페이지-->
				<% } %>

    </header>
<script>


function alramList(){
	
	var toid = '<%=session.getAttribute("nickname") %>';
	
	 $.ajax({
	        url : '${pageContext.request.contextPath}/alarm/alramList',
	        type : 'get',
	        data : {toid : toid} ,
	        dataType : "json", 
	        success : function(data){
	         	var a='';
	         		for(const i in data){
	 			let idx = data[i].idx;
	 			let toid = data[i].toid;
	 			let fromid = data[i].fromid;
	 			let bidx = data[i].bidx;
	 			let bgidx = data[i].bgidx;
	 			let step = data[i].step;
	 			let title = data[i].title;
	 			let category = data[i].category;
	 			let readcheck = data[i].readcheck;
	 			var titles = title.replace(/@\S+/g, '');
	 			if (titles.length > 10) {
	 				titles = titles.substring(0, 10) + '...';
	 			}
	         		 
	 			//alarmClick();
	 		
	 				
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
	 			
           		if (category =="Qna"){
	 			a = '<li><a href="#" onclick=" alarmRead('+idx+ ');alarmClick('+bidx+');">' + fromid + ' 님께서 ' + title + '에 답변을 다셨습니다</a></li>';
           		}else if(category =="admin"){
	 			a = '<li><a href="/web/adminnotice/adminview?idx=' + bidx + '" onclick="alarmRead('+idx+ ')">' + fromid + ' 님의 댓글 <span>' + titles + '</span></a></li>';
           		}   
           			
	 		
           		
           		
           		
           		
           		
           		
           		
           		
           		
           		
           		
           		
           		
           		
           		
           		
           		
            
	         		 
	         	 $('#myList').append(a);
	         	 };
	         	 
	         	 
	        }
	        
	    
	    });
	 }




const alarmRead = function(idx) {
	
	
	
		$.ajax({
			url : '${pageContext.request.contextPath}/alarm/alarmRead',
			type : 'get',
			data : {
				idx : idx
				
			},
			success : function(pto){
				
			alert('성공');
				
				
			},
			error : function() {
				alert('서버 에러');
			}
		});
	};


const alarmClick = function(bidx) {
	
	
	
	
	$.ajax({
		url : '${pageContext.request.contextPath}/alarm/alarmClick',
		type : 'get',
		 dataType : "json",
		data : {
			
			bidx : bidx
		
		},
		success : function(pto){
			
		
			location.href="/web/Qna/detail?idx="+pto.idx+"";
			
		},
		error : function() {
			alert('서버 에러');
		}
	});
};


const checkcount = function() {
	
	
	var toid = '<%=session.getAttribute("nickname") %>';
	
	
	$.ajax({
		url : '${pageContext.request.contextPath}/alarm/checkcount',
		type : 'get',
		 dataType : "json",
		data : {
			
			toid : toid
		
		},
		success : function(checkcount){
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if(checkcount >= 1){
				
				var svgElement = document.getElementById('mySvg');
				svgElement.style.fill = '#ff0000';
			$('#checkcount').html(checkcount);
			
			}else {
				
				var myList = document.getElementById('myList');
				  myList.style.display = 'none';
			
			
			}
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		},
		error : function() {
			alert('서버 에러');
		}
	});
};


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 


window.onload = function () {
	
	alramList();
	checkcount();
	showQna();
	
	
	
	
}





</script>


 
