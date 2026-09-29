plugins {
    java
    id("com.gradleup.shadow") version ("9.6.1")
}

group = "dev.espi"
version = project.version
description = "A grief prevention plugin for Spigot Minecraft servers."

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
    maven {
        name = "Spigot"
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }

    maven {
        name = "EngineHub"
        url = uri("https://maven.enginehub.org/repo/")
    }

    maven {
        name = "CodeMC"
        url = uri("https://repo.codemc.org/repository/maven-public")
    }

    maven {
        name = "PlaceholderAPI"
        url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    }

    maven {
        name = "PaperMC"
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
}

dependencies {
    implementation("org.bstats:bstats-bukkit:3.0.2")

    compileOnly("org.spigotmc:spigot-api:26.2-R0.1-SNAPSHOT")

    compileOnly("com.sk89q.worldguard:worldguard-bukkit:7.0.9-SNAPSHOT") {
        exclude(group = "org.bukkit")
    }

    compileOnly("net.milkbowl.vault:VaultAPI:1.7")

    compileOnly("com.sk89q.worldedit:worldedit-bukkit:7.2.6-SNAPSHOT") {
        exclude(group = "org.bukkit")
    }

    compileOnly("me.clip:placeholderapi:2.11.6")

    compileOnly("net.luckperms:api:5.2")

    implementation("com.electronwill.night-config:toml:3.6.3")
    implementation("commons-io:commons-io:2.16.1")
    implementation("org.apache.commons:commons-lang3:3.18.0")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }

    jar {
        enabled = false
    }

    shadowJar {
        archiveClassifier.set("")

        relocate(
            "org.bstats",
            "dev.espi.protectionstones"
        )
    }

    build {
        dependsOn(shadowJar)
    }

    register<Jar>("sourcesJar") {
        description = ""
        archiveClassifier.set("sources")

        from(sourceSets.main.get().allSource)
    }

    register<Jar>("javadocJar") {
        archiveClassifier.set("javadoc")

        from(javadoc)
    }
}