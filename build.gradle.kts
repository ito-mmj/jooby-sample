import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.6.20"
val joobyVersion = "2.16.1"

plugins {
    kotlin("jvm") version "1.6.20"
    id("application")
    id("io.jooby.run") version "2.16.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.google.osdetector") version "1.7.0"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    kotlin("kapt") version "1.6.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.jooby:jooby-netty:$joobyVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("ch.qos.logback:logback-classic:1.4.4")
    implementation("javax.ws.rs:javax.ws.rs-api:2.1.1")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("com.fasterxml.jackson.core:jackson-core:2.13.4")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.13.4")
    implementation("io.jooby:jooby-jackson:2.16.1")
    kapt("io.jooby:jooby-apt:$joobyVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    testImplementation("io.jooby:jooby-test:$joobyVersion")
    testImplementation("com.squareup.okhttp3:okhttp:4.10.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.javaParameters = true
}
