<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<title>index.jsp</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/top2.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/top2.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/home.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pagination.css">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="topmenu.jsp" />
<main>

<div>

<hr>
</div>



<form action="/web/name/namelist" method="post">
<div class="input-group mb-3">

  <input type="hidden" name="slt" id="sltInput" value="name">
  <input type="hidden" name="region" id="sltInput2" value="">
  <input type="text" class="form-control" name="str" placeholder="검색어를 입력하세요." aria-label="Recipient's username" aria-describedby="button-addon2">
  <button class="btn btn-outline-secondary" type="submit" id="button-addon2"   >
  
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-binoculars" viewBox="0 0 16 16">
  <path d="M3 2.5A1.5 1.5 0 0 1 4.5 1h1A1.5 1.5 0 0 1 7 2.5V5h2V2.5A1.5 1.5 0 0 1 10.5 1h1A1.5 1.5 0 0 1 13 2.5v2.382a.5.5 0 0 0 .276.447l.895.447A1.5 1.5 0 0 1 15 7.118V14.5a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 14.5v-3a.5.5 0 0 1 .146-.354l.854-.853V9.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v.793l.854.853A.5.5 0 0 1 7 11.5v3A1.5 1.5 0 0 1 5.5 16h-3A1.5 1.5 0 0 1 1 14.5V7.118a1.5 1.5 0 0 1 .83-1.342l.894-.447A.5.5 0 0 0 3 4.882V2.5zM4.5 2a.5.5 0 0 0-.5.5V3h2v-.5a.5.5 0 0 0-.5-.5h-1zM6 4H4v.882a1.5 1.5 0 0 1-.83 1.342l-.894.447A.5.5 0 0 0 2 7.118V13h4v-1.293l-.854-.853A.5.5 0 0 1 5 10.5v-1A1.5 1.5 0 0 1 6.5 8h3A1.5 1.5 0 0 1 11 9.5v1a.5.5 0 0 1-.146.354l-.854.853V13h4V7.118a.5.5 0 0 0-.276-.447l-.895-.447A1.5 1.5 0 0 1 12 4.882V4h-2v1.5a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V4zm4-1h2v-.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5V3zm4 11h-4v.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5V14zm-8 0H2v.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5V14z"/>
</svg>

</button>

</div>
</form>


<article class="first-art">

<div class="contents">
<a href="/web/name/tourlist">
<section class="contents project-card">
  <section class="project-thumbnail" id="project-macbook">
  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-camera" viewBox="0 0 16 16">
  <path d="M15 12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V6a1 1 0 0 1 1-1h1.172a3 3 0 0 0 2.12-.879l.83-.828A1 1 0 0 1 6.827 3h2.344a1 1 0 0 1 .707.293l.828.828A3 3 0 0 0 12.828 5H14a1 1 0 0 1 1 1v6zM2 4a2 2 0 0 0-2 2v6a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V6a2 2 0 0 0-2-2h-1.172a2 2 0 0 1-1.414-.586l-.828-.828A2 2 0 0 0 9.172 2H6.828a2 2 0 0 0-1.414.586l-.828.828A2 2 0 0 1 3.172 4H2z"/>
  <path d="M8 11a2.5 2.5 0 1 1 0-5 2.5 2.5 0 0 1 0 5zm0 1a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7zM3 6.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0z"/>
</svg>
  </section>
  <section class="project-explain">
    <p> 관광지 </p>
  </section>
</section>
</a>
</div>

<div class="contents">
<a href="/web/name/culturelist">
<section class="contents project-card">
  <section class="project-thumbnail" id="project-macbook">
  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bank" viewBox="0 0 16 16">
  <path d="m8 0 6.61 3h.89a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5H15v7a.5.5 0 0 1 .485.38l.5 2a.498.498 0 0 1-.485.62H.5a.498.498 0 0 1-.485-.62l.5-2A.501.501 0 0 1 1 13V6H.5a.5.5 0 0 1-.5-.5v-2A.5.5 0 0 1 .5 3h.89L8 0ZM3.777 3h8.447L8 1 3.777 3ZM2 6v7h1V6H2Zm2 0v7h2.5V6H4Zm3.5 0v7h1V6h-1Zm2 0v7H12V6H9.5ZM13 6v7h1V6h-1Zm2-1V4H1v1h14Zm-.39 9H1.39l-.25 1h13.72l-.25-1Z"/>
</svg>
  </section>
  <section class="project-explain">
    <p> 문화재 </p>
  </section>
</section>
</a>
</div>

<div class="contents">
<a href="/web/name/hotellist">
<section class="contents project-card">
  <section class="project-thumbnail" id="project-macbook">
  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
  <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146ZM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5Z"/>
</svg>
</section>
  <section class="project-explain">
    <p> 숙 박 </p>
  </section>
</section>
</a>
</div>

<div class="contents">
<a href="/web/name/hotellist">
<section class="contents project-card">
  <section class="project-thumbnail" id="project-macbook">
  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-shop" viewBox="0 0 16 16">
  <path d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z"/>
