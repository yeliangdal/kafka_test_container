package kafkaTestContainer.playground;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int v: candies) {
            if (v>max)
                max = v;
        }
        List<Boolean> ret = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= max)
                ret.add(true);
            else
                ret.add(false);
        }
        return ret;
    }
}
