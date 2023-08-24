

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    //id("kotlin-kapt")
}

android {
    namespace = "ru.yotfr.tracker"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.yotfr.tracker"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    val roomVersion = "2.5.2"
    val viewModelKTXVersion = "2.6.1"
    val coroutinesVersion = "1.7.2"
    val navVersion = "2.7.1"
    val glideVersion = "4.14.2"
    val glideComposeVersion = "1.0.0-alpha.5"
    val googleLocationServicesVersion = "21.0.1"
    val googleMapsServicesVersion = "18.1.0"
    val daggerVersion = "2.47"
    val timberVersion = "5.0.1"
    val coreKTXVersion = "1.10.1"
    val lifecycleRuntimeKTXVersion = "2.6.1"
    val activityComposeVersion = "1.7.2"
    val composeBomVersion = "2023.03.00"
    val jUnitVersion = "4.13.2"
    val androidJUnitVersion = "1.1.5"
    val espressoVersion = "3.5.1"


    // Room
    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

    // KTX
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelKTXVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    implementation("androidx.core:core-ktx:$coreKTXVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeKTXVersion")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

    // Navigation
    implementation("androidx.navigation:navigation-compose:$navVersion")

    // Glide
    implementation("com.github.bumptech.glide:compose:$glideComposeVersion")
    ksp("com.github.bumptech.glide:ksp:$glideVersion")

    // Google maps and location services
    implementation("com.google.android.gms:play-services-location:$googleLocationServicesVersion")
    implementation("com.google.android.gms:play-services-maps:$googleMapsServicesVersion")

    // Dagger
    implementation("com.google.dagger:dagger:$daggerVersion")
    ksp("com.google.dagger:dagger-compiler:$daggerVersion")

    // Timber
    implementation("com.jakewharton.timber:timber:$timberVersion")

    // Activity
    implementation("androidx.activity:activity-compose:$activityComposeVersion")

    // Compose
    implementation(platform("androidx.compose:compose-bom:$composeBomVersion"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    androidTestImplementation(platform("androidx.compose:compose-bom:$composeBomVersion"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Test
    testImplementation("junit:junit:$jUnitVersion")
    androidTestImplementation("androidx.test.ext:junit:$androidJUnitVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")


}