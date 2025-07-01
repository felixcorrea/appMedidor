plugins {
    // Plugins principais do Android (usando Version Catalog)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.jvm) apply false

    // Outros plugins
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false

    alias(libs.plugins.spotless) // Este não usa apply false porque é aplicado no root
}

spotless {
    format("misc") {
        target("**/*.md", ".gitignore")
        trimTrailingWhitespace()
        endWithNewline()
    }
    kotlin {
        target("**/src/**/*.kt", "**/src/**/*.kts")
        ktlint()
        trimTrailingWhitespace()
        endWithNewline()
    }
    kotlinGradle {
        target("*.gradle.kts")
        ktlint()
    }
}
