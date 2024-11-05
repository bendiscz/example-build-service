pluginManagement {
    repositories {
        mavenCentral()
    }

    includeBuild("build-logic")
}

rootProject.name = "example-build-service"

include(":project-a")
include(":project-b")
