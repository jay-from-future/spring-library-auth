package ru.otus.springlibrary.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.springlibrary.domain.OauthClientDetails;

public interface OauthClientDetailsRepository extends MongoRepository<OauthClientDetails, ObjectId> {

    OauthClientDetails findByClientId(String clientId);
}
