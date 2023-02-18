plugins {
    `application`
    id("com.diffplug.spotless") version "6.15.0"
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

spotless {
    java {
          // Cleanthat will refactor your code, but it may break your style: apply it before your formatter
      cleanthat()          // has its own section below
  
      // Choose one of these formatters.
      googleJavaFormat()   // has its own section below
  

    }
  }

configure<JavaPluginConvention>{
    sourceCompatibility= org.gradle.api.JavaVersion.VERSION_17
    targetCompatibility= org.gradle.api.JavaVersion.VERSION_17
}
