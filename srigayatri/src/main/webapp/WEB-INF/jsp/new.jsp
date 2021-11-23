<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
#map {
       	margin: 0;
           padding: 0;
           width: 100%;
           height: 100%;
      }
      body{
      background-color:white;
      }
</style>

<div class="container">
	<div class="row">
		<div class="col">		
			<div id="map" class="map">
    		</div>
		
		</div>
		
		<div class="col">
		
		<div class="form-group">
				<label for="basicInputTypeText">Phone Number</label> 
				<input
					class="form-control" id="phoneNumber"
					placeholder="Phone Number" type="text" />
					
				<br/>
				
				<button class="btn btn-primary" id ="getUserDetails" type="button">Get User Details</button>
				
				
				<div class="row">
					<div class="col">
						<label for="personal_fname" style="float: left"><spring:message
								code="firstName" /></label> <input type="text" class="form-control"
							id="firstName" name="firstName" value="" readonly/>
					</div>
				</div>

				<div class="row">
					<div class="col">
						<label for="personal_lname" style="float: left"><spring:message
								code="lastName" /></label> <input type="text" class="form-control"
							id="lastName" name="lastName" value="" />
					</div>
				</div>

				<div class="row">
					<div class="col">
						<label for="personal_email" style="float: left"><spring:message
								code="emailId" /></label> <input type="text" class="form-control"
							id="emailId" name="emailId" value="" />
					</div>
				</div>

			
				
		</div>
		
		
		</div>
	
	
	
	</div>
</div>