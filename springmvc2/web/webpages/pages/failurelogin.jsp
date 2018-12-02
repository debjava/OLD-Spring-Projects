<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Failure Login Page - Developped by Debadatta Mishra</title>
</head>
<script language="javascript">
function getContextURLPath()
{
	var rootUrl = location.protocol;
	rootUrl = rootUrl+"//"+location.host
	var path = location.pathname;
	var tempStr = path.split('/');
	rootUrl = rootUrl+"/"+tempStr[1];
	return rootUrl;
}

function click() {
	location.href = getContextURLPath()+"/registrationpage.html";
}
</script>
<body>
    <h2>Invalid Login</h2>
    <p>
    </p>
    If you are not a valid user, please <a href="javascript:click();" >Click</a> here to make a registration.
</body>
</html>