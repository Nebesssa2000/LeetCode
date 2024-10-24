package lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class TextValidator {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (charIndexMap.containsKey(currentChar)) {
                left = Math.max(charIndexMap.get(currentChar) + 1, left);
            }

            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Пример использования в веб-приложении
        String userInput = "abcabcbb";
        int maxLength = lengthOfLongestSubstring(userInput);
        System.out.println("Input: " + userInput + ", Length of longest substring without repeating characters: " + maxLength);

        // Валидация ввода пользователя
        if (maxLength >= 3) {
            System.out.println("Valid input.");
        } else {
            System.out.println("Invalid input. Please enter a string with at least one unique substring of length 3 or more.");
        }
    }
}
