import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.androidApp: PluginDependencySpec
    get() = id("com.android.application")

val PluginDependenciesSpec.androidLibrary: PluginDependencySpec
    get() = id("com.android.library")

val PluginDependenciesSpec.daggerHilt: PluginDependencySpec
    get() = id("dagger.hilt.android.plugin")

val PluginDependenciesSpec.ksp: PluginDependencySpec
    get() = id("com.google.devtools.ksp")

val PluginDependenciesSpec.kapt: PluginDependencySpec
    get() = kotlin("kapt")

val PluginDependenciesSpec.kotlinAndroid: PluginDependencySpec
    get() = kotlin("android")