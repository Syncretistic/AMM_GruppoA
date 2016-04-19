<%-- 
    Document   : login
    Created on : 15-apr-2016, 13.14.41
    Author     : Saverio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Login</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="description" content="User Login Page">
      <meta name="keywords" content="Tonino, Shop, Elettronica, Usato, Tablet, Smartphone, Login">
      <meta name="author" content="Saverio Salaris">
      <link rel="stylesheet" type="text/css" href="M2/style.css">
   </head>
   <body class="login">
      <%@ include file="header.jsp" %>
      <div class="container">
         <h1>Sign in</h1>
         <%@ include file="sidebar.jsp" %>
         <div class="content">
             <c:choose>
                <c:when test="${empty user}">
                    <div class="loginform">
                       <form method="get" action="login.html">
                          <div class="input-wrap">
                             <label for="user">Username</label>
                             <input id="user" type="text" name="user" >
                          </div>
                          <div class="input-wrap">
                             <label for="psw">Password</label>
                             <input id="psw" type="password" name="psw">
                          </div>
                            <c:if test="${not empty login_failed}">
                                <div class="error-msg">Login fallito. Prova di nuovo.</div>
                            </c:if> 
                          <input type="submit" name ="Submit" value="LOGIN" class="btn-std">
                       </form>
                    </div>
                </c:when>
                 <c:otherwise>
                     <p>Benvenuto ${user.fname}</p>
                 </c:otherwise>
             </c:choose>
         </div>
      <%@ include file="footer.jsp" %>
   </body>
</html>
