plugins {
    id("com.google.dagger.hilt.android")
    id("io.lb.android.library")
    kotlin("kapt")
}

android {
    namespace = "io.lb.presentation"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
}

dependencies {
    implementation(project(":common:shared"))
    implementation(project(":common:data"))
    implementation(project(":memory-game:domain"))
    implementation(libs.coil)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    testImplementation("app.cash.turbine:turbine:1.0.0")
    kapt(libs.hilt.compiler)
}
