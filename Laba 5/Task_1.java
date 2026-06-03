import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task_1 {
    public static void main(String[] args) {
        String text = "По спецификации ноутбук весит 1.45 кг, работает до 12 часов от батареи и стоит 30.000 рублей.";

        try {
            if (text == null) {
                throw new IllegalArgumentException("Исходный текст не может быть null");
            }
            // Регулярное выражение
            Pattern pattern = Pattern.compile("\\d+(?:\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);

            System.out.println("Найденные числа в тексте:");

            while (matcher.find()) {
                // Выводим в консоль найденное совпадение
                System.out.println(matcher.group());
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка обработки данных: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}