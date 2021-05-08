package com.aditya.selfmetrics.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "User")
@DynamoDBDocument
public class User {

    @DynamoDBAutoGeneratedKey
    @DynamoDBHashKey(attributeName = "userId")
    private String userId;

    @DynamoDBAttribute
    private String userName;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private String phoneNumber;
}
