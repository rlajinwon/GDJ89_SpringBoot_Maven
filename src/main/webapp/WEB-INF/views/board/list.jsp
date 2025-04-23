<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:import url="/WEB-INF/views/templates/header.jsp"></c:import>

<title>Insert title here</title>
</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<c:import url="/WEB-INF/views/templates/sidebar.jsp"></c:import>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">


			<!-- Main Content -->
			<div id="content">

				<c:import url="/WEB-INF/views/templates/topbar.jsp"></c:import>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- 본문 들어갈 contents 내용 -->




					<h2>notice</h2>
					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">${kind}</h1>




					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<form action="./list" method="GET"
								class="form-inline my-2 my-lg-0">
								<!-- 드롭다운 -->
								<select class="form-control mr-sm-2" name="kind">
									<option value="k1" ${pager.kind eq 'k1' ? 'selected': ' ' }>제목</option>
									<option value="k2" ${pager.kind eq 'k2' ? 'selected': ' ' }>내용</option>
									<option value="k3" ${pager.kind eq 'k3' ? 'selected': ' ' }>작성자</option>
								</select>



								<!-- 검색어 입력 -->
								<input class="form-control mr-sm-2" type="text"
									placeholder="Search" aria-label="Search"
									value="${pager.search}" name="search">

								<!-- 회색 버튼 -->
								<button class="btn btn-outline-secondary my-2 my-sm-0"
									type="submit">Search</button>
							</form>


						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-borderless" id="dataTable"
									width="100%" cellspacing="0">
									<thead>
										<tr>
											<th>Num</th>
											<th>Title</th>
											<th>User</th>
											<th>Date</th>
											<th>Hit</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="vo">
											<tr>
												<td>${vo.boardNum}</td>
												<td><a href="/notice/detail?boardNum=${vo.boardNum}">${vo.boardTitle}</a>
												</td>
												<td>${vo.userName}</td>
												<td>${vo.boardDate}</td>
												<td>${vo.boardHit}</td>
											</tr>

										</c:forEach>
									</tbody>

								</table>
								<nav aria-label="Page navigation example">
									<ul class="pagination justify-content-center">

										<!-- 이전 페이지 버튼 -->
										<c:if test="${pager.page > 1}">
											<li class="page-item"><a class="page-link"
												href="?page=${pager.page - 1}&search=${pager.search}">Previous</a></li>
										</c:if>
										<c:if test="${pager.page == 1}">
											<li class="page-item disabled"><a class="page-link"
												href="#" tabindex="-1" aria-disabled="true">Previous</a></li>
										</c:if>

										<!-- 페이지 번호 버튼 -->
										<c:forEach var="i" begin="${pager.start}" end="${pager.end}">
											<li class="page-item ${i == pager.page ? 'active' : ''}">
												<a class="page-link"
												href="?page=${i} &search=${pager.search}">${i}</a>
											</li>
										</c:forEach>

										<!-- 다음 페이지 버튼 -->
										<c:if test="${!pager.endCheck}">
											<li class="page-item"><a class="page-link"
												href="?page=${pager.page + 1} &search=${pager.search}">Next</a></li>
										</c:if>
										<c:if test="${pager.endCheck}">
											<li class="page-item disabled"><a class="page-link"
												href="#" tabindex="-1" aria-disabled="true">Next</a></li>
										</c:if>

									</ul>
								</nav>


								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<div>
										<a href="./add" class="btn btn-dark">글 작성</a>
									</div>
								</sec:authorize>



							</div>
						</div>
					</div>







				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->
			<c:import url="/WEB-INF/views/templates/foot.jsp"></c:import>


		</div>
		<!-- End of Content Wrapper -->


	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>



	<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>

</body>
</html>