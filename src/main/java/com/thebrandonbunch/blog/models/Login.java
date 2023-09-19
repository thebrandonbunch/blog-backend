package com.thebrandonbunch.blog.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user-login")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @Id
    private ObjectId id;
    private String userId;
    private String username;
    private String password;
}
