<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Successful</title>
</head>
<body>

You have registered successfully
<br></br>
Your name is <%= request.getParameter("name")  %>
<br></br>
Your language is <%= request.getParameter("language")  %>
<br></br>
You will write about 

<% for(String topic: request.getParameterValues("topics")){
			out.println(topic+" ");
}
%>

</body>
</html>