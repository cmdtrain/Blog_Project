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

import com.blogproject.web.dto.BlogDto;
import com.blogproject.web.models.Blog;
import com.blogproject.web.service.BlogService;

@Controller

public class BlogController {
	private BlogService blogservice;
	private BlogService blogService;
	private String attributeValue;
	private String attributeName;
	
	
	
	@Autowired
	public BlogController(BlogService blogService) {
		this.blogService = blogService;
		
	}

	@GetMapping ("/blogs")
	public String listBlogs(Model model) {
		List<BlogDto> blogs = blogService.findAllBlogs();
		model.addAttribute(attributeName: "blogs", blogs);
		return "blogs-list";
		
	}
	
	@GetMapping("/blogs/{blogId}")
	public String blogDetail(@PathVariable("blogId") long blogId, Model model) {
		BlogDto blogDto = blogService.findBlogById(blogId);
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
	
	@PostMapping ("/blogs/new")
	public String saveBlog(@Valid @ModelAttribute("blog") BlogDto blogDto, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute(attributeName: "blog", blogDto);
			return "blogs-create";
		}
		blogService.saveBlog(blogDto);
		return "redirect:/blogs";
		
		
	}
	
	@GetMapping("/blogs/{blodId}/edit")
	public String editBlogForm(@PathVariable("blogId") long blogId, Model model) {
		BlogDto blog = blogService.findBlogById(blogId);
		model.addAttribute(attributeValue: "blog", blog);
		return "blogs-edit";
		
			
	}
	
	@PostMapping("/blogs/{blogId}/edit")
	public String updateBlog(@PathVariable("blogId") Long blogId, @Valid @ModelAttribute("blog") BlogDto blog,
			BindingResult result) {
		if(result.hasErrors()) {
			return "blogs-edit";
			}
		blog.setId(blogId);
		blogService.updateBlog(blog);
		return "redirect:/blogs";
		
	}
	
}
