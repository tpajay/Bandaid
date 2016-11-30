<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Patient</title>
    <!-- defined in Medicus-servlet.xml: <mvc:resources mapping="/resources/**" location="/resources/" /> -->
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css" />' />
    <link rel="stylesheet" href='<c:url value="/resources/css/medicus.css" />' />
</head>

<body>

	<nav class="navbar navbar-default navbar-inverse navbar-static-top navbg">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand adjustlogo" href="patientlist">
					<img alt="Medicus" src="<c:url value="/resources/images/logo_200px_bluewhite2.png" />" />
				</a>
			</div> <!-- end navbar header -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      			<ul class="nav navbar-nav navbar-left">
      				<li><a class="activenavlink" href="patientlist">PATIENTS<span class="sr-only">(current)</span></a></li>
        			<li><a href="patient">NEW PATIENT</a></li>
        		</ul>
        	</div> <!-- end collapse navbar -->
		</div> <!-- end container -->
	</nav>


	<div class="container-fluid">
		<div class="panel panel-default" id="panelGeneral">
			<div class="panel-heading" id="panelGeneralHeading">
				<h3 class="panel-title">Patient List</h3>
			</div> <!-- end panelGeneralHeading-->
			<div class="panel-body" id="panelGeneralBody">
			
			<!-- BEGIN: content -->
			
			  <c:if test="${!empty patientList}">
			  <div class="container-fluid">
			   <table class="table table-striped table-bordered" cellspacing="0" width="100%">
			    <tr style="background-color: #ce9c7d; color: white; text-align: center;" height="30px">
			     <td>Last Name</td>
			     <td>First Name</td>
			     <td>Address</td>
			     <td>Phone</td>
			    </tr>
			    <c:forEach items="${patientList}" var="patient">
				     <tr style="background-color: white; color: black; text-align: center;" height="30px">	            
				      <td>
				      	<a href="patientdetails?id=${patient.patientId}"><c:out value="${patient.nameLast}" /></a>	      	
				      </td>
				      <td>
				      	<c:out value="${patient.nameFirst}" />
				      </td>
				      <td>
				      	<c:out value="${patient.homeStreetAddr1}" />
				      </td>
				      <td>
				      	<c:out value="${patient.phoneHome}" />
				      </td>
				     </tr>
			    </c:forEach>
			   </table>
			   </div>
			  </c:if>		
			
			<!-- END: content -->
					
			</div> <!-- end panelGeneralBody -->
		</div> <!-- end panelGeneral -->
	</div> <!-- end container -->

</body>
</html>