package kafkaTestContainer.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseVowels {
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        for (int i=0; i<s.length();i++) {
            if(isCharVowel(s.charAt(i))) {
                vowels.add(s.charAt(i));
                pos.add(i);
            }
        }
        Collections.reverse(vowels);
        char[] ret = s.toCharArray();
        for(int i=0; i<vowels.size();i++) {
            ret[pos.get(i)] = vowels.get(i);
        }
        return String.valueOf(ret);
    }

    private boolean isCharVowel(Character c) {
        return switch (c) {
            case 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' -> {yield true;}
            default -> {yield false;}
        };
    }
    
    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels("IceCreAm"));
    }
}