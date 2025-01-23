package kafkaTestContainer.playground;

import org.apache.kafka.common.protocol.types.Field;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public String reverseWords(String s) {
        String trimed = s.trim();
        List<String> strings = Arrays.asList(trimed.split("\\s+"));
        Collections.reverse(strings);
        return String.join(" ", strings);
    }

    public static void main(String... args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("the sky is blue"));
    }
}
