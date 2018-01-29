package com.johncnstn.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "quantity")
    @Getter
    @Setter
    private int quantity;

    @Getter
    @Setter
    @OneToMany(mappedBy="project")
    private Set<Task> tasks;
}
