package ru.otus.springlibrary.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "clean", author = "Grigorii Liullin", runAlways = true)
    public void clean(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "importInitialClientAndUser", author = "Grigorii Liullin")
    public void importSomeInitialData(MongoDatabase db) {
        Document clientDetailsDocument = new Document()
                .append("client_id", "spring-library-jwt-client")
                .append("resource_ids", "spring-library-oauth2-server")
                .append("client_secret", "$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha")
                .append("scope", "read,write")
                .append("authorized_grant_types", "password,authorization_code,refresh_token,implicit")
                .append("authorities", "USER")
                .append("access_token_validity", 10800)
                .append("refresh_token_validity", 2592000);

        db.getCollection("oauth_client_details").insertOne(clientDetailsDocument);

        Document user = new Document()
                .append("username", "admin")
                .append("password", "$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha")
                .append("enabled", true)
                .append("roles", Arrays.asList(new Document().append("name", "ADMIN"), new Document().append("name", "USER")));

        db.getCollection("users").insertOne(user);
    }
}
