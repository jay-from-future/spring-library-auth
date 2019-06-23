package ru.otus.springlibrary.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.springlibrary.domain.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);

}
