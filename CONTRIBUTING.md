# Contributing to Kotlin Java Comparison

## About This Project

This project demonstrates the same calculator functionality implemented in both Java and Kotlin, showcasing Kotlin's advantages in conciseness, safety, and modern language features. See:

- **[README.md](README.md)** - Quick comparison overview
- **[JAVA_KOTLIN_COMPARISON.md](JAVA_KOTLIN_COMPARISON.md)** - Detailed technical comparison

## Development Setup

1. **Prerequisites**
   - Java 22 or higher
   - Git

2. **Clone and Build**
   ```bash
   git clone <repository-url>
   cd kotlin-java-comparison
   ./gradlew build
   ```

## Running Tests

```bash
# Run all tests
./gradlew test

# Run Java calculator application
./gradlew runJava

# Run Kotlin calculator application
./gradlew runKotlin

# Run Builder Pattern comparison demos
./gradlew runJavaBook     # Java Builder Pattern example
./gradlew runKotlinBook   # Kotlin named parameters example

# Generate test reports
./gradlew test jacocoTestReport
```

## Code Quality

### Before Submitting a Pull Request

1. **Build and Test Locally**
   ```bash
   ./gradlew clean build test
   ```

2. **Run Both Applications**
   ```bash
   ./gradlew runJava runKotlin
   ```

3. **Check for Security Issues**
   ```bash
   ./gradlew dependencyCheckAnalyze
   ```

### CI Pipeline

All pull requests and commits to main/master automatically trigger:

- **Multi-platform builds** (Ubuntu, Windows, macOS)
- **Unit and integration tests** for both Java and Kotlin
- **Security scanning** for vulnerabilities
- **Code quality analysis** via CodeQL

### Coding Standards

- **Java**: Follow standard Java conventions
- **Kotlin**: Follow [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
- **Tests**: Write tests for both Java and Kotlin implementations
- **Documentation**: Update README.md for significant changes

## Project Structure

```
src/
├── main/
│   ├── java/com/claymccoy/
│   │   ├── jcalc/                    # Java calculator implementation
│   │   └── builder/                  # Java Builder Pattern example
│   └── kotlin/com/claymccoy/kcalc/   # Kotlin implementation
└── test/
    ├── java/com/claymccoy/jcalc/     # Java tests
    └── kotlin/com/claymccoy/
        ├── kcalc/                    # Kotlin calculator tests
        └── builder/                  # Kotlin Book example (named params)
```

## Submitting Changes

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add/update tests as needed
5. Ensure all CI checks pass
6. Submit a pull request

## Questions?

Feel free to open an issue for any questions or suggestions!
