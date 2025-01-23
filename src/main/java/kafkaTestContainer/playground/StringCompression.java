package kafkaTestContainer.playground;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    public char[] compress(char[] chars) {
        Map<Character, Integer> memo = new HashMap<>();
        for(char c: chars) {
            memo.put(c, memo.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c: memo.keySet()) {
            if (memo.get(c) > 1) {
                sb.append(c);
                sb.append(memo.get(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString().toCharArray();
    }

    public static void main(String... args) {
        StringCompression sc = new StringCompression();
        System.out.println(sc.compress(new char[]{'a','a','b','b','c','c','c'}));
    }
}
