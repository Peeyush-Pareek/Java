<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FirstJSP</title>
</head>
<body>
   <h2>Welcome to JSP</h2>
   <% 
      String name = "Peeyush";
      out.println("Hello " + name);
   %>

</body>
</html>
