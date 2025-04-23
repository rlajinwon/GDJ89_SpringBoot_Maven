<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
<c:import url="/WEB-INF/views/templates/header.jsp"></c:import>
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.css" rel="stylesheet">
 
 
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

               <h2>${kind} 글 작성</h2>

               <form action="" method="post" class="mt-4" enctype="multipart/form-data">
                  <div class="form-group">
                     <label for="boardTitle">제목</label>
                     <input type="text" class="form-control" id="boardTitle" name="boardTitle" required>
                  </div>

    
    			
    
    

                  <div class="form-group">
                     <label for="boardContents">내용</label>
                     <textarea class="form-control" id="boardContents" name="boardContents" rows="10" required></textarea>
                  </div>
                  
                  <div>
    				<input type="file" name="attaches"><br>
    				<input type="file" name="attaches"><br>
    				<input type="file" name="attaches"><br>
    			</div>
    
                  
                  <button type="submit" class="btn btn-primary mt-3">작성</button>
                  

                  <a href="/notice/list" class="btn btn-secondary mt-3">목록으로</a>
               </form>

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
   <a class="scroll-to-top rounded" href="#page-top">
       <i class="fas fa-angle-up"></i>
   </a>

   <c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
   <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.js"></script>
	
	 <script>
      $('#boardContents').summernote({
        tabsize: 2,
        height: 500
      });
    </script>
</body>
</html>
