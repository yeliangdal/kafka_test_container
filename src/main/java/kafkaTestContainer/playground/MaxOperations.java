package kafkaTestContainer.playground;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxOperations {
    public int maxOperations1(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        for(int num:nums){
            memo.put(num, memo.getOrDefault(num, 0)+1);
        }
        for(int num:nums){
            if(memo.getOrDefault(k-num, 0)>0){
                memo.put(num, memo.get(num)-1);
                memo.put(k-num, memo.get(k-num)-1);
                if(memo.get(num) >=0 && memo.get(k-num) >=0 )
                    count++;
            }
        }
        return count;
    }

    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int left=0, right = nums.length-1;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum==k){
                count++;
                left++;
                right--;
            } else if(sum>k) {
                right--;
            }else {
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxOperations maxOperations = new MaxOperations();
        System.out.println(maxOperations.maxOperations(new int[]{3,1,3,4,3}, 6));
    }
}

