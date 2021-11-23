<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<br />
<br />
<style>
body{
background-color:white;
}
</style>
<script>
$(document).ready(function(){
	$("#paymentSearchBtn").click(function(){
		var admnNo = $("#admnNo").val();
		$.ajax(({
			url:"getFeesDetails?admnNo="+admnNo,
			success:function(result){
				$("#id").val(result.id)
				$("#studentName").val(result.studentName)
				$("#admissionFees").val(result.admissionFees)
				$("#admissionPaid").val(result.admissionPaid)
				$("#admissionBal").val(result.admissionBal)
				$("#termOne").val(result.termOne)
				$("#termOnePaid").val(result.termOnePaid)
				$("#termOneBal").val(result.termOneBal)
				$("#termTwo").val(result.termTwo)
				$("#termTwoPaid").val(result.termTwoPaid)
				$("#termTwoBal").val(result.termTwoBal)
				$("#termThree").val(result.termThree)
				$("#termThreePaid").val(result.termThreePaid)
				$("#termThreeBal").val(result.termThreeBal)
				$("#termFour").val(result.termFour)
				$("#termFourPaid").val(result.termFourPaid)
				$("#termFourBal").val(result.termFourBal)
				$("#transportationFees").val(result.transportationFees)
				$("#transportationPaid").val(result.transportationPaid)
				$("#transportationBal").val(result.transportationBal)
				$("#examFees").val(result.examFees)
				$("#examFeesPaid").val(result.examFeesPaid)
				$("#examFeesBal").val(result.examFeesBal)
				$("#otherFees").val(result.otherFees)
				$("#otherPaid").val(result.otherPaid)
				$("#otherBal").val(result.otherBal)
				$("#totalFees").val(result.totalFees)
				$("#totalFeesPaid").val(result.totalFeesPaid)
				$("#totalBalFees").val(result.totalBalFees)
			}
		}));
	});
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
});
</script>
<div class="container"><a aria-controls="accordion03CollapseTwo"
		aria-expanded="true" class="collapse-icon sheet-subtitle"
		data-toggle="collapse" href="#accordion03CollapseTwo"
		id="accordion03HeadingTwo" role="tab"> <span>Fees Payment</span> <span
		class="collapse-icon-closed"> <svg
				class="lexicon-icon lexicon-icon-angle-right" focusable="false"
				role="presentation">
							<use href="/images/icons/icons.svg#angle-right"></use>
						</svg>
	</span> <span class="collapse-icon-open"> </span>
	</a>
