plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.multiplatform)
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.androidx.compose.activity)
}

android {
    namespace = "uk.co.harnick.bulwark.android"
    compileSdk = libs.versions.android.sdk.compile.get().toInt()
    defaultConfig {
        applicationId = "uk.co.harnick.bulwark"
        minSdk = libs.versions.android.sdk.min.get().toInt()
        targetSdk = libs.versions.android.sdk.compile.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1,versions/9/previous-compilation-data.bin}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
    }
    kotlinOptions {
        jvmTarget = JavaVersion.toVersion(libs.versions.jdk.get()).majorVersion
    }
}

compose {
    kotlinCompilerPlugin.set(libs.versions.compose.tooling.get())
    kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=1.9.21")
}
