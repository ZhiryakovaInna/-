package Laba_8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DataManager manager = new DataManager();
        //Регистрируем объекты обработчики (рефлексией)
        manager.registerDataProcessor(new PlanetFilter());
        manager.registerDataProcessor(new PlanetTransformer());

        manager.loadData(Arrays.asList(
                "Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун"
        ));

        System.out.println("Начинаем многопоточную обработку...");
        manager.processData();

        manager.saveData();
    }
}