package com.thebrandonbunch.blog.services;

import com.thebrandonbunch.blog.models.Posts;

import java.util.List;

public interface PostService {
    void createPost(Posts posts);
    List<Posts> allPosts();
    Posts singlePost(String postId);
    boolean updatePost(Posts updatePost);
    void deleteByPostId(String postId);
}
