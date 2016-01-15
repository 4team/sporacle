<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="../../../../resources/css/slist.css">
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link >
<h1>List Page</h1>
	${cri.toString()}
	<table id="searchList">
		<th>번호</th><th>제목</th><th>작성자</th><th>올린 날짜</th>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.bno}</td>
				<td><a href='/board/read?pageNo=${cri.pageNo}&bno=${list.bno}&type=${cri.type}&keyword=${cri.keyword}'>${list.title} [${list.replycnt }]</a></td>
				<td>${list.writer}</td>
				<td>${list.regdate}</td>
			</tr>
		</c:forEach>
	</table>

	<p></p>


	<div id="wrapper">
		<div id="searchPage">
	<form>
			<select id="searchType" name="type">
				<option value="n"></option>
				<option value="t">제목</option>
				<option value="c">내용</option>
				<option value="w">작성자</option>
				<option value="tc">제목+내용</option>
				<option value="tw">제목+작성자</option>
			</select> 
				<input id="keyword" type="text" name="keyword">
				<input type="submit" value="검색">
				<button id="listAll">전체목록</button>
				<button id="addBoard">글쓰기</button>
	</form>


			<ul class="pagination" id="pageUL">
			</ul>
		</div>
	</div>



<script>
var cri = {
	pageNo : ${cri.pageNo},
	totalCount : ${cri.totalCount},
	perPage : ${cri.perPage},
	type : '${cri.type}',
	keyword : '${cri.keyword}'
};

$(document).ready(function(){
	
	var targetUL = $("#pageUL");
	targetUL.html(makePage(cri));




	
	function makePage(criteria) {
	
	var startPage, endPage, prev, next;
	var str = "";
	var pageNo = criteria.pageNo;

	endPage = Math.ceil(pageNo / 10.0) * 10;
	startPage = endPage - 9;
	var tempLast = Math.ceil(criteria.totalCount / criteria.perPage);
	console.log('시작페이지: ' + startPage, '  마지막페이지: ' + endPage);
	endPage = tempLast < endPage ? tempLast : endPage;
	console.log('IF 후 시작페이지: ' + startPage, '  마지막페이지: ' + endPage);
	prev = startPage == 1 ? false : true;
	next = tempLast > endPage ? true : false;

	if (prev) {
		str += "<li><a href='/board/slist?pageNo=" + (startPage - 1)
				+ "'> << </a></li>";
	}
	for (var i = startPage; i <= endPage; i++) {
		str += "<li><a href='javascript:changePage(event," + i +");'>" + i
				+ "</a></li>";
	}
	if (next) {
		str += "<li><a href='/board/slist?pageNo=" + (endPage + 1)
				+ "'> >> </a></li>";
	}

	return str;
};

	
		
		
		var options = $("#searchType option");
		console.log('option size = ' + options.size());
		$("#searchType option[value='"+cri.type+"']").attr("selected","true");
	
		$("#keyword").val(cri.keyword);
		
		
		$("#listAll").on("click",function(event){
			event.preventDefault();
			self.location = "/board/slist?pageNo=1";
});
		
		
		
	$("#addBoard").on("click",function(){
		self.location = "/board/create?";
	});
	
});



function changePage(event,pageNo){
	console.log("이동할 페이지 : "+pageNo,"얻은 Criteria : "+typeof cri);
	var target = "";
	console.log("페이지: "+pageNo);
	target += "?pageNo="+pageNo;
	
	console.log("changPage에서의 cri.type : "+cri.type,"changPage에서의 cri.keyword : "+cri.keyword);
			
	if(cri.type){
		target +="&type="+cri.type;
	}
	if(cri.keyword){
		target +="&keyword="+cri.keyword;
	}
	
	self.location = "/board/slist"+target;
};




</script>
<%@include file="../include/footer.jsp"%>

</body>
</html>