<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Update comment</title>
	</head>
	<body>
		<h1>Update Comment</h1>
		<form:form action="updateCommentData" method="post" modelAttribute="comment">
			<input type="hidden" name="postId" value="${comment.post.id}">
			<form:hidden path="id"/>
			Name:<form:input path="name"/><br>
			Email:<form:input path="email"/><br>
			Comment:<form:input path="comment"/><br>
			<input type="Submit" value="Update Comment"><br>
		</form:form>
		<form action="displayBlog">
			<button type="submit" name="postId" value="${comment.post.id}">Cancel</button>
		</form>
	</body>
</html>