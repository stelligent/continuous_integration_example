<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
    <title>Online Brewery Manager</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>

    <link rel="stylesheet" href="css/style.css" type="text/css" media="all"/>
    <!--[if IE 6]>
    <link rel="stylesheet" href="css/ie6.css" type="text/css" media="all"/>
    <![endif]-->
    <link rel="shortcut icon" href="css/images/favicon.ico"/>

    <script src="js/jquery-1.4.2.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/jquery-ui-1.8.2.custom.min.js" type="text/javascript" charset="utf-8"></script>
    <!--[if IE 6]>
    <script src="js/png-fix.js" type="text/javascript" charset="utf-8"></script>
    <![endif]-->
    <script src="js/functions.js" type="text/javascript"></script>

</head>
<body>
<div class="header">
    <div class="shell">
        <h1 id="logo" class="notext"><a href="http://stelligent.com/">Online Brewery Manager</a></h1>

        <h2 class="slogan notext"><a href="http://stelligent.com/">Online Brewery Manager</a>
        </h2>
    </div>
</div>

<div class="heading">
    <div class="shell">
        <h2>Online Brewery Manager</h2>
    </div>
</div>

<div class="container">
<div class="shell">
<div class="main">
    <div class="main-t">
        <div class="main-b">

<FORM action="/brewery/Controller" method="post">
<INPUT TYPE="hidden" NAME="FROM_PAGE" VALUE="index">
<INPUT TYPE="hidden" NAME="TO_PAGE" VALUE="beer">
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

    </div>
</div>
</div>
</div>
</div>


</body>
</html>