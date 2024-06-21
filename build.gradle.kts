val javaVersion = 21
val silkVersion = "1.10.5"

plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    id("fabric-loom") version "1.6-SNAPSHOT"
}

group = "live.einfachgustaf"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:1.20.6")
    mappings(loom.officialMojangMappings())

    modImplementation("net.fabricmc:fabric-loader:0.15.10")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.97.8+1.20.6")
    modImplementation("net.fabricmc:fabric-language-kotlin:1.10.19+kotlin.1.9.23")

    modImplementation("net.silkmc:silk-core:$silkVersion")
    modImplementation("net.silkmc:silk-commands:$silkVersion")

    include(implementation("me.obsilabor", "alert", "1.0.8"))
    include(implementation("org.jetbrains.kotlinx", "kotlinx-serialization-json", "1.7.0"))
}

tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjdk-release=$javaVersion", "-Xskip-prerelease-check")
            jvmTarget = "$javaVersion"
        }
    }
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(javaVersion)
    }
    processResources {
        val properties = mapOf("version" to project.version)
        inputs.properties(properties)
        filesMatching("fabric.mod.json") { expand(properties) }
    }
}

loom {
    serverOnlyMinecraftJar()
}