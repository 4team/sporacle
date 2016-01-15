<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../include/header.jsp" %>

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
        		   
        		      			<div class="content1">
			<table>
				<tr>
					<td>

						<ul id="replies">
						</ul>
	<div class="content2">
		<div id="pagination">
			<table id="replyPaging">
				<tr>
				<tr>
			</table>
		</div>
	</div>
					</td>
				</tr>
				<tr>
					<td>작성자<input type="text" id="writer" name="writer">
						내용<input type="text" id="replytext" name="replytext">
					<button id="replyCBtn">댓글달기</button></td>
				</tr>
			</table>

		</div>
      </div><!-- /.content-wrapper -->
     
<%@include file="../include/footer.jsp"%>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<script type="text/javascript">
function getAllList(bno){
	var str = "";

	$.getJSON("/replies/all/"+bno,function(data){
		
		$(data).each(function(){
			str +="<div data-rno='"+this.rno+"' data-writer='"+this.writer+"'  data-content='"+this.replytext+"' class='replyDiv'> - "+this.writer + "님 : " +"<li  class='replyLi'>"+this.replytext+"</li><button>+</button></div>";			
		});
		
		$("#replies").html(str);
		
	});
}
</script>

<script type="text/javascript">
$(document).ready(function(){
	
	var listButton = $("#listButton");
	console.log(listButton);

	listButton.on("click",function(event){
		event.preventDefault();
		console.log(this);
		self.location = '/board/slist?${cri.getLink()}';
	});
	
	
	
	var bno = ${cri.bno};
	
	getAllList(bno,1);

	$("#replyCBtn").on("click",function(event){
		event.preventDefault();
		
		var writer = $("#writer").val();
		var replytext = $("#replytext").val();
		
		$.ajax({
			type:"post",
			url:"/replies/",
			headers:{"Content-Type":"application/json","X-HTTP-Method-Override":"POST"},
			dataType:"text",
			data:JSON.stringify({bno:bno,writer:writer,replytext:replytext}),
			success:function(result){
				if(result=='SUCCESS'){
					getAllList(bno,1);
				}
			}
		});
		$("#writer").val("");
		$("#replytext").val("");

	});
	
	
	$("#replies").on("click","div button",function(){
		
		var reply = $(this).parent();
		
		var target = $("#replyModifyDiv");
		target.show('slow');
		
		var rno = $("#rno");
		var writer = $("#newWriter");
		var content = $("#replyText");
		
		writer.val(reply.attr("data-writer"));
		content.val(reply.attr("data-content"));
		rno.val(reply.attr("data-rno"));
	});
	
	
	
	
	$("#replyModify").on("click",function(event){
		event.preventDefault();
		
		var rno = $("#rno").val();
		var writer = $("#newWriter").val();
		var replytext = $("#replyText").val();
		
		console.log("modify : "+rno,writer,replytext);
		
		$.ajax({
			type:"put",
			url:"/replies/",
			headers:{"Content-Type":"application/json","X-HTTP-Method-Override":"PUT"},
			dataType:"text",
			data:JSON.stringify({rno:rno,writer:writer,replytext:replytext}),
			success:function(result){
				if(result=='SUCCESS'){
					getAllList(bno,1);
				}
			}
		});

		var target = $("#replyModifyDiv");
		target.hide('slow');
	});
	
	
	$("#replyDelete").on("click",function(event){
		event.preventDefault();
		var rno = $("#rno").val();
		
		$.ajax({
			type:"delete",
			url:"/replies/"+rno,
			headers:{"Content-Type":"application/json","X-HTTP-Method-Override":"DELETE"},
			dataType:"text",
			success:function(result){
				if(result=='SUCCESS'){
					getAllList(bno,1);
				}
			}
		});
		var target = $("#replyModifyDiv");
		target.hide('slow');
	});
	
	
	$("#replyCancle").on("click",function(event){
		var target = $("#replyModifyDiv");
		target.hide('slow');
	});

});
</script>

 </body>
</html>
    