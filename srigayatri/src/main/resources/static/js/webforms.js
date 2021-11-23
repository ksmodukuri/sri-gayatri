$( document ).ready(function() {
	if($("#dataQueryService").val() != "showStudentsMarks"){
		loadData();
	}
	
	function loadData(){
		var searchByAdmnNo = $("#searchByAdmnNo").val();
		var searchByName = $("#searchByName").val();
		var searchByClass = $("#searchByClass").val();
		var sortBy = $("#sortBy").val();
		var asc = $("#asc").val();
		var pageIndex = ($("#selectedPage").val() - 1 )
		var pageLimit = $("#selectedPageLimit").val();
		var dataQueryService = $("#dataQueryService").val();
		var fromClass = $("#fromClass").val();
		var toClass = $("#toClass").val();
		
		if(dataQueryService != "showStudentsMarks" && dataQueryService != "viewMarks"){
		
			if( searchByAdmnNo == "" && searchByName == "" && searchByClass == "")
			{
				urlString = dataQueryService+"?pageIndex="+pageIndex+"&pageLimit="+pageLimit+"&sortBy="+sortBy+"&asc="+asc;
			}
			else if(searchByAdmnNo != "" && searchByName == "" && searchByClass == "")
			{
				urlString= dataQueryService+"/search?pageIndex="+pageIndex+"&pageLimit="+pageLimit+"&sortBy="+sortBy+"&asc="+asc+
				"&searchByAdmnNo="+searchByAdmnNo;
			}
			else if(searchByAdmnNo == "" && searchByName != "" && searchByClass == "")
			{
				urlString= dataQueryService+"/search?pageIndex="+pageIndex+"&pageLimit="+pageLimit+"&sortBy="+sortBy+"&asc="+asc+
				"&searchByName="+searchByName;
			}
			else if(searchByAdmnNo == "" && searchByName == "" && searchByClass != "")
			{
				urlString= dataQueryService+"/search?pageIndex="+pageIndex+"&pageLimit="+pageLimit+"&sortBy="+sortBy+"&asc="+asc+
				"&searchByClass="+searchByClass;
			}
			else if(searchByAdmnNo != "" && searchByName != "" && searchByClass == "")
			{
				urlString= dataQueryService+"/search?pageIndex="+pageIndex+"&pageLimit="+pageLimit+"&sortBy="+sortBy+"&asc="+asc+
				"&searchByAdmnNo="+searchByAdmnNo + "&searchByName="+searchByName;
			}
			else if(searchByAdmnNo != "" && searchByName == "" && searchByClass != "")
			{
				urlString= dataQueryService+"/search?pageIndex="+pageIndex+"&pageLimit="+pageLimit+"&sortBy="+sortBy+"&asc="+asc+
				"&searchByAdmnNo="+searchByAdmnNo + "&searchByClass="+searchByClass;
			}
			else if(searchByAdmnNo == "" && searchByName != "" && searchByClass != "")
			{
				urlString= dataQueryService+"/search?pageIndex="+pageIndex+"&pageLimit="+pageLimit+"&sortBy="+sortBy+"&asc="+asc+
				"&searchByName="+searchByName + "&searchByClass="+searchByClass;
			}
			else if(searchByAdmnNo != "" && searchByName != "" && searchByClass != "")
			{
				urlString= dataQueryService+"/search?pageIndex="+pageIndex+"&pageLimit="+pageLimit+"&sortBy="+sortBy+"&asc="+asc+
				"&searchByAdmnNo="+searchByAdmnNo + "&searchByName="+searchByName + "&searchByClass="+searchByClass;
			}
		}else if (dataQueryService == "showStudentsMarks"){
			if( searchByAdmnNo == ""){
				urlString = dataQueryService+"?std="+fromClass+"&pageIndex="+pageIndex+"&pageLimit="+pageLimit+"&sortBy="+sortBy+"&asc="+asc;
			}else{
				urlString= dataQueryService+"/search?pageIndex="+pageIndex+"&pageLimit="+pageLimit+"&sortBy="+sortBy+"&asc="+asc+
				"&searchByAdmnNo="+searchByAdmnNo;
			}
		}else if (dataQueryService == "viewMarks"){
			if( searchByAdmnNo == "" && fromClass == ""){
				urlString = dataQueryService+"?pageIndex="+pageIndex+"&pageLimit="+pageLimit+"&sortBy="+sortBy+"&asc="+asc;
			}else if(fromClass != "" && searchByAdmnNo == ""){
				urlString= dataQueryService+"/search?pageIndex="+pageIndex+"&pageLimit="+pageLimit+"&sortBy="+sortBy+"&asc="+asc+
				"&fromClass="+fromClass;
			}
		}
		$.ajax(({url: urlString,
			
			success: function(result){
				var table_1 = $("#bootstrap-table").find('tbody');
				table_1.empty();
				if(result.data.length == 0){
					$("#exampleModalCenter2").modal('show');
				}else{
			    $(result.data).each(function(index, element) {
			    	var markup = "";
			    	if(dataQueryService=="students"){
			    	var markup = "<tr><td>"+ element.admissionNumber +"</td><td>"+ element.std
			    				+"</td><td><a href= 'updateStudentDetails?studentId="+ element.id +"'>"
			    					+  element.studentName + "</a></td>"+
			    					"<td>"+ element.aadhar+"</td><td>" + element.fatherName + "</td>"
			    					+ "<td>"+ element.mobileNumber+"</td><td>" + element.dob + "</td></tr>";
			    					table_1.append(markup);
			    			}
			    	else if(dataQueryService == "fees"){
			    		var markup = "<tr><td>"+ element.admissionNumber +"</td><td>"+ element.std
	    				+"</td><td><a href= 'updateFeesDetails?studentId="+ element.id +"'>"
	    					+  element.studentName + "</a></td>"+
	    					"<td>"+ element.fees.totalFees+"</td><td>" + element.fees.totalFeesPaid + "</td>"
	    					+ "<td>"+ element.fees.totalBalFees+"</td></tr>";
	    					table_1.append(markup);
			    	}
			    	else if(dataQueryService == "showStudentsMarks"){
			    		var markup = "<tr><td>"+ element.admissionNumber +"</td><td>"+ element.std
	    				+"</td><td><a href= 'updateMarksPage?marksId="+ element.marksId +"'>"
	    					+  element.studentName + "</a></td>"+ "<td>"+ element.subject+"</td>" + 
	    					"<td>"+ element.fA1+"</td><td>" + element.fA1Grade + "</td>" +
	    					"<td>"+ element.fA2+"</td><td>" + element.fA2Grade + "</td>" +
	    					"<td>"+ element.sA1+"</td><td>" + element.sA1Grade + "</td>" +
	    					"<td>"+ element.fA3+"</td><td>" + element.fA3Grade + "</td>" +
	    					"<td>"+ element.fA4+"</td><td>" + element.fA4Grade + "</td>" +
	    					"<td>"+ element.sA2+"</td><td>" + element.sA2Grade + "</td></tr>";
	    					table_1.append(markup);
			    	}else if(dataQueryService == "viewMarks"){
			    		console.log(element.sA1Grade);
			    		var markup = "<tr><td>"+ element.admissionNumber +"</td><td>"+ element.std
	    				+"</td><td><a href= 'updateMarksPage?marksId="+ element.marksId +"'>"
	    					+  element.studentName + "</a></td>"+ "<td>"+ element.subject+"</td>" + 
	    					"<td>"+ element.fA1+"</td><td>" + element.fA1Grade + "</td>" +
	    					"<td>"+ element.fA2+"</td><td>" + element.fA2Grade + "</td>" +
	    					"<td>"+ element.sA1+"</td><td>" + element.sA1Grade + "</td>" +
	    					"<td>"+ element.fA3+"</td><td>" + element.fA3Grade + "</td>" +
	    					"<td>"+ element.fA4+"</td><td>" + element.fA4Grade + "</td>" +
	    					"<td>"+ element.sA2+"</td><td>" + element.sA2Grade + "</td></tr>";
	    					table_1.append(markup);
			    	}
			    });
				
				var pageTotalCount = result.pagination.count;
				var pageLimit = result.pagination.limit;
				var pageCurrentIndex = result.pagination.index;

				if(pageCurrentIndex == 0){
					$("#pagePreviousBtn").addClass("disabled");
				}else{
					$("#pagePreviousBtn").removeClass("disabled");
				}

				if(pageTotalCount == pageCurrentIndex+1){
					$("#pageNextBtn").addClass("disabled");
				}else{
					$("#pageNextBtn").removeClass("disabled");
				}

				$("#pageSelectDropdown").empty();

				for (var i = 1; i <= pageTotalCount; i++) {
					if(i == 1){
						$("#selectedPageText").text($("#selectedPage").val());		
					}
					$("#pageSelectDropdown").append("<li class=\"sspl-pageselect\"><a class=\"dropdown-item pages\" href=\"#1\">"+i+"</a></li>");
				}
				}
				$("#totalPageText").text(pageTotalCount);

			}}));

	}
		
	$(".dropdown-item").click(function(){
		$("#selectedPageLimit").val(Number($(this).text()));
		$("#selectedPageLimitText").text(($("#selectedPageLimit").val()));
		$("#selectedPage").val(1);
		loadData();
	});
	
	$("#pagePreviousBtn").click(function(){
		
		if(!$(this).hasClass("disabled")){
			$("#selectedPage").val(Number($("#selectedPage").val()) - 1);
			$("#selectedPageText").text($("#selectedPage").val());
			loadData();
		}
	});
	
	$("#pageNextBtn").click(function(){
		if(!$(this).hasClass("disabled")){
		$("#selectedPage").val(Number($("#selectedPage").val()) + 1);
		$("#selectedPageText").text($("#selectedPage").val());
		loadData();
		}
		
	});
	$('body').on('click', '.sspl-pageselect', function () {
		$("#selectedPage").val($(this).text());
		$("#selectedPageText").text($("#selectedPage").val());
		loadData();
	});
	
	$(".upArrow").hide();
	$(".downArrow").hide();
	$("[abbr="+ $("#sortBy").val() +"], #downArrow"+$("#sortBy").val()).show();
	
	$('th').on('click',function(){
		$("#sortBy").val($(this).attr("abbr"));
		var sortCol = $(this).attr("abbr");
		$("th").each(function(){
			var abbr = $(this).attr("abbr");
			if(sortCol != abbr){
				$("#upArrow"+abbr).hide();
				$("#downArrow"+abbr).hide();
			}
		});
		if($("#asc").val() == "false"){
			$("#asc").val("true");
			$("#upArrow"+sortCol).show();
			$("#downArrow"+sortCol).hide();
		}else{
			$("#asc").val("false");
			$("#upArrow"+sortCol).hide();
			$("#downArrow"+sortCol).show();
		}
		loadData();
		$("[abbr="+ $("#sortBy").val() +"], .upArrow"+sortCol).show();
	});
	
	$("#searchBtn").on("click",function(){
		loadData();
	});
	$("#showBtn").on("click",function(){
		if($("#fromClass").val().length > 0 && $("#searchByAdmnNo").val().length > 0){
			alert("Do not put class and admission Number together. Serach By Class or Admission Number individually")
		}else{
			loadData();
		}
	});
	
	$("#promotehBtn").on("click",function(){
		$.ajax(({url: "promoteStudents?fromClass="+$("#fromClass").val() + "&toClass="+$("#toClass").val(),
			success: function(result){
				$("#exampleModalCenter").modal('show');
			}
		}));
	});

});