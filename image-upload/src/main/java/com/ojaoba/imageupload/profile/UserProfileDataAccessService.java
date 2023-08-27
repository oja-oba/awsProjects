package com.ojaoba.imageupload.profile;

import com.ojaoba.imageupload.datastore.UserProfileDataStore;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserProfileDataAccessService {

    @Autowired
    private final UserProfileDataStore userProfileDataStore;

    List<UserProfile> getUserProfile(){
        return userProfileDataStore.getUserProfile();

    }


}
