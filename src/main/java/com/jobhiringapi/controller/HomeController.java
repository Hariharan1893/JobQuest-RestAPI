package com.jobhiringapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class HomeController {

	@ResponseBody
	@GetMapping("/home")
	public String greeting() {
		return "Hello all Welcome to JobQuest...";
	}
	
	@ResponseBody
	@GetMapping("/help")
	public String apiCalls() {
		String getAllPost = "-----GET (All post) -> localhost:8080/api/jobpost/allposts   -----";
		String addNewPost = "-----POST (New Post) -> localhost:8080/api/jobpost/addpost  -----";
		String searchPost = "-----GET (Search Post) -> localhost:8080/api/jobpost/get/search  -----";
		
		String allapi = getAllPost +"\n"+ addNewPost +"\n"+ searchPost;
		return allapi;
	}
	
}
