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
		<h1>${post.title}</h1>
		<table>
			<tbody>
				<tr>
					<td>Author:</td>
					<td>${post.author}</td>		
				</tr>				
				<tr>
					<td>Content:</td>
					<td>${post.content}</td>		
				</tr>
				<tr>
					<td>Created at:</td>
					<td>${post.createdDateTime}</td>		
				</tr>				
				<tr>
					<td>Last Updated at:</td>
					<td>${post.updatedDateTime}</td>		
				</tr>				
			</tbody>
		</table>
		<form action="updateBlog" method="post">
			<input type="hidden" value="${post.id}" name="postId"/>
			<input type="submit" value="Edit Blog"/>
		</form>
		<form action="deleteBlog" method="post">
			<input type="hidden" value="${post.id}" name="postId"/>
			<input type="submit" value="Delete Blog"/>
		</form>
		<h3>Add Comment</h3>
		<form:form action = "addComment" method="post" modelAttribute="comment">
			<input type="hidden" value="${post.id}" name="postId">
			Name:<form:input path="name"/><br>
			Email:<form:input path="email"/><br>
			Comment:<form:input path="comment"/><br>
			<input type=submit>
		</form:form>

		<a href="/Blog_Application/"><button type="button">View Blogs</button></a>

		<h3> List of Comments</h3>
		<core:forEach items="${comments}" var="comment">
			<table>
				<tbody>
					<tr>
						<td>Name:</td>
						<td>${comment.name}</td>		
					</tr>				
					<tr>
						<td>Email:</td>
						<td>${comment.email}</td>		
					</tr>
					<tr>
						<td>Comment:</td>
						<td>${comment.comment}</td>		
					</tr>
					<tr>
						<td>Created at:</td>
						<td>${comment.createdDateTime}</td>		
					</tr>				
					<tr>
						<td>Last Updated at:</td>
						<td>${comment.updatedDateTime}</td>		
					</tr>
					<tr>
						<td>
							<form action="updateComment" method="post">
								<input type="hidden" value="${comment.post.id}" name="postId"/>
								<input type="hidden" value="${comment.id}" name="commentId"/>
								<input type="submit" value="Edit comment"/>
							</form>
						</td>
						<td>
							<form action="deleteComment" method="post">
								<input type="hidden" value="${comment.post.id}" name="postId"/>
								<input type="hidden" value="${comment.id}" name="commentId"/>
								<input type="submit" value="Delete comment"/>
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</core:forEach>
	</body>
</html>