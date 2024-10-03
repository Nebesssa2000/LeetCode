package lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (charIndexMap.containsKey(currentChar)) {
                // Перемещаем указатель left на позицию после последнего вхождения текущего символа
                left = Math.max(charIndexMap.get(currentChar) + 1, left);
            }

            // Обновляем индекс текущего символа
            charIndexMap.put(currentChar, right);

            // Вычисляем длину текущего окна
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    public static class Solution {


        public static void main(String[] args) {

            String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", ""};
            for (String s : testCases) {
                System.out.println("Input: " + s + ", Output: " + lengthOfLongestSubstring(s));
            }
        }
    }
}
