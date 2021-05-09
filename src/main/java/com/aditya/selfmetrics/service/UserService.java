package com.aditya.selfmetrics.service;

import com.aditya.selfmetrics.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Value("${dynamodb.table.user}")
    private String userTableName;

    @Autowired
    DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public User getUserByUserName(final String userName){
        DynamoDbTable<User> userTable = dynamoDbEnhancedClient.table(userTableName, TableSchema.fromBean(User.class));
        final User user = userTable.getItem(Key.builder().partitionValue(userName).build());
        log.info("User Returned: {}",user);
        return user;
    }

    public String addUser(final User user){
        DynamoDbTable<User> userTable = dynamoDbEnhancedClient.table(userTableName, TableSchema.fromBean(User.class));
        userTable.putItem(user);
        return "Done!";
    }


    public List<User> getAllUsers(){
        DynamoDbTable<User> userTable = dynamoDbEnhancedClient.table(userTableName, TableSchema.fromBean(User.class));
        return IteratorUtils.toList(userTable.scan().items().iterator());
    }
}
