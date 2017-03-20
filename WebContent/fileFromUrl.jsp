<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Saisie URL</title>
</head>
<body>
<form action="FileFromURLServlet"  method="get" onsubmit="return 	validateUrl()" id="form">
Veuillez entrer une url: <input type="url" id="url" name="url" value="http://"/> <input type="submit" value="Afficher"/>
<script>
function validateUrl(){
	var s=document.getElementById("url").value;
	if(endsWith(s,".com") || endsWith(s,".en")|| endsWith(s,".net")|| endsWith(s,".eu")|| endsWith(s,".fr"))
	{
		alert("Url invalide, veuillez saisir une url de fichier texte");
		return false;
	}
	else{
		return true;
	}
	
}

function endsWith(str, suffix) {
    return str.indexOf(suffix, str.length - suffix.length) !== -1;
}
</script>
</form>
</body>
</html>
