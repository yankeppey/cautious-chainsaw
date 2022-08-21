plugins {
    androidApp
    kotlinAndroid
    kapt
    ksp
    daggerHilt
}

android {
    compileSdk = Versions.compile_sdk
    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
    }
    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.material)
    debugImplementation(Deps.Compose.uiTooling)
    implementation(Deps.Compose.uiToolingPreview)
    implementation(Deps.Compose.util)

    kapt(Deps.Hilt.compiler)
    implementation(Deps.Hilt.android)
    testImplementation(Deps.Hilt.android)
    implementation(Deps.Hilt.navigationCompose)

    testImplementation(Deps.Hilt.testing)
    kaptTest(Deps.Hilt.compiler)
    testImplementation(Deps.Tests.robolectric)
    testImplementation(Deps.Tests.kotlinTest)
    testImplementation(Deps.Tests.junit)
    testImplementation(Deps.Coroutines.test)

    implementation(Deps.Room.room)
    ksp(Deps.Room.compiler)

    implementation(Deps.Coroutines.android)


}

tasks.withType(Test::class) {
    systemProperty("robolectric.logging", "stdout")
}