import io.gitlab.trixnity.gradle.CargoHost
import io.gitlab.trixnity.gradle.cargo.dsl.*

plugins {
    kotlin("multiplatform") version "2.0.0"
    id("org.jetbrains.kotlin.plugin.atomicfu") version "2.0.0"
    id("io.gitlab.trixnity.cargo.kotlin.multiplatform")
    id("io.gitlab.trixnity.uniffi.kotlin.multiplatform")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.kotlin.link")
}

uniffi {
    generateFromUdl {
        namespace = "math"
        build = "LinuxX64"
        udlFile = layout.projectDirectory.file("rust/src/math.udl")
    }
}

cargo {
    packageDirectory = layout.projectDirectory.dir("rust")

    cargo {
        builds.jvm {
            jvm = (rustTarget == CargoHost.current.hostTarget)
        }
        builds.native { }
    }

}

kotlin {
    explicitApi = null

    linuxX64 {
        binaries.executable {
        }
    }

    jvm()
}