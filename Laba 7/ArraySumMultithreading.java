package Laba_7.Task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ArraySumMultithreading {
    public static void main(String[] args) {
        int arraySize = 10000;
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = 1;
        }
        int numThreads = 4;
        // Создаем пул потоков (ExecutorService)
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Long>> futures = new ArrayList<>();

        int chunkSize = arraySize / numThreads;

        for (int i = 0; i < numThreads; i++) {
            final int start = i * chunkSize;
            // Вычисляем индекс конца участка. Если это последний поток — берем до конца массива
            final int end = (i == numThreads - 1) ? arraySize : (i + 1) * chunkSize;

            Callable<Long> task = () -> {
                long partialSum = 0;
                for (int j = start; j < end; j++) {
                    partialSum += array[j];
                }
                return partialSum;
            };
            // Передаем задачу в исполнитель
            futures.add(executor.submit(task));
        }

        long totalSum = 0;
        try {
            for (Future<Long> future : futures) {
                totalSum += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        System.out.println("Сумма всех элементов массива: " + totalSum);
    }
}