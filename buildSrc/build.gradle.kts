plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.spotless)
    implementation(libs.spring.dependency.management.plugin)
    implementation(libs.spring.boot.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.spring.plugin)
    implementation(libs.jooq.plugin)
    implementation(libs.flyway.plugin)
    implementation(libs.testcontainers.postgres)
    implementation(libs.postgres)
}