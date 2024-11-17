<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Board List Page with Paging</h1>
<hr>
<div>
	<c:if test="${param.result != null }">
		${param.result } 행이 삭제되었습니다.
	</c:if>
</div>
	
<div>
	<p><a href="/board/registForm">게시글 작성하기</a></p>
</div>
<div>
	<table border="1">
		<thead>
			<tr>
				<th>bno</th><th>title</th><th>writer</th><th>Uploaded File</th><th>regdate</th><th>modifydate</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.bno }</td>
				<td><a href="/board/board/${board.bno }">${board.title }</a></td>
				<td>${board.writer }</td>
				<td><img src="/images/${board.filename }" alt="${board.filename }이미지" width="100px"/></td>
				<td>${board.regdate }</td>
				<td>${board.modifydate }</td>
			</tr>
		</c:forEach>	
		</tbody>
	</table>
	<div>
	페이지번호 : ${cri.pageNum } / 끝번호 : ${endNum }<br />
	<c:if test="${cri.pageNum > 1 }">
		<a href="/board/listWithPaging2?pageNum=${cri.pageNum - 1 }&amount=${cri.amount }">[이전]</a>
	</c:if>
	<c:forEach var="pageNum" begin="1" end="${endNum }" step="1">
		<c:if test="${pageNum eq cri.pageNum }">
			<b><a href="/board/listWithPaging2?pageNum=${pageNum }&amount=${cri.amount }">${pageNum }</a></b>&nbsp;&nbsp;
		</c:if>
		<c:if test="${pageNum ne cri.pageNum }">
			<a href="/board/listWithPaging2?pageNum=${pageNum }&amount=${cri.amount }">${pageNum }</a>&nbsp;&nbsp;
		</c:if>
	</c:forEach>
	<c:if test="${cri.pageNum < endNum }">
		<a href="/board/listWithPaging2?pageNum=${cri.pageNum + 1 }&amount=${cri.amount }">[다음]</a>
	</c:if>
</div>
</div>

</body>
</html>