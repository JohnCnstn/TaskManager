package com.johncnstn.data.entity;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> f4f3d8cdf813a4cf165d18841f570002778d425e
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> f4f3d8cdf813a4cf165d18841f570002778d425e

@Entity
@Table(name = "worker")
public class Worker extends User {

<<<<<<< HEAD
=======
    @JsonIgnore
>>>>>>> f4f3d8cdf813a4cf165d18841f570002778d425e
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "worker_qualification_id", nullable = false)
    @Getter
    @Setter
    private WorkerQualification workerQualification;

<<<<<<< HEAD
=======
    @JsonIgnore
>>>>>>> f4f3d8cdf813a4cf165d18841f570002778d425e
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;
}
