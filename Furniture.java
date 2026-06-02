public abstract class Furniture {
    private String material;
    private String color;
    private double price;
    private static int count = 0; // Статический счетчик

    // Конструктор
    public Furniture(String material, String color, double price) {
        this.material = material;
        this.color = color;
        this.price = price;
        count++;
    }

    // Конструктор по умолчанию
    public Furniture() {
        this("Дерево", "Коричневый", 0.0);
    }

    public static int getCount() { return count; }

    // Абстрактный метод (Абстракция)
    public abstract void use();

    // Метод поведения
    public void describe() {
        System.out.println("Мебель из " + material + ", цвет " + color + ", цена " + price);
    }

    // Геттеры и сеттеры (Инкапсуляция)
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}