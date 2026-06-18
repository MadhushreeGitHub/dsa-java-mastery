# Day 5 — Top K Frequent Elements

**LeetCode #347 · NeetCode 150 · Arrays & Hashing · Medium**

---

## Problem

Given an integer array `nums` and integer `k`, return the `k` most frequent elements. Answer may be in any order; uniqueness of answer is guaranteed by the problem.

**Constraints:** `1 ≤ nums.length ≤ 10^5`, `k ∈ [1, unique_elements]`.

| Input | k | Output |
|---|---|---|
| `[1,1,1,2,2,3]` | 2 | `[1,2]` |
| `[1]` | 1 | `[1]` |
| `[4,1,-1,2,-1,2,3]` | 2 | `[-1,2]` |

---

## Shipped Solution — Bucket Sort, O(n)

```java
public static int[] topKFrequent(int[] nums, int k) {
    // 1. Count frequencies
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
        freq.merge(num, 1, Integer::sum);
    }

    // 2. Buckets indexed by frequency. Size n+1 because freq ∈ [0..n].
    List<Integer>[] buckets = new List[nums.length + 1];
    for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
        int f = e.getValue();
        if (buckets[f] == null) buckets[f] = new ArrayList<>();
        buckets[f].add(e.getKey());
    }

    // 3. Walk HIGH → LOW. Stop when result is full.
    int[] result = new int[k];
    int index = 0;
    for (int i = buckets.length - 1; i >= 1 && index < k; i--) {
        if (buckets[i] == null) continue;
        for (int num : buckets[i]) {
            result[index++] = num;
            if (index == k) break;
        }
    }
    return result;
}
```

---

## Complexity

| Metric | Cost | Why |
|---|---|---|
| **Time** | **O(n)** | Two linear walks: over `nums`, over `buckets`. No sort. |
| **Space** | O(n) | Frequency map + bucket array, each bounded by n. |

---

## DSA Pattern — Bucket Sort / Counting Sort family

> **Insight:** When the values you'd sort by are bounded by `n`, use them as **array indices** instead of comparator keys. Indexing is O(1) per element; comparison sort is O(log n) per element.

The unlock for this problem: frequency of any element is bounded by `nums.length`. That bound is what lets us skip sorting entirely.

**Reappears in:** Sort Colors (Dutch flag, values bounded {0,1,2}), H-Index (citations bounded by n), Kth Largest Element variants where bucket sort beats heap.

**Heuristic:** anytime you catch yourself reaching for a heap or sort with a small / bounded value domain, ask "can I bucket-index this instead?"

---

## Alternative Approach — Stream + Sort, O(n log n)

Worked but not shipped (suboptimal). Kept here for the Java 8 lesson it taught.

```java
return map.entrySet().stream()
    .sorted(Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed())
    .limit(k)
    .mapToInt(Map.Entry::getKey)
    .toArray();
```

Comparison:

| Approach | Time | When it's the right tool |
|---|---|---|
| Bucket sort (shipped) | O(n) | Values bounded by n — this problem. |
| HashMap + sort entries | O(n log n) | Values unbounded, or n is small. |
| HashMap + min-heap size k | O(n log k) | Streaming data, or k ≪ n. |

---

## Java 8 Locked — `Comparator` Combinators

The senior anti-pattern (subtraction comparator) and its Java 8 replacement.

**Don't:**
```java
.sorted((a, b) -> b.getValue() - a.getValue())   // overflow risk
```
Concrete overflow: `a = 1_000_000_000`, `b = -2_000_000_000` → `a - b = 3_000_000_000` → wraps int → wrong sign.

**Do:**
```java
Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed()
// or, with the built-in:
Map.Entry.<Integer, Integer>comparingByValue().reversed()
```

**Three combinators worth remembering:**

| API | Purpose |
|---|---|
| `Comparator.comparingInt(ToIntFunction<T>)` | Build a comparator from an int-returning key extractor (no boxing). |
| `Comparator<T>.reversed()` | Flip ascending → descending. |
| `Map.Entry.<K,V>comparingByValue()` / `comparingByKey()` | Built-in for entries. Type witness needed because of static generic inference. |

**Rule:** never write a subtraction comparator in shipped code. Use `Integer.compare(a, b)` or a key-extractor combinator.

---

## Lesson 0 in Action (continuing from Day 2)

The shipped O(n) solution uses **less** Java 8 than the O(n log n) alternative. No streams, no Comparator chains, no method refs (beyond `Integer::sum`). Plain arrays and `for` loops.

**Knowing when not to reach for streams is a senior skill.** Bucket sort is index arithmetic — streams add friction, not value. The right tool is the one that fits the algorithm, not the one that looks modern.

---

## Anti-patterns surfaced today

- Subtraction comparators (`a - b`) — overflow risk. Use combinators.
- Debug `System.out.println` inside `forEach` left in shipped code — same cleanliness rule as Day 3's dead HashMap.
- `new List[nums.length]` for frequency buckets — off-by-one. Frequency can equal `n`, so size must be `n + 1`.
- Walking buckets low → high when you want top-K — direction matters. Index = frequency, so highest index = most frequent.
- `if (k == 0) break` inside a nested loop — only breaks innermost. Use a guarded outer `for` (`index < k`) instead of a `while` wrapper or labeled break.
- `for (int x : nullableList)` without a null check — NPE on sparse bucket arrays.

---

## Retrospective

- **What clicked:** _Learned java7 is best for index-based algorithms (bucket sort), java8 is best for comparator-based algorithms (sort by frequency)._
- **Still fuzzy:** _When to use streams for side effects (spoiler: almost never).

---

## TODOs deferred

- Method references — formal lesson (carried from Day 3, Day 4)
- `Collectors.groupingBy` — full coverage when stream is the right tool
- Generic array creation warning (`new List[n+1]` produces an unchecked warning) — suppress correctly or use `List<List<Integer>>` instead
- Labeled break — when it's actually the right tool vs. a guard expression