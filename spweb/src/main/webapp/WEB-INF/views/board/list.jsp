<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../include/header.jsp" %>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        
        <table class="table table-bordered">
        	<tr>
        		<th style="width: 10px">BNO</th>
        		<th>TITLE</th>
        		<th>WRITER</th>
        		<!-- <th>REGDATE</th>
        		<th style="width : 40px"> VIEWCNT</th> -->
        	</tr>
        	
        	<c:forEach items="${list}" var="boardVO">
        	 
        		<tr>
        			<td>${boardVO.bno}</td>
        			<td><a href= ''>${boardVO.title}</a></td>
        			<td>${boardVO.writer}</td>
        			<!--<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}"/></td>
        			<td><span class="badge bg-red">${boradVO.viewcnt}</span></td>-->
        		</tr>	
        	
        	
        	
        	</c:forEach>	
        		
        
        
        </table>

      </div><!-- /.content-wrapper -->
     
<%@include file="../include/footer.jsp"%>

 </body>
</html>
    