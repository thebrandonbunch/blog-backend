package com.thebrandonbunch.blog.controllers;

import com.thebrandonbunch.blog.models.Posts;
import com.thebrandonbunch.blog.repositories.PostsRepository;
import com.thebrandonbunch.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostsRepository postsRepository;

    @PostMapping("/create-post")
    public HttpStatus createPost(@RequestBody Posts post) {
        postService.createPost(post);
        return HttpStatus.CREATED;
    }

    @GetMapping("/get-posts")
    public ResponseEntity<List<Posts>> getAllPosts() {
        return new ResponseEntity<List<Posts>>(postService.allPosts(), HttpStatus.OK);
    }

    @GetMapping("/get-posts/{postId}")
    public ResponseEntity<Posts> getSinglePost(@PathVariable String postId) {
        return new ResponseEntity<Posts>(postService.singlePost(postId), HttpStatus.OK);
    }

    @PutMapping("/update-post")
    public HttpStatus updateById(@RequestBody Posts postDetails) {

        boolean isUpdated = postService.updatePost(postDetails);

        if(isUpdated) {
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_MODIFIED;
    }

    @DeleteMapping("/delete-post/{postId}")
    public void deletePost(@PathVariable String postId) {
        System.out.println("deleting: " + postId);
        postService.deleteByPostId(postId);
    }
}

