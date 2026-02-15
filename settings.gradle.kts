pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Material Preferences"
include(":material_preferences")
include(":material_preferences_utils")
include(":material_preferences_utils_compose")
include(":demo_koin")
include(":demo_manual")
include(":demo_shared")

if (file("testing").exists()) {
    include(":testing")
}
