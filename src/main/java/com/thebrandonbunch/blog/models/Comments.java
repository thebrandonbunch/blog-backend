package com.thebrandonbunch.blog.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "comments")
@Data
@NoArgsConstructor
public class Comments {

    private String commentId;
    private String content;
    private String username;
    private int likes;
    private int dislikes;
    private String date;

    public Comments(String commentId, String content, String username, int likes, int dislikes, String date) {
        this.commentId = commentId;
        this.content = content;
        this.username = username;
        this.likes = likes;
        this. dislikes = dislikes;
        this.date = date;
    }
}
