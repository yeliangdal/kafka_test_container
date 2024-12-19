package kafkaTestContainer.playground;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] newNums = Arrays.stream(nums).distinct().toArray();
        IntStream.range(0, newNums.length)
                .forEach(i -> map.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i));
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++){
                int tmp = nums[i] + nums[j];
                if (map.containsKey(-tmp)) {
                    List<Integer> index = map.get(-tmp);
                    int finalI = i;
                    int finalJ = j;
                    index.stream()
                            .filter(v -> v> finalI && v> finalJ)
                            .forEach(v-> ret.add(List.of(nums[finalI], nums[finalJ], nums[v])));
                }
            }
        }
        return ret;
    }

    class Kitty {
        int age;
        String name;

        Kitty(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String... args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("1", "one");
//        map.merge("1", "1", (s1,s2) ->
//                s1.length()>s2.length()? s1 : s2
//        );
//        Comparator<Kitty> byString = (k1, k2) -> {
//            Comparator<Kitty> c = Comparator.comparing(k -> k.name);
//            c.thenComparing(kitty -> kitty.age);
//            return c.compare(k1, k2);
//        };
//
//        Predicate<String> egg = s -> s.contains("egg");
//        Predicate<String> moreEgg = egg.negate();
//        Arrays.asList(1,232,3);
        ThreeSum threeSum = new ThreeSum();
        int[] input = {-1,0,1,2,-1,-4};
        System.out.println(threeSum.threeSum(input));
    }
}
