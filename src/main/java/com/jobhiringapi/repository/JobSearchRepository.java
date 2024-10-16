package com.jobhiringapi.repository;

import java.util.List;

import com.jobhiringapi.model.JobPost;

public interface JobSearchRepository {

	public 	List<JobPost> findBySearch(String search);
}
