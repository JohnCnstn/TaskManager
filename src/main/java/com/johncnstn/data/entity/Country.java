package com.johncnstn.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy="country")
    private Set<Tour> tours;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="manager_id", nullable=false)
    private Manager manager;

    @JsonIgnore
    @OneToMany(mappedBy="country")
    private Set<Client> clients;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }
}
