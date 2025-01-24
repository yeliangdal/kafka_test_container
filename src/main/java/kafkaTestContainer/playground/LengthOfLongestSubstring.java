package kafkaTestContainer.playground;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int start = 0, end = 0;
        int maxLenth = 1;
        Map<Character, Integer> memo = new HashMap<>();
        for (; end < s.length();end++) {
            Integer i = memo.getOrDefault(s.charAt(end), -1);
            if (i>=0) {
                maxLenth = (end - start)>maxLenth? end-start:maxLenth;
                if(start<=i)
                    start = i+1;
                
            } 
            memo.put(s.charAt(end), end);
        }
        maxLenth = (end - start)>maxLenth? end-start:maxLenth;
        return maxLenth;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring longestSubstring = new LengthOfLongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring("pwwkew"));
    }
}
