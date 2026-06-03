package Laba_8;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DataManager {
    private List<String> sourceData = new ArrayList<>();
    private final List<Object> processors = new ArrayList<>();
    // Создаем потокобезопасный список: чтобы разные потоки могли безопасно писать в него результат
    private final List<String> resultData = Collections.synchronizedList(new ArrayList<>());

    public void registerDataProcessor(Object processor) {

        processors.add(processor);
    }

    public void loadData(List<String> data) {
        this.sourceData = data;
        System.out.println("Данные загружены: " + sourceData);
    }

    public void processData() {
        // Создаем пул потоков по количеству процессоров (сколько методов найдем)
        ExecutorService executor = Executors.newFixedThreadPool(processors.size());

        for (Object processor : processors) {
            // РЕФЛЕКСИЯ: получаем все методы данного класса
            for (Method method : processor.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    executor.submit(() -> {
                        try {
                            // ВЫЗОВ МЕТОДА: используем invoke, чтобы запустить метод через рефлексию
                            List<String> processedChunk = (List<String>) method.invoke(processor, sourceData);
                            resultData.addAll(processedChunk);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void saveData() {
        System.out.println("\n--- Результаты обработки планет ---");
        resultData.forEach(System.out::println);
    }
}