package com.ojaoba.imageupload.profile;

import com.ojaoba.imageupload.bucket.BucketName;
import com.ojaoba.imageupload.filestore.FileStore;
import lombok.AllArgsConstructor;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
@AllArgsConstructor
public class UserProfileService {
    @Autowired
    private final UserProfileDataAccessService userProfileDataAccessService;
    private  final FileStore fileStore;

    List<UserProfile> getUserProfile(){

        return userProfileDataAccessService.getUserProfile();
    }


    public void uploadProfileImage(UUID userProfileId, MultipartFile file) {
        if(file.isEmpty()){

            throw  new IllegalStateException("cannot uload empty file [ " + file.getSize() + "]");
        }
        if(!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_GIF.getMimeType()).contains(file.getContentType())){
            throw new IllegalStateException("File must be image");



        }
     UserProfile user  =   userProfileDataAccessService
                .getUserProfile()
                .stream()
                .filter(userProfile -> userProfile.getUserProfileID().equals(userProfileId))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException(String.format("User Profile %s not found", userProfileId)));

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        String path = String.format("%s", BucketName.PROFILE_IMAGE.getBucketName());
        String fileName = String.format("%s/%s-%s", user.getUserProfileID(),file.getOriginalFilename(), UUID.randomUUID());

        try {
            fileStore.save(path,fileName,Optional.of(metadata), file.getInputStream());
            user.setUserProfileImageLink(fileName);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }


        // check if image is not empty
        // chekc if file is image
        //check wheteher user exists in dtatbase
        // grab metadat
        //store image in s3 and update imagelink



    }

    public byte[] downloadProfileImage(UUID userProfileId) {
        UserProfile user  =   userProfileDataAccessService
                .getUserProfile()
                .stream()
                .filter(userProfile -> userProfile.getUserProfileID().equals(userProfileId))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException(String.format("User Profile %s not found", userProfileId)));
        String bucket = BucketName.PROFILE_IMAGE.getBucketName();

         String path = user.getUserProfileImageLink();

         return fileStore.download(bucket, path);



    }
}
