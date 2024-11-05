package com.example.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class ExamplePlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getLogger().quiet(">>> class loader: " + ExampleBuildService.class.getClassLoader() + " @"
                + Integer.toHexString(System.identityHashCode(ExampleBuildService.class.getClassLoader())));

        // get the shared service provider
        var serviceProvider = project.getGradle().getSharedServices()
                .registerIfAbsent("example-service", ExampleBuildService.class);

        // use the shared service
        project.getLogger().quiet(">>> apply: " + serviceProvider.get().example());

        // configure task that uses the shared service
        project.getTasks().create("example", ExampleTask.class, exampleTask -> {
            exampleTask.getBuildService().set(serviceProvider);
            exampleTask.usesService(serviceProvider);
        });
    }
}
