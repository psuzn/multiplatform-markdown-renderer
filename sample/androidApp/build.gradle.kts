plugins {
  kotlin("multiplatform")
  id("com.android.application")
  id("org.jetbrains.compose")
}

kotlin {
  android()
  sourceSets {
    val androidMain by getting {
      dependencies {
        implementation(project(":sample:shared"))
        api("androidx.activity:activity-compose:1.7.2")
        api("androidx.core:core-ktx:1.10.1")
      }
    }
  }
}

android {
  compileSdk = Versions.androidCompileSdk
  namespace = "com.mikepenz.markdown.sample"

  defaultConfig {
    applicationId = "com.mikepenz.markdown.sample"
    minSdk = Versions.androidMinSdk
    targetSdk = Versions.androidTargetSdk
    versionCode = 1
    versionName = "0.0.1"
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
  }
}
