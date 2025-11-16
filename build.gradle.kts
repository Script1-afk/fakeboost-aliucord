buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.aliucord.com/snapshots")
        maven("https://jitpack.io")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.aliucord.gradle:gradle-plugin:main-SNAPSHOT")
    }
}

plugins {
    kotlin("android") version "1.5.21" apply false
}

repositories {
    google()
    mavenCentral()
    maven("https://maven.aliucord.com/snapshots")
    maven("https://jitpack.io")
}

group = "com.yourusername.plugins"
version = "1.0.0"

apply(plugin = "com.android.library")
apply(plugin = "org.jetbrains.kotlin.android")
apply(plugin = "com.aliucord.gradle")

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 24
        targetSdk = 31
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

aliucord {
    author("TonPseudoDiscord", 123456789012345678)
    updateUrl.set("https://raw.githubusercontent.com/USERNAME/REPONAME/builds/updater.json")
    buildUrl.set("https://raw.githubusercontent.com/USERNAME/REPONAME/builds/%s.zip")
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
}