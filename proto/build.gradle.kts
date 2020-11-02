import com.google.protobuf.gradle.*

buildscript {
    extra.apply {
        set("protocVersion", "+")
        set("protobufPluginVersion", "0.8.13")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:${property("protobufPluginVersion")}")
    }
}

java.sourceCompatibility = JavaVersion.VERSION_14

plugins{
	id("java")
	id("com.google.protobuf") version "${property("protobufPluginVersion")}"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("javax.annotation:javax.annotation-api:+")
    implementation("io.grpc:grpc-netty:${property("grpcVersion")}")
    implementation("io.grpc:grpc-protobuf:${property("grpcVersion")}")
    implementation("io.grpc:grpc-stub:${property("grpcVersion")}")
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

