package kafkaTestContainer.playground;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DeleteAndEarn {
    private Map<Integer, Integer> valueMap = new HashMap<>();
    public int deleteAndEarn(int[] nums) {
        Arrays.stream(nums)
                .forEach(num -> valueMap.put(num, valueMap.getOrDefault(num, 0) + num));
        return 0;
    }

    public static void main(String... args) {
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        int[] input = {2,2,3,3,3,4};
        System.out.println(deleteAndEarn.deleteAndEarn(input));
    }
}
