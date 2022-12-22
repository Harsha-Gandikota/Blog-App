package com.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String excerpt;
	
	private String content;
	
	private String author;
	
	@Column(name="published_at")
	private Timestamp publishedDateTime;

	@Column(name="is_published")
	private String isPublished;
	
	@Column(name="created_at",updatable = false)
	@CreationTimestamp
	private Timestamp createdDateTime;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Timestamp updatedDateTime;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "post",cascade = {CascadeType.ALL})
	private List<Comment> comments;

//	@ManyToMany(cascade=CascadeType.ALL)
//	private List<Tag> tag = new ArrayList<>();
		
//	public List<Tag> getTag() {
//	return tag;
//}
//
//public void setTag(List<Tag> tag) {
//	this.tag = tag;
//}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	public Post() {
		
	}


	public Post(String title, String excerpt, String content, String author) {
		this.title = title;
		this.excerpt = excerpt;
		this.content = content;
		this.author = author;
		isPublished = "No";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getExcerpt() {
		return excerpt;
	}


	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Timestamp getPublishedDateTime() {
		return publishedDateTime;
	}


	public void setPublishedDateTime(Timestamp publishedDateTime) {
		this.publishedDateTime = publishedDateTime;
	}


	public String getIsPublished() {
		return isPublished;
	}


	public void setIsPublished(String isPublished) {
		this.isPublished = isPublished;
	}


	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}


	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}


	public Timestamp getUpdatedDateTime() {
		return updatedDateTime;
	}


	public void setUpdatedDateTime(Timestamp updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public void add(Comment comment) {
		 if (comments==null) {
			comments = new ArrayList<>(); 
		 }
		 comments.add(comment);
		 comment.setPost(this);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", excerpt=" + excerpt + ", content=" + content + ", author="
				+ author + ", publishedDateTime=" + publishedDateTime + ", isPublished=" + isPublished
				+ ", createdDateTime=" + createdDateTime + ", updatedDateTime=" + updatedDateTime + ", comments="
				+ comments + ", tag=";// + tag + "]";
	}
	
}
