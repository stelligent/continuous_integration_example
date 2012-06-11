<html>
<title>Brewery</title>
<head>
<link href="stylesheets/onsq.css" rel="stylesheet" type="text/css" />
</head>

<BODY BGCOLOR="White" LINK="#FFAA00" VLINK="#FFAA00" ALINK="#330066" LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH="0" MARGINHEIGHT="0">
<FORM action="/brewery/Controller" method="post">
<INPUT TYPE="hidden" NAME="FROM_PAGE" VALUE="editbeer">
<INPUT TYPE="hidden" NAME="TO_PAGE" VALUE="beer">
<table align="center">
  <tr><td colspan="2"><b>Beer</b></td></tr>
  <tr>
    <td>Beer Name: </td><td><input type="text" name="beer_name" id="beer_name" value="" length="30" /></td>
  </tr>
  <tr>
    <td>Brewer: </td><td><input type="text" name="brewer" id="brewer" value="" length="30" /></td>
  </tr>
  <tr>
    <td>Date Received: </td><td><input type="text" name="date_received" id="date_received" value="" length="30" /></td>
  </tr>
  <tr>
    <td><input type="submit" name="save" id="save" value="Save" /></td>
  </tr>
</table>
</FORM>
</body>
</html>