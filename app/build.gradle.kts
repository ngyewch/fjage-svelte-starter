plugins {
    java
    id("com.github.ben-manes.versions")
    id("com.github.ngyewch.gradle-fjage-plugin") version "0.3.0"
}

repositories {
    jcenter()
}

dependencies {
    "fjage"("com.github.org-arl:fjage:1.6.3")
    "fjage"("org.codehaus.groovy:groovy-all:2.5.8")
}

tasks {
    // run via ./gradlew test1 --console=plain --no-daemon
    register<org.arl.fjage.gradle.FjageGroovyBootTask>("test1") {
        scripts = listOf("scripts/test1")
        systemProperties = mapOf("java.util.logging.config.file" to "logging.properties")
    }
}

evaluationDependsOn(":ui")

fjage {
    // Copy extra files
    copyInto("web", tasks.getByPath(":ui:build").outputs.files.asFileTree)
}
