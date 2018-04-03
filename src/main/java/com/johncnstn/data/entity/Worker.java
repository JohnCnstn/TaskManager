package com.johncnstn.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "worker")
public class Worker extends User {

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "worker_qualification_id", nullable = false)
    @Getter
    @Setter
    private WorkerQualification workerQualification;

    @JsonIgnore
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;
}
