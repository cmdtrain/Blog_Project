package com.blogproject.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogproject.web.dto.BlogDto;
import com.blogproject.web.models.Blog;
import com.blogproject.web.models.UserEntity;
import com.blogproject.web.security.SecurityUtil;
import com.blogproject.web.service.BlogService;
import com.blogproject.web.service.UserService;

@Controller

public class BlogController {
	private BlogService blogservice;
	private BlogService blogService;
	private String attributeValue;
	private String attributeName;
	private UserService userService;
	
	
	
	
	@Autowired
	public BlogController(BlogService blogService, UserService userService) {
		this.userService = userService;
		this.blogService = blogService;
		
	}

	@GetMapping ("/blogs")
	public String listBlogs(Model model) {
		UserEntity user = new UserEntity();
		List<BlogDto> blogs = blogService.findAllBlogs();
		String username = SecurityUtil.getSessionUser();
		if(username != null) {
			user = userService.findByUsername(username);
			model.addAttribute(attributeName: "user", user);
		}
		model.addAttribute(attributeName: "user", user);
		model.addAttribute(attributeName: "blogs", blogs);
		return "blogs-list";
		
	}
	
	@GetMapping("/blogs/{blogId}")
	public String blogDetail(@PathVariable("blogId") long blogId, Model model) {
		UserEntity user = new UserEntity();
		
		BlogDto blogDto = blogService.findBlogById(blogId);
		String username = SecurityUtil.getSessionUser();
		if(username != null) {
			user = userService.findByUsername(username);
			model.addAttribute(attributeName: "user", user);
		}
		model.addAttribute(attributeName: "user", user);
		model.addAttribute(attributeName: "blog", blogDto);
		return "blogs-detail";
	}
	
	@GetMapping("/blogs/new")
	public String createBlogForm(Model model) {
		Blog blog = new Blog();
		model.addAttribute(attributeName: "blog", blog);
		return "blogs-create";
		
	}
	
	@GetMapping("/blogs/{blogId}/delete")
	public String deleteBlog(@PathVariable("blogId")Long blogId) {
		blogService.delete(blogId);
		return "redirect:/blogs";
	}
	
	@GetMapping("/blogs/search")
	public String searchBlog(@RequestParam(value = "query") String query, Model model) {
		List<BlogDto> blogs = blogService.searchBlogs(query);
		model.addAttribute(attributeValue: "blogs", blogs);
		return "blogs-list";
	}
	
	@PostMapping ("/blogs/new")
	public String saveBlog(@Valid @ModelAttribute("blog") BlogDto blogDto, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute(attributeName: "blog", blogDto);
			return "blogs-create";
		}
		blogService.saveBlog(blogDto);
		return "redirect:/blogs";
		
		
	}
	
	@GetMapping("/blogs/{blogId}/edit")
	public String editBlogForm(@PathVariable("blogId") long blogId, Model model) {
		BlogDto blog = blogService.findBlogById(blogId);
		model.addAttribute(attributeValue: "blog", blog);
		return "blogs-edit";
		
			
	}
	
	@PostMapping("/blogs/{blogId}/edit")
	public String updateBlog(@PathVariable("blogId") Long blogId, @Valid @ModelAttribute("blog") BlogDto blog,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute(attributeName:"blog", blog);
			return "blogs-edit";
			}
		blog.setId(blogId);
		blogService.updateBlog(blog);
		return "redirect:/blogs";
		
	}
	
}
