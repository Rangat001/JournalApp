package com.rgt.journal.Repository;

import com.rgt.journal.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<UserEntity> getUserForSA(){
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is("rgt"));
        List<UserEntity> userEntities = mongoTemplate.find(query, UserEntity.class);
        return userEntities;
    }
}
