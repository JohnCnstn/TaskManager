package com.johncnstn.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "project")
public class Project {

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

    @OneToMany(mappedBy="project")
    private Set<Task> tasks;

    @ManyToOne
    @JoinColumn(name="manager_id", nullable=false)
    private Manager manager;

    @OneToMany(mappedBy="project")
    private Set<Worker> workers;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }
}
