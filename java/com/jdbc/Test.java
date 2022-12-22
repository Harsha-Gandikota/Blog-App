package com.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Comment;
import com.entity.Post;

public class Test {

		
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Post.class).addAnnotatedClass(Comment.class).buildSessionFactory();	
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			session.beginTransaction();
			
			Post post = session.get(Post.class, 20);
			System.out.println(post.getComments());
			Comment comment = session.get(Comment.class, 1);
			comment.getPost().getComments().remove(comment);
			System.out.println(post.getComments());
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}
}
