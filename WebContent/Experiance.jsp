<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ExperianceServlet" method = "post">
<h4>Work Experiance</h4>
<table> 
   <TR>
      <TD>Company</TD>
      <TD><input type = "text" name = "Company" ></TD>
  </TR>
 <TR>
      <TD>Position</TD>
      <TD><input type = "text" name = "Position" ></TD>
  </TR>

  <TR>
      <TD>Year of Experiance</TD>
      <TD><input type = "text" name = "Experiance" ></TD>
  </TR>
</table>
<br><input type = "submit" value = "ADD">
<a href = "Skill.jsp">NEXT</a>
</form>
</body>
</html>