<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="header-body">
		<div class="show">
			<p>Show</p>
			<button class="down"></button>
			<p>
				<i class="fas fa-chevron-down"></i>
			</p>
			<p>entries</p>
		</div>
		<div class="search-container">
			<label for="search">Search :</label> <input type="search"
				id="searchInput" name="Search">
		</div>
	</div>

	<table>
		<thead id="tableHead">
			<tr>
				<th><input type="checkbox" id="selectAllCheckbox"
					onchange="updateSelectedSchedules(this)"></th>
				<th>ScheduleId</th>
				<th>Vaccine</th>
				<th>Time</th>
				<th>Place</th>
				<th>Status</th>
				<th>Note</th>
			</tr>
		</thead>
		<tbody id="tableBody">
			<c:forEach var="s" items="${list}">
				<tr>
					<td><input type="checkbox" value="${s.injectionSchedule}"></td>
					<td>${s.injectionSchedule}</td>
					<td>${s.vaccine.vaccineName}</td>
					<td>From ${s.startDate} To ${s.endDate}</td>
					<td>${s.place}</td>
					<td>${s.description}</td>
					<td>note1</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="first-footer">
		<div>
			<p>Showing 1 to 5 of 11 entries</p>
		</div>
		<div>
			<ul class="pagination pagination-sm">
				<li class="page-item"><a class="page-link" href="#"><i
						class="fa fa-angle-double-left"></i></a></li>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/listschedule?pageNum=1">1</a></li>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/listschedule?pageNum=2">2</a></li>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/listschedule?pageNum=3">3</a></li>
				<li class="page-item"><a class="page-link" href="#"><i
						class="fa fa-angle-double-right"></i></a></li>
			</ul>
		</div>
	</div>
	<div>
		<button type="button" id="btn-create">
			<a href="${pageContext.request.contextPath}/createschedule">New
				Injection Schedule</a>
		</button>
		<button class="btn-warning" type="button" id="btn-update"
			onclick="updateSelectedSchedules()">Update Injection
			Schedule</button>
	</div>

	<script type="text/javascript">
		function updateSelectedSchedules() {
			var checkboxes = document
					.querySelectorAll('input[type="checkbox"]:checked');
			if (checkboxes.length > 0) {
				var selectedScheduleId = checkboxes[0].value;
				window.location.href = "${pageContext.request.contextPath}/selectedupdateschedule?id="
						+ selectedScheduleId;
			} else {
				alert("Please select a schedule before updating.");
			}
		}
		// Lấy các phần tử DOM cần thiết
		var searchInput = document.getElementById('searchInput');
		var tableBody = document.getElementById('tableBody');
		var originalTableBodyHtml = tableBody.innerHTML; // Lưu trữ nội dung gốc của bảng

		// Gắn sự kiện input cho ô nhập liệu tìm kiếm
		searchInput.addEventListener('input', function() {
			var searchTerm = searchInput.value.toLowerCase(); // Chuyển đổi thành chữ thường để tìm kiếm không phân biệt chữ hoa chữ thường
			var rows = tableBody.getElementsByTagName('tr');

			// Lặp qua từng dòng trong bảng
			for (var i = 0; i < rows.length; i++) {
				var cells = rows[i].getElementsByTagName('td');
				var found = false;

				// Lặp qua từng ô trong dòng
				for (var j = 0; j < cells.length; j++) {
					var cellText = cells[j].textContent.toLowerCase(); // Chuyển đổi thành chữ thường

					// Nếu có từ khóa tìm kiếm trong ô, đặt found thành true và thoát khỏi vòng lặp
					if (cellText.includes(searchTerm)) {
						found = true;
						break;
					}
				}

				// Hiển thị hoặc ẩn dòng dựa trên kết quả tìm kiếm
				rows[i].style.display = found ? '' : 'none';
			}
		});

		// Hàm để đặt lại bảng về trạng thái ban đầu
		function resetTable() {
			tableBody.innerHTML = originalTableBodyHtml;
		}
		document.addEventListener('DOMContentLoaded', function() {
			// ... (các phần khác của mã JavaScript)

			// Lắng nghe sự kiện click của nút double-left
			var doubleLeftButton = document
					.querySelector('.fa-angle-double-left');
			if (doubleLeftButton) {
				doubleLeftButton.addEventListener('click', function() {
					// Lấy URL hiện tại
					var currentURL = window.location.href;

					// Kiểm tra xem tham số pageNum có tồn tại không
					var hasPageNum = currentURL.includes("pageNum=");

					if (hasPageNum) {
						// Lấy giá trị hiện tại của tham số pageNum
						var currentPageNum = parseInt(currentURL
								.match(/pageNum=(\d+)/)[1]);

						// Giảm giá trị của tham số pageNum đi 1
						var previousPageNum = Math.max(currentPageNum - 1, 1);

						// Thay thế giá trị cũ của tham số pageNum bằng giá trị mới
						var newURL = currentURL.replace(/pageNum=\d+/,
								"pageNum=" + previousPageNum);

						// Chuyển hướng đến URL mới
						window.location.href = newURL;
					} else {
						// Nếu tham số pageNum không tồn tại, thêm nó với giá trị là 1
						window.location.href = currentURL
								+ (currentURL.includes("?") ? "&" : "?")
								+ "pageNum=1";
					}
				});
			}
			var doubleRightButton = document
					.querySelector('.fa-angle-double-right');
			if (doubleRightButton) {
				doubleRightButton.addEventListener('click', function() {
					// Lấy URL hiện tại
					var currentURL = window.location.href;

					// Kiểm tra xem tham số pageNum có tồn tại không
					var hasPageNum = currentURL.includes("pageNum=");

					if (hasPageNum) {
						// Lấy giá trị hiện tại của tham số pageNum
						var currentPageNum = parseInt(currentURL
								.match(/pageNum=(\d+)/)[1]);

						// Tăng giá trị của tham số pageNum lên 1
						var nextPageNum = currentPageNum + 1;

						// Thay thế giá trị cũ của tham số pageNum bằng giá trị mới
						var newURL = currentURL.replace(/pageNum=\d+/,
								"pageNum=" + nextPageNum);

						// Chuyển hướng đến URL mới
						window.location.href = newURL;
					} else {
						// Nếu tham số pageNum không tồn tại, thêm nó với giá trị là 2 (ví dụ)
						window.location.href = currentURL
								+ (currentURL.includes("?") ? "&" : "?")
								+ "pageNum=2";
					}
				});
			}
			// Lấy trang hiện tại từ tham số pageNum trong URL
			var currentPageNum = new URLSearchParams(window.location.search)
					.get('pageNum');

			// Lấy tất cả các li của pagination
			var paginationItems = document
					.querySelectorAll('.pagination .page-item');

			// Lặp qua từng li và kiểm tra xem có phải trang hiện tại không
			paginationItems.forEach(function(item) {
				var pageLink = item.querySelector('.page-link');
				if (pageLink
						&& pageLink.getAttribute('href').includes(
								"pageNum=" + currentPageNum)) {
					// Nếu là trang hiện tại, thêm lớp 'active' hoặc thay đổi trạng thái tương ứng
					item.classList.add('active');
				}
			});

		});
	</script>
</body>
</html>
