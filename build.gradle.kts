
buildscript {
    extra.apply {
        set("grpcVersion","+")
        set("kotlinVersion", "1.3.70")
    }

    repositories {
        mavenCentral()
    }
}

plugins{
	kotlin("jvm") version("${property("kotlinVersion")}") apply false
}

tasks.wrapper {
    gradleVersion = "6.3-rc-4"
    distributionType = Wrapper.DistributionType.ALL
}
