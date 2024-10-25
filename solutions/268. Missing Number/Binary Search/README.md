## Intuition
Since the numbers are in an array and are expected to begin with 0, we can expect the value to match the index if no numbers are missing.

## Approach
My goal was to practice Binary Search, so that's why I'm using it in this case. A binary search can only be performed on a sorted list, so first step was to sort the list with Arrays.sort(nums)

With our sorted list, we can cover two scenarios before looping:
1. If index 0 is not 0, then 0 is missing.
2. If the last index matches, then we're not missing any numbers.

#### Loop logic:

Based off the constraints, we can expect the value to match the [index] if no numbers are missing.

- If [m] is equal to m, then none of the previous numbers are missing
- If [m] is equal to m AND [m+1] is not equal to m+1, then the missing number is in between these two index values
- If [m] is not equal to m, then a previous number is missing

## Complexity
- Time complexity: $$O(logn)$$
- Space complexity: $$O(n)$$

## Example Code
```java
class Solution {
    public int missingNumber(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int m=l+(r-l)/2;

        Arrays.sort(nums);

        if (nums[l] != l) { // If index 0 is not 0, then return 0;
            return l;
        }

        if (nums[r] == r) { // If has no missing numbers, then return r+1
            return r+1;
        }

        while(l<=r){          
            if (nums[m] == m) { // If [m] == m, then ignore left half.
                if (nums[m]+1 != m+1) { // If [m+1] is not m+1, then missing number is in between [m] & [m+1]
                    return m+1;
                } 
                l=m+1;
            } else if (nums[m] != m) {// If index m != m, then ignore right half.
                r=m-1;
            }

            m=l+(r-l)/2;
        }

        return l;
    }
}
```
