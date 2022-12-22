package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.BlogServiceInterface;
import com.entity.Comment;
import com.entity.Post;

@Controller
public class BlogController {
	
	@Autowired
	private BlogServiceInterface blogServiceInterface;
	
	@RequestMapping("/")
	public String getBlogs(Model model) {
		
		List<Post> blogList = blogServiceInterface.getBlogs();
		
		model.addAttribute("postList", blogList);
		
		return "displayBlogs";
	}
	
	@RequestMapping("/displayBlog")
	public String displayBlog(@RequestParam(name="postId") String postId, Model model) {
		
		Post post = blogServiceInterface.getBlog(Integer.parseInt(postId));
		
		model.addAttribute("post", post) ;
		
		model.addAttribute("comments",post.getComments()) ;

		Comment comment = new Comment();

		model.addAttribute("comment",comment);
		
		return "displayBlog";
	}
	
	@RequestMapping("/createBlog")
	public String createBlog(Model model) {
		
		Post post = new Post();
		
		model.addAttribute("post",post);
		
		return "createPost";
	}
	
	@PostMapping("/processBlog")
	public String processBlog(@ModelAttribute("post") Post post) {
		
		post.setIsPublished("No");
		
		blogServiceInterface.updateBlog(post);
		
		return "redirect:/";
	}
	
	@PostMapping("/updateBlog")
	public String updateBlog(@RequestParam(name="postId") String postId, Model model) {
		
		Post post = blogServiceInterface.getBlog(Integer.parseInt(postId));
		
		model.addAttribute("post",post) ;
			
		return "createPost";
	}
	
	@PostMapping("/deleteBlog")
	public String deleteBlog(@RequestParam(name="postId") String postId) {
		
		int id = Integer.parseInt(postId);
		
		blogServiceInterface.deleteBlog(id);
		
		return "redirect:/";
	}
	
	
	@PostMapping("/addComment")
	public String addComment(@RequestParam(name="postId") String postId,@ModelAttribute("comment") Comment comment, Model model) {

		blogServiceInterface.addComment(Integer.parseInt(postId),comment);
		
		model.addAttribute("postId", postId);

		return "redirect:/displayBlog";
	}
	
	@PostMapping("/updateComment")
	public String updateComment(@RequestParam(name="postId") String postId,@RequestParam(name="commentId") String commentId, Model model) {
		
		model.addAttribute("postId", postId);
		
		model.addAttribute("comment", blogServiceInterface.getComment(Integer.parseInt(commentId)));
				
		return "updateComment";
	}
	
	@PostMapping("/updateCommentData")
	public String updateCommentDaa(@ModelAttribute(name="postId") String postId,@ModelAttribute("comment") Comment comment, Model model) {

		Post post = blogServiceInterface.getBlog(Integer.parseInt(postId));

		blogServiceInterface.updateComment(post,comment);
		
		return "redirect:/displayBlog";
	}
	
	@PostMapping("/deleteComment")
	public String deleteComment(@ModelAttribute(name="postId") String postId,@RequestParam(name="commentId") String commentId,Model model) {
		
		blogServiceInterface.deleteComment(Integer.parseInt(commentId));
		
		model.addAttribute("postId", postId);
		
		return "redirect:/displayBlog";
	}
	
}
	

