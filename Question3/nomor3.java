public class nomor3 {
    public static void main(String[] args) {
        food f1 = new food("Beef Rendang", 15000);
        food f2 = new RegularMenu("Chicken Ramen", 20000);
        food f3 = new SpecialMenu("Fiery Fried Rice", 80000);

        f1.getInfo();
        f2.getInfo();
        f3.getInfo();
    }
}
class food {
    protected String name;
    protected int basePrice;

    public food(String name, int basePrice){
        if (basePrice >= 1000000){
            throw new IllegalArgumentException("Base price must be below 1000000");
        }
        this.name = name;
        this.basePrice = basePrice;
    }
    public int calcPrice(){
        return basePrice + 5000;
    }
    public void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + calcPrice());
    }
}
class RegularMenu extends food {
    public RegularMenu(String name, int basePrice) {
        super(name, basePrice);
    }

    @Override
    public int calcPrice() {
        return basePrice + 5000 + 10000;
    }
}
class SpecialMenu extends food{
    public SpecialMenu(String name, int basePrice){
        super(name, basePrice);
    }
    @Override
    public int calcPrice(){
        return basePrice + 5000 + 20000;
    }
}