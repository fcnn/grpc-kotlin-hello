import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    extra.apply {
        //set("grpcVersion","+")
        //set("kotlinVersion", "1.3.70")
    }

    repositories {
	    jcenter()
	    mavenCentral()
	    maven ("https://dl.bintray.com/kotlin/kotlin-eap")
	    maven ("https://kotlin.bintray.com/kotlinx")
    }

    dependencies {
        classpath( "org.jetbrains.kotlin:kotlin-gradle-plugin:${property("kotlinVersion")}")
    }
}

plugins{
	id("java")
	id("application")
	kotlin("jvm")
}

application {
    mainClassName = "HelloworldclientKt"
}

java.sourceCompatibility = JavaVersion.VERSION_17

    repositories {
	    jcenter()
	    mavenCentral()
	    maven ("https://dl.bintray.com/kotlin/kotlin-eap")
	    maven ("https://kotlin.bintray.com/kotlinx")
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
		jvmTarget = "17"
	}
}

