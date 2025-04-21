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



					<div class="container">

						<div class="card o-hidden border-0 shadow-lg my-5">
							<div class="card-body p-0">
								<!-- Nested Row within Card Body -->
								<div class="row">
									<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
									<div class="col-lg-7">
										<div class="p-5">
											<div class="text-center">
												<h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
											</div>
											<form class="user" method="post" enctype="multipart/form-data"
												action="${pageContext.request.contextPath}/users/join">
												<div class="form-group row">
													<div class="col">
														<input type="text" name="username"
															class="form-control form-control-user" id="username"
															placeholder="아이디">
													</div>


												</div>

												<div class="form-group row">
													<div class="col-sm-6 mb-3 mb-sm-0">
														<input type="password" name="password"
															class="form-control form-control-user"
															id="exampleInputPassword" placeholder="비밀번호">
													</div>
													<div class="col-sm-6">
														<input type="password" name="password"
															class="form-control form-control-user"
															id="exampleRepeatPassword" placeholder="비밀번호 확인">
													</div>
												</div>

												<div class="form-group">
													<input type="text" name="email"
														class="form-control form-control-user"
														id="exampleInputEmail" placeholder="이메일">
												</div>

												<div class="form-group">
													<input type="text" name="phone"
														class="form-control form-control-user"
														id="exampleInputPhone" placeholder="핸드폰 번호">
												</div>

												<div class="form-group">
													<input type="date" name="birth"
														class="form-control form-control-user"
														id="exampleInputDate" placeholder="생년월일">
												</div>
												
											             
			                                <div class="form-group">
			                                    <input type="file" id="avatar" name="avatar">
			                                </div>
												    
												    
												    


												<button type="submit"
													class="btn btn-primary btn-user btn-block">회원가입</button>
													
												<hr>
												<a href="index.html"
													class="btn btn-google btn-user btn-block"> <i
													class="fab fa-google fa-fw"></i> Register with Google
												</a> <a href="index.html"
													class="btn btn-facebook btn-user btn-block"> <i
													class="fab fa-facebook-f fa-fw"></i> Register with Facebook
												</a>
											</form>
											<hr>
											<div class="text-center">
												<a class="small" href="forgot-password.html">Forgot
													Password?</a>
											</div>
											<div class="text-center">
												<a class="small" href="login.html">Already have an
													account? Login!</a>
											</div>
										</div>
									</div>
								</div>
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