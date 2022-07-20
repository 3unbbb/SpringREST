<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
<h1>create.jsp</h1>

<form action="">
	글제목 : <input type="text" name="title" id="tit"><br>
	글쓴이 : <input type="text" name="writer" id="wri"><br>
	글내용 : <textarea rows="5" cols="10" name="content" id="con"></textarea><br>

	<input type="button" value="글쓰기" id="btn1">
</form>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//alert('실행');
	
	$('#btn1').click(function(){
		alert('버튼클릭');
		//입력한 데이터를 객체형태로 저장
		
		var board = {
			'title' : $('#tit').val(),
			'writer' : $('#wri').val(),
			'content' : $('#con').val()
		
		};
			console.log(board);
			
		//ajax 사용 - 글쓰기
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/boards",
			data : JSON.stringify(board),
			contentType : "application/json",
			success:function(data){
				alert('정보전달 완료');
				console.log(data);
				if(data == 'addOK'){
					alert('글쓰기 완료!');
					location.href='/web/all';
				}
				
			}
			
		});
		
	});
	
	
	
	
	
});



</script>


</body>
</html>