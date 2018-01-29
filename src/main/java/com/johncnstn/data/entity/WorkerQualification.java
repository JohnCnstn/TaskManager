package com.johncnstn.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "worker_qualification")
public class WorkerQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name="type", length=15, unique=true, nullable=false)
    @Getter
    @Setter
    private String type = WorkerQualificationType.JUNIOR.getWorkerQualificationType();
}
