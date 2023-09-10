pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "CellcomExam"
include(":app")
include(":core")
include(":core_ui")
include(":modules")
include(":modules:movies")
include(":modules:movies:movies_data")
include(":modules:movies:movies_domain")
include(":modules:movies:movies_presentation")
