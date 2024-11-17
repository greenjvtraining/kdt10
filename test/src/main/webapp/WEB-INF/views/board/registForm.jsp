<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Board Regist Form</h1>
<div>
	<form action="/board/regist" method="post" enctype="multipart/form-data">
	<table border="1">
		<tbody>
			<tr>
				<th>writer</th><td><input type="text" name="writer" value=""/></td>
			</tr>
			<tr>
				<th>title</th>
				<td colspan="3">
					<input type="text" name="title" />
				</td>
			</tr>
			<tr>
				<th>content</th>
				<td colspan="3">
				<textarea name="content" rows="5" cols="60" style="font-size: 1.3em;">
				</textarea></td>
			</tr>
			<tr>
				<th>file</th>
				<td><input type="file" name="file" /></td>
			</tr>
		</tbody>
	</table>
	<div>
		<button type="submit">등록</button>&nbsp;&nbsp;
	</div>
	</form>
</div>
</body>
</html>