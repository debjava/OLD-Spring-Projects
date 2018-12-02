<html>
  <head>
    <title>Web Application for Spring</title>
  </head>
  <body>
    <h1>Sample Login Page for Spring Web Application</h1>
    <form action="/springmvcweb6/authenticlogin.html" method="POST">
            <table border="0">
            <tr>
                <td>
                    <fieldset>
                        <legend>&nbsp; Login &nbsp;</legend>
                        <table>
                            <tr> 
                              <td>Username</td>
                              <td>
                                <input type="text" id="usernameId" name="username" value=""/>
                              </td>
                            </tr>
                            <tr>&nbsp;</tr>
                            <tr> 
                              <td>Password</td>
                              <td>
                                <input type="password" id="passwordId" name="password" value=""/>
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
    
    </form>
  </body>
</html>
