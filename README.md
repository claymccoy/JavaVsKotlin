# Java Kotlin comparison

[![CI](https://github.com/claymccoy/kotlin-java-comparison/actions/workflows/ci.yml/badge.svg)](https://github.com/claymccoy/kotlin-java-comparison/actions/workflows/ci.yml)

This project demonstrates equivalent implementations in Java and Kotlin.

## Building and Running

This project uses Gradle with the Kotlin DSL. You can use the included Gradle wrapper to build and run the project.

### Build the project
```bash
./gradlew build
```

### Run the Java version
```bash
./gradlew runJava
```

### Run the Kotlin version
```bash
./gradlew runKotlin
```

### Additional demo tasks
```bash
# Builder Pattern comparison demos
./gradlew runJavaBook     # Java Builder Pattern example
./gradlew runKotlinBook   # Kotlin named parameters example
```

### Other useful Gradle tasks
```bash
./gradlew tasks          # List all available tasks
./gradlew clean          # Clean build artifacts
./gradlew test           # Run tests
./gradlew check          # Run tests and code quality checks
```

## Project Structure

- `src/main/java/` - Java source code (`com.claymccoy.jcalc` package)
- `src/main/kotlin/` - Kotlin source code (`com.claymccoy.kcalc` package)
- `build.gradle.kts` - Main Gradle build script
- `settings.gradle.kts` - Gradle settings
- `gradle.properties` - Gradle configuration properties

## CI/CD Pipeline

This project includes comprehensive GitHub Actions workflows for continuous integration:

### Workflows
- **CI (ci.yml)**: Builds and tests on multiple platforms (Ubuntu, Windows, macOS) for every push to master/main and pull requests
- **Security Scan (security.yml)**: Weekly dependency vulnerability scanning
- **CodeQL (codeql.yml)**: Static code analysis for security and quality issues

### Test Coverage
- Java unit tests using JUnit Jupiter
- Kotlin unit tests using kotlin-test
- Integration tests for both calculator implementations

## Java vs Kotlin Code Comparison

This project demonstrates the same calculator functionality implemented in both Java and Kotlin, showcasing Kotlin's advantages in terms of conciseness, safety, and modern language features.

### 🎯 **Key Differences Overview**

| Aspect | Java | Kotlin |
|--------|------|--------|
| **Lines of Code** | ~180 lines | ~50 lines (72% less!) |
| **Null Safety** | Runtime `NullPointerException` risk | Compile-time null safety |
| **Collections** | Verbose stream operations | Concise functional operations |
| **Type Inference** | Explicit types required | Smart type inference |
| **Operator Overloading** | Not supported | Natural DSL creation |
| **Immutability** | Manual (records/final) | Built-in (`val`, immutable collections) |
| **Builder Pattern** | Manual implementation (54 lines) | Named params + defaults (4 lines) |

### 📊 **Code Conciseness**

**Java Main Class (37 lines):**
```java
// Verbose stream operations with explicit types
ImmutableList.of(
    solver.solve(new Expression(Add, new Operand(2), new Operand(3))),
    solver.solve(new Expression(Add, new Operand(7), new Operand(5))),
    // ... more expressions
).stream().filter(solvedExpression -> solvedExpression.result() < 100)
    .collect(Collectors.groupingBy(SolvedExpression::result))
    .entrySet().stream()
    .map(entry -> {
        final var joinedExpressions = entry.getValue().stream()
            .map(solvedExpression -> solvedExpression.expression().toString())
            .collect(Collectors.joining(" = "));
        return entry.getKey() + " = " + joinedExpressions;
    }).toList()
    .stream().sorted(Comparator.comparing(String::length))
    .forEach(System.out::println);
```

**Kotlin Main Class (22 lines):**
```kotlin
// Concise functional operations with operator overloading
Solver(CalculatorImpl()).solve {
    listOf(
        Operand(2) + 3,
        Operand(7) + 5,
        // ... more expressions
    ).filter { it.result < 100 }
        .groupBy { it.result }
        .map { (result, solvedExpressions) ->
            val joinedExpressions = solvedExpressions.map { it.expression }.joinToString(" = ")
            "$result = $joinedExpressions"
        }.sortedBy { it.length }
        .forEach(::println)
}
```

### 🛡️ **Null Safety**

**Java:**
```java
public SolvedExpression solve(@NotNull Expression expression) {
    requireNonNull(expression, "expression is null"); // Runtime check
    return new SolvedExpression(expression, calculator.calculate(expression));
}
```

**Kotlin:**
```kotlin
// Compile-time null safety - no null checks needed!
fun calculate(expression: Expression): Int {
    return when (expression.operator) {
        Add -> expression.run { first.value + second.value }
        // ...
    }
}
```

### 🎨 **Operator Overloading & DSL**

**Java** - No operator overloading, verbose expression creation:
```java
solver.solve(new Expression(Add, new Operand(2), new Operand(3)))
solver.solve(new Expression(Multiply, new Operand(4), new Operand(3)))
```

**Kotlin** - Natural DSL with operator overloading:
```kotlin
Operand(2) + 3
Operand(4) * 3
Operand(5) exp 3  // Custom infix function
```

### 🔄 **Collections & Functional Programming**

**Java** - Verbose stream operations:
```java
.stream().filter(solvedExpression -> solvedExpression.result() < 100)
.collect(Collectors.groupingBy(SolvedExpression::result))
.entrySet().stream()
.map(entry -> /* complex mapping logic */)
.collect(Collectors.joining(" = "))
```

**Kotlin** - Concise and readable:
```kotlin
.filter { it.result < 100 }
.groupBy { it.result }
.map { (result, solvedExpressions) -> /* destructuring */ }
.joinToString(" = ")
```

### 📝 **Pattern Matching**

**Java** - Switch expressions (modern Java):
```java
return switch (expression.operator()) {
    case Add -> expression.first().value() + expression.second().value();
    case Subtract -> expression.first().value() - expression.second().value();
    // ...
};
```

**Kotlin** - More powerful `when` expressions:
```kotlin
return when (expression.operator) {
    Add -> expression.run { first.value + second.value }
    Subtract -> expression.run { first.value - second.value }
    // ...
}
```

### 🏗️ **Data Classes & Immutability**

**Java** - Records (verbose):
```java
public record Expression(
    @NotNull Operator operator,
    @NotNull Operand first,
    @NotNull Operand second) {
    
    public Expression {
        requireNonNull(operator, "operator is null");
        requireNonNull(first, "first is null");
        requireNonNull(second, "second is null");
    }
    
    @Override
    public String toString() {
        return first + " " + operator + " " + second;
    }
}
```

**Kotlin** - Data classes (concise):
```kotlin
class Expression(val operator: Operator, val first: Operand, val second: Operand) {
    override fun toString() = "$first $operator $second"
}
```

### 🏗️ **Builder Pattern vs Named Parameters**

One of the most striking differences is how object construction is handled. Java often requires the Builder pattern for complex objects, while Kotlin provides this functionality built-in with named parameters and default values.

**Java** - Traditional Builder Pattern (54 lines):
```java
public record BookRecord(String title, String author, int yearPublished, Optional<String> description) {
    
    public static class Builder {
        private final String title;
        private String author;
        private int yearPublished;
        private Optional<String> description;

        public Builder(String title) { this.title = title; }
        
        public Builder author(String author) {
            this.author = author;
            return this;
        }
        
        public Builder yearPublished(int yearPublished) {
            this.yearPublished = yearPublished;
            return this;
        }
        
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }
        
        public BookRecord build() {
            return new BookRecord(this.title, this.author, this.yearPublished, this.description);
        }
    }
}

// Usage:
var book = new BookRecord.Builder("Effective Java")
    .author("Joshua Bloch")
    .yearPublished(2001)
    .build();

var secondEdition = new BookRecord.Builder("Effective Java")
    .author("Joshua Bloch")
    .yearPublished(2008)
    .description(Optional.of("Second Edition"))
    .build();
```

**Kotlin** - Named Parameters + Default Values + Copy (4 lines):
```kotlin
data class Book(val title: String,
                val author: String,
                val yearPublished: Int,
                val description: String? = null)

// Usage:
val book = Book(
    title = "Effective Java",
    author = "Joshua Bloch",
    yearPublished = 2001
)

val secondEdition = book.copy(yearPublished = 2008, description = "Second Edition")
```

**Key Advantages of Kotlin's Approach:**
- **📉 93% Less Code** - 4 lines vs 54 lines for the same functionality
- **🎯 Named Parameters** - Self-documenting calls, order-independent
- **⚡ Default Values** - No need for multiple constructors or builder methods
- **🔄 Copy Function** - Immutable updates with `copy()` method automatically generated
- **🛡️ Null Safety** - `String?` vs `Optional<String>` - cleaner and more expressive
- **✨ No Boilerplate** - No manual builder class implementation needed

You can run these examples:
```bash
./gradlew runJavaBook    # See Java Builder pattern in action
./gradlew runKotlinBook  # See Kotlin's concise equivalent
```

### 🧪 **Testing**

Both implementations have comprehensive test suites, but Kotlin tests benefit from:
- More concise syntax
- Better type inference
- Less boilerplate

### 💡 **Summary**

Kotlin provides significant advantages over Java:

1. **📉 72% Less Code** - Same functionality in much fewer lines
2. **🛡️ Compile-time Null Safety** - Eliminates `NullPointerException` at runtime
3. **🎨 Operator Overloading** - Creates natural, readable DSLs
4. **📊 Functional Programming** - More concise and expressive collection operations
5. **🔧 Smart Type Inference** - Less verbose type declarations
6. **🏗️ Built-in Immutability** - `val` keyword and immutable collections by default
7. **🏗️ No Builder Pattern Needed** - Named parameters + default values + copy methods
8. **⚡ Seamless Java Interop** - Can use any Java library seamlessly

**Specific Examples:**
- **Calculator Logic**: 50 lines vs 180 lines (72% reduction)
- **Builder Pattern**: 4 lines vs 54 lines (93% reduction)
- **Null Handling**: Compile-time safety vs runtime `Optional<T>` checks

While both implementations produce identical results, the Kotlin version is more maintainable, safer, and significantly more concise.
