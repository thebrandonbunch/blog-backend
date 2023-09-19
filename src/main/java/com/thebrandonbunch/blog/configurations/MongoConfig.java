package com.thebrandonbunch.blog.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.MongoDatabaseFactory;


@Configuration
@PropertySource("classpath:application.properties")
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String uri;
    @Autowired
    private Environment env;

    @Bean
    public MongoDatabaseFactory mongoDbFactory() {
        System.out.println("uri " + uri);
        return new SimpleMongoClientDatabaseFactory(uri);
    }

    @Bean
    public MongoTemplate mongoTemplate() {

        return new MongoTemplate(mongoDbFactory());

    }

}