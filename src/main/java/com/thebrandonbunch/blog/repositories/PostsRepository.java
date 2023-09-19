package com.thebrandonbunch.blog.repositories;

import com.thebrandonbunch.blog.models.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends MongoRepository<Posts, String> {
    Posts findByPostId(String postId);

}

