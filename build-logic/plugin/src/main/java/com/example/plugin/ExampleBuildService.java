package com.example.plugin;

import java.util.concurrent.atomic.AtomicInteger;

import org.gradle.api.services.BuildService;
import org.gradle.api.services.BuildServiceParameters;

public abstract class ExampleBuildService implements BuildService<BuildServiceParameters.None> {

    private static final AtomicInteger COUNTER = new AtomicInteger();

    private final String value = "shared-@"
            + Integer.toHexString(System.identityHashCode(getClass().getClassLoader()))
            + "-" + COUNTER.incrementAndGet();

    public ExampleBuildService() {
        System.out.println(">>> creating build service with " + value);
    }

    public String example() {
        return value;
    }
}
