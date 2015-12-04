<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../include/header.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
<style>
table, th, td {
	border: 1px solid white;
	border-collapse: collapse;
}

th, td {
	padding: 6px;
	text-align: center;
}
</style>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<!-- Content Header (Page header) -->
	<h2>${cri.toString()}</h2>
	<div style="padding: 70px">
		<h2>이용후기</h2>
		<br>
		<table>
			<tr>
				<th style="width: 100px">번호</th>
				<th style="width: 580px">제목</th>
				<th style="width: 150px">작성자</th>
				<th style="width: 150px">작성일</th>
				<th style="width: 120px">추천수</th>
				<th style="width: 120px">조회수</th>
			</tr>

			<c:forEach items="${list}" var="boardVO">

				<tr>
					<td>${boardVO.bno}</td>
					<td><a href='/board/read?bno=${boardVO.bno}'>${boardVO.title}</a></td>
					<td>${boardVO.writer}</td>
					<td>${boardVO.regdate}</td>
					<td>${boradVO.viewcnt}</td>
					<td>${boradVO.reccnt}</td>

				</tr>
			</c:forEach>
		</table>
		<div style="padding: 10px" align="right">
			<form action="/board/create">
				<input type="image" src="/resources/image/22.png">
			</form>
		</div>

		<ul class="pagination" id="pageUL">

		</ul>
	</div>

</div>
<!-- /.content-wrapper -->

<script src="pageMaker.js"></script>
<script>
$(document).ready(function(){
    var cri = {pageNo:11,totalCount:138, perPage:10};


    $("#pageUL").on("click","li a",function(event){
        event.preventDefault();
       console.log(this);
        var targetPage = $(this).attr("href");
        console.log(targetPage);
        
        self.location = targetPage;
    });
    $("#pageUL").html(makePage(cri)); //dom이 만들어 지기 전에 이벤트를 걸면 이벤트가 걸리지 않느다.

});



</script>

<%@include file="../include/footer.jsp"%>

</body>
</html>
