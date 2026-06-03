package Laba_6.Task_3;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SalesTracker {
    // ConcurrentHashMap для хранения пар "Название товара" -> "Количество продаж"
    // Она обеспечивает потокобезопасность, что важно для систем учета
    private static ConcurrentHashMap<String, Integer> salesCount = new ConcurrentHashMap<>();

    // Дополнительная карта для хранения цен товаров: "Название товара" -> "Цена"
    private static Map<String, Double> productPrices = new HashMap<>();

    public static void main(String[] args) {
        addProductPrice("Яблоки", 100.0);
        addProductPrice("Бананы", 80.0);
        addProductPrice("Апельсины", 120.0);
        addProductPrice("Кофе", 250.0);

        recordSale("Яблоки", 5);
        recordSale("Бананы", 10);
        recordSale("Кофе", 2);
        recordSale("Яблоки", 3); // Еще раз купили яблоки
        recordSale("Апельсины", 4);
        printSalesList();

        System.out.printf("Общая сумма продаж: %.2f руб.%n", calculateTotalSales());
        System.out.println("Наиболее популярный товар: " + getMostPopularProduct());
    }

    public static void addProductPrice(String name, double price) {
        productPrices.put(name, price);
    }
    //Метод для регистрации факта продажи
    public static void recordSale(String productName, int quantity) {
        salesCount.merge(productName, quantity, Integer::sum);
    }

    public static void printSalesList() {
        System.out.println("Список проданных товаров:");
        salesCount.forEach((product, count) -> {
            System.out.println("- " + product + ": " + count + " шт.");
        });
    }

    public static double calculateTotalSales() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : salesCount.entrySet()) {
            String product = entry.getKey();
            int count = entry.getValue();
            double price = productPrices.getOrDefault(product, 0.0);
            total += price * count;
        }
        return total;
    }

    public static String getMostPopularProduct() {
        String popular = "Нет продаж";
        int maxSales = 0;

        for (Map.Entry<String, Integer> entry : salesCount.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                popular = entry.getKey();
            }
        }
        return popular + " (продано " + maxSales + " шт.)";
    }
}