<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../include/header.jsp" %>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
${cri.getLink()}
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
<button id="listButton">목록</button>
		   
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

<script>
console.log("뷰 페이지....");

		
var listButton = $("#listButton");
console.log(listButton);

listButton.on("click",function(event){
	event.preventDefault();
	console.log(this);
	self.location = '/board/slist?${cri.getLink()}';
});

	
</script>


 </body>
</html>
    