<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="EducationServlet" method = "post">
<h4>Educational Background</h4>
<table> 
   <TR>
      <TD>University</TD>
      <TD><input type = "text" name = "University" ></TD>
  </TR>
 <TR>
      <TD>Major</TD>
      <TD><input type = "text" name = "Major" ></TD>
  </TR>

  <TR>
      <TD>Year of Grad.</TD>
      <TD><input type = "text" name = "Year" ></TD>
  </TR>
</table>
<br><input type = "submit" value = "ADD">
<a href = "Experiance.jsp">NEXT</a>
</form>
<p> -> Press Next to continue to Experience</p> 
</body>
</html>