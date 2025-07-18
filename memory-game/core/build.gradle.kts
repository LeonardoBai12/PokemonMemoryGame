plugins {
    id("com.google.dagger.hilt.android")
    id("io.lb.android.app")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    kotlin("kapt")
}

android {
    namespace = "io.lb.astormemory.app"

    defaultConfig {
        versionCode = 1
        versionName = "1.0.0"
    }

    packaging {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics")
    implementation("com.google.android.play:integrity:1.4.0")
    implementation(project(":impl:room-database"))
    implementation(project(":memory-game:data"))
    implementation(project(":memory-game:domain"))
    implementation(project(":memory-game:presentation"))
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
