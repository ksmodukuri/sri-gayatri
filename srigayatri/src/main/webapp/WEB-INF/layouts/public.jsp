<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="vendor/jquery/jquery.min.js"></script>
  <meta name="description" content="">
  <meta name="author" content="">
  <title><tiles:getAsString name="title" /></title>
  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="vendor/bootstrap/css/font.css" rel="stylesheet">
  <!-- Custom styles for this template-->
 <!--  <link href="css/sb-admin-2.min.css" rel="stylesheet"> -->
   <link rel="stylesheet" href="vendor/bootstrap/css/atlas.css"/>
<style>
.imageBack {
	background-image: url("/images/watermark.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-attachment: fixed;
	opacity: 0.03;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	position: absolute;
	z-index: -1;
}
</style>
</head>
<body id="page-top">
<div class="container-fluid imageBack">

</div>
  <!-- Page Wrapper -->
  <div id="wrapper">
    <div id="content-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">
      <tiles:insertAttribute name="header" />
      <tiles:insertAttribute name="body" />
      
    </div>
    </div>
    </div>

    
  <!-- Bootstrap core JavaScript-->
  <!-- <script src="/antispread/vendor/bootstrap/js/bootstrap-select.min.js"></script> -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="js/webforms.js"></script>
  <script src="js/jquery.validate.min.js"></script>
  <script src="js/additional-methods.min.js"></script>
  <!-- Custom scripts for all pages-->


</body>
</html>