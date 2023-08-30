pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "multiplatform-markdown-renderer-root"

include(":sample:androidApp")
include(":sample:desktopApp")
include(":sample:shared")
include(":multiplatform-markdown-renderer")
include(":app")
include(":compose-desktop")
