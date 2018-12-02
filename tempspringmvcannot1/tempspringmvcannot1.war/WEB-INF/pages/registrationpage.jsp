<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Registration Page - Developped by Debadatta Mishra</title>
</head>
<script type="text/javascript">
	function validate() {
		var flag = false;
		var pwd = document.getElementById("pwd").value;
		var pwd1 = document.getElementById("pwd1").value;
		if( pwd != pwd1 ) {
			alert("Passwords do not match");
			flag = false;
		}
		else {
			flag = true;
		}
		return flag;
	}
</script>
<body>

    <h1>Enter Following Information for Registration</h1>
    
    <form:form commandName="User" method="post" onsubmit="return validate()">
    	<table>
        <tr>
            <td>First Name : </td>
            <td>
            	<form:input path="firstName" type="text" name="firstName" value=""/>
            </td>
        </tr>
        <tr>
            <td>Last Name : </td>
            <td>
            	<form:input path="lastName" type="text" name="lastName" value=""/>
            </td>
        </tr>
        <tr>
            <td>Employee Id : </td>
            <td>
            	<form:input path="empId" type="text" name="empId" value=""/>
            </td>
        </tr>
        <tr>
        	<td>Password : </td>
        	<td>
        		<form:input path="password" type="password" id="pwd" name="pwd" value=""/>
            </td>
        </tr>
        <tr>
        	<td>Re-enter password : </td>
        	<td>
        		<form:input path="password" type="password" id="pwd1" name="pwd1" value=""/>
            </td>
        </tr>
        <tr>
            <td/>
            <td><input type="submit" value="Register" ></td>
        </tr>
    </table>
    </form:form>

</body>
</html>