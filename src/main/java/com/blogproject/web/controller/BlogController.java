package com.blogproject.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogproject.web.dto.BlogDto;
import com.blogproject.web.models.Blog;
import com.blogproject.web.service.BlogService;

@Controller

public class BlogController {
	private BlogService blogservice;
	private BlogService blogService;
	private String attributeValue;
	
	
	@Autowired
	public BlogController(BlogService blogService) {
		this.blogService = blogService;
		
	}

	@GetMapping ("/blogs")
	public String listBlogs(Model model) {
		List<BlogDto> blogs = blogService.findAllBlogs();
		model.addAttribute( attributeValue: "blogs", blogs);
		return "blogs-list";
		
	}
	
	@GetMapping("/blogs/new")
	public String createBlogForm(Model model) {
		Blog blog = new Blog();
		model.addAttribute( attributeValue: "blog", blog);
		return "blogs-create";
		
	}
	
	@PostMapping ("/blogs/new")
	public String saveBlog(@ModelAttribute("blog") Blog blog) {
		blogService.saveBlog(blog);
		return "redirect:/blogs";
		
		
	}
	
	@GetMapping("/blogs/{blodId}/edit")
	public String editBlogForm(@PathVariable("blogId") long blogId, Model model) {
		BlogDto blog = blogService.findBlogById(blogId);
		model.addAttribute( attributeValue: "blog", blog);
		return "blogs-edit";
		
			
	}
	
	@PostMapping("/blogs/{blogId}/edit")
	public String updateBlog(@PathVariable("blogId") Long blogId, @ModelAttribute("blog") BlogDto blog) {
		blog.setId(blogId);
		blogService.updateBlog(blog);
		return "redirect:/blogs";
		
	}
	
}
