import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Создаем HashMap: Ключ - Телефон, Значение - Контакт
        HashMap<String, Contact> phoneBook = new HashMap<>();

        // ВСТАВКА
        phoneBook.put("89001112233", new Contact("Алексей", "Петров", "alex@mail.ru"));
        phoneBook.put("89995554422", new Contact("Мария", "Иванова", "masha@yandex.ru"));
        phoneBook.put("89110000000", new Contact("Дмитрий", "Сидоров", "sid@gmail.com"));

        System.out.println("Контактов в базе: " + phoneBook.size());

        // ПОИСК
        String searchPhone = "89995554422";
        if (phoneBook.containsKey(searchPhone)) {
            System.out.println("Найден контакт: " + phoneBook.get(searchPhone));
        }

        // УДАЛЕНИЕ
        phoneBook.remove("89110000000");
        System.out.println("Контакт 89110000000 удален.");

        // ВЫВОД ВСЕХ
        System.out.println("\nСписок всех контактов:");
        for (String phone : phoneBook.keySet()) {
            System.out.println("Тел: " + phone + " | " + phoneBook.get(phone));
        }
    }
}