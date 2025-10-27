plugins {
    kotlin("jvm") version "2.0.21"
    java
    application
}

group = "com.claymccoy"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_22
    targetCompatibility = JavaVersion.VERSION_22
}

kotlin {
    jvmToolchain(22)
}

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin dependencies
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    
    // Other dependencies
    implementation("jakarta.validation:jakarta.validation-api:3.1.1")
    implementation("com.google.guava:guava:33.4.0-jre")
    
    // Test dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.11.4")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

// Configure source sets to include both Java and Kotlin
sourceSets {
    main {
        java {
            setSrcDirs(listOf("src/main/java"))
        }
        kotlin {
            setSrcDirs(listOf("src/main/kotlin"))
        }
    }
    test {
        java {
            setSrcDirs(listOf("src/test/java"))
        }
        kotlin {
            setSrcDirs(listOf("src/test/kotlin"))
        }
    }
}

// Optional: Configure main classes for running the applications
application {
    mainClass.set("com.claymccoy.jcalc.JavaSolve") // Default to Java main class
}

// Create tasks to run both Java and Kotlin versions
tasks.register<JavaExec>("runJava") {
    group = "application"
    description = "Run the Java version of the calculator"
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("com.claymccoy.jcalc.JavaSolve")
}

tasks.register<JavaExec>("runKotlin") {
    group = "application"
    description = "Run the Kotlin version of the calculator"
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("com.claymccoy.kcalc.KotlinSolveKt")
}

// Additional demo tasks for Builder Pattern comparison
tasks.register<JavaExec>("runJavaBook") {
    group = "demo"
    description = "Run the Java Builder Pattern demo"
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("com.claymccoy.builder.BookMain")
}

tasks.register<JavaExec>("runKotlinBook") {
    group = "demo"
    description = "Run the Kotlin data class demo"
    classpath = sourceSets.test.get().runtimeClasspath
    mainClass.set("com.claymccoy.builder.BookKt")
}
