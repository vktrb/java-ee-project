plugins {
    java
    war
    id("com.diffplug.spotless") version "6.25.0"
}

group = "pl.lodz.uni"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.build {
    dependsOn(tasks.spotlessCheck)
}

tasks.test {
    useJUnitPlatform()
}

spotless {
    java {
        googleJavaFormat("1.17.0") // use Google Java Format with JDK17 support
        target("src/**/*.java")    // format all Java files
    }
    format("misc") {
        target("*.gradle", "*.md", ".gitignore")
        trimTrailingWhitespace()
        endWithNewline()
    }
}
