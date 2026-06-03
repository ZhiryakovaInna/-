import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task_2 {
    public static void main(String[] args) {
        String sourcePath = "source.txt";
        String destPath = "destination.txt";

        // Используем try-with-resources для автоматического закрытия файлов
        try (FileInputStream in = new FileInputStream(sourcePath);
             FileOutputStream out = new FileOutputStream(destPath)) {
            int byteData;
            while ((byteData = in.read()) != -1) {
                out.write(byteData);
            }

            System.out.println("Файл успешно скопирован!");

        } catch (IOException e) {
            System.out.println("ОШИБКА: Произошел сбой при чтении или записи файла!");
            System.out.println("Детали ошибки: " + e.getMessage());
        }
    }
}