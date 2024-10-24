package LongestPalindromicSubstring;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        System.out.println("Longest Palindromic Substring of '" + s1 + "': " + longestPalindrome(s1));
        System.out.println("Longest Palindromic Substring of '" + s2 + "': " + longestPalindrome(s2));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Расширение вокруг одного центра
            int len2 = expandAroundCenter(s, i, i + 1); // Расширение вокруг двух центров
            int len = Math.max(len1, len2); // Выбираем максимальную длину
            if (len > end - start) { // Обновляем индексы начала и конца, если найденная длина больше текущей
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1); // Возвращаем самую длинную палиндромную подстроку
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) { // !!! цикл продолжается пока соблюдается условие
            left--;
            right++;
        }
        return right - left - 1; // Возвращаем длину палиндромной подстроки
    }
}
