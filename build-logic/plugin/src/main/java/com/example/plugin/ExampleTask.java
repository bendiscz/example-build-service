package com.example.plugin;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.TaskAction;

public abstract class ExampleTask extends DefaultTask {

    @Internal
    abstract Property<ExampleBuildService> getBuildService();

    @TaskAction
    public void execute() {
        // use the shared service
        getProject().getLogger().quiet(">>> task: " + getBuildService().get().example());
    }
}
