<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<jsp:useBean id="question" scope="request" class="com.qapro.entity.Question"></jsp:useBean>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${question.id eq null}"> There is no question with this id </c:when>

	<c:otherwise>
		Question:<br></br>
		<c:out value="${question.text}"></c:out>
		
		<br></br>
		<c:forEach var="answer" items="${question.answers}">
			Answer: <c:out value="${answer.text}"></c:out>
			<br></br>
		</c:forEach>
		
		
	</c:otherwise>
</c:choose>



<form action="Voting">
	<input type="hidden" name="questionId" value="${question.id}"/>
	<input type="hidden" name="type" value="UP"/>
	 ${question.upVote} vote
	<button type="submit"><img width="20px" height="20px" src="assets/img/Hands-Thumb-Up-icon.png"></img></button>
</form>

<form action="Voting">

	<input type="hidden" name="questionId" value="${question.id}"/>
	<input type="hidden" name="type" value="DOWN"/>
	 ${question.downVote} vote
	<button type="submit"><img  width="20px" height="20px" src="assets/img/Hands-Thumb-Down-icon.png"></img></button>
</form>


</body>
</html>