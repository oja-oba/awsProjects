package com.ojaoba.imageupload.bucket;

public enum BucketName {
    PROFILE_IMAGE("ojaoba-08-25-2023");

    private final String bucketName;

    BucketName(String bucketName){

        this.bucketName = bucketName;
    }

    public String getBucketName(){
        return bucketName;
    }

}
