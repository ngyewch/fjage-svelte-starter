plugins {
    base
    id("com.github.ben-manes.versions") version "0.27.0"
}

allprojects {
    tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
        gradleReleaseChannel = "current"
    }
}
