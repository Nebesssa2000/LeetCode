import java.util.Arrays;

import static TwoSum.TwoSum.twoSum;
import static TwoSum.TwoSum.twoSumFast;

public class Solutions {
    public static void main(String[] args) {
        int[]nums = {3,2,4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
        System.out.println(Arrays.toString(twoSumFast(nums, 5)));
    }
}
