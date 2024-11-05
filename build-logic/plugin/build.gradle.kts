plugins {
    `java-gradle-plugin`
}

gradlePlugin {
    val example by plugins.creating {
        id = "com.example.plugin"
        implementationClass = "com.example.plugin.ExamplePlugin"
    }
}
