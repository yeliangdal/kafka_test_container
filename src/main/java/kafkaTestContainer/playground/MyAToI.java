package kafkaTestContainer.playground;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then round the integer to remain in the range. Specifically, integers less than -2^31 should be rounded to -231,
 and integers greater than 2^31 - 1 should be rounded to 2^31 - 1.
Return the integer as the final result.

 */
public class MyAToI {
    public int myAtoi(String s) {
        Pattern pattern = Pattern.compile("^([+|-]?)(\\d+)");
        Matcher matcher = pattern.matcher(s.trim());
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            String match = matcher.group();
            System.out.println(match);
            sb.append(match);
        }
        if (!sb.isEmpty()) {
            String numString = sb.toString();
            int ret = 0;
            try {
                ret = Integer.parseInt(numString);
            } catch (NumberFormatException e) {
                if(numString.startsWith("-")) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            return ret;
        }
        return 0;
    }

    public static void main(String... args) {
        MyAToI aToI = new MyAToI();
        System.out.println(aToI.myAtoi("-91283472332"));
    }
}
