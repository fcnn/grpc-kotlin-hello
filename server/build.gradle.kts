//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    extra.apply {
        set("grpcVersion","+")
        set("kotlinVersion", "1.3.61")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath( "org.jetbrains.kotlin:kotlin-gradle-plugin:${property("kotlinVersion")}")
    }
}

plugins{
	id("java")
	id("application")
	kotlin("jvm") version("${property("kotlinVersion")}")
}

application {
    mainClassName = "HelloworldserverKt"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":proto"))
    implementation("io.grpc:grpc-stub:${property("grpcVersion")}")
    implementation("io.grpc:grpc-netty:${property("grpcVersion")}")
    implementation("io.grpc:grpc-protobuf:${property("grpcVersion")}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${property("kotlinVersion")}")
}

