/**
 * 
 */



window.onload = function() {
    // 페이지가 로드될 때 실행되는 코드
  
	showQna();
  };
    
  
  function moveBackground1() {
	   
	  $('.buttonfirst2').removeClass("changecolor");
		$('.buttonfirst1').addClass("changecolor");
	  document.getElementById('backgroundM').style.left = '280px';
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