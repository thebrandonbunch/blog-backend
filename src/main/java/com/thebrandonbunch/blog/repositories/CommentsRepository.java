package com.thebrandonbunch.blog.repositories;

import com.thebrandonbunch.blog.models.Comments;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends MongoRepository<Comments, ObjectId> {

}
