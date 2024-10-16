package com.jobhiringapi.repository.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.jobhiringapi.model.JobPost;
import com.jobhiringapi.repository.JobSearchRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class JobSearchImplementation implements JobSearchRepository {

	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoConverter converter;

	public List<JobPost> findBySearch(String search) {
		
		final List<JobPost> posts = new ArrayList<>();
		MongoDatabase database = mongoClient.getDatabase("JobHiringPortalApi");
		MongoCollection<Document> collection = database.getCollection("JobLists");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
				new Document("$search",
						new Document("index", "jobpostsearch").append("text",
								new Document("query", search).append("path",
										Arrays.asList("desc", "profile", "techs")))),
				new Document("$sort", new Document("exp", 1L)), new Document("$limit", 5L)));

		result.forEach(doc -> posts.add(converter.read(JobPost.class, doc)));
		return posts;
	}
}
