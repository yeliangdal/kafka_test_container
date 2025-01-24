package kafkaTestContainer.playground;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int first =0, second = 0;
        while (first<s.length() && second<t.length()){
            if(s.charAt(first)==t.charAt(second)){
                first++;
            }
            second++;
        }
        if (first==s.length())
            return true;
        return false;
    }
}
