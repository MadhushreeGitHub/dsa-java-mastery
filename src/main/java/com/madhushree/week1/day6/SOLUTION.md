# Day 6 — Product of Array Except Self

**LeetCode #238 · NeetCode 150 · Arrays & Hashing · Medium**

## Shipped: O(1) extra space

```java
public int[] productExceptSelfOptimized(int[] nums) {
    int[] result = new int[nums.length];
    result[0] = 1;
    for (int i = 1; i < nums.length; i++) {
        result[i] = result[i - 1] * nums[i - 1];   // prefix products into result
    }
    int suffix = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
        result[i] *= suffix;                        // combine with running suffix
        suffix *= nums[i];
    }
    return result;
}
```

**Time:** O(n) · **Extra space:** O(1) (output array excluded per problem statement)

## DSA pattern — prefix/suffix accumulation

For each index `i`: `answer[i] = (product of everything left of i) × (product of everything right of i)`.

Three optimization levels:

| Version | Time | Extra space | Key insight |
|---|---|---|---|
| Naive nested loop | O(n²) | O(1) | Recomputes prefix/suffix from scratch every iteration |
| Two arrays | O(n) | O(n) | Cache prefix + suffix in arrays via single-pass recurrence |
| In-place (shipped) | O(n) | O(1) | Build prefix into `result`; replace suffix array with one `int` |

**Pattern reuse:** trapping rain water, candy distribution, max product subarray, range-sum queries.

## Why no Java 8 features today (Lesson 0)

Index arithmetic with backward sweep. Streams would fight the direction-dependent recurrence. Plain `for` loops are the right tool. **Knowing when not to reach for streams is a senior skill** — reinforced from Day 2 and Day 5.

## Anti-patterns surfaced

- `Map<Integer, Integer>` keyed by sequential integers — that's an array with boxing tax + hashing overhead. Use `int[]`.
- Computing prefix/suffix in nested loops (O(n²)) when the recurrence allows single-pass build.
- Variable names that lie about type (`preFixMap` after refactoring it to `int[]`).
- Dead `int multiplication = 1;` initialization immediately overwritten.

## Retrospective

- **What clicked:** _Optimizing from O(n²) → O(n) is a matter of caching prefix/suffix, not a matter of streams._
- **Still unclear:** _It looks like more optimize option is there when I check on LeetCode and neetCode. I should work on it._

## TODOs deferred

- Method references — formal lesson (carried from Day 3, Day 4, Day 5)
- `Collectors.groupingBy` — full coverage when stream is the right tool
- Day 5 bucket-sort cleanup (`System.out.println` removal, comparator rewrite)
- Parameterized tests (`@ParameterizedTest`) — would collapse the duplicated `WithX` / `OptimizedWithX` test pairs