<div class="panel-body">
	<div class="row">
		<div class="col">
			<label>Search By Admission Number</label> <input
				class="form-control" id="admnNo" name="admnNo" type="text" />
		</div>
		<div class="col" style="margin-top: 0.65cm">
			<button class="btn btn-success" type="submit" id="paymentSearchBtn">Submit</button>
		</div>
	</div>
	<br />

	<form:form id="feesPaymentForm" class="form-group" method="post" action="feesPayment" modelAttribute="updateFees">
		<div class="row">
			<div class="col">
				<label>Student Name</label> <input class="form-control"
					id="studentName" name="studentName" type="text"
					value="${updateFees.studentName }" />
			</div>
		</div>
		<br/>
		<div class="row">
		<div class="col">
				<label>Admission Fees</label> <input class="form-control" id="admissionFees"
					name="admissionFees" type="number" value="${updateFees.admissionFees }" readonly/>
			</div>
			<div class="col">
				<label>Term 1</label> <input class="form-control" id="termOne"
					name="termOne" type="number" value="${updateFees.termOne }" readonly/>
			</div>
			<div class="col">
				<label>Term 2</label> <input class="form-control" id="termTwo"
					name="termTwo" type="number" value="${updateFees.termTwo }" readonly/>
			</div>
			<div class="col">
				<label>Term 3</label> <input class="form-control" id="termThree"
					name="termThree" type="number" value="${updateFees.termThree }" readonly/>
			</div>
			<div class="col">
				<label>Term 4</label> <input class="form-control" id="termFour"
					name="termFour" type="number" value="${updateFees.termFour }" readonly/>
			</div>
			<div class="col">
				<label>Transport Fees</label> <input class="form-control"
					id="transportationFees" name="transportationFees" type="number" value="${updateFees.transportationFees }" readonly/>
			</div>
			<div class="col">
				<label>Exams Fees</label> <input class="form-control" id="examFees"
					name="examFees" type="number" value="${updateFees.examFees }" readonly />
			</div>
			<div class="col">
				<label>Other Fees</label> <input class="form-control" id="otherFees"
					name="otherFees" type="number" value="${updateFees.otherFees }" readonly/>
			</div>
			<div class="col">
				<label>Total Fees</label> <input class="form-control" id="totalFees"
					name="totalFees" type="number" value="${updateFees.totalFees }" readonly/>
			</div>

		</div>
		<br/>
		<div class="row">
		<div class="col">
				<label>Admission Paid</label> <input class="form-control" id="admissionPaid"
					name="admissionPaid" type="number" value="${updateFees.admissionPaid }"/>
			</div>
			<div class="col">
				<label>Term 1 Paid</label> <input class="form-control" id="termOnePaid"
					name="termOnePaid" type="number" value="${updateFees.termOnePaid }" />
			</div>
			        
			<div class="col">
				<label>Term 2 Paid</label> <input class="form-control" id="termTwoPaid"
					name="termTwoPaid" type="number" value="${updateFees.termTwoPaid }"/>
			</div>
			<div class="col">
				<label>Term 3 Paid</label> <input class="form-control" id="termThreePaid"
					name="termThreePaid" type="number" value="${updateFees.termThreePaid }"/>
			</div>
			<div class="col">
				<label>Term 4 Paid</label> <input class="form-control" id="termFourPaid"
					name="termFourPaid" type="number" value="${updateFees.termFourPaid }"/>
			</div>
			<div class="col">
				<label>Transport Paid</label> <input class="form-control"
					id="transportationPaid" name="transportationPaid" type="number" value="${updateFees.transportationPaid }"/>
			</div>
			<div class="col">
				<label>Exams Fees Paid</label> <input class="form-control"
					id="examFeesPaid" name="examFeesPaid" type="number" value="${updateFees.examFeesPaid }"/>
			</div>
			<div class="col">
				<label>Other Fees Paid</label> <input class="form-control"
					id="otherPaid" name="otherPaid" type="number" value="${updateFees.otherPaid }"/>
			</div>
			<div class="col">
				<label>Total Fees Paid</label> <input class="form-control"
					id="totalFeesPaid" name="totalFeesPaid" type="number" value="${updateFees.totalFeesPaid }"/>
			</div>

		</div>
		<br />
		<div class="row">
		<div class="col">
				<label>Admission Bal</label> <input class="form-control" id="admissionBal"
					name="admissionBal" type="number" value="${updateFees.admissionBal }" readonly/>
			</div>
			<div class="col">
				<label>Term 1 Bal</label> <input class="form-control" id="termOneBal"
					name="termOneBal" type="number" value="${updateFees.termOneBal }" readonly/>
			</div>
			<div class="col">
				<label>Term 2 Bal</label> <input class="form-control" id="termTwoBal"
					name="termTwoBal" type="number" value="${updateFees.termTwoBal }" readonly/>
			</div>
			<div class="col">
				<label>Term 3 Bal</label> <input class="form-control" id="termThreeBal"
					name="termThreeBal" type="number" value="${updateFees.termThreeBal }" readonly/>
			</div>
			<div class="col">
				<label>Term 4 Bal</label> <input class="form-control" id="termFourBal"
					name="termFourBal" type="number" value="${updateFees.termFourBal }" readonly/>
			</div>
			<div class="col">
				<label>Transport Bal</label> <input class="form-control"
					id="transportationBal" name="transportationBal" type="number" value="${updateFees.transportationBal }" readonly/>
			</div>
			<div class="col">
				<label>Exams Fees Bal</label> <input class="form-control"
					id="examFeesBal" name="examFeesBal" type="number" value="${updateFees.examFeesBal }" readonly/>
			</div>
			<div class="col">
				<label>Other Fees Bal</label> <input class="form-control"
					id="otherBal" name="otherBal" type="number" value="${updateFees.otherBal }" readonly/>
			</div>
			<div class="col">
				<label>Total Fees Bal</label> <input class="form-control"
					id="totalBalFees" name="totalBalFees" type="number" value="${updateFees.totalBalFees }" readonly/>
			</div>

		</div>
		<br />
		<input type="hidden" id="id" name="id" value="${updateFees.id }"/>
		<button class="btn btn-success" type="submit">Pay Fees</button>

	</form:form>
</div>
</div>