package com.johncnstn.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "client_type")
public class ClientType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name="type", length=15, unique=true, nullable=false)
    @Getter
    @Setter
    private String type = ClientTypeEnum.KID.getClientType();
}
