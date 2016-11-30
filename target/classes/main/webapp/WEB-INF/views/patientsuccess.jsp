<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Patient Success</title>
    <!-- had to define in Medicus-servlet.xml: <mvc:resources mapping="/resources/**" location="/resources/" /> -->
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css" />' />
</head>

<body>

	<strong>Patient First Name: ${patient.nameFirst}</strong><br>
	<strong>Patient Last Name: ${patient.nameLast}</strong><br>
	<strong>Due Date/Time: ${patient.dueDttm}</strong><br>

</body>
</html>