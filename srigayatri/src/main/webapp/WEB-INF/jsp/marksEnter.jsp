<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>

$(document).ready(function(){
	$("#studentSearch").click(function(){
		var studentName = $("#studentName").val();
		var admnNo = $("#admissionNumber").val();
		var subjectSelect = $("#subject");
		var examType = $("#examType");
		subjectSelect.empty();
		examType.empty();
		$("#fA1,#fA2,#fA3,#fA4,#sA1,#sA2").val(0);
		$.ajax(({
			url:"getStudentSubjects?admnNo="+admnNo,
			success:function(result){
				console.log(result);
				
						$(result.subjectList).each(function(i,v){
							if(subjectSelect.is(':empty')){
								var markup = "<option value=\"\">-Select-</option>";
								subjectSelect.append(markup);
								}
										var markup = "<option value="+ v +">"+ v +"</option>";
										subjectSelect.append(markup);

						});
						$("#studentName").val(result.studentName);
						$("#studentId").val(result.studentId);
						$("#std").val(result.std);
				}
		}));
	});
	

});
function validateMyForm(){
	var validateForm =  $( "#marksForm" ).validate({
		  rules: {
			fA1: {
		      	  range: [0, 50]
		    	},
			fA2: {
			      range: [0, 50]
			    },
			fA3: {
			      range: [0, 50]
			    },
			fA4: {
			      range: [0, 50]
			    },
			sA1: {
			      range: [0, 100]
			    },
			sA2: {
			      range: [0, 100]
			    },
		  },
		  messages : {
			  fA1: "Marks must be between 0 and 50",
			  fA2: "Marks must be between 0 and 50",
			  fA3: "Marks must be between 0 and 50",
			  fA4: "Marks must be between 0 and 50",
			  sA1: "Marks must be between 0 and 100",
			  sA2: "Marks must be between 0 and 100",	  
		  }
		});
		validateForm.form();
}
</script>
<style>
body{
background-color:white;
}
.error{
color:red;
}
</style>
<div class="container">
	<a aria-controls="accordion03CollapseTwo" aria-expanded="true"
		class="collapse-icon sheet-subtitle" data-toggle="collapse"
		href="#accordion03CollapseTwo" id="accordion03HeadingTwo" role="tab">
		<span>Enter Marks</span> <span class="collapse-icon-closed"> <svg
				class="lexicon-icon lexicon-icon-angle-right" focusable="false"
				role="presentation">
							<use href="/images/icons/icons.svg#angle-right"></use>
						</svg>
	</span> <span class="collapse-icon-open"> </span>
	</a>
	<div class="panel-body">
		<div class="row">
			<div class="col">
				<label for="personal_fname" style="float: left">Student
					Admission Number</label> <input type="text" class="form-control"
					id="admissionNumber" name="admissionNumber" value="" />
			</div>
			<button type="button" class="btn btn-success" id="studentSearch"  style="margin-top: 0.65cm">
				Search&nbsp;
				<svg class="lexicon-icon lexicon-icon-search" focusable="false"
					role="presentation">
							<use href="/images/icons/icons.svg#search"></use>
						</svg>
			</button>
		</div>
		<br/>
		<form:form method="post" id="marksForm" action="marksEnter"
			modelAttribute="marksEnterObject">
			<div class="row">
				<div class="col">
				<label for="personal_fname" style="float: left">Student Name</label>
					<input type="text" class="form-control" id="studentName"
						name="studentName" value="" readonly/>
				</div>
				<div class="col">
				<label for="personal_fname" style="float: left">Student Class</label>
					<input type="text" class="form-control" id="std"
						name="std" value="" readonly/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label for="personal_email" style="float: left">Subject</label> 
					<select id="subject" name="subject" class="form-control">
						<option value="">-Select-</option>
					</select>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label for="personal_email" style="float: left">FA1</label> <input
						type="text" class="form-control" id="fA1" name="fA1" value="" />
				</div>
				<div class="col">
					<label for="personal_email" style="float: left">FA2</label> <input
						type="number" class="form-control" id="fA2" name="fA2" value="" />
				</div>
				<div class="col">
					<label for="personal_email" style="float: left">SA1</label> <input
						type="number" class="form-control" id="sA1" name="sA1" value="" />
				</div>
				<div class="col">
					<label for="personal_email" style="float: left">FA3</label> <input
						type="number" class="form-control" id="fA3" name="fA3" value="" />
				</div>
				<div class="col">
					<label for="personal_email" style="float: left">FA4</label> <input
						type="number" class="form-control" id="fA4" name="fA4" value="" />
				</div>
				<div class="col">
					<label for="personal_email" style="float: left">SA2</label> <input
						type="number" class="form-control" id="sA2" name="sA2" value="" />
				</div>
			</div>
			<br/>
			<input type="hidden" name="studentId" id="studentId"/>
			<button type="submit" class="btn btn-success" id="marksSubmitBtn" onClick="validateMyForm()">Submit</button>
		</form:form>
	</div>
</div>