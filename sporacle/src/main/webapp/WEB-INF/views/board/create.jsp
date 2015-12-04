<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../include/header.jsp" %>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
 
      
        <form method="post">
        	<div class="box-body" style="text-align:center">
        		<label>Title &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label><br>
        	 	<input type="text" name="title" size="60px" >
        	</div>
        	<div class="box-body" style="text-align:center">
        		<label>Writer &nbsp&nbsp&nbsp </label><br>
        		<input type="text" name="writer" size="60px" >	
        	</div>
        	<div class="box-body" style="text-align:center">
        		<label>Content</label><br>
        		<textarea rows="15" cols="60"  name="content"></textarea>
        	</div>    
        	
        	 <div style="align:center"> 
        	<input type="submit" value="저장">
        	</div>
        	           
        </form>
         <div style="text-align:center"> 
        <form action ="/board/list" >
        <input type="submit" value="취소">  
        </form>   
            </div>
      </div>
 
      <!-- /.content-wrapper -->
     
<%@include file="../include/footer.jsp"%>
</body>
</html>