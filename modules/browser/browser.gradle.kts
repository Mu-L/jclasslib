plugins {
    kotlin("jvm")
    application
    `maven-publish`
}

configurePublishing()

application {
    mainClass.set("org.gjt.jclasslib.browser.BrowserApplication")
}

val flatLafVersion = "2.4"

dependencies {
    api(project(":agent"))
    api(project(":data"))
    compileOnly(":apple")
    implementation("com.install4j:install4j-runtime:10.0.3")
    implementation("org.jetbrains:annotations:19.0.0")
    implementation("com.github.ingokegel:kotlinx.dom:0.0.10")
    implementation("com.miglayout:miglayout-swing:5.2")
    implementation("com.formdev:flatlaf:$flatLafVersion")
    implementation("com.formdev:flatlaf-extras:$flatLafVersion")
}

tasks {
    jar {
        archiveFileName.set("jclasslib-browser.jar")
        manifest {
            attributes("Main-Class" to application.mainClass.get())
        }
    }

    val copyDist by registering(Copy::class) {
        from(configurations.compileClasspath.map { configuration -> configuration.files.filterNot { file -> file.name.contains("install4j") } })
        from(configurations.runtimeClasspath.map { configuration -> configuration.files.filter { file -> file.name.contains("svg") } })
        from(jar)
        into(externalLibsDir)
    }

    register("dist") {
        dependsOn(copyDist)
    }
}

