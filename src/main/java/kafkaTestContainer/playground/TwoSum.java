package kafkaTestContainer.playground;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        IntStream.range(0, nums.length)
                        .forEach(i-> map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i));
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                if (2*nums[i] == target && map.get(nums[i]).size() == 1) {
                    continue;
                } else {
                    ret[0] = i;
                    ret[1] = map.get(target-nums[i]).getLast();
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String... args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3,2, 4}, 6)));
    }

}
