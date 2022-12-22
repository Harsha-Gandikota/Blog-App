package com.dao;

import java.util.List;

import com.entity.Comment;
import com.entity.Post;

public interface BlogDAOInterface {
	
	public boolean updateBlog(Post post);

	public List<Post> getBlogs();
	
	public Post getBlog(int id);
	
	public void deleteBlog(int id);
	
	public void addComment(int id, Comment comment);
	
	public void updateComment(Post post, Comment comment);
	
	public void deleteComment(int commentId);
	
	public Comment getComment(int id);
}
