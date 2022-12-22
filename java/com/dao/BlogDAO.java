package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Comment;
import com.entity.Post;

@Repository
public class BlogDAO implements BlogDAOInterface {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean updateBlog(Post post) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(post);
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Post> getBlogs(){
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Post> postList= session.createQuery("from Post Order by createdDateTime desc").getResultList();
				
		return postList;
	}
	
	public Post getBlog(int id){
		
		Session session = sessionFactory.getCurrentSession();
		
		Post post = session.get(Post.class, id);
		
		return post;
	}
	
	public void deleteBlog(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Post post = session.get(Post.class, id);

		session.remove(post);
	}

	public void addComment(int id, Comment comment) {

		Session session = sessionFactory.getCurrentSession();
	
		Post post = session.get(Post.class, id);
	
		comment.setPost(post);
		
		session.saveOrUpdate(comment);
	}

	public void updateComment(Post post, Comment comment) {
		
		Session session = sessionFactory.getCurrentSession();
		
		comment.setPost(post);
		
		session.saveOrUpdate(comment);
	}
	
	
	public Comment getComment(int id) {

		Session session = sessionFactory.getCurrentSession();
		
		Comment comment = session.get(Comment.class, id);
		
		return comment;
	}
	
	public void deleteComment(int commentId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Comment comment = session.get(Comment.class, commentId);
		
		comment.getPost().getComments().remove(comment);
		
		session.remove(comment);
		
	}
	
}
