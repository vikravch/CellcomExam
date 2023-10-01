plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = ProjectConfig.appId+".movies_presentation"
}
apply{
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.core_ui))

    "implementation"(project(Modules.movies_domain))
    "implementation"(project(Modules.movies_data))
}