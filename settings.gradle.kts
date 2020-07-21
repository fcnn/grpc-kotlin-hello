/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user manual at https://docs.gradle.org/6.0/userguide/multi_project_builds.html
 */

pluginManagement {
        repositories {
                maven { url = uri("https://repo.spring.io/milestone") }
                maven { url = uri("https://repo.spring.io/snapshot") }
                maven ("https://dl.bintray.com/kotlin/kotlin-eap")
                gradlePluginPortal()
        }
}

rootProject.name = "grpc-kotlin-hello"
include ("proto")
include ("server")
include ("client")

