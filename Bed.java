public class Bed extends Furniture {
    private String size;

    public Bed(String material, String color, double price, String size) {
        super(material, color, price);
        this.size = size;
    }

    @Override
    public void use() {
        System.out.println("На кровати можно спать.");
    }
}