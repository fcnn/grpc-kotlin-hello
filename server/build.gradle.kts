buildscript {
    extra.apply {
        set("grpcVersion","+")
        set("kotlinVersion", "+")
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
	//id("kotlin")
	id("application")
}

application {
    mainClassName = "HelloworldserverKt"
}

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

