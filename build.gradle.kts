
val gradle_version = "6.7-rc-1"

buildscript {
    extra.apply {
        set("grpcVersion", "+")
        set("kotlinVersion", "1.4.10")
    }

    repositories {
	    jcenter()
	    mavenCentral()
	    maven ("https://dl.bintray.com/kotlin/kotlin-eap")
	    maven ("https://kotlin.bintray.com/kotlinx")
    }
}

plugins{
	kotlin("jvm") version("${property("kotlinVersion")}") apply false
}

tasks.wrapper {
    gradleVersion = gradle_version
    distributionType = Wrapper.DistributionType.ALL
}
