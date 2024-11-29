package kafkaTestContainer.playground;

import org.apache.kafka.common.protocol.types.Field;

public class ContainerWithMostWater {
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for(int i = 0; i < height.length-1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j])*(j-i);
                if (area>maxArea)
                    maxArea = area;
            }
        }
        return maxArea;
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int l=0, r= height.length-1;
        while(l<r) {
            int area = (r-l)*Math.min(height[l], height[r]);
            maxArea = Math.max(area, maxArea);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
    public static void main(String... args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
