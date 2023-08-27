package com.ojaoba.imageupload.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user-profile")
@CrossOrigin("*")
@AllArgsConstructor

public class UserProfileController {

    @Autowired
    private final UserProfileService userProfileService;


    @GetMapping
    public List<UserProfile> getUserProfiles(){
        return userProfileService.getUserProfile();


    }

    @PostMapping(
            path ="{userProfileID}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE
    )
    public void uploadUserProfileImage(@PathVariable("userProfileID") UUID userProfileId,
                                            @RequestParam("file") MultipartFile file){

        userProfileService.uploadProfileImage(userProfileId,file);


    }

        @GetMapping("{userProfileID}/image/download")
    public byte[] downloadUserProfileImage(@PathVariable("userProfileID") UUID userProfileId){

       return    userProfileService.downloadProfileImage(userProfileId);


    }
}
