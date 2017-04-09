<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<span style="color: #333333"> You are logged in as <b> ${sessionScope.memberInfo.userName} </b></span>
<br></br>
<span style="color: #333333"> Here is the latest question: </span>
<br></br>
<a href="DisplayQuestion?qId=1">Advice me a Java course..</a>
</body>
</html>