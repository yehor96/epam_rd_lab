package com.epam.test.ht2.task2;

import java.time.Duration;

public enum Subjects {
    PHOTOSHOP(Duration.ofHours(16)),
    HTML(Duration.ofHours(10)),
    DOCKER(Duration.ofHours(12)),
    NETWORKS(Duration.ofHours(15)),
    JAVA(Duration.ofHours(20)),
    SELENIUM(Duration.ofHours(10));

    Duration duration;

    Subjects(Duration duration) {
        this.duration = duration;
    }
}