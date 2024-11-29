package kafkaTestContainer.playground;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000
*/
public class IntegerToRoman {
    Map<Integer, List<String>> valueMap;
    {
        List<String> digits = List.of("I", "V");
        List<String> tens = List.of("X", "L");
        List<String> hundreds = List.of("C", "D");
        List<String> thousands = List.of("M");
        valueMap = new HashMap<>();
        valueMap.put(0, digits);
        valueMap.put(1, tens);
        valueMap.put(2, hundreds);
        valueMap.put(3, thousands);
    }
    public String intToRoman(int num) {
        String numStr = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for (int index = numStr.length()-1; index >=0; index--) {
            sb.append(mapToRoman(index, numStr.charAt(numStr.length()-index-1)-'0'));
        }
        return sb.toString();
    }

    private String mapToRoman(int digit, int value) {
        if (digit == 3) {
            return IntStream.range(0, value)
                    .mapToObj(i -> "M")
                    .collect(Collectors.joining());
        } else {
            int fives = value/5;
            int ones = value%5;
            if (ones != 4){
                return stringHelper(valueMap.get(digit).getLast(), fives) + stringHelper(valueMap.get(digit).getFirst(), ones);
            }
            if (fives == 0) {
                return valueMap.get(digit).getFirst() + valueMap.get(digit).getLast();
            }
            return valueMap.get(digit).getFirst() + valueMap.get(digit+1).getFirst();
        }
    }

    private String stringHelper(String element, int num) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, num)
                .forEach(i -> sb.append(element));
        return  sb.toString();
    }

    public static void main(String... args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(3749));
    }



}
