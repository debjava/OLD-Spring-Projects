<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
  <head>
    <title>Web Application for Spring</title>
  </head>
  <body>
    <h1>Sample Login Page for Spring Web Application</h1>
    <form:form commandName="Login">
    	 <table border="0">
            <tr>
                <td>
                    <fieldset>
                        <legend>&nbsp; Login &nbsp;</legend>
                        <table>
                            <tr> 
                              <td>Username</td>
                              <td>
                              	<form:input path="userName"/>
                              </td>
                            </tr>
                            <tr>&nbsp;</tr>
                            <tr> 
                              <td>Password</td>
                              <td>
                              	<form:input path="password"/>
                              </td>
                            </tr>
                            <tr>
                                <td/>
                                <td><input type="submit" name="Login" value="Login"/></td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
        </table>
    </form:form>
  </body>
</html>
