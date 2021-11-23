<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
$(document).ready(function(){
	var totalBal = 0;
	var ids={}
	var idBal={}
	var count = 0;
	ids["admissionPaid"] = "admissionFees";
	ids["termOnePaid"] = "termOne";
	ids["termTwoPaid"] = "termTwo";
	ids["termThreePaid"] = "termThree";
	ids["termFourPaid"] = "termFour";
	ids["transportationPaid"] = "transportationFees";
	ids["examFeesPaid"] = "examFees";
	ids["otherPaid"] = "otherFees";
	
	idBal["admissionPaid"] = "admissionBal";
	idBal["termOnePaid"] = "termOneBal";
	idBal["termTwoPaid"] = "termTwoBal";
	idBal["termThreePaid"] = "termThreeBal";
	idBal["termFourPaid"] = "termFourBal";
	idBal["transportationPaid"] = "transportationBal";
	idBal["examFeesPaid"] = "examFeesBal";
	idBal["otherPaid"] = "otherBal";
	
	$("#admissionPaid,#termOnePaid,#termTwoPaid,#termThreePaid,#termFourPaid,#transportationPaid,#examFeesPaid,#otherPaid").keyup(function(){
		idList = ["#admissionPaid","#termOnePaid","#termTwoPaid","#termThreePaid","#termFourPaid","#transportationPaid","#examFeesPaid","#otherPaid"]
		for(i=0;i<idList.length;i++){
			if($(idList[i]).val() == "" && idList[i] != "#" + this.id){
				$(idList[i]).val(0);
				var id = idList[i].split("#");
				$("#"+idBal[id[1]]).val($("#" + ids[id[1]]).val())
			}
		}
		$("#"+idBal[this.id]).val(parseInt($("#"+ids[this.id]).val())-parseInt($("#"+this.id).val()));
		$("#totalFeesPaid").val(parseInt($("#termOnePaid").val())
				  + parseInt($("#termTwoPaid").val())
				  + parseInt($("#termThreePaid").val())
				  + parseInt($("#termFourPaid").val())
				  + parseInt($("#transportationPaid").val())
			      + parseInt($("#examFeesPaid").val())
			      + parseInt($("#otherPaid").val())
			      + parseInt($("#admissionPaid").val()))
		
      $("#totalBalFees").val(parseInt($("#termOneBal").val())
		  + parseInt($("#termTwoBal").val())
		  + parseInt($("#termThreeBal").val())
		  + parseInt($("#termFourBal").val())
		  + parseInt($("#transportationBal").val())
	      + parseInt($("#examFeesBal").val())
	      + parseInt($("#otherBal").val())
	      + parseInt($("#admissionBal").val()))
		
	});	
})
</script>
<style>
body{
background-color:white;
}
</style>

