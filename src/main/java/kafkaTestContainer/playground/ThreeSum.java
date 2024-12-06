package kafkaTestContainer.playground;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
//        Arrays.stream(nums)
        Comparator<Kitty> byString = (k1, k2) -> {
            Comparator<Kitty> c = Comparator.comparing(k -> k.name);
            c.thenComparing(kitty -> kitty.age);
            return c.compare(k1, k2);
        };
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
        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.merge("1", "1", (s1,s2) ->
                s1.length()>s2.length()? s1 : s2
        );


        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> moreEgg = egg.negate();
        Arrays.asList(1,232,3);

    }
}
