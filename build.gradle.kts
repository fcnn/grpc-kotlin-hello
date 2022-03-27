buildscript {
    extra.apply {
        set("grpcVersion", "+")
        set("kotlinVersion", "1.6.20-RC2")
    }

    repositories {
	    jcenter()
	    mavenCentral()
	    gradlePluginPortal()
	    maven ("https://dl.bintray.com/kotlin/kotlin-eap")
	    maven ("https://kotlin.bintray.com/kotlinx")
    }
    dependencies {
	    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${property("kotlinVersion")}")
    }
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/snapshot") }
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
}
plugins{
	kotlin("jvm") version("${property("kotlinVersion")}") apply false
	id("io.spring.dependency-management") version("1.0.11.RELEASE")
}

tasks.wrapper {
    gradleVersion = "7.4.1"
    distributionType = Wrapper.DistributionType.ALL
}
