<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p> Affichage du JSON </p>
	<div id="json"> 
	</div>
	
	<script type="text/javascript">

		var json = <% out.println((String)request.getAttribute("json")); %>;
		var jsonPretty = JSON.stringify(json,null,2);
		jsonPretty = jsonPretty.replace(/\n/g, "<br />");
		jsonPretty = jsonPretty.replace(/\t/g, "&nbsp;&nbsp;&nbsp;&nbsp;");
		document.getElementById('json').innerHTML=jsonPretty;
		
	</script>
</body>
</html>