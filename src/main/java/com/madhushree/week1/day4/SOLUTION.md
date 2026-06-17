# Day 4 — Group Anagrams

**LeetCode #49 · NeetCode 150 · Arrays & Hashing · Medium**

## Shipped Solution

```java
public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        map.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(s);
    }
    return new ArrayList<>(map.values());
}
```

**Time:** O(N · K log K) | **Space:** O(N · K)
N = `strs.length`, K = avg string length.

## DSA Pattern — Canonical-Form Key

Don't compare elements pairwise. Derive a key all equivalents share (sorted chars). HashMap groups them for free.

Reappears in: Group Shifted Strings, Isomorphic Strings, Find All Anagrams in a String, Valid Sudoku.

## Java 8 Locked — `Map.computeIfAbsent`

Returns existing value, or computes-and-inserts then returns. Lambda runs only on miss.

Replaces:
```java
/*
if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(value);*/

```
With:
```java
map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
```

**Rule:** never wrap `computeIfAbsent` in `if (containsKey)` — defeats the point.

## Anti-patterns to avoid (surfaced today)

- `stream().forEach(x -> mutate(external))` → stateful lambda; use `for` loop.
- `AtomicBoolean` inside a lambda → wrong tool; use `for` loop with `boolean`.
- `Arrays.toString(char[])` as a map key → debug format, not a key; use `new String(chars)`.

## Retrospective
- We had a good discussion on the tradeoffs of different approaches (sorting vs counting chars). Sorting is simpler and faster for short strings, counting can be faster for long strings but is more complex.
## TODOs deferred

- Test naming convention (`methodUnderTest_scenario_expected`)
- Deeper assertions beyond `.size()` (`Set<Set<String>>` for order-independent equality)
- Method references — formal lesson (carried from Day 3)
- `Collectors.groupingBy` — full coverage on a day where stream is the right tool