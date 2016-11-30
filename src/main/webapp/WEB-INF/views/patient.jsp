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

<!-- 
	1. Describe the Bootstrap grid layout
	2. Add the rows and cols [container - panels(headers) - row - cols]
		for smaller forms could use <form class="form-inline"> instead of cols
			eg. name/email/submit, email/password/login
	3. Add form fields
	4. Add field validation and proper formatting eg. email/phone number
-->

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
        			<li><a class="activenavlink" href="patient">NEW PATIENT</a></li>
        		</ul>
        	</div> <!-- end collapse navbar -->
		</div> <!-- end container -->
	</nav>


	<!-- <div class="container-fluid"> -->
	<div class="container-fluid">
	<form:form method="POST" action="/Medicus/addpatient" commandName="patient">
			
			<!-- BEGIN: content -->
			
			<!-- possibly add submit button on top page -->
			<!-- <button type="submit" class="btn btn-secondary">Submit</button> -->
			
				<!-- prefix, first, middle, last, suffix -->
				<div class="panel panel-default" id="panelGeneral">
					<div class="panel-heading" id="panelGeneralHeading">
						<h3 class="panel-title">Patient Details</h3>
					</div> <!-- end panelGeneralHeading-->
					<div class="panel-body" id="panelGeneralBody">
											
						<div class="row" id="row1">
							<div class="col-md-1" id="row1Col1">
								<div class="form-group">
									<label for="namePrefix"><spring:message code="patient.namePrefix"/></label>
									<form:input path="namePrefix" cssClass="form-control" placeholder="Prefix" />								
								</div>
							</div><!-- end row1Col1 -->
							<div class="col-md-2" id="row1Col2">
								<div class="form-group">
									<label for="nameFirst"><spring:message code="patient.nameFirst"/></label>
									<form:input path="nameFirst" cssClass="form-control" placeholder="First Name" />
									<form:errors path="nameFirst" cssClass="medicusformerror" />
								</div>
							</div><!-- end row1Col2 -->
							<div class="col-md-2" id="row1Col3">
								<div class="form-group">
									<label for="nameMiddle"><spring:message code="patient.nameMiddle"/></label>
									<form:input path="nameMiddle" cssClass="form-control" placeholder="Middle Name"  />
								</div>				
							</div><!-- end row1Col3 -->
							<div class="col-md-2" id="row1Col4">
								<div class="form-group">
									<label for="nameLast"><spring:message code="patient.nameLast"/></label>
									<form:input path="nameLast" cssClass="form-control" placeholder="Last Name"  />
									<form:errors path="nameLast" cssClass="medicusformerror" />
								</div>
							</div><!-- end row1Col4 -->
							<div class="col-md-1" id="row1Col5">
								<div class="form-group">
									<label for="nameSuffix"><spring:message code="patient.nameSuffix"/></label>
									<form:input path="nameSuffix" cssClass="form-control" placeholder="Suffix"  />
								</div>
							</div><!-- end row1Col5 -->
						</div> <!-- end row1 -->
						
						<!-- ssn(last4), DOB, homePhone, workPhone, mobilePhone -->
						<div class="row" id="row2">
							<div class="col-md-2" id="row2Col1">
								<div class="form-group">
									<label for="ssn"><spring:message code="patient.ssn"/></label>
									<form:input path="ssn" cssClass="form-control" placeholder="####"  />
								</div>						
							</div><!-- end row2Col1 -->
							<div class="col-md-2" id="row2Col2">
								<div class="form-group">
									<label for="dob"><spring:message code="patient.dob"/></label>
									<form:input path="dob" cssClass="form-control" type="date" placeholder="MM/DD/YYYY"  />
								</div>						
							</div><!-- end row2Col2 -->
						</div> <!-- end row2 -->
						
						<div class="row" id="row3">
							<div class="col-md-2" id="row3Col1">
								<div class="form-group">
									<label for="phoneHome"><spring:message code="patient.phoneHome"/></label>
									<form:input path="phoneHome" cssClass="form-control" placeholder="###-###-####"  />
								</div>						
							</div><!-- end row3Col1 -->
							<div class="col-md-2" id="row3Col2">
								<div class="form-group">
									<label for="phoneWork"><spring:message code="patient.phoneWork"/></label>
									<form:input path="phoneWork" cssClass="form-control" placeholder="###-###-####"  />
								</div>						
							</div><!-- end row3Col2 -->
							<div class="col-md-2" id="row3Col3">
								<div class="form-group">
									<label for="phoneMobile"><spring:message code="patient.phoneMobile"/></label>
									<form:input path="phoneMobile" cssClass="form-control" placeholder="###-###-####"  />
								</div>
							</div><!-- end row3Col3 -->
						</div> <!-- end row3 -->
												
						<div class="row" id="rowDueDttm">
							<div class="col-md-3" id="rowDueDttmCol1">
								<div class="form-group">
									<label for="dueDttm">
										<spring:message code="patient.dueDateTime"/> (MM/DD/YYYY HH:MM 24hr)</label>
										<small class="form-text text-muted">
											<br/>*Future date/time, please attempt to break validation
										</small>
									<form:input path="dueDttm" cssClass="form-control" placeholder="MM/DD/YYYY HH:MM (24h format)" />
									<form:errors path="dueDttm" cssClass="medicusformerror" />
								</div>						
							</div><!-- end rowDueDttmCol1 -->							
						</div> <!-- end rowDueDttm -->
						
					</div> <!-- end panelGeneralBody -->					
				</div> <!-- end mainPanelGeneral -->
					
				<!-- emergency contact, emergency contact number -->
				<div class="panel panel-default" id="panelEmergency">
					<div class="panel-heading" id="panelEmergencyHeading">
						<h3 class="panel-title">Emergency Contact</h3>
					</div> <!-- end panelEmergencyHeading-->
					<div class="panel-body" id="panelEmergencyBody">
						<div class="row" id="row4">
							<div class="col-md-3" id="row4Col1">
								<div class="form-group">
									<label for="emergencyContact"><spring:message code="patient.emergencyContact"/></label>
									<form:input path="emergencyContact" cssClass="form-control" placeholder="Contact Name"  />
								</div>							
							</div><!-- end row4Col1 -->
							<div class="col-md-3" id="row4Col2">
								<div class="form-group">
									<label for="emergencyPhone"><spring:message code="patient.emergencyPhone"/></label>
									<form:input path="emergencyPhone" cssClass="form-control" placeholder="###-###-####"  />
								</div>							
							</div><!-- end row4Col2 -->
						</div> <!-- end row4 -->
					</div> <!-- end panelEmergencyBody -->
				</div> <!-- end panelEmergency -->
				
				<!-- email address, email address verification -->
				<div class="panel panel-default" id="panelEmail">
					<div class="panel-heading" id="panelEmailHeading">
						<h3 class="panel-title">Email/Password [Your site Login Credentials]</h3>
					</div> <!-- end panelEmailHeading-->
					<div class="panel-body" id="panelEmailBody">
						<div class="row" id="row5">
							<div class="col-md-3" id="row5Col1">
								<div class="form-group">
									<label for="email"><spring:message code="patient.email"/></label>
									<form:input path="email" type="email" cssClass="form-control" placeholder="Email Address"  />
									<form:errors path="email" cssClass="medicusformerror" />
								</div>							
							</div><!-- end row5Col1 -->
							<div class="col-md-3" id="row5Col2">
								<div class="form-group">
									<label for="emailVerify"><spring:message code="patient.emailVerify"/></label>
									<form:input path="emailVerify" type="email" cssClass="form-control" placeholder="Please verify your email address"  />
								</div>
							</div><!-- end row5Col2 -->							
						</div> <!-- end row5 -->
						<div class="row" id="row6">
						
							<div class="col-md-3" id="row6Col1">
								<div class="form-group">
									<label for="password"><spring:message code="patient.password"/></label>
									<form:input path="password" type="password" cssClass="form-control" placeholder="Password"  />
									<form:errors path="password" cssClass="medicusformerror" />
								</div>							
							</div><!-- end row5Col1 -->
							<div class="col-md-3" id="row6Col2">
								<div class="form-group">
									<label for="passwordVerify"><spring:message code="patient.passwordVerify"/></label>
									<form:input path="passwordVerify" type="password" cssClass="form-control" placeholder="Please verify your password"  />
								</div>
							</div><!-- end row5Col2 -->						
						
						</div> <!-- end row6 -->
					</div> <!-- end panelEmailBody -->
				</div> <!-- end panelEmail -->
				
				<!-- HOME ADDRESS INFO -->
				<!-- address1 -->
				<!-- address2 -->
				<!-- city, zipcode -->
				<!-- state, country -->
				<div class="panel panel-default" id="panelHomeAddr">
					<div class="panel-heading" id="panelHomeAddrHeading">
						<h3 class="panel-title">Home</h3>
					</div> <!-- end panelHomeAddrHeading-->
					<div class="panel-body" id="panelHomeAddrBody">
						<div class="row" id="homeAddrRow1">
							<div class="col-md-3" id="homeAddrRow1Col1">
								<div class="form-group">
									<label for="homeStreetAddr1"><spring:message code="patient.homeStreetAddr1"/></label>
									<form:input path="homeStreetAddr1" cssClass="form-control" placeholder="Street"  />
								</div>							
							</div><!-- end homeAddrRow1Col1 -->
							<div class="col-md-3" id="homeAddrRow1Col2">
								<div class="form-group">
									<label for="homeStreetAddr2"><spring:message code="patient.homeStreetAddr2"/></label>
									<form:input path="homeStreetAddr2" cssClass="form-control" placeholder="Suite/PO Box/Apt"  />
								</div>							
							</div><!-- end homeAddrRow1Col2 -->							
						</div> <!-- end homeAddrRow1 -->						
						<div class="row" id="homeAddrRow3">
							<div class="col-md-2" id="homeAddrRow3Col1">
								<div class="form-group">
									<label for="homeCity"><spring:message code="patient.homeCity"/></label>
									<form:input path="homeCity" cssClass="form-control" placeholder="City"  />
								</div>							
							</div><!-- end homeAddrRow3Col1 -->
							<div class="col-md-1" id="homeAddrRow3Col2">
								<div class="form-group">
									<label for="homeState"><spring:message code="patient.homeState"/></label>
									<form:input path="homeState" cssClass="form-control" placeholder="State"  />
								</div>							
							</div><!-- end homeAddrRow3Col2 -->
						</div> <!-- end homeAddrRow3 -->
						<div class="row" id="homeAddrRow4">
							<div class="col-md-2" id="homeAddrRow4Col1">
								<div class="form-group">
									<label for="homeZipcode"><spring:message code="patient.homeZipcode"/></label>
									<form:input path="homeZipcode" cssClass="form-control" placeholder="Zipcode"  />
								</div>							
							</div><!-- end homeAddrRow4Col1 -->
							<div class="col-md-2" id="homeAddrRow4Col2">
								<div class="form-group">
									<label for="country"><spring:message code="patient.country"/></label>
									<form:input path="country" value="United States" cssClass="form-control" placeholder="Country"  />
								</div>
							</div><!-- end homeAddrRow4Col2 -->
						</div> <!-- end homeAddrRow4 -->
					</div> <!-- end panelHomeAddrBody -->
				</div> <!-- end panelHomeAddr -->
				
				<!-- WORK ADDRESS INFO -->
				<!-- address1 -->
				<!-- address2 -->
				<!-- city, zipcode -->
				<!-- state, country -->
				<div class="panel panel-default" id="panelWorkAddr">
					<div class="panel-heading" id="panelWorkAddrHeading">
						<h3 class="panel-title">Work</h3>
					</div> <!-- end panelWorkAddrHeading-->
					<div class="panel-body" id="panelWorkAddrBody">
						<div class="row" id="workAddrRow1">
							<div class="col-md-3" id="workAddrRow1Col1">
								<div class="form-group">
									<label for="workStreetAddr1"><spring:message code="patient.workStreetAddr1"/></label>
									<form:input path="workStreetAddr1" cssClass="form-control" placeholder="Street"  />
								</div>							
							</div><!-- end workAddrRow1Col1 -->
							<div class="col-md-3" id="workAddrRow1Col2">
								<div class="form-group">
									<label for="workStreetAddr2"><spring:message code="patient.workStreetAddr2"/></label>
									<form:input path="workStreetAddr2" cssClass="form-control" placeholder="Suite/PO Box/Apt"  />
								</div>							
							</div><!-- end workAddrRow1Col2 -->
						</div> <!-- end workAddrRow1 -->
						<div class="row" id="workAddrRow3">
							<div class="col-md-3" id="workAddrRow3Col1">
								<div class="form-group">
									<label for="workCity"><spring:message code="patient.workCity"/></label>
									<form:input path="workCity" cssClass="form-control" placeholder="City"  />
								</div>							
							</div><!-- end workAddrRow3Col1 -->
							<div class="col-md-2" id="workAddrRow3Col2">
								<div class="form-group">
									<label for="workState"><spring:message code="patient.workState"/></label>
									<form:input path="workState" cssClass="form-control" placeholder="State"  />
								</div>							
							</div><!-- end workAddrRow3Col2 -->
						</div> <!-- end workAddrRow3 -->
						<div class="row" id="workAddrRow4">
							<div class="col-md-3" id="workAddrRow4Col1">
								<div class="form-group">
									<label for="workZipcode"><spring:message code="patient.workZipcode"/></label>
									<form:input path="workZipcode" cssClass="form-control" placeholder="Zipcode"  />
								</div>							
							</div><!-- end workAddrRow4Col1 -->
						</div> <!-- end workAddrRow4 -->
					</div> <!-- end panelWorkAddrBody -->
				</div> <!-- end panelWorkAddr -->				
				
				<button type="submit" class="btn btn-secondary">Submit</button>
				
				<br/><br/><br/><br/>
				
				
			<!-- END: content -->
			
	</form:form>
	</div> <!-- end container -->
</body>
</html>