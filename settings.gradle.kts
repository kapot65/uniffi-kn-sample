pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    includeBuild("../uniffi-kotlin-multiplatform-bindings/build-logic")
}

includeBuild("../uniffi-kotlin-multiplatform-bindings/build-logic") {
    dependencySubstitution {
        substitute(module("io.gitlab.trixnity.uniffi.kotlin.multiplatform:gradle-plugin"))
            .using(project(":gradle-plugin"))
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

rootProject.name = "online-kt"

