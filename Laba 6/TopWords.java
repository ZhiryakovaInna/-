package Laba_6.Task_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "C:\\Учеба\\java\\text.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Map<String, Integer> wordCounts = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            word = word.replaceAll("[^a-zA-Zа-яА-Я0-9]", "");

            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
        scanner.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCounts.entrySet());
        // Используем компаратор для сортировки списка
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        System.out.println("Топ-10 самых часто встречающихся слов:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            if (count >= 10) {
                break;
            }
            System.out.println((count + 1) + ". " + entry.getKey() + ": " + entry.getValue());
            count++;
        }
    }
}