<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Cos Blog</title>
  <!-- Bootstrap core CSS -->
  <link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath() %>/css/blog-home.css" rel="stylesheet">
  <!-- Bootstrap core JavaScript -->
  <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<!-- Nav Include -->
	<jsp:include page="/include/header.jsp"/>
  <c:if test="${member!=null }">

  <!-- Page Content -->
	<div class="container">
   <div class="row">
     <!-- Blog Entries Column -->
     <div class="col-md-8">
     	<div class="content-section">
     		<form method="POST" action="<%=request.getContextPath() %>/member?cmd=member_update">
     			<fieldset class="form-group">     			
     				<legend class="border-bottom mb-4">Account</legend>
     				<div class="form-goup">
     				 <label class="form-control-label">ID</label>
     				 <input class="form-control form-control-lg" type="text" name="id" value="${member.getId()}" maxlength="20" readonly>
     				</div>
     				<div class="form-goup">
     				 <label class="form-control-label">Password</label>
     				 <input class="form-control form-control-lg" type="password" name="password" maxlength="20" required>
     				</div>
     				<div class="form-goup">
     				 <label class="form-control-label">New Password</label>
     				 <input class="form-control form-control-lg" type="password" name="confirm" maxlength="20" required>
     				</div>
     				<div class="form-goup">
     				 <label class="form-control-label">Confirm Password</label>
     				 <input class="form-control form-control-lg" type="password" name="confirm" maxlength="20" required>
     				</div>
     				<div class="form-goup">
     				 <label class="form-control-label">User Name</label>
     				 <input class="form-control form-control-lg" type="text" name="username" value="${member.getUsername()}"maxlength="20" required>
     				</div>
     				<div class="form-goup">
     				 <label class="form-control-label">E-mail</label>
     				 <input class="form-control form-control-lg" type="email" name="email" value="${member.getEmail()}"maxlength="20" required>     				 
     				</div>
     				<c:choose>
     				 <c:when test="${member.isEmailcheck() == false}">
     				  <div class="border-top pt-3">
     					<small class="text-muted">
     					You can use this Blog after e-mail certification.
     					<button class="btn btn-outline-info" type="button">Modify</button>
     					</small>
     				</div>
     				 </c:when>
     				 </c:choose>     				
     				<div class="form-group">
     					<button class="btn btn-outline-info" type="submit">Modify</button>
     				</div>     				     			
     			</fieldset>
     		</form>
     	</div>      
     </div>

	<!-- SideBar Include -->
	<jsp:include page="/include/aside.jsp"/>

   </div>
   <!-- /.row -->

 </div>
 <!-- /.container -->

 <!-- Footer -->
 <footer class="py-5 bg-dark">
   <div class="container">
     <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
   </div>
   <!-- /.container -->
 </footer>

 
  </c:if>

</body>

</html>
