package com.epam.test.ht2.task2;

import java.time.Duration;

public enum Specialties {
    DESIGN(Subjects.HTML,Subjects.PHOTOSHOP, Subjects.DOCKER.duration.plusHours(Subjects.NETWORKS.duration.toHours())),
    DEVOPS(Subjects.DOCKER, Subjects.NETWORKS, Subjects.DOCKER.duration.plusHours(Subjects.NETWORKS.duration.toHours())),
    TESTING(Subjects.JAVA, Subjects.SELENIUM, Subjects.JAVA.duration.plusHours(Subjects.SELENIUM.duration.toHours()));

    Subjects subject1, subject2;
    Duration duration;

    Specialties(Subjects subject1, Subjects subject2, Duration duration) {
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.duration = duration;
    }
}