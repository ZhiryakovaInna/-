public class Chair extends Furniture {
    private boolean hasBackrest;

    public Chair(String material, String color, double price, boolean hasBackrest) {
        super(material, color, price);
        this.hasBackrest = hasBackrest;
    }

    @Override
    public void use() {
        System.out.println("На стуле можно сидеть.");
    }
}