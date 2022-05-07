buildscript {
    extra.apply {
        set("grpcVersion", "+")
        set("kotlinVersion", "1.7.0-Beta")
    }

    repositories {
	    jcenter()
	    mavenCentral()
	    gradlePluginPortal()
	    //maven ("https://dl.bintray.com/kotlin/kotlin-eap")
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
}
plugins{
	kotlin("jvm") version("${property("kotlinVersion")}") apply false
	id("io.spring.dependency-management") version("1.0.11.RELEASE")
}

tasks.wrapper {
    gradleVersion = "7.4.2"
    distributionType = Wrapper.DistributionType.ALL
}