</svg>
  </section>
  <section class="project-explain">
    <p> 음식점 </p>
  </section>
</section>
</div>
</a>

</article>



<div class="middle-container">

<div class="home-container" >
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3" aria-label="Slide 4"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="${pageContext.request.contextPath}/resources/img/${fnlist[0]}" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>${namelist[0].name}</h5>
      </div>
    </div>
    <div class="carousel-item">
      <img src="${pageContext.request.contextPath}/resources/img/${fnlist[1]}" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>${namelist[1].name}</h5>
      </div>
    </div>
    <div class="carousel-item">
		<img src="${pageContext.request.contextPath}/resources/img/${fnlist[2]}" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>${namelist[2].name}</h5>
      </div>
    </div>
    <div class="carousel-item">
		<img src="${pageContext.request.contextPath}/resources/img/${fnlist[3]}" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h3>${namelist[3].name}</h3>
      </div>
    </div>
  </div>
  
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</div>




	<div class="home-container-right">
	<div id="backgroundM" onclick="this.style.left='100px' "></div>
<div class="tab-box">
	<ul class="tab-tpye1">
		<li id="Qnali"  onclick="moveBackground1()" class="on-back">	
			<button  id="Qnabtn" class="buttonfirst1 changecolor" type="button" title="" > <Strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Qna</Strong></button>
		</li>
		
		<li id="Freeli"  onclick="moveBackground2()" class="on-back">
			<button id="Freebtn" class="buttonfirst2" type="button" title="" ><Strong>자유게시판</Strong></button>
		</li>
	
	
	</ul>
</div>

	<div class="QnaAFree">
	<table class="viewlist">
	
	</table>
	
	</div>

	



	</div>

</div>



<script>

    
  
  function moveBackground1() {
	   
	  $('.buttonfirst2').removeClass("changecolor");
		$('.buttonfirst1').addClass("changecolor");
	  document.getElementById('backgroundM').style.left = '279px';
	  showQna();
	    
	
  }
    
  function moveBackground2() {
	  $('.buttonfirst1').removeClass("changecolor");
		$('.buttonfirst2').addClass("changecolor");
			showFree();
	
	  document.getElementById('backgroundM').style.left = '400px';
  }
    
  
 

  const showQna = function() {

	    $.ajax({
	        url: 'showQna',
	        type: 'get',
	        data: {},
	        success: function(data) {
	            // 댓글에 답글달기를 누르면 답글입력란이 나온다.
	            // ------답글입력란

	            let listHtml = "";
	            listHtml += "<tr>";
	            listHtml += "  <th class='ListTh'>등록일자</th> ";
	            listHtml += "  <th class='ListTh'>제목</th> ";
	            listHtml += "  <th class='ListTh'>조회</th> ";
	            listHtml += "</tr>";

	            for (const i in data) {
	                let idx = data[i].idx;
	                let regdate = data[i].regdate;
	                let title = data[i].title;
	                let readcnt = data[i].readcnt;

	                listHtml += "<tr>";
	                listHtml += "  <td class='ListTd'>" + regdate + "</td> ";
	                listHtml += "  <td class='ListTd'><a href='/web/Qna/detail?idx=" + idx + "'>" + title + "</a></td> ";
	                listHtml += "  <td class='ListTd'>" + readcnt + "</td> ";
	                listHtml += "</tr>";
	            }

	            // 답글입력란 끝

	            $(".viewlist").html(listHtml);
	        },
	        error: function() {
	            alert('서버 에러');
	        }
	    });
	};
  
  const showFree = function() {
	  console.log("하하하위윙");

	    $.ajax({
	        url: 'showFree',
	        type: 'get',
	        data: {},
	        success: function(data) {
	            // 댓글에 답글달기를 누르면 답글입력란이 나온다.
	            // ------답글입력란

	            let listHtml = "";
	            listHtml += "<tr>";
	            listHtml += "  <th class='ListTh'>등록일자</th> ";
	            listHtml += "  <th class='ListTh'>제목</th> ";
	            listHtml += "  <th class='ListTh'>조회</th> ";
	            listHtml += "</tr>";

	            
	            
	            for (const i in data) {
	                let idx = data[i].idx;
	                let regdate = data[i].regdate;
	                let title = data[i].title;
	                let totalcount = data[i].totalcount;

	                listHtml += "<tr>";
	                listHtml += "  <td class='ListTd'>" + regdate + "</td> ";
	                listHtml += "  <td class='ListTd'><a href='/web/adminnotice/adminview?idx=" + idx + "'>" + title + "</a></td> ";
	                listHtml += "  <td class='ListTd'>" + totalcount + "</td> ";
	                listHtml += "</tr>";
	            }

	            // 답글입력란 끝

	            $(".viewlist").html(listHtml);
	        },
	        error: function() {
	            alert('서버 에러');
	        }
	    });
	};


</script>
</main>
 <footer>
        <!-- 푸터(footer) 요소 -->
        <div class="foot"></div>
  </footer>

</body>
</html>