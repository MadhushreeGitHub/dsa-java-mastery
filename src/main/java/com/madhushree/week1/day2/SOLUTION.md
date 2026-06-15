# Day 2 — Contains Duplicate

| | |
|---|---|
| **Date** | 2026-06-15 |
| **Source** | NeetCode 150 → Arrays & Hashing → Easy |
| **LeetCode #** | 217 |
| **Link** | https://leetcode.com/problems/contains-duplicate/ |

---

## Problem

Given an integer array `nums`, return `true` if any value appears at least twice; otherwise return `false`.

**Examples**

| Input | Output |
|---|---|
| `[1, 2, 3, 1]` | `true` |
| `[1, 2, 3, 4]` | `false` |
| `[]` | `false` |

---

## Java 7 Solution — Original

```java
public static boolean checkDuplicate(int[] numbers) {
    Set<Integer> set = new HashSet<>();
    for (int i : numbers) {
        if (set.contains(i)) {
            return true;
        }
        set.add(i);
    }
    return false;
}
```

✅ Correct. Clean. Uses `HashSet` for O(1) membership lookup.

---

## Java 7 Solution — Cleaned up (SHIPPED)

```java
public static boolean containsDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    for (int n : nums) {
        if (!seen.add(n)) return true;
    }
    return false;
}
```

**Why this version ships:**
- `HashSet.add()` returns `false` if the element is already present → collapses `contains` + `add` into **one** hash lookup per element (instead of two).
- Same O(n) asymptotic complexity, ~2× faster constant factor.
- Early-exit on first duplicate preserved.
- Method name aligned to LeetCode signature (`containsDuplicate`).
- Variable name `seen` reads more clearly than `set`.

---

## Complexity

| Metric | Best case | Average / Worst case |
|---|---|---|
| **Time** | O(1) — input like `[x, x, ...]`, returns at iteration 2 | O(n) |
| **Space** | O(1) — early exit before set grows | O(n) — all unique, set holds every element |

---

## DSA Pattern — HashSet Membership

> ***"Have I seen this before?"*** → reach for `HashSet`.
>
> ***"Have I seen this AND what was paired with it?"*** → reach for `HashMap`.

### Where this pattern reappears (NeetCode 150)

| Problem | Variant |
|---|---|
| Two Sum (Day 1) | HashMap — store value → index |
| Contains Duplicate II | HashMap — store value → most recent index |
| Longest Substring Without Repeating Characters | HashSet inside a sliding window |
| Linked List Cycle | HashSet of visited nodes (Floyd's algorithm is better, but HashSet works) |
| Happy Number | HashSet of seen values to detect cycle |

---

## Day 2 Lesson 0 — When NOT to use a Stream

### Anti-pattern #1 — the "obvious" one-liner

```java
return Arrays.stream(nums).distinct().count() != nums.length;
```

**Don't ship.** Reasons:
1. `distinct()` is a **stateful intermediate operation** — internally maintains a HashSet, **cannot short-circuit** (must stay ready to emit unseen elements right through the end of the stream).
2. Wrong-shaped question. We need *"is there at least one duplicate?"*, not *"how many uniques exist?"*.

### Anti-pattern #2 — the "clever" one-liner

```java
Set<Integer> seen = new HashSet<>();
return Arrays.stream(nums).anyMatch(n -> !seen.add(n));
```

**Also don't ship.** Reason:
- The lambda `n -> !seen.add(n)` is a **stateful lambda** — reads from and mutates external `seen`.
- Works **sequentially**. **Breaks** the moment someone adds `.parallel()` — `HashSet` is not thread-safe → corrupted buckets, dropped elements, wrong answers, intermittently.
- Code review reject at any product company.

### The Rule

> **Use an imperative loop over a Stream pipeline when:**
> **(a) the iteration is *stateful* — each step depends on what you've seen before — OR**
> **(b) you need to short-circuit but no clean Stream terminal fits the question's shape.**

### The smell test

> *"If I added `.parallel()` to this stream, would it still be correct?"*
>
> If **no** → don't use a stream. Use a for-loop.

---

## New Java 8 concepts learned today

| Concept | One-line meaning |
|---|---|
| `Arrays.stream(int[])` | Returns an `IntStream` — primitive specialization, no `Integer` boxing |
| `IntStream` | A `Stream`-like pipeline over `int` primitives |
| `anyMatch(predicate)` | Returns `true` on the first element satisfying the predicate; `false` if stream exhausts. **Short-circuits.** |
| `allMatch(predicate)` | `true` if every element satisfies; short-circuits on first failure |
| `noneMatch(predicate)` | `true` if no element satisfies; short-circuits on first match |
| Stateless lambda | Output depends *only* on the input. Same input → same output, always. |
| Stateful lambda | Output depends on input AND external mutable state. **Side effect inside lambda = stateful.** |
| `.parallel()` on a stream | Splits work across CPU cores. Requires **stateless** lambdas to remain correct. |
| Code smell | Surface symptom of a deeper structural problem. Code can work and still smell. |

### Stateful vs stateless — quick reference

```java
// Stateless
Predicate<Integer> isEven = n -> n % 2 == 0;
// Same input → same output, always.

// Stateful
Set<Integer> seen = new HashSet<>();
Predicate<Integer> isDuplicate = n -> !seen.add(n);
// isDuplicate.test(5) → false (first time)
// isDuplicate.test(5) → true  (seen now contains 5)
// Same input, different output → STATE.
```

### Short-circuiting terminal ops — cheat sheet

| Method | Returns `true` when… | Short-circuits? |
|---|---|---|
| `anyMatch(p)` | any element satisfies `p` | ✅ on first match |
| `allMatch(p)` | every element satisfies `p` | ✅ on first failure |
| `noneMatch(p)` | no element satisfies `p` | ✅ on first match |
| `findFirst()` | (returns `Optional` of first element) | ✅ on first element |
| `findAny()` | (returns `Optional` of any element) | ✅ on first element |

---

## Retrospective

**What clicked:**
- _(fill in)_

**What's still unclear:**
- _(fill in)_

---

## TODOs deferred from today

- [ ] Write JUnit 5 test cases covering: empty array, single element, all unique, duplicate at start, duplicate at end.
