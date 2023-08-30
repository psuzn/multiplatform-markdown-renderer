import com.android.build.gradle.tasks.factory.AndroidUnitTest

plugins {
  kotlin("multiplatform")
  kotlin("native.cocoapods")
  id("com.android.library")
  id("org.jetbrains.compose")
}

version = "1.0-SNAPSHOT"

kotlin {
  android()
  jvm("desktop")
  ios()
  iosSimulatorArm64()

  cocoapods {
    summary = "Shared code for the sample"
    homepage = "https://github.com/JetBrains/compose-jb"
    ios.deploymentTarget = "14.1"
    podfile = project.file("../iosApp/Podfile")
    framework {
      baseName = "shared"
      isStatic = true
    }
    extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
  }

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(compose.ui)
        implementation(compose.material)
        api(project(":multiplatform-markdown-renderer"))
      }
    }

    val androidMain by getting {
      dependencies {
        api("androidx.appcompat:appcompat:1.6.1")
      }
    }

    val iosMain by getting {

    }

    val iosSimulatorArm64Main by getting {
      dependsOn(iosMain)
    }

    val desktopMain by getting {

    }
  }
}


android {
  namespace = "com.mikepenz.markdown.sample.common"
  compileSdk = Versions.androidCompileSdk
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
  sourceSets["main"].res.srcDirs("src/androidMain/res")
  sourceSets["main"].resources.srcDirs("src/commonMain/resources")

  defaultConfig {
    minSdk = Versions.androidMinSdk
  }

  buildFeatures {
    compose = true
    buildConfig = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.4"
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}

tasks.withType<AndroidUnitTest> {
  useJUnitPlatform()
}
