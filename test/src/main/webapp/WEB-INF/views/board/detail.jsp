<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Board Detail Page</h1>
<hr>
<div>
	<form action="/board/modify" method="post" enctype="multipart/form-data">
	<table border="1">
		<tbody>
			<tr>
				<th>bno</th><td><input type="text" name="bno" id="bno" value="${board.bno }" readonly/></td>
				<th>writer</th><td>${board.writer }</td>
			</tr>
			<tr>
				<th>title</th>
				<td colspan="3">
					<input type="text" name="title" value="${board.title }" />
				</td>
			</tr>
			<tr>
				<th>content</th>
				<td colspan="3">
				<textarea name="content" rows="5" cols="60" style="font-size: 1.3em;">
				${board.content }
				</textarea></td>
			</tr>
			<tr>
				<th>regdate</th><td>${board.regdate }</td>
				<th>modifydate</th><td>${board.modifydate }</td>
			</tr>
			<tr>
				<td>file</td>
				<td colspan="3">
					<img src="/images/${board.filename }" alt="${board.filename }" />	
				</td>
			</tr>
			<tr>
				<td>파일수정</td>
				<td>
					<input type="file" name="file" />
				</td>
			</tr>
		</tbody>
	</table>
	<div>
		<button type="submit">수정</button>&nbsp;&nbsp;
		<button type="button" onclick="deleteBoard()">삭제</button>
	</div>
	</form>
</div>

<script>
	function deleteBoard(){
		alert("delete....");
		const bno = document.getElementById("bno");
		
		window.location.href="/board/board/delete/" + bno.value;
	}
</script>

</body>
</html>