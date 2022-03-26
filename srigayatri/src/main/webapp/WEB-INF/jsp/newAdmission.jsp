<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
body{
background-color:white;
}
</style>
<script>
$(document).ready(function(){
	var stdList = ["","1","2","3","4","5","6","7","8","9","10"]
	$("#admissionFees,#termOne,#termTwo,#termThree,#termFour,#transportationFees,#examFees,#otherFees,#admissionFees").keyup(function(){
		ids = ["termOne","termTwo","termThree","termFour","transportationFees","examFees","otherFees","admissionFees"]
		for(i=0;i<ids.length;i++){
			if($("#"+ids[i]).val() == "" && ids[i] != this.id){
				$("#"+ids[i]).val(0);
			}
		}
		$("#totalFees").val(parseInt($("#termOne").val())
						  + parseInt($("#termTwo").val())
						  + parseInt($("#termThree").val())
						  + parseInt($("#termFour").val())
						  + parseInt($("#transportationFees").val())
		  			      + parseInt($("#examFees").val())
		  			      + parseInt($("#otherFees").val())
		  			      + parseInt($("#admissionFees").val()))
						});
	$("#std").keyup(function(){
		if(stdList.indexOf($("#std").val()) <= -1){
			$("#admissionNumber").addClass("disabled");
		}else{
			$("#admissionNumber").removeClass("disabled");
		}
	});
});
</script>
<div class="container">
	<a aria-controls="accordion03CollapseTwo"
		aria-expanded="true" class="collapse-icon sheet-subtitle"
		data-toggle="collapse" href="#accordion03CollapseTwo"
		id="accordion03HeadingTwo" role="tab"> <span>New Student</span> <span
		class="collapse-icon-closed"> <svg
				class="lexicon-icon lexicon-icon-angle-right" focusable="false"
				role="presentation">
							<use href="/images/icons/icons.svg#angle-right"></use>
						</svg>
	</span> <span class="collapse-icon-open"> </span>
	</a>

	<div class="panel-body">
		<a aria-controls="accordion03CollapseTwo" aria-expanded="true"
			class="collapse-icon sheet-subtitle" data-toggle="collapse"
			href="#accordion03CollapseTwo" id="accordion03HeadingTwo" role="tab">
			<span>Student Details</span> <span class="collapse-icon-closed">
				<svg class="lexicon-icon lexicon-icon-angle-right" focusable="false"
					role="presentation">
							<use href="/images/icons/icons.svg#angle-right"></use>
						</svg>
		</span> <span class="collapse-icon-open"> </span>
		</a>
		<form:form method="post" id="newStudentForm" action="newAdmission" modelAttribute="newStudent">
			<div class="row">
				<div class="col">
					<label for="personal_fname" style="float: left">Student
						Admission Number</label> <input type="text" class="form-control"
						id="admissionNumber" name="admissionNumber" value="" required/>
				</div>
				<div class="col">
					<label for="personal_lname" style="float: left">Student
						Date Of Joining</label> <input type="text" class="form-control"
						id="dateOfJoining" name="dateOfJoining" value="" required/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label for="personal_fname" style="float: left">Student
						First Name</label> <input type="text" class="form-control" id="studentFirstName"
						name="studentFirstName" value="" required/>
				</div>
				<div class="col">
					<label for="personal_lname" style="float: left">Student
						Last Name</label> <input type="text" class="form-control" id="studentLastName"
						name="studentLastName" value="" required/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label for="personal_email" style="float: left">Student
						Aadhar</label> <input type="text" class="form-control" id="aadhar"
						name="aadhar" value="" required/>
				</div>
				<div class="col">
					<label for="personal_phoneNumber" style="float: left">Student
						DOB</label> <input type="text" class="form-control" id="dob"
						name="dob" value="" required/>
				</div>
			</div>
			</br>
			<div class="row">
				<div class="col">
					<label for="personal_email" style="float: left">Student
						Gender</label> <select id="gender" name="gender" class="form-control" required>
						<option value="">-Select-</option>
						<option value="F">Female</option>
						<option value="M">Male</option>
						<option value="O">Other</option>
					</select>
				</div>
				<div class="col">
					<label for="personal_phoneNumber" style="float: left">Student
						Class Admission</label><input class="form-control" type="text" id="std" name="std" required/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label for="personal_email" style="float: left">Mole</label> 
					<input type="text" class="form-control"
						id="mole1" name="mole1" value="" required/>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col">
					<label for="personal_email" style="float: left">Mole</label> 
					<input type="text" class="form-control"
						id="mole2" name="mole2" value="" required/>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col">
					<label for="personal_email" style="float: left">Student
						Previous School</label> <input type="text" class="form-control"
						id="previousSchoolName" name="previousSchoolName" value="" required/>
				</div>
			</div>
			<br />
			<a aria-controls="accordion03CollapseThree" aria-expanded="true"
				class="collapse-icon sheet-subtitle" data-toggle="collapse"
				href="#accordion03CollapseThree" id="accordion03HeadingThree"
				role="tab"> <span>Fees Details</span> <span
				class="collapse-icon-closed"> <svg
						class="lexicon-icon lexicon-icon-angle-right" focusable="false"
						role="presentation">
							<use href="/images/icons/icons.svg#angle-right"></use>
						</svg>
			</span> <span class="collapse-icon-open"> </span>
			</a>
			<div class="row">
				<div class="col">
					<label>Admission Fees</label> <input class="form-control" id="admissionFees"
						name="admissionFees" type="tel" required/>
				</div>
				<div class="col">
					<label>Term I</label> <input class="form-control"
						id="termOne" name="termOne" type="tel" required/> 
				</div> 
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label>Term II</label> <input class="form-control" id="termTwo"
						name="termTwo" type="number" required/>
				</div>
				<div class="col">
					<label>Term III</label> <input class="form-control"
						id="termThree" name="termThree" type="number" required/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label>Term IV</label> <input class="form-control" id="termFour"
						name="termFour" type="number" required/>
				</div>
				<div class="col">
					<label>Transportation Fees</label> <input class="form-control"
						id="transportationFees" name="transportationFees" type="number" required/>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col">
					<label>Exam Fees</label> <input class="form-control" id="examFees"
						name="examFees" type="number" required/>
				</div>
				<div class="col">
					<label>Other</label> <input class="form-control" id="otherFees"
						name="otherFees" type="number" required/>
				</div>
				<div class="col">
					<label>Total Fees</label> <input class="form-control" id="totalFees"
						name="totalFees" type="number" required/>
				</div>
			</div>
			<br/>
			<a aria-controls="accordion03CollapseThree" aria-expanded="true"
				class="collapse-icon sheet-subtitle" data-toggle="collapse"
				href="#accordion03CollapseThree" id="accordion03HeadingThree"
				role="tab"> <span>Parent Details</span> <span
				class="collapse-icon-closed"> <svg
						class="lexicon-icon lexicon-icon-angle-right" focusable="false"
						role="presentation">
							<use href="/images/icons/icons.svg#angle-right"></use>
						</svg>
			</span> <span class="collapse-icon-open"> </span>
			</a>
			<div class="row">
				<div class="col">
					<label>Father's Name</label> <input class="form-control" id="fatherName"
						name="fatherName" required/>
				</div>
				<div class="col">
					<label>Father Aadhar Number</label> <input class="form-control"
						id="fatherAadhar" name="fatherAadhar" required/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label>Mother's Name</label> <input class="form-control" id="motherName"
						name="motherName" required/>
				</div>
				<div class="col">
					<label>Mother Aadhar Number</label> <input class="form-control"
						id="motherAadhar" name="motherAadhar" required/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label>Ration Card Number</label> <input class="form-control" id="rationCardNumber"
						name="rationCardNumber" required/>
				</div>
				<div class="col">
					<label>Mobile Number</label> <input class="form-control"
						id="mobileNumber" name="mobileNumber" required/>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col">
					<label>Address Line 1</label> <input class="form-control" id="address1"
						name="address1" required/>
				</div>
				<div class="col">
					<label>Address Line 2</label> <input class="form-control"
						id="address2" name="address2" />
				</div>
				<div class="col">
					<label>Address Line 3</label> <input class="form-control"
						id="address3" name="address3" />
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label>Religion</label> <input class="form-control" id="religion"
						name="religion" required/>
				</div>
				<div class="col">
					<label>Caste</label> <input class="form-control"
						id="caste" name="caste" required/>
				</div>
				<div class="col">
					<label>Category</label> <input class="form-control"
						id="category" name="category" required/>
				</div>
			</div>
			<br/>
			
			<button class="btn btn-success" id="healthStatusSubmitBtn"
				type="submit">Submit</button>
	</form:form>
	</div>

	<br /> <br />
</div>