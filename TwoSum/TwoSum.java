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
    public static void main(String[] args) {
        int[] result1 = twoSumFast(new int[]{9, -6, 5, 1, 4, -2}, 10);
        if (result1.length == 2) {
            System.out.println("Subarray found from index " + result1[0] + " to " + result1[1]);
        } else {
            System.out.println("Subarray not found");
        }

        int[] result2 = twoSumFast(new int[]{6, 3, 5, -5, 3, -4, 8, -4, 3, -5}, 10);
        if (result2.length == 2) {
            System.out.println("Subarray found from index " + result2[0] + " to " + result2[1]);
        } else {
            System.out.println("Subarray not found");
        }

        int[] result3 = twoSumFast(new int[]{1, 2, 3, 4, 5}, 15);
        if (result3.length == 2) {
            System.out.println("Subarray found from index " + result3[0] + " to " + result3[1]);
        } else {
            System.out.println("Subarray not found");
        }

        int[] result4 = twoSumFast(new int[]{1, -1, 2, 3, -2, 4}, 6);
        if (result4.length == 2) {
            System.out.println("Subarray found from index " + result4[0] + " to " + result4[1]);
        } else {
            System.out.println("Subarray not found");
        }

        int[] result5 = twoSumFast(new int[]{9, 8, -2, 3, -8, 4, -2}, 10);
        if (result5.length == 2) {
            System.out.println("Subarray found from index " + result5[0] + " to " + result5[1]);
        } else {
            System.out.println("Subarray not found");
        }
    }
}
