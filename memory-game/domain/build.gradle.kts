plugins {
    id("com.google.dagger.hilt.android")
    id("io.lb.android.library")
    kotlin("kapt")
}

android {
    namespace = "io.lb.domain"
}

dependencies {
    implementation(project(":common:data"))
    implementation(project(":common:shared"))
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
