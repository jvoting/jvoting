<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saisie d'un profil de vote</title>
</head>
<body>
<form name="profile" action="InsertProfile"  method="POST">
<textarea name="profil" rows="70" cols="250">
Veuillez saisir un profil de vote au format preflib
</textarea>
<input type="submit" value="Valider"></input>
</form>

<!--<script type="text/javascript" >
function validerNBC(){
	var n= document.getElementById("1").value;
	var s= document.createElement("select");
	for(var i=0;i<n;i++){
		var t=document.createElement("input");
		t.setAttribute('type','text');
		t.setAttribute('value','nom du candidat');
		t.setAttribute('id','nom'+i);
		document.getElementsByTagName('body')[0].appendChild(t);
		
		}
}
</script>
Veuillez saisir le nombre de candidats: <input type="text" id="1" name="nbC"></input>
<input type="button" id="test" onclick="validerNBC()">CLICKIT</input>-->

</body>

</html>