Question:
LC 303 — Range Sum Query Immutable

Pattern:
Prefix Sum with extra array of size n + 1

When to use:
Use when the problem asks for repeated range sum queries like sum(left, right).

Core idea:
Precompute cumulative sums once.
Then each range sum can be answered in O(1).

Build template:
int[] prefixSum = new int[nums.length + 1];

for (int i = 0; i < nums.length; i++) {
    prefixSum[i + 1] = prefixSum[i] + nums[i];
}

Query template:
return prefixSum[right + 1] - prefixSum[left];

Why prefixSum has size n + 1?
Because prefixSum[0] stores 0, meaning sum before the array starts.

Meaning:
prefixSum[i] = sum of first i elements

Example:
nums      = [2, 4, 1, 3]
prefixSum = [0, 2, 6, 7, 10]

sumRange(1, 3):
prefixSum[4] - prefixSum[1]
= 10 - 2
= 8

Mistake to avoid:
Do not write prefixSum[right] - prefixSum[left].
Because with n + 1 prefix array, right must become right + 1.

Complexity:
Constructor: O(n)
sumRange: O(1)
Space: O(n)

Memory hook:
Extra 0 at start means:
right becomes right + 1
left stays left
