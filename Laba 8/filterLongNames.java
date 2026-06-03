package Laba_8;

import java.util.List;
import java.util.stream.Collectors;

class PlanetFilter {
    @DataProcessor
    public List<String> filterLongNames(List<String> data) {
        System.out.println("[" + Thread.currentThread().getName() + "] Фильтруем длинные названия планет...");
        return data.stream()
                .filter(s -> s.length() > 6)
                .collect(Collectors.toList());
    }
}

class PlanetTransformer {
    @DataProcessor
    public List<String> transformToUpper(List<String> data) {
        System.out.println("[" + Thread.currentThread().getName() + "] Преобразуем названия в капс...");
        return data.stream()
                .map(String::toUpperCase)
                .map(s -> "🪐 " + s)
                .collect(Collectors.toList());
    }
}