<div class="container">
	<a aria-controls="accordion03CollapseTwo"
		aria-expanded="true" class="collapse-icon sheet-subtitle"
		data-toggle="collapse" href="#accordion03CollapseTwo"
		id="accordion03HeadingTwo" role="tab"> <span>Update Student Details</span> <span
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
		<form:form method="post" id="newStudentForm" action="updateStudentDetails" modelAttribute="updateStudent">
			<div class="row">
				<div class="col">
					<label for="personal_fname" style="float: left">Student
						Admission Number</label> <input type="text" class="form-control"
						id="admissionNumber" name="admissionNumber" value="${updateStudent.admissionNumber }" />
				</div>
				<div class="col">
					<label for="personal_lname" style="float: left">Student
						Date Of Joining</label> <input type="text" class="form-control"
						id="dateOfJoining" name="dateOfJoining" value="${updateStudent.dateOfJoining }" />
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label for="personal_fname" style="float: left">Student
						First Name</label> <input type="text" class="form-control" id="studentFirstName"
						name="studentFirstName" value="${updateStudent.studentFirstName }" />
				</div>
				<div class="col">
					<label for="personal_lname" style="float: left">Student
						Last Name</label> <input type="text" class="form-control" id="studentLastName"
						name="studentLastName" value="${updateStudent.studentLastName }"/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label for="personal_email" style="float: left">Student
						Aadhar</label> <input type="text" class="form-control" id="aadhar"
						name="aadhar" value="${updateStudent.aadhar }" />
				</div>
				<div class="col">
					<label for="personal_phoneNumber" style="float: left">Student
						DOB</label> <input type="text" class="form-control" id="dob"
						name="dob" value="${updateStudent.dob }" />
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label for="personal_email" style="float: left">Student
						Gender</label> <select id="gender" name="gender" class="form-control">
						<c:set var="optionFemale" value="" />
						<c:set var="optionMale" value="" />
						<c:set var="optionOther" value="" />
						<c:if test="${updateStudent.gender  == 'F'}">
						<c:set var="optionFemale" value="selected" />
						</c:if>
						<c:if test="${updateStudent.gender  == 'M'}">
						<c:set var="optionMale" value="selected" />
						</c:if>
						<c:if test="${updateStudent.gender  == 'O'}">
						<c:set var="optionOther" value="selected" />
						</c:if>
						<option value="">-Select-</option>
						<option ${optionFemale} value="F">Female</option>
						<option ${optionMale} value="M">Male</option>
						<option ${optionOther} value="O">Other</option>
					</select>
				</div>
				<div class="col">
					<label for="personal_phoneNumber" style="float: left">Student
						Class Admission</label><input class="form-control" type="text" id="std" name="std" value="${updateStudent.std }"/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label for="personal_email" style="float: left">Mole</label> 
					<input type="text" class="form-control"
						id="mole1" name="mole1" value="${updateStudent.mole1 }"/>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col">
					<label for="personal_email" style="float: left">Mole</label> 
					<input type="text" class="form-control"
						id="mole2" name="mole2" value="${updateStudent.mole2 }" />
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col">
					<label for="personal_email" style="float: left">Student
						Previous School</label> <input type="text" class="form-control"
						id="previousSchoolName" name="previousSchoolName" value="${updateStudent.previousSchoolName }" />
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
					name="admissionFees" type="number" value="${updateStudent.fees.admissionFees }" readonly/>
			</div>
			<div class="col">
				<label>Term 1</label> <input class="form-control" id="termOne"
					name="termOne" type="number" value="${updateStudent.fees.termOne }" readonly/>
			</div>
			<div class="col">
				<label>Term 2</label> <input class="form-control" id="termTwo"
					name="termTwo" type="number" value="${updateStudent.fees.termTwo }" readonly/>
			</div>
			<div class="col">
				<label>Term 3</label> <input class="form-control" id="termThree"
					name="termThree" type="number" value="${updateStudent.fees.termThree }" readonly/>
			</div>
			<div class="col">
				<label>Term 4</label> <input class="form-control" id="termFour"
					name="termFour" type="number" value="${updateStudent.fees.termFour }" readonly/>
			</div>
			<div class="col">
				<label>Transport Fees</label> <input class="form-control"
					id="transportationFees" name="transportationFees" type="number" value="${updateStudent.fees.transportationFees }" readonly/>
			</div>
			<div class="col">
				<label>Exams Fees</label> <input class="form-control" id="examFees"
					name="examFees" type="number" value="${updateStudent.fees.examFees }" readonly />
			</div>
			<div class="col">
				<label>Other Fees</label> <input class="form-control" id="otherFees"
					name="otherFees" type="number" value="${updateStudent.fees.otherFees }" readonly/>
			</div>
			<div class="col">
				<label>Total Fees</label> <input class="form-control" id="totalFees"
					name="totalFees" type="number" value="${updateStudent.fees.totalFees }" readonly/>
			</div>

		</div>
		<br/>
		<div class="row">
		<div class="col">
				<label>Admission Paid</label> <input class="form-control" id="admissionPaid"
					name="admissionPaid" type="number" value="${updateStudent.fees.admissionPaid }"/>
			</div>
			<div class="col">
				<label>Term 1 Paid</label> <input class="form-control" id="termOnePaid"
					name="termOnePaid" type="number" value="${updateStudent.fees.termOnePaid }" />
			</div>
			        
			<div class="col">
				<label>Term 2 Paid</label> <input class="form-control" id="termTwoPaid"
					name="termTwoPaid" type="number" value="${updateStudent.fees.termTwoPaid }"/>
			</div>
			<div class="col">
				<label>Term 3 Paid</label> <input class="form-control" id="termThreePaid"
					name="termThreePaid" type="number" value="${updateStudent.fees.termThreePaid }"/>
			</div>
			<div class="col">
				<label>Term 4 Paid</label> <input class="form-control" id="termFourPaid"
					name="termFourPaid" type="number" value="${updateStudent.fees.termFourPaid }"/>
			</div>
			<div class="col">
				<label>Transport Paid</label> <input class="form-control"
					id="transportationPaid" name="transportationPaid" type="number" value="${updateStudent.fees.transportationPaid }"/>
			</div>
			<div class="col">
				<label>Exams Fees Paid</label> <input class="form-control"
					id="examFeesPaid" name="examFeesPaid" type="number" value="${updateStudent.fees.examFeesPaid }"/>
			</div>
			<div class="col">
				<label>Other Fees Paid</label> <input class="form-control"
					id="otherPaid" name="otherPaid" type="number" value="${updateStudent.fees.otherPaid }"/>
			</div>
			<div class="col">
				<label>Total Fees Paid</label> <input class="form-control"
					id="totalFeesPaid" name="totalFeesPaid" type="number" value="${updateStudent.fees.totalFeesPaid }"/>
			</div>

		</div>
		<br />
		<div class="row">
		<div class="col">
				<label>Admission Bal</label> <input class="form-control" id="admissionBal"
					name="admissionBal" type="number" value="${updateStudent.fees.admissionBal }" readonly/>
			</div>
			<div class="col">
				<label>Term 1 Bal</label> <input class="form-control" id="termOneBal"
					name="termOneBal" type="number" value="${updateStudent.fees.termOneBal }" readonly/>
			</div>
			<div class="col">
				<label>Term 2 Bal</label> <input class="form-control" id="termTwoBal"
					name="termTwoBal" type="number" value="${updateStudent.fees.termTwoBal }" readonly/>
			</div>
			<div class="col">
				<label>Term 3 Bal</label> <input class="form-control" id="termThreeBal"
					name="termThreeBal" type="number" value="${updateStudent.fees.termThreeBal }" readonly/>
			</div>
			<div class="col">
				<label>Term 4 Bal</label> <input class="form-control" id="termFourBal"
					name="termFourBal" type="number" value="${updateStudent.fees.termFourBal }" readonly/>
			</div>
			<div class="col">
				<label>Transport Bal</label> <input class="form-control"
					id="transportationBal" name="transportationBal" type="number" value="${updateStudent.fees.transportationBal }" readonly/>
			</div>
			<div class="col">
				<label>Exams Fees Bal</label> <input class="form-control"
					id="examFeesBal" name="examFeesBal" type="number" value="${updateStudent.fees.examFeesBal }" readonly/>
			</div>
			<div class="col">
				<label>Other Fees Bal</label> <input class="form-control"
					id="otherBal" name="otherBal" type="number" value="${updateStudent.fees.otherBal }" readonly/>
			</div>
			<div class="col">
				<label>Total Fees Bal</label> <input class="form-control"
					id="totalBalFees" name="totalBalFees" type="number" value="${updateStudent.fees.totalBalFees }" readonly/>
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
						name="fatherName" value="${updateStudent.fatherName }"/>
				</div>
				<div class="col">
					<label>Father Aadhar Number</label> <input class="form-control"
						id="fatherAadhar" name="fatherAadhar" value="${updateStudent.fatherAadhar }"/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label>Mother's Name</label> <input class="form-control" id="motherName"
						name="motherName" value="${updateStudent.motherName }"/>
				</div>
				<div class="col">
					<label>Mother Aadhar Number</label> <input class="form-control"
						id="motherAadhar" name="motherAadhar" value="${updateStudent.motherAadhar }"/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label>Ration Card Number</label> <input class="form-control" id="rationCardNumber"
						name="rationCardNumber" value="${updateStudent.rationCardNumber }"/>
				</div>
				<div class="col">
					<label>Mobile Number</label> <input class="form-control"
						id="mobileNumber" name="mobileNumber" value="${updateStudent.mobileNumber }"/>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col">
					<label>Address Line 1</label> <input class="form-control" id="address1"
						name="address1" value="${updateStudent.address1 }"/>
				</div>
				<div class="col">
					<label>Address Line 2</label> <input class="form-control"
						id="address2" name="address2" value="${updateStudent.address2 }"/>
				</div>
				<div class="col">
					<label>Address Line 3</label> <input class="form-control"
						id="address3" name="address3" value="${updateStudent.address3 }"/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label>Religion</label> <input class="form-control" id="religion"
						name="religion" value="${updateStudent.religion }"/>
				</div>
				<div class="col">
					<label>Caste</label> <input class="form-control"
						id="caste" name="caste" value="${updateStudent.caste }"/>
				</div>
				<div class="col">
					<label>Category</label> <input class="form-control"
						id="category" name="category" value="${updateStudent.category }"/>
				</div>
			</div>
			<br/>
			<input type="hidden" name="id" id="id" value="${updateStudent.id }"/>
			<button class="btn btn-success" id="healthStatusSubmitBtn"
				type="submit">Submit</button>
	</form:form>
	</div>

	<div class="modal fade" id="personalDetailsModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Success</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Saved Data Successfully</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary float-right"
						data-dismiss="modal" id="modalClose">Close</button>
				</div>
			</div>
		</div>
	</div>
	<br /> <br />
</div>