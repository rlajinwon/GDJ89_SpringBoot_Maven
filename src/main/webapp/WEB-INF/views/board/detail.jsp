<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

					<h2>${kind}</h2>





					<table class="table table-dark ">
						<thead>
							<tr>
								<th>TITLE</th>
								<th>WRITER</th>
								<th>DATE</th>
								<th>HIT</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>${vo.boardTitle}</td>
								<td>${vo.userName}</td>
								<td>${vo.boardDate}</td>
								<td>${vo.boardHit}</td>
							</tr>
					</table>



					<div class="alert alert-dark" role="alert" style="min-height: 60vh">
						${vo.boardContents}</div>

					<div class="card-body">
						<c:forEach items="${vo.boardFileVO}" var="f">
							<a href="./fileDown?fileNum=${f.fileNum} ">${f.oldName}</a>
						<%-- 	<img alt="" src="/files/${kind}/${f.fileName}"> --%>
						</c:forEach>
					</div>




					<form action="./delete" method="post" style="display: inline;">
						<input type="hidden" name="boardNum" value="${vo.boardNum}" />
						<button type="submit" class="btn btn-dark">글 삭제</button>
					</form>

					<a href="./update?boardNum=${vo.boardNum}"
						class="btn btn-outline-success">수정</a>








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