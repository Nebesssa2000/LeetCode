/*Шаблон Дана строка, содержащая буквы //A-Z//: "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"
Нужно написать функцию RLE, которая выведет строку вида: "A4B3C2XYZD4E3F3A6B28"
Еще надо выдавать ошибку, если на ввод приходит недопустимая строка
Примечания:
Если символ встречается один раз, он остается неизменным
Если символ встречается более одного раза, к нему добавляется число повторений
public static String RLE(String str) {
} */
public class YandexTask {
    public static void main(String[] args) {
        try {
            System.out.println(RLE("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
    public static String RLE(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // Проверка на допустимые символы
            if (currentChar < 'A' || currentChar > 'Z') {
                throw new IllegalArgumentException("Invalid character in input string: " + currentChar);
            }

            if (i + 1 < str.length() && currentChar == str.charAt(i + 1)) {
                count++;
            } else {
                result.append(currentChar);
                if (count > 1) {
                    result.append(count);
                }
                count = 1;
            }
        }

        return result.toString();
    }
}
