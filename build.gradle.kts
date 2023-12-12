plugins {
    id("java-library")
    id("maven-publish")
    id("jacoco")
    kotlin("jvm") version "1.9.20"
    signing
}

group = "sigbla.app"
version = "0.8"

repositories {
    mavenCentral()
}

val kotlinVersion = "1.9.20"
val guavaVersion = "32.1.3-jre"
val assertJVersion = "1.7.0"
val junitVersion = "4.13.2"
val junitEngineVersion = "5.9.2"

dependencies {
    implementation("com.intellij:annotations:12.0")
    testImplementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
    testImplementation("com.google.guava:guava:$guavaVersion")
    testImplementation("org.assertj:assertj-core:$assertJVersion")
    testImplementation("junit:junit:$junitVersion")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:$junitEngineVersion")
}

tasks.test {
    useJUnitPlatform()
    maxHeapSize = "2048m"
    jvmArgs("-server")
}

kotlin {
    jvmToolchain(17)
}

tasks.withType<JacocoReport> {
    reports {
        xml.required = true
        csv.required = true
        html.required = true
    }
}

publishing {
    publications {
        create<MavenPublication>("sigbla") {
            groupId = "sigbla.app"
            artifactId = "sigbla-pds"

            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "ProjectRepo"
            url = uri(layout.projectDirectory.dir(".m2/repository"))
        }
    }
}

signing {
    sign(publishing.publications["sigbla"])
}
