plugins {
    kotlin("jvm") version "2.0.0"
    id("com.google.devtools.ksp") version "2.0.0-1.0.21"
}

group = "org.aesirlab"
//version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/zg009/mycustomprocessor")
            credentials {
                username = "zg009"
                password = project.findProperty("gpr.key") as String? ?: System.getProperty("TOKEN")
            }
    }
}
val version = "0.1.5"
dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
//    implementation("com.google.devtools.ksp:symbol-processing-api:2.0.0-1.0.21")
    ksp("com.squareup:kotlinpoet:1.14.0")
//    implementation("com.squareup:kotlinpoet-ksp:1.12.0")
    ksp("com.squareup:kotlinpoet-ksp:1.12.0")

    implementation("org.zg009:aesir-test-annotation:$version")
//    implementation("org.zg009:aesir-test-processor:$version")
    ksp("org.zg009:aesir-test-processor:$version")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}