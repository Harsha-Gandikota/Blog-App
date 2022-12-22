<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			table{
				border:2px solid;
				width : 75%;
				margin: 30px auto;
			}
			th,td{
				border:1px solid;
				text-align: center;
			}	
	</style>
	</head>

	<body>
		<table>
			<thead>
				<tr>
					<th colspan="7">Blog Posts</th>
				</tr>
				<tr>
					<td>Title</td>
					<td>Author</td>
					<td>Excerpt</td>
					<td>Published status</td>
					<td>Created At</td>
					<td>Updated At</td>
					<td>Action</td>					
				</tr>
			</thead>
			<tbody>
				<core:forEach items="${postList}" var="post">
					<tr>
						<td>${post.title}</td>
						<td>${post.author}</td>
						<td>${post.excerpt}</td>
						<td>${post.isPublished}</td>
						<td>${post.createdDateTime}</td>
						<td>${post.updatedDateTime}</td>
						<td>
							<form action="displayBlog" method="post">
								<input type="hidden" value="${post.id}" name="postId"/>
								<input type="submit" value="View Blog"/>
							</form>
						</td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
		<a href="createBlog"><button type="button">Create Blog</button></a>
	</body>
</html>