package ZigzagConversion;

public class ZigzagConversion {
    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println("Converted string: " + convert(s1, numRows1));

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println("Converted string: " + convert(s2, numRows2));

        String s3 = "A";
        int numRows3 = 1;
        System.out.println("Converted string: " + convert(s3, numRows3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
