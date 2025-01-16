package kafkaTestContainer.playground;

import java.util.Map;

public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(; index < word1.length() && index < word2.length(); index++) {
            sb.append(word1.charAt(index));
            sb.append(word2.charAt(index));
        }
        if (index==word1.length()) {
            sb.append(word2.substring(index));
        } else {
            sb.append(word1.substring(index));
        }
        return sb.toString();
    }

    public static void main(String... args) {
        MergeAlternately ma = new MergeAlternately();
        System.out.println(ma.mergeAlternately("", ""));
    }
}
