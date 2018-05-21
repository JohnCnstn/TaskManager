package com.johncnstn.data.entity;

import lombok.Getter;

public enum ClientTypeEnum {
    KID("KID"),
    MAN("MAN"),
    WOMAN("WOMAN");

    @Getter
    String ClientType;

    ClientTypeEnum(String ClientType) {
        this.ClientType = ClientType;
    }
}
