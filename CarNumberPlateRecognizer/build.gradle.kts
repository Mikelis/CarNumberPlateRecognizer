import com.android.build.gradle.internal.utils.createPublishingInfoForLibrary

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }

    }

    namespace = "lv.mikeliskaneps.carnumberplaterecognizer"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.text.recognition)
}
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "lv.mikelis.kaneps"
                artifactId = "carnumberplaterecognizer"
                version = "1.0.2"
            }
        }
    }
}
