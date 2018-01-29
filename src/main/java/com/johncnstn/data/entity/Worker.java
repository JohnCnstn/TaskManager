package com.johncnstn.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "worker")
public class Worker extends User {
    @Getter
    @Setter
    @OneToMany(mappedBy="manager")
    private Set<Project> projects;
}
