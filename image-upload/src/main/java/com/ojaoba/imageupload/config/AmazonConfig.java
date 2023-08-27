package com.ojaoba.imageupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.s3.AmazonS3;

@Configuration
public class AmazonConfig {

    @Bean
    public  AmazonS3 s3() {

        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIA4OXIQYIMXOLLOB4P",
                "mB+AD8j/pwRT6WX3ci7evlXfeGcheAMUph1W+X3/"
        );

        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();




    }




}
