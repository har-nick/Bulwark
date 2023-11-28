import org.jetbrains.compose.desktop.application.dsl.TargetFormat.AppImage
import org.jetbrains.compose.desktop.application.dsl.TargetFormat.Exe

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.sqldelight)
}

kotlin {
    applyDefaultHierarchyTemplate()

    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = JavaVersion.toVersion(libs.versions.jdk.get()).majorVersion
        }
    }

    androidTarget {
        compilations.all {
            kotlinOptions.jvmTarget = JavaVersion.toVersion(libs.versions.jdk.get()).majorVersion
        }
    }

    sourceSets {
        all {
            languageSettings.enableLanguageFeature("ExpectActualClasses")
        }

        val desktopMain by getting

        commonMain.dependencies {
            implementation(libs.bundles.compose.multiplatform)
            implementation(libs.bundles.sqldelight)
            implementation(libs.bundles.voyager)

            implementation(libs.kotlinx.datetime)
            implementation(libs.kmpalette.core)
            implementation(libs.materialkolor)
            implementation(libs.coroutines.core)
            implementation(libs.windowsize)
        }

        androidMain.dependencies {
            implementation(libs.androidx.biometric)
            implementation(libs.androidx.compose.activity)
            implementation(libs.androidx.core.ktx)
            implementation(libs.androidx.compose.ui.tooling)
            implementation(libs.coroutines.android)
            implementation(libs.sqldelight.driver.android)
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.coroutines.jvm)
            implementation(libs.coroutines.swing)
            implementation(libs.sqldelight.driver.jvm)
        }
    }
}

android {
    namespace = "uk.co.harnick.bulwark"
    compileSdk = libs.versions.android.sdk.compile.get().toInt()
    defaultConfig.minSdk = libs.versions.android.sdk.min.get().toInt()
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.tooling.get()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
    }
}

compose {
    kotlinCompilerPlugin.set(libs.versions.compose.tooling.get())
    kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=1.9.21")

    desktop.application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(AppImage, Exe)
        }
    }
}

sqldelight {
    databases {
        create("LocalStorage") {
            packageName.set("uk.co.harnick.bulwark")
        }
    }
}
