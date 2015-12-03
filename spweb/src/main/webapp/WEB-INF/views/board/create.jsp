<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../include/header.jsp" %>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <form method="post">
        	<div class="box-body">
        		<lable>Title</lable>
        	 	<input type="text" name="title" class="form-control" placeholder="Enter Title">
        	</div>
        	<div class="form-group">
        		<label>Content</label>
        		<textarea type="text" name="content" rows="3" placeholder="Enter..."></textarea>	
        	</div>
        	<div class="form-group">
        		<label>Writer</label>
        		<input type="text" name="writer" class="form-control" placeholder="Enter Writer">
        	</div>    
        	
        	<div class="box-footer">
        	<button type="submit" class="btn btn-primary">Submit</button>
        	</div>            
        </form>        
      </div>
      <!-- /.content-wrapper -->
     
<%@include file="../include/footer.jsp"%>
</body>
</html>