package com.thebrandonbunch.blog.services.impl;

import com.thebrandonbunch.blog.models.Comments;
import com.thebrandonbunch.blog.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl {
    @Autowired
    private CommentsRepository commentsRepository;

    public Comments createComment(Comments comments) {

        return commentsRepository.insert(comments);
    }

}
