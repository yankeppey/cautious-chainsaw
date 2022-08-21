plugins {
    androidApp version Versions.androidGradlePlugin apply false
    androidLibrary version Versions.androidGradlePlugin apply false
    kapt version Versions.kotlin apply false
    kotlinAndroid version Versions.kotlin apply false
    id("com.google.dagger.hilt.android") version Versions.hilt apply false
    id("com.google.devtools.ksp") version Versions.kspPlugin apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}