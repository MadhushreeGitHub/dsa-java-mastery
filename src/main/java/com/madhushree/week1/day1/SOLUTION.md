# Day 1 — Two Sum

## Problem
LeetCode #1 — Given an array of integers and a target, return indices of two numbers that sum to the target.

## DSA Pattern
**HashMap lookup** — trade O(n) space for O(n) time. Walk the array once;
for each element, check if its complement is already in the map. This pattern
applies to many "find a pair" problems (e.g., 3Sum, 4Sum, Two Sum Sorted).

## Complexity
- Time:  O(n)
- Space: O(n)

## Java 8+ Feature Used: Optional<T>
- Changed return type from `int[]` (using empty array as sentinel)
  to `Optional<int[]>` (explicit absence).
- Caller uses `ifPresentOrElse(present, empty)` — type system forces
  handling of both cases. Bugs caught at compile time instead of runtime.

## What clicked today
- Stream pipeline shape: SOURCE → intermediate → terminal
- Lesson 0: Two Sum's core loop is a BAD fit for streams (early return,
  index tracking, mutable state). Knowing when NOT to use streams matters.
- Optional > empty-array-as-sentinel for missing return values.

## What's still unclear
- (be honest — write whatever feels shaky here)

## Time spent
~3 hours (over budget — Day 2 will respect the 2-hour cap)