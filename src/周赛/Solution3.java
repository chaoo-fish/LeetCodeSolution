package 周赛;

import java.util.PriorityQueue;

class Solution3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        String aa = "64333639502";
        long substring = Long.parseLong(aa.substring(aa.length() - 10),10);
        System.out.println(substring);
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int index = query[1]; // 移位
            PriorityQueue<long[]> pq = new PriorityQueue<>();
            for (int j = 0; j < nums.length; j++) {
                long subNum = 0;
                subNum = Long.parseLong(nums[j].substring(nums[j].length() - index));
                pq.add(new long[]{subNum, j});
            }
            for (int i1 = 0; i1 < query[0] - 1; i1++) {
                pq.remove();
            }
            assert pq.peek() != null;
            ans[i] = (int) pq.peek()[1];
        }

        return ans;
    }
}