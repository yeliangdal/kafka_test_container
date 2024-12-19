package kafkaTestContainer.playground;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/house-robber/
public class HouseRobber {
    private Map<Integer, Integer> memo = new HashMap<>();
    private int[] nums;

    private int dp(int index) {
        if (index == 0)
            return nums[0];
        if (index == 1)
            return Math.max(nums[0], nums[1]);
        if (memo.get(index) == null) {
            memo.put(index, Math.max(dp(index-1), dp(index-2)+nums[index]));
        }
        return memo.get(index);
    }
    public int rob(int[] nums) {
        this.nums = nums;
    }
}
