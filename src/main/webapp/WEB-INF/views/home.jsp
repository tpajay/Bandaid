<!DOCTYPE html>
<html lang="en-US">

  <head>
    <meta charset="UTF-8" />
    <title>Bandaid AngularJS and REST</title>
    
	<!--  src="${pageContext.request.contextPath}/app-resources -->
    <script src="/Bandaid/app-resources/js/lib/angular.min.js"></script>
    <script src="/Bandaid/app-resources/js/lib/angular-resource.min.js"></script>
	<script src="/Bandaid/app-resources/js/app.js"></script>
	<link rel="stylesheet" type="text/css" href="/app-resources/css/style.css"/>
  </head>

  <body ng-app="myApp">
  	<div ng-controller="PersonController as pController">

	  	<form name="personForm" method="POST">
	  		<table>
	  			<tr>
	  				<td colspan="2">
	  					<div ng-if="pController.flag != 'edit'">
	  						<h3> Add New Person </h3>
	  					</div>
	  					<div ng-if="pController.flag == 'edit'">
	  						<h3> Update Person for ID: {{ pController.person.pid }} </h3>
	  					</div>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td>Name: </td>
	  				<td>
	  					<input type="text" name="name" ng-model="pController.person.name" required/>
	  					<span ng-show="personForm.name.$error.required" class="msg-val">Name is required.</span>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td>Location: </td>
	  				<td>
	  					<input type="text" name="location" ng-model="pController.person.location" required/>
	  					<span ng-show="personForm.location.$error.required" class="msg-val">Location is required.</span>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td colspan="2"> 
	  					<span ng-if="pController.flag=='created'" class="msg-success">Person successfully added.</span>
	  					<span ng-if="pController.flag=='failed'" class="msg-val">Person already exists.</span>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td colspan="2">
	  					<div ng-if="pController.flag != 'edit'">
	  						<input  type="submit" ng-click="pController.addPerson()" value="Add Person"/>
	  						<input type="button" ng-click="pController.reset()" value="Reset"/>
	  					</div>
	  					<div ng-if="pController.flag == 'edit'">
	  						<input  type="submit" ng-click="pController.updatePersonDetail()" value="Update Person"/>
	  						<input type="button" ng-click="pController.cancelUpdate()" value="Cancel"/>
	  					</div>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td colspan="2"> <span ng-if="pController.flag=='deleted'" class="msg-success">Person successfully deleted.</span>
	  			</tr>
	  		</table>
	  		
	  		</form>
	  			<table>
	  				<tr>
	  					<th>ID </th>
	  					<th>Name</th> <th>Location</th>
	  				</tr>
	  				<tr ng-repeat="row in pController.persons">
	  					<td><span ng-bind="row.pid"></span></td>
	  					<td><span ng-bind="row.name"></span></td>
	  					<td><span ng-bind="row.location"></span></td>
	  					<td>
	  						<input type="button" ng-click="pController.deletePerson(row.pid)" value="Delete"/>
	  						<input type="button" ng-click="pController.editPerson(row.pid)" value="Edit"/>
	  						<span ng-if="pController.flag=='updated' && row.pid==pController.updatedId" class="msg-success">Person successfully updated.</span>
	  					</td>
	  				</tr>
	  			</table>
  		</div>

 </body>
</html>  
  