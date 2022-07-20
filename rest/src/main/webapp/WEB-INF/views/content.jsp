<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>


</head>
<body>
<h1>content.jsp</h1>
<input type="button" id="modBtn" value="내용수정하기">
<input type="button" id="delBtn" value="내용삭제하기">
<h2> 컨트롤러 </h2>

	글번호 : ${vo.bno }<br>
	제목: ${vo.title }<br>
	내용 : ${vo.content }<br>
	작성자 : ${vo.writer }<br>
	조회수 : ${vo.viewcnt }<br>
	날짜 : ${vo.regdate }<br>


	
<hr>


<h2>REST 컨트롤러</h2>
<script type="text/javascript">
$(document).ready(function(){
	
	$.ajax({
		
		url : "/web/boards/${vo.bno}",
		type: "GET",
		success : function(data){
			alert('글 조회 성공');
			console.log(data);
			
			$('body').append("글 번호 : "+data.bno+"<br>");
		}
		
	});//ajax
	
	//수정버튼
	$('#modBtn').click(function(){
		alert('수정버튼 클릭');
		//정보 수정(제목, 내용, 글쓴이)
		
		//alert("${vo.title}"+"${vo.bno}");
		
		var modVO={
			//'title' : '수정제목',
			'title' : "${vo.title}"+"${vo.bno}",
			'content' : "${vo.content}@@@@@",
			'writer' : "${vo.writer}님"
			
		};
		
		//console.log(modVO);
		
		//ajax 사용 정보 수정
		$.ajax({
			//url:"/web/boards/12528",
			url:"/web/boards/${vo.bno}",
			type : "PUT",
			contentType : "application/json",
			data : JSON.stringify(modVO),
			success : function(data){
			
				alert('수정동작완료');
				
				if(data == "modOK"){
					alert("수정동작 완료");
					location.reload();
				}else{
					alert("수정 동작 실패");
					location.reload();
				}
			}
			
		});
		
		
	});// 수정버튼
	
	$('#delBtn').click(function(){
		
		alert("삭제버튼 클릭");
		
		$.ajax({
			url : '/web/boards/${vo.bno}',
			type : "DELETE",
			success : function(data){
				alert("삭제동작 완료");
				if(data == "delOK"){
					location.href ="/web/all";
				}
			},
			error : function(){
				alert("삭제동작 실패");
			}
			
		});
		
	});
	
	
	
	
	
});

</script>



</body>
</html>