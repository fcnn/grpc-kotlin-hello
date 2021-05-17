buildscript {
    extra.apply {
        set("grpcVersion", "+")
        set("kotlinVersion", "1.5.0")
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
    gradleVersion = "7.0.2"
    distributionType = Wrapper.DistributionType.ALL
}
