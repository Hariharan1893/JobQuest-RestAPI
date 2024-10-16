package com.jobhiringapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jobhiringapi.model.JobPost;

public interface JobPostRepository extends MongoRepository<JobPost, String> {

}
