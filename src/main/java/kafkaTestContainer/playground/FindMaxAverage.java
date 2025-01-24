package kafkaTestContainer.playground;

public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        
        int left = 0, right = left+k;
        double avg = Double.MIN_VALUE;
        while(right<nums.length){
            int sum = 0;
            for(int i=left;i<=right;i++){
                sum+=nums[i];
            }
            avg = (sum/k>avg)? sum/k : avg;
            left++;
            right++;
        }
        return avg;
    }

    public static void main(String[] args) {
        FindMaxAverage avg = new FindMaxAverage();
        System.out.println(avg.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
