package com.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BlogDAOInterface;
import com.entity.Comment;
import com.entity.Post;

@Service
public class BlogService implements BlogServiceInterface {
	
	@Autowired
	private BlogDAOInterface blogDAOInterface;
	
	@Transactional
	public boolean updateBlog(Post post) {
		return blogDAOInterface.updateBlog(post);
	}
	
	@Transactional
	public List<Post> getBlogs(){
		return blogDAOInterface.getBlogs();
	}
	
	@Transactional
	public Post getBlog(int id) {
		return blogDAOInterface.getBlog(id);
	}
	
	@Transactional
	public void deleteBlog(int id) {
		blogDAOInterface.deleteBlog(id);
	}
	
	@Transactional
	public void addComment(int id, Comment comment) {
		blogDAOInterface.addComment(id,comment);
	}
	
	@Transactional
	public Comment getComment(int id) {
		return blogDAOInterface.getComment(id);
	}
	
	@Transactional
	public void updateComment(Post post, Comment comment) {
		blogDAOInterface.updateComment(post,comment);
	}
	
	@Transactional
	public void deleteComment(int commentId) {
		blogDAOInterface.deleteComment(commentId);
	}
}
