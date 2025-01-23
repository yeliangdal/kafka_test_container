package kafkaTestContainer.playground;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductExceptSelf {
//    public int[] productExceptSelf(int[] nums) {
//        Map<Integer, Integer> memo = new HashMap<>();
//        for(int num: nums) {
//            memo.put(num, memo.getOrDefault(num, 0) + 1);
//        }
//        int[] res = new int[nums.length];
//        for (int i=0; i<nums.length;i++) {
//            int product = 1;
//            for(Integer key: memo.keySet()) {
//                if (key != nums[i]) {
//                    product *= (int) Math.pow(key, memo.get(key));
//                } else if (key != 0) {
//                    product *= (int) Math.pow(key, memo.get(key)-1);
//                } else if (memo.get(key) > 1) {
//                    product = 0;
//                }
//            }
//            res[i] = product;
//        }
//        return res;
//    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] leftMemo = new int[nums.length];
        int[] rightMemo = new int[nums.length];
        int left = 1, right = 1;
        for (int i = 0; i < nums.length; i++) {
            if(i ==0)
                leftMemo[i] = left;
            else
                leftMemo[i] = nums[i-1]*leftMemo[i-1];
        }
        for (int i = nums.length-1; i >=0; i--) {
            if(i == nums.length-1)
                rightMemo[i] = right;
            else
                rightMemo[i] = nums[i+1]*rightMemo[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = leftMemo[i]*rightMemo[i];
        }

        return res;
    }

    public static void main(String... args) {
        ProductExceptSelf pes = new ProductExceptSelf();
        System.out.println(Arrays.toString(pes.productExceptSelf(new int[]{1, 2, 3, 4})));
    }

}
