package TwoSum;

import java.util.HashMap;
import java.util.Map;

// O(n)2
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] sum = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println("Point: " + nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println("Sum: " + (nums[i] + nums[j]));
                if ((nums[i] + nums[j]) == target) {
                    sum[0] = i;
                    sum[1] = j;
                    return sum;
                }
            }
        }
        return sum;
    }

// O(n)
    public static int[] twoSumFast(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
