class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int m=l+(r-l)/2;

        if (target > nums[r]) {
            return r+1;
        }
        if (target < nums[l]) {
            return l;
        }
        while(l <= r) {
            if (target == nums[m]){
                return m;
            }
            if (target > nums[m]){
                l=m+1;
            } else if (target < nums[m]){
                r=m-1;
            }
            m=l+(r-l)/2;
        }
        return r+1;
    }
}
