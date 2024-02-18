<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
	.error{
		color: red;
	}
</style>
<body>
	<div class="mt-4" style="padding: 15px;">
		<f:form action="${pageContext.request.contextPath}/createschedule"
			method="post" modelAttribute="schedule">

			<div class="row">
				<div class="col-md-4 mb-3">
					<label for="my-select">Vaccine<span style="color: red;">(*)</span>:
					</label> <select id="my-select" class="form-control" name="vaccine.vaccineId" required>
						<option value="">~ Select Vaccine</option>
						<c:forEach var="v" items="${listVaccine}">
							<option value="${v.vaccineId}">${v.vaccineName}</option>
						</c:forEach>
					</select>
					<f:errors path="vaccine.vaccineId" cssClass="error"/>


				</div>
				<div class="col-md-4 mb-3">
					<label for="from">From<span style="color: red;">(*)</span>:
					</label> <f:input type="date" class="form-control" id="from" path="startDate" />
					<f:errors path="startDate" cssClass="error"/>
				</div>
				<div class="col-md-4 mb-3">
					<label for="to">To<span style="color: red;">(*)</span>:
					</label> <f:input type="date" class="form-control" id="to" path="endDate" />
					<f:errors path="endDate" cssClass="error"/>
				</div>

			</div>

			<div class="row">
				<div class="col-md-4 mb-3">
					<label for="place">Place<span style="color: red;">(*)</span>:
					</label> <f:input type="text" class="form-control" id="place" path="place"
						value=""/>
					<f:errors path="place" cssClass="error"/>
				</div>
				<div class="col-md-8 mb-3">
					<label for="note">Note:</label> <f:input type="text"
						class="form-control" id="note" path="description"/>
					<f:errors path="description" cssClass="error"/>
				</div>

			</div>

			<div class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-success">Save</button>
					<button type="reset" class="btn btn-primary">Reset</button>
					<button type="button" class="btn btn-warning"><a style="text-decoration: none; color: white;" href="${pageContext.request.contextPath}/listschedule">Cancel</a></button>  
				</div>
			</div>
		</f:form>
	</div>
</body>
</html>