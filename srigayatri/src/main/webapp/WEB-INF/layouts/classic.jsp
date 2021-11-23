<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<script src="/antispread/js/gauge.min.js"></script>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <title><tiles:getAsString name="title" /></title>
  <!-- Custom fonts for this template-->
  <link href="/antispread/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="/antispread/vendor/bootstrap/css/font.css" rel="stylesheet">
  <link rel="stylesheet" href="/antispread/vendor/bootstrap/css/atlas.css"/>
  <script src="/antispread/vendor/jquery/jquery.min.js"></script>

<style>
body{
background-color:white;
}
</style>
</head>
<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">
    <div id="content-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">
      <tiles:insertAttribute name="body" />
      
    </div>
    </div>
    </div>

    
  <!-- Bootstrap core JavaScript-->
  <!-- <script src="/antispread/vendor/bootstrap/js/bootstrap-select.min.js"></script> -->
  <script src="/antispread/vendor/jquery/jquery.min.js"></script>
  <script src="/antispread/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="/antispread/vendor/jquery-easing/jquery.easing.min.js"></script>
  <!-- Custom scripts for all pages-->
  <script src="/antispread/js/webforms.js"></script>

</html>