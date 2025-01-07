plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}
android {
    namespace = "com.example.mozanmap"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mozanmap"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    // viewBindingを有効化
    viewBinding {
        enable = true
    }
}
dependencies {
    // AndroidXとMaterialライブラリの依存関係
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.gridlayout)


//    implementation("com.android.support:appcompat-v7:25.3.1")
//    implementation("com.android.support:cardview-v7:25.3.1")
//    implementation("com.android.support:design:25.3.1")
//    implementation("net.cachapa.expandablelayout:expandablelayout:2.8")
//    implementation (libs.expandableLayout)
//    implementation ("androidx.cardview:cardview:1.0.0")
//    implementation(platform("com.google.firebase:firebase-bom:33.7.0"))
//    implementation("com.google.firebase:firebase-analytics")

    // テスト関連の依存関係
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

