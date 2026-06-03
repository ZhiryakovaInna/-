import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task_3_2 {

    public static void main(String[] args) {
        try {
            System.out.println("Результат 10 * 5 = " + calculate(10, 5, "*"));
            System.out.println("Результат 10 ^ 5 = " + calculate(10, 5, "^"));

        } catch (Task_3_1 e) {
            System.out.println("ПЕРЕХВАТ: " + e.getMessage());
            logErrorToFile(e);
        }
    }

    public static double calculate(double a, double b, String operation) throws Task_3_1 {
        switch (operation) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) {
                    throw new Task_3_1("Ошибка: Деление на ноль!");
                }
                return a / b;
            default:
                throw new Task_3_1("Операция '" + operation + "' не поддерживается!");
        }
    }

    //Метод, который принимает объект исключения и записывает информацию о нем в текстовый файл логов
    private static void logErrorToFile(Exception e) {
        //Поток для записи в файл errors.log
        try (FileWriter fw = new FileWriter("errors.log", true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println("--- ЗАПИСЬ ОБ ОШИБКЕ ---");
            pw.println("Тип ошибки: " + e.getClass().getName());
            pw.println("Сообщение: " + e.getMessage());
            System.out.println("Информация об ошибке успешно записана в файл 'errors.log'.");

        } catch (IOException ioException) {
            System.out.println("Не удалось записать лог в файл.");
        }
    }
}