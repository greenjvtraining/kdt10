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
<h1>Board List Page</h1>
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
</div>
</body>
</html>