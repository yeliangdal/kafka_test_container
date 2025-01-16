package kafkaTestContainer.playground;

public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        String s,l;
        if (str1.length()<=str2.length()) {
            s = str1;
            l = str2;
        } else {
            s = str2;
            l = str1;
        }
        for (int i = s.length()-1; i>0; i--) {
            if(s.length()%i==0 && l.length()%i == 0){
                if(isFactor(s, s.substring(0, i)) && (isFactor(l, s.substring(0, i))))
                    return str1.substring(0, i);
            }
        }
        return "";
    }

    // returns true if str2 is a factor of str1
    private boolean isFactor(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty() || str1.length() < str2.length())
            return false;
        if (str1.length()%str2.length() != 0)
            return false;
        int multiplier = str1.length()/str2.length();
        StringBuilder sb = new StringBuilder();
        sb.append(str2.repeat(multiplier));
        if (sb.toString().equals(str1))
            return true;
        return false;
    }
}
