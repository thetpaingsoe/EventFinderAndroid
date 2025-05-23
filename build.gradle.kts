// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.kapt) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Correct way to reference Gradle plugins as classpath dependencies
        classpath("com.android.tools.build:gradle:8.1.0") // Use your AGP version from libs.versions.toml
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0") // Match your Kotlin version
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48") // Match your Hilt version
    }
}