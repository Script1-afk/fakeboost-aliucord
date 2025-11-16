// build.gradle.kts

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.aliucord.com/releases") // Repo Aliucord
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.aliucord.gradle:gradle-plugin:2.1.2") // version stable
    }
}

plugins {
    kotlin("jvm") version "1.5.21" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.aliucord.com/releases")
    }
}

apply(plugin = "com.android.library")
apply(plugin = "kotlin-android")
apply(plugin = "com.aliucord.gradle.plugin")

aliucord {
    author("DISCORD USERNAME", 123456789L)
    updateUrl.set("https://raw.githubusercontent.com/USERNAME/REPONAME/builds/updater.json")
    buildUrl.set("https://raw.githubusercontent.com/USERNAME/REPONAME/builds/%s.zip")
}

android {
    compileSdkVersion(31)

    defaultConfig {
        minSdk = 24
        targetSdk = 31
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}