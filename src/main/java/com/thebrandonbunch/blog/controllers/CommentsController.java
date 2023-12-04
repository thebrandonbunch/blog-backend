package com.thebrandonbunch.blog.controllers;

import com.thebrandonbunch.blog.models.Comments;
import com.thebrandonbunch.blog.services.impl.CommentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentsController {
    @Autowired
    private CommentsServiceImpl commentsService;

    @PostMapping("/create-comment")
    public HttpStatus createComment(@RequestBody Comments comments) {
       commentsService.createComment(comments);
       return HttpStatus.CREATED;
    }

//    @GetMapping("/get-comments")
}
