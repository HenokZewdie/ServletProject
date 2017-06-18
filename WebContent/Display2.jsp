<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="jumbotron text-center">
  <h1>Your Personal Profile</h1>
  
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <h3>Personal Information</h3>
      <p>Full Name</p>
      <p>${FullNameSession}</p>
    </div>
    
    <div class="col-sm-4">
      <h3>Contact Address</h3>
      <p>Email</p>
      <p>${EmailSession}</p>
    </div>
    
    <div class="col-sm-4">
      <h3>Educational Background</h3>
      <p>Education</p>
      <table> <c:forEach items="${EducALSession}" var="Educ">   
    <tr>      
        <td>${Educ} </td>
    </tr>
    </c:forEach></table>
     
    </div>
    
    <div class="col-sm-4">
      <h3> Career</h3>
      <p>Work Experience</p>
      <table><c:forEach items="${ExpALSession}" var="Exp">
    <tr>      
        <td>${Exp} </td>
    </tr>
    </c:forEach></table>
    </div>
    
    <div class="col-sm-4">
      <h3>Skills</h3> <table><c:forEach items="${SkillSession}" var="Skill">
     
    <tr>      
        <td>${Skill} </td>
    </tr>
</c:forEach></table>       
      
  
    </div>
  </div>
</div>
</body>
</html>