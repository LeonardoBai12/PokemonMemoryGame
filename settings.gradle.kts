pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PokemonMemoryGame"

include(":common:shared")
include(":common:data")
include(":impl:ktor-client")
include(":memory-game:presentation")
include(":memory-game:data")
include(":memory-game:domain")
include(":memory-game:core")
include(":impl:room-database")
