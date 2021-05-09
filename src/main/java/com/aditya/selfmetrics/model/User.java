package com.aditya.selfmetrics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
@Setter
public class User {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @DynamoDbPartitionKey
    @DynamoDbAttribute(value = "userName")
    public String getUserName() {
        return userName;
    }

    @DynamoDbAttribute(value = "firstName")
    public String getFirstName() {
        return firstName;
    }

    @DynamoDbAttribute(value = "lastName")
    public String getLastName() {
        return lastName;
    }

    @DynamoDbAttribute(value = "email")
    public String getEmail() {
        return email;
    }

    @DynamoDbAttribute(value = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
