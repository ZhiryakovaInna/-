public class Main {
    public static void main(String[] args) {
        // Создание объектов
        Table table = new Table("Дуб", "Белый", 15000, 4);
        Chair chair = new Chair("Пластик", "Черный", 2000, true);
        Bed bed = new Bed("Ткань", "Серый", 25000, "King Size");

        // Демонстрация поведения
        table.describe();
        table.use();
        table.use("Черчение проекта"); // Перегрузка

        chair.use();

        // Счетчик объектов
        System.out.println("Всего создано единиц мебели: " + Furniture.getCount());
    }
}