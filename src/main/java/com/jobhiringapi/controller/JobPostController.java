package com.jobhiringapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobhiringapi.model.JobPost;
import com.jobhiringapi.repository.JobPostRepository;
import com.jobhiringapi.repository.JobSearchRepository;



@RestController
@RequestMapping("/api/jobpost")
public class JobPostController {

	@Autowired
	JobPostRepository jobrepo;
	
	@Autowired
	JobSearchRepository searchrepo;

	@GetMapping("/allposts")
	public List<JobPost> getAllPost() {
		return jobrepo.findAll();
	}
	
	@GetMapping("/get/{search}")
	public List<JobPost> searchPost(@PathVariable String search){
		return searchrepo.findBySearch(search);
	}
	
	@PostMapping("/addpost")
	public JobPost addPost(@RequestBody JobPost post) {
		return jobrepo.save(post);
	}
}
