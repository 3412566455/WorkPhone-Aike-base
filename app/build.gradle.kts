plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.apollo.safechat"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.apollo.safechat"
        minSdk = 33
        targetSdk = 36
        versionCode = 12
        versionName = "12.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint{
        baseline = file("lint-baseline.xml")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}