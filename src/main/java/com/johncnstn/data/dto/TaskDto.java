package com.johncnstn.data.dto;

import lombok.Getter;
import lombok.Setter;

public class TaskDto {

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String path;
    @Setter
    @Getter
    private long projectId;
    @Setter
    @Getter
    private long taskId;
}
