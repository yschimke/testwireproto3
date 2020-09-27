plugins {
    kotlin("jvm") version "1.4.10"
    id("com.squareup.wire") version "3.4.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

wire {
    kotlin {
        out = "src/main/kotlin"
        javaInterop = true
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("com.squareup.wire:wire-runtime:3.4.0")
    implementation("com.squareup.wire:wire-moshi-adapter:3.4.0")
    implementation("com.squareup.wire:wire-grpc-client:3.4.0") {
        exclude(group = "com.squareup.okhttp3")
    }
    implementation("com.squareup.wire:wire-moshi-adapter:3.4.0")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict  -Xopt-in=kotlin.RequiresOptIn")
        jvmTarget = "11"
    }
}
