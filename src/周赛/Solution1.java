package 周赛;

class Solution1 {
    int sum = 0;
    int[] nums;
    boolean flag = false;
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        for (int num : nums) {
            sum += num;
        }
        if ((sum^1) == 1) return false;
        dfs(0,0);
        return flag;
    }

    private void dfs(int index,int count) {
        // 截止条件
        if (count == sum >> 1) {
            flag = true;
            return;
        }
        if (flag) return;
        for (int i = index; i < nums.length; i++) {
            dfs(index+1,count += nums[i]);
        }
    }
}