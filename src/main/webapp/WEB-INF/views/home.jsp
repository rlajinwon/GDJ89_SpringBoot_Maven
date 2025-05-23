<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:import url="./templates/header.jsp"></c:import>

<title>Insert title here</title>
</head>
<body id="page-top">

   <!-- Page Wrapper -->
   <div id="wrapper">   

      <c:import url="./templates/sidebar.jsp"></c:import>

      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">
            

         <!-- Main Content -->
         <div id="content">
         
            <c:import url="./templates/topbar.jsp"></c:import>

            <!-- Begin Page Content -->
            <div class="container-fluid">
               
               <!-- 본문 들어갈 contents 내용 -->
               
            
            	<h2>환영합니다</h2>
            
            
           <sec:authorize access="isAuthenticated()">
            	<h3>USERNAME : <sec:authentication property="principal.username"/></h3>
            </sec:authorize>
            
            
            
            
            
            </div>
            <!-- /.container-fluid -->

         </div>
         <!-- End of Main Content -->         
		<c:import url="./templates/foot.jsp"></c:import>
         
   
      </div>
      <!-- End of Content Wrapper -->

      
   </div>
   <!-- End of Page Wrapper -->
   
   <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
    
    
    
    <c:import url="./templates/footer.jsp"></c:import>
	
</body>
</html>