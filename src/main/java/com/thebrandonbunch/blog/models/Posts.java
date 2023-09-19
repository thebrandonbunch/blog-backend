package com.thebrandonbunch.blog.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "posts")
@Data
@NoArgsConstructor
@Setter
@Getter
public class Posts {
    @Id
    private String postId;
    private String title;
    private String content;
    private int likes;
    private int dislikes;

    private List<Comments> comments;
    private String date;

    public Posts(String postId, String title, String content, int likes, int dislikes, List<Comments> comments, String date) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
        this.date = date;
    }

}

