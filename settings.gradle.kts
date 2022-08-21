include(
        ":app",
)

buildCache {
    local {
        isEnabled = true
        removeUnusedEntriesAfterDays = 30
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
