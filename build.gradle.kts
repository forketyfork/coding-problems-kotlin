import org.gradle.kotlin.dsl.KotlinClosure2

plugins {
    kotlin("jvm") version "2.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.11.4")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.11.4")
    testImplementation("org.junit.platform:junit-platform-launcher")
    testImplementation("org.assertj:assertj-core:3.27.2")
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
