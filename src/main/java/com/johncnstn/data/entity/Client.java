package com.johncnstn.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client extends User {

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "client_type_id", nullable = false)
    @Getter
    @Setter
    private ClientType clientType;

    @JsonIgnore
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;
}
