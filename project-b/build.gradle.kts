plugins {
    id("com.example.plugin")
}

tasks.register("test") {
    doLast {
        println("${project.name} OK")
    }
}
