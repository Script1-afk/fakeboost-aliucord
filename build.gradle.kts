import com.aliucord.gradle.AliucordExtension
import com.android.build.gradle.BaseExtension

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
        classpath("com.aliucord:gradle:main-SNAPSHOT")
    }
}

// Appliquer les plugins aux subprojects
subprojects {
    apply(plugin = "com.android.library")
    apply(plugin = "org.jetbrains.kotlin.android")
    apply(plugin = "com.aliucord.gradle")

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

        // Kotlin options
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "11"
                freeCompilerArgs = freeCompilerArgs +
                        "-Xno-call-assertions" +
                        "-Xno-param-assertions" +
                        "-Xno-receiver-assertions"
            }
        }
    }

    dependencies {
        val discord by configurations
        val implementation by configurations

        discord("com.discord:discord:aliucord-SNAPSHOT")
        implementation("com.aliucord:Aliucord:main-SNAPSHOT")

        implementation("androidx.appcompat:appcompat:1.4.0")
        implementation("com.google.android.material:material:1.4.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    }
}

// Tâche clean
tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}