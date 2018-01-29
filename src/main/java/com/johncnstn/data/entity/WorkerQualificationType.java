package com.johncnstn.data.entity;

import lombok.Getter;

public enum WorkerQualificationType {
    JUNIOR("JUNIOR"),
    MIDDLE("MIDDLE"),
    SENIOR("SENIOR");

    @Getter
    String workerQualificationType;

    WorkerQualificationType(String workerQualificationType) {
        this.workerQualificationType = workerQualificationType;
    }
}
