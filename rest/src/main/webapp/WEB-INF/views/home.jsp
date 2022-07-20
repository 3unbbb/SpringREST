<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

	<title>Home</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	alert('jQuery call~~')
	
	$('#checkBtn').click(function(){
		$.ajax({
			uri:'${pageContext.request.contextPath}/test1',
			type:"GET",
			success:function(data){
				alert('SUCCESS!!!');
				
				$('body').append("전달값 : " + data+"<br>");
			}
		});
	});
	
})



</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<input type="button" value="BTN" id="checkBtn">



</body>
</html>
