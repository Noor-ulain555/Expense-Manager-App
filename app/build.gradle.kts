plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.expensemanagerapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.expensemanagerapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures{
        viewBinding=true
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
//
//
//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation("androidx.navigation:navigation-fragment-ktx:2.7.3")
//    implementation("androidx.navigation:navigation-ui-ktx:2.7.3")
//    //noinspection LifecycleAnnotationProcessorWithJava8
//    kapt ("androidx.lifecycle:lifecycle-compiler:2.7.0-alpha02")
//    implementation("androidx.activity:activity-ktx:2.3.0-alpha06")
//
//    // Lifecycles only (without ViewModel or LiveData)
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-alpha06")
//    // ViewModel
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0-alpha06")
//    // LiveData
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.0-alpha06")
//
//    // Coroutines
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
//
//    implementation("com.google.android.material:material:1.1.0")
//
//    implementation("androidx.room:room-ktx:2.2.5")
//    implementation("androidx.room:room-runtime:2.2.5")
//    kapt("androidx.room:room-compiler:2.5.2")


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.room:room-runtime:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")
    ksp("androidx.room:room-compiler:2.5.2")


}