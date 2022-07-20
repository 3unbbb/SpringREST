<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	//RESTController에 접근(ajax)
	$.ajax({
		
		url:'/web/boards/all',
		type:'GET',
		success : function(data){
			alert('조회 성공');
			alert(data);
			console.log(data);
			
			$('body').append(data[0].bno);
			
			//테이블에 요소 추가
			$(data).each(function(idx,item){
				
				var tag="<tr>";
				tag += "<td>"+item.bno+"</td>"
				tag += "<td><a href='/web/"+item.bno+"'>"+item.title+"</a></td>"
				tag += "<td>"+item.writer+"</td>"
				tag += "<td>"+new Date(item.regdate)+"</td>"
				tag += "<td>"+item.viewcnt+"</td>"
				tag += "</tr>";
				
				$('table').append(tag);
			});
		}
		
	});
	
	
});







</script>
</head>
<body>
<h1>read.jsp</h1>

<table border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>이름</td>
		<td>날짜</td>
		<td>조회수</td>
	</tr>
</table>

</body>
</html>