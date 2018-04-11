package com.johncnstn.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "manager")
public class Manager extends User{
    @JsonIgnore
    @Getter
    @Setter
    @OneToMany(mappedBy="manager")
    private Set<Project> projects;
}
