# Java Interview Practice

A focused Java practice project with common interview-style coding challenges, implemented as small, readable classes. The repository is designed to show practical problem-solving across arrays, strings, collections, and simulation tasks.

## What This Project Covers

- **Array pair sum (Two Sum):** brute-force and hash-based solutions in `SumArrayTarget`.
- **Subsequence validation:** ordered subsequence check in `SubSequenceArray`.
- **Seat reservation simulation:** reserve/cancel flows with priority handling in `ReservationSystem`.
- **Comment moderation count:** case-insensitive keyword detection with underscore tokenization in `CommentsCount`.
- **Core algorithm drills:** palindrome, anagrams, sorting, first non-repeating character, and frequency counting in `BasicAlgorithms`.
- **Utility methods:** reverse string, word counting, and duplicate removal in `Utils`.
- **Executable demo:** `App` runs sample scenarios and prints example results.

## Tech Stack

- Java (tested locally with Java 25 LTS)
- Plain source layout (no Maven/Gradle required)
- VS Code Java project settings (`.vscode/settings.json`)

## Project Structure

```text
.
├── src/
│   ├── App.java
│   ├── BasicAlgorithms.java
│   ├── CommentsCount.java
│   ├── ReservationSystem.java
│   ├── SubSequenceArray.java
│   ├── SumArrayTarget.java
│   └── Utils.java
├── bin/               # compiled classes
├── lib/               # optional external jars
└── README.md
```

## Run Locally

### 1) Compile

```bash
javac -d bin src/*.java
```

### 2) Run the demo app

```bash
java -cp bin App
```

## Example Runtime Behavior

When running `App`, you should see outputs similar to:

- Two-sum pair for target `9` from `[2, 7, 11, 15]` -> `2, 7`
- Reversed string for `"Hello, World!"`
- Word occurrence count for `"apple"`
- Deduplicated list output
- Reservation sequence result for operations `{0, 0, 1, 0}` with 5 seats -> `[1, 2, 1]`
- Derogatory comment count for keyword `"bad"` -> `3`

## How To Extend

1. Add a new challenge class under `src/`.
2. Keep the solution method small, deterministic, and easy to run from `main`.
3. Add a quick demonstration call in `App.java`.
4. Recompile and run to verify behavior.

## Quality Notes

- This repository currently uses executable examples rather than a unit-test suite.
- There is no build tool wrapper yet (Maven/Gradle), by design, to keep the project lightweight.
- Some classes include multiple solution variants to compare tradeoffs (clarity vs. performance).

## Suggested Next Improvements

1. Add JUnit tests for each challenge class.
2. Introduce Maven or Gradle for dependency and test lifecycle management.
3. Add CI checks (compile + tests) for pull requests.
