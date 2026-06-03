public class Table extends Furniture {
    private int legsCount;

    public Table(String material, String color, double price, int legsCount) {
        super(material, color, price);
        this.legsCount = legsCount;
    }

    @Override
    public void use() { // Переопределение
        System.out.println("За столом можно работать или обедать.");
    }

    // Перегрузка метода (демонстрация полиморфизма)
    public void use(String activity) {
        System.out.println("Используем стол для: " + activity);
    }
}