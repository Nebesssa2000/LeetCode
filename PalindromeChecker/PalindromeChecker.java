package PalindromeChecker;

import java.util.stream.IntStream;

/**
 * Класс для проверки, является ли заданное число палиндромом.
 */
public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println(isPalindrome(20_002));
        System.out.println(isPalindromeDeclarativeStyle(20_102));
        System.out.println(isPalindromeDeclarativeStyle(Integer.MAX_VALUE));
    }

    /**
     * Проверяет, является ли заданное число палиндромом.
     * Палиндром - это число, которое читается одинаково как слева направо, так и справа налево.
     *
     * @param x число для проверки
     * @return true, если число является палиндромом, иначе false
     */
    public static boolean isPalindrome(int x) {
        // Если число отрицательное, оно не может быть палиндромом
        if (x < 0) {
            return false;
        }

        // Если число оканчивается на 0 и не является 0, оно не может быть палиндромом
        if (x % 10 == 0 && x != 0) {
            return false;
        }

        // Переменная для хранения инвертированного числа
        long invertedNumber = 0;
        // Копия исходного числа для манипуляций
        int copyOfX = x;

        // Инвертируем число
        while (copyOfX != 0) {
            // Добавляем последнюю цифру из copyOfX к invertedNumber
            invertedNumber = invertedNumber * 10 + copyOfX % 10;
            // Удаляем последнюю цифру из copyOfX
            copyOfX = copyOfX / 10;
        }

        // Проверяем, не произошло ли переполнение
        if (invertedNumber > Integer.MAX_VALUE) {
            return false;
        }

        // Проверяем, равно ли инвертированное число исходному числу
        return invertedNumber == x;
    }

    public static boolean isPalindromeDeclarativeStyle(int x) {
        // Если число отрицательное, оно не может быть палиндромом
        if (x < 0) {
            return false;
        }

        // Преобразуем число в строку
        String str = Integer.toString(x);

        // Используем стримы для проверки, является ли строка палиндромом
        return IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
    }
}
