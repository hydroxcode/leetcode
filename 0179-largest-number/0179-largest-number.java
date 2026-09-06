import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        // convert int to string
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // sort with custom comparator
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // edge case: if largest is "0"
        if (arr[0].equals("0")) return "0";

        
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }
}