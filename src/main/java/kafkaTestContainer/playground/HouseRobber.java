package kafkaTestContainer.playground;

import java.util.Arrays;
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
        return dp(this.nums.length-1);
    }

    //bottom up approach
    public int rob1(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[1], nums[0]);
        for(int i = 2; i< nums.length; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + nums[i]);
        }
        return res[nums.length-1];
    }

    public static void main(String... args) {
        int[] input = {1,2,3,1};
        HouseRobber hr = new HouseRobber();
        System.out.println(hr.rob(input));
    }
}
