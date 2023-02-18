plugins {
    `application`
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}


application {
    mainClass.set("lofi.Main")
}

tasks.jar{
    manifest{
        attributes("Main-Class" to "lofi.Main")
    }
}

configure<JavaPluginConvention>{
    sourceCompatibility= org.gradle.api.JavaVersion.VERSION_17
    targetCompatibility= org.gradle.api.JavaVersion.VERSION_17
}
