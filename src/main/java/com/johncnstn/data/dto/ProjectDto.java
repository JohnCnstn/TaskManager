package com.johncnstn.data.dto;

import com.johncnstn.data.entity.Manager;
import com.johncnstn.data.entity.Worker;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class ProjectDto {
    @NotNull
    @NotEmpty
    @Setter
    @Getter
    private String name;

    @NotNull
    @NotEmpty
    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private long quantity;

    @Setter
    @Getter
    private long managerId;

    @Setter
    @Getter
    private long workerId;

}
