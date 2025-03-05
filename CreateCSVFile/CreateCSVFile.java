package CreateCSVFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CreateCSVFile {

    public static void main(String[] args) {
        String[] headers = {"Дата, время", "Ручей 7: Уровень металла в кристаллизаторе, мм", "Ручей 8: Уровень металла в кристаллизаторе, мм"};
        String fileName = "data.csv";
        int totalRows = 1200;
        LocalDateTime startDateTime = LocalDateTime.of(2022, 2, 1, 15, 50, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, StandardCharsets.UTF_8))) {
            // Write headers
            writer.write(String.join(",", headers));
            writer.newLine();

            // Generate and write data
            for (int i = 0; i < totalRows; i++) {
                String dateTime = startDateTime.plusSeconds((i / 20) * 60).format(formatter);
                int level7 = 660 + random.nextInt(181); // 660 to 840
                int level8 = 650 + random.nextInt(201); // 650 to 850
                writer.write(String.join(",", dateTime, String.valueOf(level7), String.valueOf(level8)));
                writer.newLine();
            }

            System.out.println("Файл " + fileName + " успешно создан.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
