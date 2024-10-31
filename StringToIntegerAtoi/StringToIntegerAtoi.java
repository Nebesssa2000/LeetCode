package StringToIntegerAtoi;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("42")); // Output: 42
        System.out.println(myAtoi("   -42")); // Output: -42
        System.out.println(myAtoi("1337c0d3")); // Output: 1337
        System.out.println(myAtoi("0-1")); // Output: 0
        System.out.println(myAtoi("words and 987")); // Output: 0
    }

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();
        // Игнорируем начальные пробелы
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Проверяем, достигли ли конца строки
        if (i == n) {
            return 0;
        }

        // Определяем знак числа
        int sign = 1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Чтение цифр и преобразование их в число
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Проверка на переполнение
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
