package com.ojaoba.imageupload.filestore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileStore {

    @Autowired
    private  final AmazonS3 s3;

    public void save(String path,
                     String fileName,
                     Optional<Map<String, String>> optionalMetaData,
                     InputStream inputStream){
        ObjectMetadata metadata = new ObjectMetadata();
        optionalMetaData.ifPresent(map->{
            if(!map.isEmpty()){
                map.forEach(metadata::addUserMetadata);
            }
        });

        try{
            s3.putObject(path,fileName, inputStream, metadata);

        }catch (AmazonS3Exception e){
            throw  new IllegalStateException("File to store content", e);


        }

    }

    public byte[] download(String bucket, String path) {
        try {

            S3Object object = s3.getObject(bucket,path);
         return IOUtils.toByteArray(object.getObjectContent());

        }catch (AmazonServiceException | IOException e) {
            throw  new IllegalStateException("Fail to upload file");


        }

    }
}
