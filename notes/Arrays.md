Pattern                     Clue in Question
Two Pointers                “sorted array”, “pair”, “reverse”
Sliding Window              “subarray”, “maximum”, “minimum”, “continuous”
Prefix Sum                  “range sum”, “multiple queries”
Hashing                     “frequency”, “exists”, “count”
Binary Search               “sorted”, “min/max feasible”


Prefix Sum                     Equality-based window (=k, %k, exact count)
Sliding Window                 Monotonic / non-negative constraints
Kadane                         Max / min subarray, state reset required
Two Pointers                   Sorted / monotonic movement


Problem                             Pattern
Max Subarray Sum                    Kadane
Max Subarray Sum (Circular)         Kadane + Min Kadane
Max Product Subarray                Kadane with 2 states (min & max)
Buy/Sell (1 transaction)            Kadane on price differences
Buy/Sell (multiple)                 Greedy
Subarray Sum = K                    Prefix Sum
Product < K                         Sliding Window

