plugins {
    id("com.moowork.node") version "1.3.1"
}

tasks {
    register("build") {
        outputs.dir(file("public"))
        dependsOn("npmInstall", "npm_run_build")
    }
}
