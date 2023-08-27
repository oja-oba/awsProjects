package com.ojaoba.imageupload.datastore;

import com.ojaoba.imageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("19581953-1f61-4eca-8dc7-8ccefe673aae"), "akinwale", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("0a353688-dd09-4a18-a677-950e668565df"), "opeyemi", null));
    }

    public  List<UserProfile>getUserProfile(){
        return USER_PROFILES;
    }
}
