import AddTwoNumbers.AddTwoNumbers.ListNode;

import java.util.Arrays;

import static AddTwoNumbers.AddTwoNumbers.addTwoNumbers;
import static ReverseInteger.ReverseInteger.reverse;
import static TwoSum.TwoSum.twoSum;
import static TwoSum.TwoSum.twoSumFast;

public class Solutions {
    public static void main(String[] args) {
        // TwoSum
        int[] nums = {3, 2, 4};
        System.out.println("TwoSum");
        System.out.println(Arrays.toString(twoSum(nums, 6)));
        System.out.println(Arrays.toString(twoSumFast(nums, 5)));

        // AddTwoNumbers
        System.out.println("AddTwoNumbers");
        // Создаем первый связанный список: 2 -> 4 -> 3 (представляет число 342)
        ListNode l1 = new ListNode(2);
        l1.setNext(new ListNode(4));
        l1.getNext().setNext(new ListNode(3));

        // Создаем второй связанный список: 5 -> 6 -> 4 (представляет число 465)
        ListNode l2 = new ListNode(5);
        l2.setNext(new ListNode(6));
        l2.getNext().setNext(new ListNode(4));

        // Складываем два числа
        ListNode result = addTwoNumbers(l1, l2);

        // Выводим результат
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.getVal());
            if (result.getNext() != null) {
                System.out.print(" -> ");
            }
            result = result.getNext();
        }


        // ReverseInteger
        int x = 123;
        System.out.println("Reversed: " + reverse(x)); // Output: 321

        x = -123;
        System.out.println("Reversed: " + reverse(x)); // Output: -321

        x = 120;
        System.out.println("Reversed: " + reverse(x)); // Output: 21

        x = 1534236469;
        System.out.println("Reversed: " + reverse(x)); // Output: 0 (due to overflow)
    }
}
