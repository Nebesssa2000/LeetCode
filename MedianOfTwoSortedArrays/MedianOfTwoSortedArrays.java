package MedianOfTwoSortedArrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 7};
        int[] nums2 = {2,9, 10};
        System.out.println("Median: " + findMedianSortedArrays(nums1, nums2));
    }

    /**
    *Объяснение
     * Проверка длины массивов: Мы гарантируем, что nums1 всегда будет меньше или равен nums2 по длине.
     * Это упрощает дальнейшие вычисления.
     * Бинарный поиск: Мы используем бинарный поиск для нахождения правильного разделения массивов.
     * Разделение массивов: Мы делим массивы на две части таким образом, чтобы левая часть содержала половину элементов,
     * а правая часть содержала другую половину.
     * Нахождение медианы: В зависимости от четности или нечетности общего количества элементов, мы находим медиану,
     * используя максимальные элементы левой части и минимальные элементы правой части.
    */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // Гарантируем, что nums1 будет меньше или равен nums2
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;
            if (i < m && nums1[i] < nums2[j - 1]) {
                // i слишком маленькое, нужно увеличить его
                imin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                // i слишком большое, нужно уменьшить его
                imax = i - 1;
            } else {
                // i идеально
                int maxOfLeft;
                if (i == 0) {
                    maxOfLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1];
                } else {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                int minOfRight;
                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }
        return 0.0;
    }
}