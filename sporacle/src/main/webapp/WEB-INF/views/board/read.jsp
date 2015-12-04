<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../include/header.jsp" %>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        
        <input type='hidden' name='bno' value="${read.bno}">
        
        <table class="table table-bordered">
        	
        		<tr style="width: 10px"><td>BNO : ${read.bno}</td></tr>
        		<tr><td>TITLE : ${read.title}</td></tr>
        		<tr><td>WRITER : ${read.writer}</td></tr>
        		<tr><td>CONTENT : ${read.content}</td></tr>
        		
        		</table>
        		
        		
        		<!-- <th>REGDATE</th>
        		<th style="width : 40px"> VIEWCNT</th> -->
        	
        	
        			<!--<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}"/></td>
        			<td><span class="badge bg-red">${boradVO.viewcnt}</span></td>-->
        		   
<form action="/board/list">
<input type="submit" value="목록">
</form>
		   
<form action="/board/modify">
<input type="hidden" name="bno" value="${read.bno}">
<input type="submit" value="수정">
</form>
		   
<form action="/board/remove" method="post">
<input type="hidden" name="bno" value="${read.bno}">
<input type="submit" value="삭제">
</form>
        		   
        		      		
      </div><!-- /.content-wrapper -->
     
<%@include file="../include/footer.jsp"%>

 </body>
</html>
    