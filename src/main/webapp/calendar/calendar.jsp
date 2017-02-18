<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String email = request.getParameter("email");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../lib/extjs/resources/css/ext-all-neptune.css">
<link rel="stylesheet" type="text/css" href="../lib/css/todo.css">
<script type="text/javascript" src="../lib/extjs/ext-all.js"></script>
<script type="text/javascript" src="../lib/extjs/locale/ext-lang-zh_TW.js"></script>

<script type="text/javascript" src="../calendar/app.js"></script>

</head>
<body>
	<script>
		var email = '<%=email%>';
	</script>
</body>
</html>