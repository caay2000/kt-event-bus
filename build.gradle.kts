plugins {
    application
    kotlin("jvm") version "1.8.0"
    id("com.diffplug.spotless") version "6.13.0"
}

group = "com.github.caay2000"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

tasks.check {
    dependsOn(tasks.spotlessCheck)
}

tasks.withType<Wrapper> {
    gradleVersion = "7.6"
}

kotlin { jvmToolchain(11) }

spotless {
    kotlin { ktlint() }
    kotlinGradle { ktlint() }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.0")

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("org.assertj:assertj-core:3.24.1")
}
