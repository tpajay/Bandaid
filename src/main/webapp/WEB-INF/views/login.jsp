<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
    <!-- defined in Medicus-servlet.xml: <mvc:resources mapping="/resources/**" location="/resources/" /> -->
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css" />' />
    <link rel="stylesheet" href='<c:url value="/resources/css/medicus.css" />' />
    <link rel="stylesheet" href='<c:url value="/resources/css/app.css" />' />
    
    <!--no fonts.. <link rel="stylesheet" href='<c:url value="/resources/css/font-awesome.css" />' /> -->    
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
    
</head>
 
    <body>
        <div id="mainWrapper">
            <div class="login-container">
                <div class="login-card">
                    <div class="login-form">
                        <c:url var="loginUrl" value="/login" />
                        <form action="${loginUrl}" method="post" class="form-horizontal">
                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Invalid username and password.</p>
                                </div>
                            </c:if>
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>
                            
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                                <input type="text" class="form-control" id="username" name="loginId" placeholder="Enter Username" required>
                            </div>
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                            </div>
                            <div class="input-group input-sm">
                              <div class="checkbox">
                                <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>  
                              </div>
                            </div>                            
                            <!-- Cross Site Request Forgery (CSRF) -->
                            <!--  use the _csrf request attribute to obtain the current CsrfToken -->
                            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                                 
                            <div class="form-actions">
                                <input type="submit" class="btn btn-block btn-primary btn-default" value="Log in">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
 
    </body>
</html>