<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Main Page</h1>
<hr>
<ol>
	<li><a href="/registForm">registForm(Member)</a></li>
	<li><a href="/login">loginForm</a></li>
	<li>---------------------------------------</li>
	<li><a href="/board/list">게시글 목록보기</a></li>
	<li><a href="/board/registForm">게시글 등록하기</a></li>
	<li>---------------------------------------</li>
	<li><a href="/board/listWithPaging?pageNum=1">게시글 목록보기(페이지네이션)</a></li>
	<li><a href="/board/listWithPaging2?pageNum=1&amount=5">게시글 목록보기2(페이지네이션2)</a></li>
</ol>
<form action="/board/modify">
	<input type="submit" value="전송">
</form>
</body>
</html>