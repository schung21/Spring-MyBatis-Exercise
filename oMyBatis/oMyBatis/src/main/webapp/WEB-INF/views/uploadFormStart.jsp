<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
iframe {
	width: 0px;
	height: 0px;
	border: 0px
}
</style>
</head>
<body>
    Upload File 입력하세요^^<p>
	<form id="form1" action="uploadForm.do" method="post"
		enctype="multipart/form-data" target="myBatisFrame">
		<input type="file" name="file"> 
	    <input type="hidden" name="path" value="${pageContext.request.contextPath}/resources/image/"> 
		<input type="submit">
	</form>
      
	<iframe name="myBatisFrame"></iframe>

	<script>
		function addFilePath(msg) {
			alert(msg);
			document.getElementById("form1").reset();
		}
	</script>

</body>
</html>

