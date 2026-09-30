import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    java
    id("de.eldoria.plugin-yml.bukkit") version ("0.9.0")
    id("com.gradleup.shadow") version ("9.6.1")
}

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

bukkit {
    name = "ByteProtectionStones"
    version = project.version.toString()
    description = project.description
    authors = listOf("EspiDev", "iAmForyy_")
    main = "dev.espi.protectionstones.ProtectionStones"
    apiVersion = "1.21.10"

    depend = listOf(
        "WorldGuard",
        "WorldEdit"
    )

    softDepend = listOf(
        "Vault",
        "PlaceholderAPI",
        "LuckPerms"
    )

    permissions {
        create("protectionstones.create") {
            description = "Protect a region by placing a ProtectionStones block."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.destroy") {
            description = "Allow players to remove their own protected regions (block break)."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.unclaim") {
            description = "Allow players to unclaim their region using /ps unclaim."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.unclaim.remote") {
            description = "Allow players to unclaim their region remotely using /ps unclaim [list|region-id]."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.view") {
            description = "Allows players the use of /ps view in their own regions."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.view.others") {
            description = "Allows players the use of /ps view in regions they are not a part of."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.info") {
            description = "Allows players the use of /ps info."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.info.others") {
            description = "Allows players to use /ps info in unowned regions."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.get") {
            description = "Allows players the use of /ps get."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.give") {
            description = "Allows players the use of /ps give (give protectionstones to others as admin)."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.count") {
            description = "Allows players the use of /ps count."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.count.others") {
            description = "Allows players the use of /ps count [player]."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.list") {
            description = "Allows players the use of /ps list."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.list.others") {
            description = "Allows players to do /ps list [player]."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.hide") {
            description = "Allow players to hide their ProtectionStones block."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.unhide") {
            description = "Allow players to unhide their ProtectionStones block."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.setparent") {
            description = "Allow access to /ps setparent."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.setparent.others") {
            description = "Allow players to set their region to inherit properties from other regions they don't own."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.name") {
            description = "Access to the /ps name command."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.home") {
            description = "Access to the /ps home command."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.sethome") {
            description = "Access to /ps sethome."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.tp") {
            description = "Access to /ps tp command."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.tp.bypasswait") {
            description = "Bypass the wait time set in the config for /ps home and /ps tp"
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.tp.bypassprevent") {
            description = "Bypass prevent_teleport_in option in config"
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.priority") {
            description = "Allows players to set their region's priority."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.owners") {
            description = "Allows players to add or remove region owners. Allows players to use /ps info owners command."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.members") {
            description = "Allows players to add or remove region members. Allows players to use /ps info members command."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.flags") {
            description = "Allows players to set their region flags."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.rent") {
            description = "Allows players to use the /ps rent command."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.buysell") {
            description = "Allows players access to /ps buy and /ps sell."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.tax") {
            description = "Allows players to access /ps tax commands."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.toggle") {
            description = "Allows players to toggle ProtectionStones placement."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.region") {
            description = "Allows players to use the /ps region commands."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.merge") {
            description = "Allows players to merge their regions with other regions they own."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.admin") {
            description = "This permission allows users to override all ProtectionStones regions and use /ps admin and /ps reload."
            default = BukkitPluginDescription.Permission.Default.OP
        }

        create("protectionstones.superowner") {
            description = "Allows players to override region permissions."
            default = BukkitPluginDescription.Permission.Default.OP
        }
    }

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