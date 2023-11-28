package uk.co.harnick.bulwark.core.util

enum class BuildIdentifiers {
    Android,
    Desktop
}

expect val bulwarkBuild: BuildIdentifiers