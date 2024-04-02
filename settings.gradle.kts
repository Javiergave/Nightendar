pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}


rootProject.name = "Nightendar"
include(":app")
