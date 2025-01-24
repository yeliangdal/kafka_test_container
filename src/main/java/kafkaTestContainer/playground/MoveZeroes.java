package kafkaTestContainer.playground;

import java.util.Arrays;

public class MoveZeroes {
    // public void moveZeroes(int[] nums) {
    //     for(int i=0;i<nums.length-1;i++){
    //         if(nums[i]==0){
    //             int j = i+1;
    //             while(j<nums.length-1){
    //                 if(nums[j]==0){
    //                     j++;
    //                 } else{
    //                     break;
    //                 }
    //             }
    //             nums[i]=nums[j];
    //             nums[j]=0;
    //         }
    //     }
    // }
// two pointers
    public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                int j = i+1;
                while(j<nums.length-1){
                    if(nums[j]==0){
                        j++;
                    } else{
                        break;
                    }
                }
                nums[i]=nums[j];
                nums[j]=0;
            }
        }
    }
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] input = new int[]{0,1,0,3,12};
        moveZeroes.moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }
}
