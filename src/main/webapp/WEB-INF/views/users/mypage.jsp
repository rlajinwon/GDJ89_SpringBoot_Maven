<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/WEB-INF/views/templates/header.jsp"></c:import>
<title>마이페이지 - 회원정보 수정</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
</head>
<body id="page-top">

	<div id="wrapper">
		<c:import url="/WEB-INF/views/templates/sidebar.jsp"></c:import>

		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/templates/topbar.jsp"></c:import>

				<div class="container-fluid">

					<h3 class="mb-4">마이페이지</h3>

					<h3>
						ID :
						<sec:authentication property="name" />
					</h3>
					<sec:authentication property="principal" var="user" />
					<h3>EMAIL :${user.email}</h3>
					<h3>
						<sec:authentication property="principal.phone" />
					</h3>
					<h3>
						<sec:authentication property="principal.birth" />
					</h3>
					<h3>
						<sec:authentication property="principal.birth" />
					</h3>
					<img
						src="/files/user/<sec:authentication property='principal.fileName'/>"
						alt="프로필 이미지" class="rounded-circle"
						style="width: 150px; height: 150px; object-fit: cover;" />


				</div>
			</div>
			<c:import url="/WEB-INF/views/templates/foot.jsp"></c:import>
		</div>
	</div>

	<a class="scroll-to-top rounded" href="#page-top"><i
		class="fas fa-angle-up"></i></a>
	<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
</body>
</html>
