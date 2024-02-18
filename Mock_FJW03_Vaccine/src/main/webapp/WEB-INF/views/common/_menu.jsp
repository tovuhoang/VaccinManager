<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="menu">
		        <div class="img-header-nhanvien">
                    <img id="backgroup-menu" src="<%=request.getContextPath()%>/logo/aside.png" alt="backgroup">
                    <div class="img-nhanvien-menu">
                        <img id="img-nhanvien-menu" src="<%=request.getContextPath()%>/logo/nhanvien.png" alt="img nhan vien">
                        <p>Admin</p>
                        <div class="email-menu">
                            <p>admin@fsoft.com.vn</p><i class="fa fa-chevron-down"></i>
                        </div>
                    </div>
                </div>
                <nav class="link-menu">
                    <div class="home-menu">
                        <a href="#"><strong>Home</strong></a>
                    </div>
                    <div class="link-vaccine-menu">
                        <a href="#demo" class="btn" data-toggle="collapse"><strong>Employee management</strong> <i class="fa fa-plus"></i></a>
                        <div id="demo" class="collapse">
                        <a href="${pageContext.request.contextPath}/listemployee">Employee List</a>
                        <a href="${pageContext.request.contextPath}/createemployee">Create Employee</a>
                        </div>
                    </div>
                    <div class="link-vaccine-menu">
                        <a href="#demo1" class="btn" data-toggle="collapse"><strong>Customer management</strong> <i class="fa fa-plus"></i></a>
                         <div id="demo1" class="collapse">
                         <a href="${pageContext.request.contextPath}/listcustomer">Customer List</a>
                         <a href="${pageContext.request.contextPath}/createcustomer">Create Customer</a>
                         </div>
                    </div>
                    <div class="link-vaccine-menu">
                        <a href="#demo2" class="btn" data-toggle="collapse"><strong>Vaccine Type management</strong> <i class="fa fa-plus"></i></a>
                        <div id="demo2" class="collapse">
                        <a href="${pageContext.request.contextPath}/listvaccinetype">Vaccine Type List</a>
                        <a href="${pageContext.request.contextPath}/createvaccinetype">Create Vaccine Type</a>
                        </div>
                    </div>
                    <div class="link-vaccine-menu">
                        <a href="#demo3" class="btn" data-toggle="collapse"><strong>Vaccine management</strong> <i class="fa fa-plus"></i></a>
                        <div id="demo3" class="collapse">
                        <a href="${pageContext.request.contextPath}/listvaccine">Vaccine List</a>
                        <a href="${pageContext.request.contextPath}/createvaccine">Create Vaccine</a>
                        </div>
                    </div>
                    <div class="link-vaccine-menu">
                       <a href="#demo4" class="btn" data-toggle="collapse"><strong>Injection Schedule</strong> <i class="fa fa-plus"></i></a>
                        <div id="demo4" class="collapse">
                        <a href="${pageContext.request.contextPath}/listschedule">Schedule List</a>
                        <a href="${pageContext.request.contextPath}/createschedule">Create Schedule</a>
                        </div>
                    </div>
                    <div class="link-vaccine-menu">
                        <a href="#demo5" class="btn" data-toggle="collapse"><strong>Injection Result</strong> <i class="fa fa-plus"></i></a>
                        <div id="demo5" class="collapse">
                        <a href="${pageContext.request.contextPath}/listresult">Result List</a>
                        <a href="${pageContext.request.contextPath}/createresult">Create Result</a>
                        </div>
                    </div>
                    <div class="link-vaccine-menu">
                        <a href="#demo6" class="btn" data-toggle="collapse"><strong>News</strong><i class="fa fa-plus"></i></a>
                        <div id="demo6" class="collapse">
                        <a href="${pageContext.request.contextPath}/listnews">News List</a>
                        <a href="${pageContext.request.contextPath}/createnews">Create News</a>
                        </div>
                    </div>
                    <div class="link-vaccine-menu">
                        <a href="#demo7" class="btn" data-toggle="collapse"><strong>Report</strong><i class="fa fa-plus"></i></a>
                        <div id="demo7" class="collapse">
                        <a href="${pageContext.request.contextPath}/listreport">Report List</a>
                        <a href="${pageContext.request.contextPath}/createreport">Create report</a>
                        </div>
                    </div>               
                </nav>
    </div>
</body>
</html>