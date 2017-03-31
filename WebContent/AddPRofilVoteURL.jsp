<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profil de Vote</title>
</head>
<body>
<h1>Add Profil Vote URL</h1>
<form action="AddProfilVoteURLServlet" method="post" enctype="multipart/form-data">
    NAME OF VOTE :  <input type="text" name="nameProfilVote"  /><br /><br />
    URL  OF VOTE :  <input type="text" name="profilVoteUrl" />
    <input type="submit"  value="SEND"/>
</form>
</body>
</html>