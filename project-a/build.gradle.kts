plugins {
    id("com.example.plugin")

    // build fails when the following plugin is applied
//    id("com.gradleup.shadow") version "8.3.4"
}

tasks.register("test") {
    doLast {
        println("${project.name} OK")
    }
}
