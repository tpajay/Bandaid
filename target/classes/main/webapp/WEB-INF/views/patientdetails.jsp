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
      				<li><a href="patientlist">PATIENTS<span class="sr-only">(current)</span></a></li>
        			<li><a href="patient">NEW PATIENT</a></li>
        		</ul>
        	</div> <!-- end collapse navbar -->
		</div> <!-- end container -->
	</nav>
	
	<!-- <div class="container-fluid"> -->
	<div class="container-fluid">
		<div class="panel panel-default" id="panelGeneral">
			<div class="panel-heading" id="panelGeneralHeading">
				<h3 class="panel-title">Patient Details</h3>
			</div> <!-- end panelGeneralHeading-->
			<div class="panel-body" id="panelGeneralBody">
			
			<!-- BEGIN: content -->
			
			
			<table class="table table-bordered">
				<!-- <tr>
					<td>Patient ID:</td><td>${patient.patientId}</td>
				</tr>
				-->
				<tr class="detailstr">
					<td class="detailstd" ><strong><spring:message code="patient.nameFirst"/>:</strong></td><td>${patient.nameFirst}</td>
				</tr>
				<tr class="detailstr">
					<td><strong><spring:message code="patient.nameLast"/>:</strong></td><td>${patient.nameLast}</td>
				</tr>
				<tr class="detailstr">
					<td><strong><spring:message code="patient.homeStreetAddr1"/>:</strong></td><td>${patient.homeStreetAddr1}</td>
				</tr>
				<tr class="detailstr">
					<td><strong><spring:message code="patient.homeCity"/>:</strong></td><td>${patient.homeCity}</td>
				</tr>
				<tr class="detailstr">
					<td><strong><spring:message code="patient.homeState"/>:</strong></td><td>${patient.homeState}</td>
				</tr>
				<tr class="detailstr">
					<td><strong><spring:message code="patient.homeZipcode"/>:</strong></td><td>${patient.homeZipcode}</td>
				</tr>
				<tr class="detailstr">
					<td><strong><spring:message code="patient.phoneHome"/>:</strong></td><td>${patient.phoneHome}</td>
				</tr>	
			</table>
			
				<div class="panel panel-default">
					<div class="panel-heading">
						<!-- <span class="precords"><spring:message code="records"/></span> -->
						<h3 class="panel-title"><spring:message code="records"/></h3>
						<!-- <b><spring:message code="records"/></b> -->
					</div> <!-- end panel-heading -->
						<c:if test="${!empty patient.getRecords()}">
							<table class="table table-hover">
						    <tr style="background-color: #ce9c7d; color: white; text-align: left;" height="30px">
						     
						     <!-- <td>Record ID</td> -->
						     <td>Physician</td>
						     <td>Form Name</td>
						     <td></td>
						     <td></td>
						    </tr>
						    <c:forEach items="${patient.getRecords()}" var="record">
							     <tr
							      style="background-color: white; color: black; text-align: left;"
							      height="30px">
							      
							      <td>
							      	<c:out value="${record.getPhysicianId()}" />
							      </td>
							      <td>
							      	<c:out value="${record.getFormDisplayName()}" />
							      </td>
							      <!-- 
							      <td><a href="editrecord?id=${record.getFormId()}">View</a></td>
							      <td><a href="deleterecord?id=${record.getFormId()}">Delete</a></td>
							      -->
							      <!-- 
							      <td><a href="edit?id=${patient.patientId}">Edit</a></td>
							      <td><a href="delete?id=${patient.patientId}">Delete</a></td>
							      -->      
							     </tr>
						    </c:forEach>
						   </table>
						  </c:if>
						 </div>
			
			<!-- END: content -->			
			
			</div> <!-- end panelGeneralBody -->
		</div> <!-- end panelGeneral -->
	</div> <!-- end container -->

<!-- &nbsp&nbsp&nbsp<a href="deletePatient?id=${patient.patientId}">delete patient & all records ()</a> -->

</body>
</html>