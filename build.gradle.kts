
val gradle_version = "6.6-rc-2"

buildscript {
    extra.apply {
        set("grpcVersion", "+")
        set("kotlinVersion", "1.4-M3")
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
