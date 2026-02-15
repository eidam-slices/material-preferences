import org.jetbrains.kotlin.gradle.dsl.JvmTarget

group = "cz.eidam.material-preferences"
version = "0.3.1"

publishing {
    publications {
        create<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"])
            }
            groupId = project.group.toString()
            artifactId = "utils"
            version = project.version.toString()
        }
    }
}

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "cz.eidam.material_preferences.utils"

    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 26
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_11
    }
}


dependencies {
    implementation(libs.androidx.datastore.preferences)
    implementation(project(":material_preferences"))
}