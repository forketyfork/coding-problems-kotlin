import org.gradle.kotlin.dsl.KotlinClosure2

plugins {
    kotlin("jvm") version "2.2.20"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter.engine)
    testImplementation(libs.junit.jupiter.params)
    testImplementation(libs.assertj.core)
    testImplementation(libs.junit.platform.launcher)
}

tasks {

    test {
        useJUnitPlatform()
        afterTest(KotlinClosure2<TestDescriptor, TestResult, Any>({ descriptor, result ->
            val test = descriptor as org.gradle.api.internal.tasks.testing.TestDescriptorInternal
            println("${test.className} > ${test.name} [${test.displayName}]: ${result.resultType}")
        }))
    }

}

kotlin {
    jvmToolchain(21)
}
