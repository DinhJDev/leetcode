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
