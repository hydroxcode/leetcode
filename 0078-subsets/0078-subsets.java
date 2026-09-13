class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    static void solve(int[] nums, int i, List<Integer> temp,
                      List<List<Integer>> ans) {

        if (i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        solve(nums, i + 1, temp, ans);
        temp.add(nums[i]);
        solve(nums, i + 1, temp, ans);

        temp.remove(temp.size() - 1);
    }
}