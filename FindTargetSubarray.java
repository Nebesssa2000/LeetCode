import java.util.HashMap;
import java.util.Map;

public class FindTargetSubarray {
    public static int[] findTarget(int[] input, int target) {
        // Карта для хранения текущей суммы и соответствующего индекса
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        // Проход по массиву
        for (int i = 0; i < input.length; i++) {
            sum += input[i];

            // Если текущая сумма равна целевой, возвращаем индексы от начала до текущего
            if (sum == target) {
                return new int[]{0, i};
            }

            // Если (currentSum - target) уже есть в карте, значит подотрезок найден
            if (map.containsKey(sum - target)) {
                return new int[]{map.get(sum - target) + 1, i};
            }

            // Сохраняем текущую сумму и индекс в карту
            map.put(sum, i);
        }

        // Если подотрезок не найден, возвращаем пустой массив
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result1 = findTarget(new int[]{9, -6, 5, 1, 4, -2}, 10);
        if (result1.length == 2) {
            System.out.println("Subarray found from index " + result1[0] + " to " + result1[1]);
        } else {
            System.out.println("Subarray not found");
        }

        int[] result2 = findTarget(new int[]{6, 3, 5, -5, 3, -4, 8, -4, 3, -5}, 10);
        if (result2.length == 2) {
            System.out.println("Subarray found from index " + result2[0] + " to " + result2[1]);
        } else {
            System.out.println("Subarray not found");
        }

        int[] result3 = findTarget(new int[]{1, 2, 3, 4, 5}, 15);
        if (result3.length == 2) {
            System.out.println("Subarray found from index " + result3[0] + " to " + result3[1]);
        } else {
            System.out.println("Subarray not found");
        }

        int[] result4 = findTarget(new int[]{1, -1, 2, 3, -2, 4}, 6);
        if (result4.length == 2) {
            System.out.println("Subarray found from index " + result4[0] + " to " + result4[1]);
        } else {
            System.out.println("Subarray not found");
        }

        int[] result5 = findTarget(new int[]{1, 3, 9, 9, 9, 9, -5, -8, -5, -8, 7}, 10);
        if (result5.length == 2) {
            System.out.println("Subarray found from index " + result5[0] + " to " + result5[1]);
        } else {
            System.out.println("Subarray not found");
        }
    }
}