class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int startB = newInterval[0];
        int endB = newInterval[1];
        int start = -1;
        int end = -1;
        int i = 0;
        while (i < intervals.length) {
            int startA = intervals[i][0];
            int endA = intervals[i][1];
            if (endA < startB) {
                ans.add(intervals[i]);
                i++;
            }
            else if (
                (startB >= startA && startB <= endA) ||
                (endB >= startA && endB <= endA) ||
                (startA >= startB && startA <= endB) ||
                (endA >= startB && endA <= endB)
            ) {
                if (start == -1) {
                    start = Math.min(startA, startB);
                    end = Math.max(endA, endB);
                }
                else {
                    start = Math.min(start, startA);
                    end = Math.max(end, endA);
                }
                i++;
            }
            else {
                break;
            }
        }
        if (start == -1) {
            start = startB;
            end = endB;
        }
        ans.add(new int[]{start, end});
        while (i < intervals.length) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}