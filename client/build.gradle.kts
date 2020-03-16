import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    extra.apply {
        set("grpcVersion","+")
        set("kotlinVersion", "1.3.70")
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
    mainClassName = "HelloworldclientKt"
}

java.sourceCompatibility = JavaVersion.VERSION_14

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${property("kotlinVersion")}")
    implementation("io.grpc:grpc-netty:${property("grpcVersion")}")
    implementation("io.grpc:grpc-protobuf:${property("grpcVersion")}")
    implementation("io.grpc:grpc-stub:${property("grpcVersion")}")
    implementation(project(":proto"))
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "13"
	}
}

