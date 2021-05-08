package com.aditya.selfmetrics.repository;

import com.aditya.selfmetrics.model.User;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public User getUserById(String userId){
        return dynamoDBMapper.load(User.class,userId);
    }

    public User addUser(User user){
        log.info("ADDING USER:{}",user.toString());
        dynamoDBMapper.save(user);
        return user;
    }

}
