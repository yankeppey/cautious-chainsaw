object Versions {

    const val min_sdk = 29
    const val target_sdk = 32
    const val compile_sdk = 32

    const val kotlin = "1.7.10"
    const val mockk = "1.12.4"
    const val androidGradlePlugin = "7.2.2"
    const val googleServicesPlugin = "4.3.10"
    const val crashlyticsPlugin = "2.8.1"
    const val firebasePerformancePlugin = "1.4.1"
    const val kspPlugin = "1.7.10-1.0.6"

    const val accompanist = "0.25.0"
    const val activityCompose = "1.4.0"
    const val composeCompiler = "1.3.0"
    const val compose = "1.2.1"
    const val coroutines = "1.6.4"

    const val firebase = "29.3.0"

    const val hilt = "2.42"
    const val room = "2.4.3"
    const val retrofit = "2.9.0"
    const val navigation = "2.4.2"

    const val vanpraComposeMaterialDialogs = "0.7.0"

    const val okhttpMock = "1.5.0"

    const val robolectric = "4.8.1"

    const val commonsNet = "3.8.0"

    object AndroidX {
        const val appcompat = "1.3.0"
        const val core = "1.7.0"
        const val dataStore = "1.0.0"
        const val lifecycle = "2.5.0"
        const val startup = "1.1.1"
        const val test = "1.3.0"
        const val camera = "1.1.0"
    }
}

object Deps {
    const val glide = "com.github.bumptech.glide:glide:4.12.0"
    const val coilCompose = "io.coil-kt:coil-compose:2.1.0"
    const val workRuntimeKtx = "androidx.work:work-runtime-ktx:2.7.1"

    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val googleServicesPlugin = "com.google.gms:google-services:${Versions.googleServicesPlugin}"

    const val gson = "com.google.code.gson:gson:2.8.6"

    const val commonsNet = "commons-net:commons-net:${Versions.commonsNet}"

    const val signaturePad = "com.github.gcacace:signature-pad:1.3.1"

    object AndroidX {
        const val lifecycleLivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidX.lifecycle}"
        const val customViewPoolingContainer = "androidx.customview:customview-poolingcontainer:1.0.0-rc01"
    }

    object Coroutines {
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object Compose {

        const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val util = "androidx.compose.ui:ui-util:${Versions.compose}"
    }

    object Hilt {
        const val testing = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        const val androidXCompiler = "androidx.hilt:hilt-compiler:1.0.0"
        const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val navigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val work = "androidx.hilt:hilt-work:1.0.0"
        const val common = "androidx.hilt:hilt-common:1.0.0"
    }

    object Accompanist {
        const val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
        const val insetsUI = "com.google.accompanist:accompanist-insets-ui:${Versions.accompanist}"
        const val pager = "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
        const val systemUIController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
        const val swipeRefresh = "com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist}"
        const val permissions = "com.google.accompanist:accompanist-permissions:${Versions.accompanist}"
    }

    object Room {
        const val room = "androidx.room:room-ktx:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val common = "androidx.room:room-common:${Versions.room}"
    }

    object Network {

        object Retrofit {
            const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
            const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        }

        const val okhttpMock = "com.github.gmazzo:okhttp-mock:${Versions.okhttpMock}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.8.1"

    }

    object Navigation {

        const val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
        const val compose = "androidx.navigation:navigation-compose:${Versions.navigation}"
        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Tests {
        const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
        const val junit = "junit:junit:4.13.2"
        const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
        const val mockk = "io.mockk:mockk:${Versions.mockk}"
    }

    object Google {
        const val playServicesMaps = "com.google.android.gms:play-services-maps:18.0.2"
        const val playServicesLocation = "com.google.android.gms:play-services-location:20.0.0"
        const val androidMapsUtils = "com.google.maps.android:android-maps-utils:2.3.0"

        const val mapsCompose = "com.google.maps.android:maps-compose:2.5.3"
    }

}
