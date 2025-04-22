<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/WEB-INF/views/templates/header.jsp"></c:import>
<title>마이페이지 - 회원정보 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypage.css">
</head>
<body id="page-top">

	<div id="wrapper">
		<c:import url="/WEB-INF/views/templates/sidebar.jsp"></c:import>

		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/templates/topbar.jsp"></c:import>

				<div class="container-fluid">

					<h2 class="mb-4">회원정보 수정</h2>

					<div class="card shadow p-4">
						<form:form modelAttribute="userVO" method="post" enctype="multipart/form-data"
							action="${pageContext.request.contextPath}/users/update">
							
							<div class="mb-3">
								<label for="username" class="form-label">아이디</label>
								<input type="text" class="form-control" id="username" name="username" value="${user.username}" readonly />
							</div>

							<div class="mb-3">
								<label for="name" class="form-label">이름</label>
								<input type="text" class="form-control" id="name" name="name" value="${user.name}" />
								<form:errors path="name" cssClass="text-danger" />
							</div>

							<div class="mb-3">
								<label for="email" class="form-label">이메일</label>
								<input type="email" class="form-control" id="email" name="email" value="${user.email}" />
								<form:errors path="email" cssClass="text-danger" />
							</div>

							<div class="mb-3">
								<label for="phone" class="form-label">전화번호</label>
								<input type="text" class="form-control" id="phone" name="phone" value="${user.phone}" />
								<form:errors path="phone" cssClass="text-danger" />
							</div>

							<div class="mb-3">
								<label for="birth" class="form-label">생년월일</label>
								<input type="date" class="form-control" id="birth" name="birth" value="${user.birth}" />
								<form:errors path="birth" cssClass="text-danger" />
							</div>

							<div class="mb-3">
								<label for="avatar" class="form-label">프로필 이미지</label>
								<input type="file" class="form-control" id="avatar" name="avatar" />
							</div>

							<button type="submit" class="btn btn-primary">정보 수정</button>
						</form:form>
					</div>

				</div>
			</div>
			<c:import url="/WEB-INF/views/templates/foot.jsp"></c:import>
		</div>
	</div>

	<a class="scroll-to-top rounded" href="#page-top"><i class="fas fa-angle-up"></i></a>
	<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
</body>
</html>
