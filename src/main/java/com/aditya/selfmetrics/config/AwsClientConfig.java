package com.aditya.selfmetrics.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import javax.annotation.PostConstruct;
import java.net.URI;

@Configuration
public class AwsClientConfig {

    @Value("${aws.dynamodb.endpoint}")
    private String dynamoDbEndpoint;
    @Value("${aws.accesskey}")
    private String accessKey;
    @Value("${aws.secretkey}")
    private String secretKey;
    @Value("${aws.region}")
    private String region;

    private AwsCredentials credentials;

    @PostConstruct
    public void createCredentials(){
        credentials = AwsBasicCredentials.create(accessKey,secretKey);
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(){
        DynamoDbClient client = DynamoDbClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .endpointOverride(URI.create(dynamoDbEndpoint))
                .build();
        return DynamoDbEnhancedClient.builder().dynamoDbClient(client).build();

    }
}
