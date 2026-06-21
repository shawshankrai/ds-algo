Question:
LC 1480 — Running Sum of 1d Array

Pattern:
Basic Prefix Sum / Running Sum

When to use:
Use when the problem asks for cumulative sum till each index.

Core idea:
Each index should store the sum from index 0 to that index.

Template:
for (int i = 1; i < nums.length; i++) {
    nums[i] += nums[i - 1];
}

Why start from i = 1?
Index 0 has no previous element. Its running sum is already nums[0].

Mistake to avoid:
Do not start from i = 0, because nums[i - 1] would become nums[-1].

Complexity:
Time: O(n)
Space: O(1)

Memory hook:
Prefix sum = running total.
nums[i] += nums[i - 1]
