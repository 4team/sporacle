<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search List View</title>
<style>
#searchList{
	width: 100%;
	
}

#searchList{
	background-color: #FFDFDF;
	border-collapse: collapse;
	padding : 10px;
}

#searchList tr:hover{
	background-color: #FFFFEF;
}

ul li {
	float: left;
	text-decoration: none;
	list-style: none;
	padding: 5px;
}

#wrapper{
	width:600px;
}

#searchPage {
	margin-left:50%;
}
</style>
</head>
<body>
	<h1>List Page</h1>


	${cri.toString()}

	<p></p>

	<table id="searchList">
		<c:forEach var="list" items="${list}">
			<tr>
				<td>번호 : ${list.bno}</td>
				<td>제목 : ${list.title}</td>
				<td>작성자 : ${list.writer}</td>
				<td>등록일 : ${list.regdate}</td>
			</tr>
		</c:forEach>
	</table>

	<p></p>

	<div id="wrapper">
		<div id="searchPage">
			<select id="searchType">
				<option value="n">-</option>
				<option value="t">제목</option>
				<option value="c">내용</option>
				<option value="w">작성자</option>
				<option value="tc">제목+내용</option>
				<option value="tw">제목+작성자</option>
			</select> <input id="keyword" type="text" name="keyword">


			<ul class="pagination" id="pageUL">
			</ul>
		</div>
	</div>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script>
		function makePage(criteria) {
			var startPage, endPage, prev, next;
			var str = "";
			var pageNo = criteria.pageNo;

			endPage = Math.ceil(pageNo / 10.0) * 10;
			startPage = endPage - 9;
			var tempLast = Math.ceil(criteria.totalCount / criteria.perPage);
			console.log('템프 라스트 : ' + tempLast);
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
				str += "<li><a href='/board/slist?pageNo=" + i + "'>" + i
						+ "</a></li>";
			}
			if (next) {
				str += "<li><a href='/board/slist?pageNo=" + (endPage + 1)
						+ "'> >> </a></li>";
			}

			return str;
		}

		$(document).ready(
				function() {
					var cri = {
						pageNo : 2,
						totalCount : 138,
						perPage : 10,
						searchType : 'w',
						keyword : '안녕'
					};
					var targetUL = $("#pageUL");
					targetUL.html(makePage(cri));

					targetUL.on("click", "li a", function(event) {
						event.preventDefault();
						var targetPage = $(this).attr("href");
						console.log('타겟 페이지 : ' + targetPage);
						self.location = targetPage;
					});

					var options = $("#searchType option");
					console.log('option size = ' + options.size());
					$("#searchType option[value=" + cri.searchType + "]").attr(
							"selected", "true");

					$("#keyword").val(cri.keyword);

				});
	</script>

</body>
</html>