package kafkaTestContainer.playground;

public class MinCostClimbing {

    //Constraints:
    //
    //2 <= cost.length <= 1000
    //0 <= cost[i] <= 999
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i], dp[i-2] + cost[i]);
        }
        dp[len] = Math.min(dp[len - 2], dp[len - 1]);
        return dp[cost.length];
    }

    public static void main(String... args) {
        MinCostClimbing minCostClimbing = new MinCostClimbing();
//        int[] input = {1,100,1,1,1,100,1,1,100,1};
        int[] input = {10,15,20};
        System.out.println(minCostClimbing.minCostClimbingStairs(input));
    }
}
