plugins {
    alias(libs.plugins.kotlin.jvm)
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
        addTestListener(object : TestListener {
            override fun beforeSuite(suite: TestDescriptor) {}
            override fun afterSuite(suite: TestDescriptor, result: TestResult) {}
            override fun beforeTest(testDescriptor: TestDescriptor) {}
            override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {
                val test = testDescriptor as org.gradle.api.internal.tasks.testing.TestDescriptorInternal
                println("${test.className} > ${test.name} [${test.displayName}]: ${result.resultType}")
            }
        })
    }

}

kotlin {
    jvmToolchain(24)
}
