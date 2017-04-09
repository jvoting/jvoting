<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<jsp:useBean id="memberInfo"  class="com.qapro.entity.MemberInfo" scope="request">  
     
</jsp:useBean>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Successful</title>
</head>
<body>






This is 2nd step for registration

Your member id in our system is: <jsp:getProperty name="memberInfo" property="userId" />
<br></br>

You will use our system as: <jsp:getProperty name="memberInfo" property="memberRole" />

<ul>
	<c:forEach var="item" items="${memberInfo.privileges}">
		<li>${item}</li>
	</c:forEach>
</ul>


<c:choose>
    <c:when test="${memberInfo.memberRole == 'admin'}">
       <a href="#">Go to admin page</a>
    </c:when>
    <c:otherwise>
       <a href="#">Apply for administration role</a>
    </c:otherwise>
</c:choose>

</body>
</html>