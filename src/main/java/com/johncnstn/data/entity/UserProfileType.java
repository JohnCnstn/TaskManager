package com.johncnstn.data.entity;

import lombok.Getter;

public enum UserProfileType {

    WORKER("WORKER"),
    MANAGER("MANAGER"),
    ADMIN("ADMIN");

    @Getter
    String userProfileType;

    UserProfileType(String userProfileType) {
        this.userProfileType = userProfileType;
    }

}
