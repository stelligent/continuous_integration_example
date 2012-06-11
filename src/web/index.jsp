<html>
<title>Login</title>
<head>
<link href="stylesheets/onsq.css" rel="stylesheet" type="text/css" />
</head>

<BODY BGCOLOR="White" LINK="#FFAA00" VLINK="#FFAA00" ALINK="#330066" LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH="0" MARGINHEIGHT="0">
<FORM action="/brewery/Controller" method="post">
<INPUT TYPE="hidden" NAME="FROM_PAGE" VALUE="index">
<INPUT TYPE="hidden" NAME="TO_PAGE" VALUE="beer">
<h3> Online Brewery Manager </h3>
<table align="center">
  <tr>
    <td><input type="text" name="username" id="username" value=""></td>
  </tr>
  <tr>
    <td><input type="password" name="password" id="password" value=""></td>
  </tr>  
  <tr>
    <td><INPUT type="submit" value="Login"></td>
  </tr>
</table>
</FORM>
</body>
</html>