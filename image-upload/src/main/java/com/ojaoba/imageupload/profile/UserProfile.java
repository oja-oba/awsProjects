package com.ojaoba.imageupload.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class UserProfile {

    private UUID userProfileID;
    private String username;
    private String userProfileImageLink;

    public Optional<String> userProfileImageLink(){
        return Optional.ofNullable(userProfileImageLink);

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return userProfileID.equals(that.userProfileID) && username.equals(that.username) && userProfileImageLink.equals(that.userProfileImageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileID, username, userProfileImageLink);
    }
}
