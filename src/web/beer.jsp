<html>
<title>Brewery</title>
<head>
<link href="stylesheets/onsq.css" rel="stylesheet" type="text/css" />
</head>

<%
com.beer.business.service.BeerService beerService = new com.beer.business.service.BeerServiceImpl();
java.util.Collection beers =  beerService.findAll();
java.util.Iterator itor = beers.iterator();
String name = null;
String brewer = null;
String dateReceived = null;
%>

<BODY BGCOLOR="White" LINK="#FFAA00" VLINK="#FFAA00" ALINK="#330066" LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH="0" MARGINHEIGHT="0">
<FORM action="/brewery/Controller" method="post">
<INPUT TYPE="hidden" NAME="FROM_PAGE" VALUE="beer">
<INPUT TYPE="hidden" NAME="TO_PAGE" VALUE="editbeer">
<table align="center">
  <tr><td colspan="2"><b>Beer</b></td></tr>
  <%
   while (itor.hasNext()) {
     com.beer.business.domain.Beer beer = (com.beer.business.domain.Beer) itor.next(); 
     name = beer.getName();
     brewer = beer.getBrewer();
     dateReceived = beer.getDateReceived();
   %>    
   <tr>
   <td><%=name%></td>
   <td><%=brewer%></td>
   <td><%=dateReceived%></td>
   </tr>
   <%
     }
   %>
   <tr>
     <td><input type="submit" name="add" id="add" value="Add New Beer" /></td>
   </tr>
   <%= request.getAttribute("userMessage") %>
</table>
</FORM>
</body>
</html>