
val gradle_version = "6.5-milestone-2"

buildscript {
    extra.apply {
        set("grpcVersion","+")
        set("kotlinVersion", "1.3.72")
    }

    repositories {
        mavenCentral()
    }
}

plugins{
	kotlin("jvm") version("${property("kotlinVersion")}") apply false
}

tasks.wrapper {
    gradleVersion = gradle_version
    distributionType = Wrapper.DistributionType.ALL
}
