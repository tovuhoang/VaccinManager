<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	
	<title><tiles:getAsString name="title" /></title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"></link>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<!--  pageContext.request.contextPath = http://localhost:8080/Vaccine/ -->
</head>

<body style="width: 100%">

	<!--Header-->
	<header>
	 	<tiles:insertAttribute name="header" />
	</header>
	
	
	<div class="row">
	<div class="col-3">
		  <tiles:insertAttribute name="menu" />
		  </div>
		  <div class="col-9">
		    <tiles:insertAttribute name="body" />
		  </div>
	</div>
	<tiles:insertAttribute name="footer" />
		
</body>
</html>