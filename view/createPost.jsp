<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form:form action="processBlog" method="post" modelAttribute="post">
			<form:hidden path="id"/>
			<table>
				<thead>
					<tr>
						<th colspan="2">Add/Edit the Blog Post</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Title:</td>
						<td><form:input path="title"/></td>
					</tr>
					<tr>
						<td>Author:</td>
						<td><form:input path="author"/></td>
					</tr>
					<tr>
						<td>Short Excerpt:</td>
						<td><form:input path="excerpt"/></td>
					</tr>
					<tr>
						<td>Content:</td>
						<td><form:textarea path="content"/></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" name="Post"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<a href="/Blog_Application/"><button type="button">Go Back</button></a>
	</body>
</html>