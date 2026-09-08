class Solution {
    public boolean search(int[] nums, int target) {
        for(int x: nums){
            if(target==x) return true;
        }
        return false;
    }
}