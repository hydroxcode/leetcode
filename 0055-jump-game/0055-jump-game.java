class Solution {
    public boolean canJump(int[] nums) {

        int i = 0;

        while (i < nums.length - 1) {

            int jump = nums[i];

            if (jump == 0)
                return false;

            int next = i + 1;
            for (int j = i + 1; j <= i + jump && j < nums.length; j++) {

                if (j + nums[j] > next + nums[next]) {
                    next = j;
                }
            }

            i = next;
        }

        return true;
    }
}