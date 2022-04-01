pluginManagement {
   repositories {
       mavenCentral()
       gradlePluginPortal()
       //maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
   }
}

rootProject.name = "grpc-kotlin-hello"
include ("proto")
include ("server")
include ("client")

