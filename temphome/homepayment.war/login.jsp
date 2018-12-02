<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Home Payment System</title>
<SCRIPT type="text/javascript">
function validate() 
{
	var userType = "NORMAL";
	var errorHtml = "";
	var userName = document.getElementById("usernameId").value;
	var password = document.getElementById("passwordId").value;
	if(userName=='') {
		errorHtml = errorHtml+"<li>User name can not be blank.";
	}
	if(password == '') {
		errorHtml = errorHtml+"<li>Password can not be blank.";
	}
	var adminCheck = document.getElementById("admincheckId");
	if(adminCheck.checked == true)
		userType = "ADMIN"
	else {
		userType = "NORMAL"
	}
	adminCheck.value = userType;	
	document.getElementById("errMsgId").innerHTML = errorHtml;
	if( errorHtml =="") {
		return true;
	}	
	else {
		return false;
	}	
	
}
</SCRIPT>
</head>
<body>
	<h1>Home Payment System</h1>
	<form action="/homepayment/authenticlogin.html" method="POST" onsubmit="return validate()">
		
		<!-- Left Div -->
		<div
			style="position: absolute; left: 10px; width: 370; height: 270; border: 1px solid green">
			<table border="0">
				<tr>
					<td>
						<fieldset>
							<legend>&nbsp; Login &nbsp;</legend>
							<table>
								<tr>
									<td>Username</td>
									<td><input type="text" id="usernameId" name="username" value="" /></td>
									<td/>
								</tr>
								<tr>&nbsp;</tr>
								<tr>
									<td>Password</td>
									<td><input type="password" id="passwordId" name="password" value="" /></td>
									<td/>
								</tr>
								<tr>
									<td/>
									<td>
										<input type="submit" name="Login" value="Login" />
										<input type="checkbox" name="admin" value="admin" id="admincheckId">Administrator
									</td>
									<td/>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</div>

		<!-- Right Div for Error display -->
		<div style="position: absolute; left: 400px; width: 400px; height: 270px;">
			<div id="errMsgId" style="color: red;">
				<!-- <c:out value="${requestScope.serverError}"/> -->
				<c:out value="${serverError}"/>
			</div>
		</div>

	</form>
</body>
</html>
