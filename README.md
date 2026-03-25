# Java Interview Practice

A focused Java practice project with common interview-style coding challenges, organized in a professional Maven layout with unit tests.

## What This Project Covers

- **Array pair sum (Two Sum):** brute-force and hash-based solutions in `SumArrayTarget`.
- **Subsequence validation:** ordered subsequence check in `SubSequenceArray`.
- **Seat reservation simulation:** reserve/cancel flows with priority handling in `ReservationSystem`.
- **Comment moderation count:** case-insensitive keyword detection with underscore tokenization in `CommentsCount`.
- **Core algorithm drills:** palindrome, anagrams, sorting, first non-repeating character, and frequency counting in `BasicAlgorithms`.
- **Additional interview basics:** two-sum indices and palindrome-number checks in `BasicProblems`.
- **Utility methods:** reverse string, word counting, and duplicate removal in `Utils`.

## Tech Stack

- Java 25
- Maven
- JUnit 5 (Jupiter)

## Project Structure

```text
.
├── pom.xml
├── src/
│   ├── main/java/com/practice/
│   │   ├── App.java
│   │   ├── algorithms/
│   │   │   ├── BasicAlgorithms.java
│   │   │   ├── BasicProblems.java
│   │   │   ├── SubSequenceArray.java
│   │   │   └── SumArrayTarget.java
│   │   ├── logic/
│   │   │   ├── CommentsCount.java
│   │   │   └── ReservationSystem.java
│   │   └── utils/
│   │       └── Utils.java
│   └── test/java/com/practice/
│       ├── algorithms/
│       ├── logic/
│       └── utils/
└── README.md
```

## Build and Test

### Run all tests

```bash
mvn test
```

### Quiet test run

```bash
mvn -q test
```

### Build artifact (skip tests)

```bash
mvn -DskipTests package
```
### Use this as your default after adding new functions:

```bash
mvn test
```

That compiles main code, compiles tests, and runs all JUnit tests.

If you only want to check compilation and build a jar without running tests:

```bash
mvn -DskipTests package
```

Useful quick options:

```bash
mvn -Dtest=BasicAlgorithmsTest test 
```
(run one test class)

```bash
mvn -Dtest=BasicAlgorithmsTest#isPalindrome_ShouldReturnTrue_ForPalindrome test
```
(single test)

```bash
mvn clean test
``` 
(same as mvn test, but cleans old build output first)

## Notes

- `App` is intentionally minimal and does not execute demonstration scenarios.
- Validation of algorithm behavior is done through JUnit 5 test classes under `src/test/java`.

## How To Extend

1. Add a new challenge class under `src/main/java/com/practice/...`.
2. Add or update corresponding tests under `src/test/java/com/practice/...`.
3. Document method intent and complexity in Javadoc (`@param`, `@return`, time/space complexity).
4. Run `mvn test` before committing.

## Suggested Next Improvements

1. Add CI pipeline checks (`mvn test` on pull requests).
2. Add JaCoCo test coverage reports.
3. Add parameterized tests for broader input coverage.
