package com.thebrandonbunch.blog.services.impl;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import com.thebrandonbunch.blog.repositories.CommentsRepository;
import com.thebrandonbunch.blog.models.Posts;
import com.thebrandonbunch.blog.repositories.PostsRepository;
import com.thebrandonbunch.blog.services.PostService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PostsServiceImpl implements PostService {
    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public void createPost(Posts post) {
        post.setPostId(getUUID());
        post.setDate(setDate());
        postsRepository.insert(post);
    }

    public List<Posts> allPosts() {
        return postsRepository.findAll();
    }

    public Posts singlePost(String postId) {
        return postsRepository.findByPostId(postId);
    }

    public boolean updatePost(Posts postDetails) {
        MongoClientURI connectionString = new MongoClientURI("mongodb+srv://thebrandonbunch1113:marines2011@blogcluster.gtjwolt.mongodb.net");
        MongoDatabase mongoDatabase = null;
        MongoCollection<Document> collection = null;
        try(MongoClient mongoClient = new MongoClient(connectionString)) {
            mongoDatabase = mongoClient.getDatabase("blog-api-db");
            collection = mongoDatabase.getCollection("posts");
        }

        UpdateResult updateResult = collection.updateMany(Filters.eq("postId", postDetails.getPostId()),
                Updates.combine(
                        Updates.set("title", postDetails.getTitle()),
                        Updates.set("content", postDetails.getContent()),
                        Updates.set("comments", postDetails.getComments())
                )
        );

//        postDetails.getComments().forEach((comment -> {
//            String commentId = comment.getCommentId();
//
//            if(commentId.equals(commentParam)) {
//                postDetails.getComments().remove(comment);
//            }
//        }));

        return updateResult.getModifiedCount() > 0;
    }

    public void deleteByPostId(String postId) { postsRepository.deleteById(postId); }

    private String setDate() {
        return Date.from(Instant.now()).toString();
    }

    private String getUUID() {
        return UUID.randomUUID().toString();
    }

}
