import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.google.protobuf.gradle.*
import org.gradle.kotlin.dsl.provider.gradleKotlinDslOf

buildscript {
    extra.apply {
        set("grpcVersion","+")
        set("protocVersion","+")
        set("protobufPluginVersion", "0.8.11")
        //set("protobufPluginVersion", "+")
        set("kotlinVersion", "1.3.70")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:${property("protobufPluginVersion")}")
    }
}

java.sourceCompatibility = JavaVersion.VERSION_13

plugins{
	id("java")
	kotlin("jvm") version("${property("kotlinVersion")}")
	id("com.google.protobuf") version "${property("protobufPluginVersion")}"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.grpc:grpc-netty:${property("grpcVersion")}")
    implementation("io.grpc:grpc-protobuf:${property("grpcVersion")}")
    implementation("io.grpc:grpc-stub:${property("grpcVersion")}")
    implementation("javax.annotation:javax.annotation-api:+")
}

protobuf {
    protoc { artifact = "com.google.protobuf:protoc:${property("protocVersion")}" }

    plugins {
        id("grpc") { artifact = "io.grpc:protoc-gen-grpc-java:${property("grpcVersion")}" }
    }

    generatedFilesBaseDir = "${property("projectDir")}/src"
    generateProtoTasks {
        all().forEach { task ->
	    task.plugins { id("grpc") { outputSubDir = "java" } }
        }
    }
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "13"
	}
}
